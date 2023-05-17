package boot.mvc.sell_now;

import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.mvc.buy_bid.BuyBidDto;
import boot.mvc.buy_bid.BuyBidService;
import boot.mvc.purchase.PurchaseDto;
import boot.mvc.purchase.PurchaseService;
import boot.mvc.user.UserService;

@Controller
public class SellNowController {

	@Autowired
	UserService userService;	
	
	@Autowired
	PurchaseService purchaseService;
	
	@Autowired 
	BuyBidService buyBidService;
	
	@Autowired
	SellNowService sellNowService;
	
	@PostMapping("/sell/insertSellNow")
	@ResponseBody
	public String sellNow(@RequestParam String item_num,
			@RequestParam String buy_num,
			@RequestParam int totalPrice,
			@RequestParam String name, 
			@RequestParam String phone, 
			@RequestParam String addr, 
			@RequestParam String account1, 
			@RequestParam String account2, 
			@RequestParam String penaltypay1, 
			@RequestParam String penaltypay2,
			HttpSession session) {
		
		String loginEmail = (String) session.getAttribute("loginEmail");
	      
        String user_num = userService.findEmailUserNum(loginEmail);
        userService.getUserNumData(user_num);

        String account = account1 + " " + account2;
        String penaltypay = penaltypay1 + " " + penaltypay2;
        String sellAddr = name+"," + phone + "," +addr;
        
        SellNowDto sellNowDto = new SellNowDto();
        
        sellNowDto.setUser_num(user_num);
        sellNowDto.setItem_num(item_num);
        sellNowDto.setBuy_num(buy_num);
        sellNowDto.setSellnow_totalprice(totalPrice);
        sellNowDto.setSellnow_account(account);
        sellNowDto.setSellnow_penaltypay(penaltypay);
        sellNowDto.setSellnow_addr(sellAddr);
                
        // test_result 합격, 불합격 랜덤 부여
        String test_result = "";
        
        Random random = new Random();
        double testResult = random.nextDouble(); 

        if (testResult <= 0.05) {
           test_result = "불합격";  // 5% 확률로 불합격
        } else {
           test_result = "합격";  // 95% 확률로 합격
        }
        
        // test_result 불합격이면 sell_status 판매불가
        if(test_result.equals("불합격")) {
        	sellNowDto.setSell_status("판매불가");      
        	sellNowDto.setTest_result(test_result);
        	
        	sellNowService.insertSellNow(sellNowDto);
        }
        else {
        	// 검수 결과가 합격이면 판매 상태 -> 판매 완료
        	sellNowDto.setSell_status("판매완료");    
        	sellNowDto.setTest_result(test_result);
        	
        	sellNowService.insertSellNow(sellNowDto);

        	// purchase insert하기
        	PurchaseDto purchaseDto = new PurchaseDto();
        	
        	BuyBidDto buyBidDto = buyBidService.getDataOfBuyBid(buy_num);
        	
        	purchaseDto.setItem_num(item_num);
        	purchaseDto.setPurchase_buy(buyBidDto.getBuy_num());
        	purchaseDto.setPurchase_sell(user_num);
        	purchaseDto.setBuybid_num(buy_num);
        	purchaseDto.setPurchase_addr(purchaseDto.getPurchase_addr());
        	purchaseDto.setPurchase_price(Integer.parseInt(buyBidDto.getBuy_wishprice()));
        	purchaseDto.setPurchase_delivery("빠른배송");
        	purchaseDto.setPurchase_total_price(totalPrice);
        	
        	purchaseService.insertPurchase(purchaseDto);
        }
        
		return loginEmail;
	}
	
	
}
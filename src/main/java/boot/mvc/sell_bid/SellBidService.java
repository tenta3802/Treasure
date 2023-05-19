package boot.mvc.sell_bid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellBidService implements SellBidServiceInter {

	@Autowired
	SellBidMapperInter mapper;

	@Override
	public void insertSellBid(SellBidDto SellBidDto) {
		// TODO Auto-generated method stub
		mapper.insertSellBid(SellBidDto);
		
	}

	@Override
	public String getNowinsertSellBidNum() {
		return mapper.getNowinsertSellBidNum();
	}

	@Override
	public SellBidDto getSellBidData(String user_num, String sell_num) {
		// TODO Auto-generated method stub
		return mapper.getSellBidData(user_num, sell_num);
	}
	
  @Override
	public SellBidDto getSellBidDatas(String item_num) {
		return mapper.getSellBidDatas(item_num);
	}

}

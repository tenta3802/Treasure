package boot.mvc.detail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import boot.mvc.item.ItemDto;

@Service
public class DetailService implements DetailServiceInter {

	@Autowired
	DetailMapperInter mapper;

	@Override
	public ItemDto DetailgetData(String item_num) {
		// TODO Auto-generated
		// method stub
		return mapper.DetailgetData(item_num);
	}

	@Override
	public List<ItemDto> getAllData() {
		// TODO Auto-generated
		// method stub
		return mapper.getAllData();
	}

	@Override
	public List<Map<String, Object>> getBuyBidGroupedData(String item_num) {
		// TODO Auto-generated
		// method stub
		return mapper.getBuyBidGroupedData(item_num);
	}

	@Override
	public List<Map<String, Object>> getSellBidGroupedData(String item_num) {
		// TODO Auto-generated
		// method stub
		return mapper.getSellBidGroupedData(item_num);
	}

	@Override
	public List<Map<String, Object>> getPurchaseData(String item_num) {
		// TODO Auto-generated
		// method stub
		return mapper.getPurchaseData(item_num);
	}

	@Override
	public String getPurchaseRecentPriceAll(String item_num) {
		// TODO Auto-generated
		// method stub
		return mapper.getPurchaseRecentPriceAll(item_num);
	}

	@Override
	public Integer getPurchaseRecentPriceSize(String item_num, String buy_size) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("item_num", item_num);
		map.put("buy_size", buy_size);
		
		Integer recentPrice = mapper.getPurchaseRecentPriceSize(map);

	    // 반환된 값이 null인 경우 0으로 대체
	    if (recentPrice == null) {
	        recentPrice = 0;
	    }

	    return recentPrice;
	}
}

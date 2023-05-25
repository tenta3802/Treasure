package boot.mvc.layout;

import boot.mvc.item.ItemDto;
import boot.mvc.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LayoutController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/")
	public String main(Model model)
	{
		List<String> items = new ArrayList<>();
		for(int i=0; i<16; i++) {
			int num = (int)(Math.random() * 50) + 161;
			if(items.contains(String.valueOf(num))) {
				i--;
				continue;
			}
			items.add(String.valueOf(num));
		}

		List<ItemDto> itemDtoList1 = new ArrayList<>();
		List<ItemDto> itemDtoList2 = new ArrayList<>();
		List<ItemDto> itemDtoList3 = new ArrayList<>();
		List<ItemDto> itemDtoList4 = new ArrayList<>();

		for(int i=0; i<4; i++) {
			itemDtoList1.add(itemService.getItemData(items.get(i)));
		}
		for(int i=4; i<8; i++) {
			itemDtoList2.add(itemService.getItemData(items.get(i)));
		}
		for(int i=8; i<12; i++) {
			itemDtoList3.add(itemService.getItemData(items.get(i)));
		}
		for(int i=12; i<16; i++) {
			itemDtoList4.add(itemService.getItemData(items.get(i)));
		}
		model.addAttribute("itemDtoList1", itemDtoList1);
		model.addAttribute("itemDtoList2", itemDtoList2);
		model.addAttribute("itemDtoList3", itemDtoList3);
		model.addAttribute("itemDtoList4", itemDtoList4);

		return "/layout/main";
	}
}

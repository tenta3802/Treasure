package boot.mvc.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

	@Autowired
    OrderService service;
	
}

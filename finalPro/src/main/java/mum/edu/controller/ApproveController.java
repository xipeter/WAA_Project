package mum.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApproveController {
	@RequestMapping(value="/approve")
	public String approve() {
		return "approve";
	}

}

package mum.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class welcomeController {

	@RequestMapping(value="/")
	public String home() {
		return "index";
	}
}

package mum.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrackController {

	@RequestMapping("/track")
	public String track() {
		return "track";
	}
}

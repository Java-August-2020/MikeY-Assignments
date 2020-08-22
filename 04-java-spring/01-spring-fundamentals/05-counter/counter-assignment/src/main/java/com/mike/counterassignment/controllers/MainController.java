package com.mike.counterassignment.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {
	@RequestMapping("/")
	public String index(HttpSession session, Model viewModel) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		
		viewModel.addAttribute("totalCount", session.getAttribute("count"));
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		Integer currentCount = (Integer) session.getAttribute("count");
		currentCount++;
		session.setAttribute("count", currentCount);
		return "counter.jsp";
	}
}

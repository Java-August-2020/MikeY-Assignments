package com.mike.displaydate.controllers;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "landingDateTime.jsp";
	}
	@RequestMapping("/time")
	public String time(Model viewModel) {
		LocalTime timeNow = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
		viewModel.addAttribute("timeNow", timeNow.format(formatter));
		return "time.jsp";
	}
	@RequestMapping("/date")
	public String date(Model viewModel) {
		LocalDate dateNow = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE,' the' dd' of' MMMM, YYYY");
		viewModel.addAttribute("dateNow", dateNow.format(formatter));
		return "date.jsp";
	}
}

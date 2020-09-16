package com.mike.controllerandviews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mike.controllerandviews.models.User;
import com.mike.controllerandviews.services.UserService;
import com.mike.controllerandviews.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	//registration page
	@RequestMapping("/")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	
	//display the login page
	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
		}
	
	
	//Register new user
	@PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page 
		//custom validations
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "registrationPage.jsp";
			// else, save the user in the database, save the user id in session, and redirect them to the /home route
		} else {
		User u = uService.registerUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/home";
		}
    }
	
	
	//login for user
	//request for user email/password and authenticate
	@PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
		boolean isAuthenticated  = uService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = uService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/home";  		
    	} else {
        // else, add error messages and return the login page
    		model.addAttribute("error",  "Invalid Credentials.  Please try again");
        	return "loginPage.jsp";
    	}
    }
	
	// this is the route for redirecting user to home page
	// checks params and info saved in database and in session for user to get here
	@RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save in the model and return the home page
		Long userId = (Long) session.getAttribute("userId") ;
		if (userId == null) {
			return "redirect:/";
		}
    	User u = uService.findUserById(userId);
    	model.addAttribute("user", u);
    	return "homePage.jsp";
    }
	
	//LOG OUT
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
		session.invalidate();
        // redirect to login page
		return "redirect:/login";
    }
}	

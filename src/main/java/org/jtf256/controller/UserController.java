package org.jtf256.controller;

import org.jtf256.entity.User;
import org.jtf256.service.UserService;
import org.jtf256.controller.CardController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
//@RestController
@Controller
public class UserController 
{
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login(Model  model)
	{
		User user = new User();
		model.addAttribute("user", user);
		
		return "login";
		
	}
	
	@PostMapping("/login")
	public String login_check(@ModelAttribute("user") User user, Model model)
	{
		System.out.println("What was entered: "  + user);
		String result =  "login";
		CardController control  = new CardController();
		
		try {
			User check = userService.getUser(user.getUsername());
			if(check.getPassword().equals(user.getPassword()))
			{
				System.out.println("Passwords match!");
				//result =  control.addCard(model);
				result = "login_successful";
				System.out.println(result);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result.equals("login"))
		{
			model.addAttribute("error_msg", "Wrong username or password");
		}
		
		return result;
	}

}

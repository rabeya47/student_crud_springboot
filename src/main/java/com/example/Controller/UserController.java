package com.example.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.UserModel;
import com.example.Repository.UserRepo;

@Controller
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/")
	public ModelAndView index() {
		Map<String, Object> map =  new HashMap<String, Object>();
		return new ModelAndView ("index", "data",map);
	}
	
	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");		
		UserModel user = this.userRepo.findByUsername(username);
		
		if(user != null) {
			if(user.getPassword().equals(password)) {
				return new ModelAndView("studentList");
			}
			return new ModelAndView("error_page");
		}else {
			return new ModelAndView("error_page");
		}
	}
}

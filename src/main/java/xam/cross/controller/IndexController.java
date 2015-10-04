package xam.cross.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xam.cross.entity.User;
import xam.cross.service.UserService;

@Controller
@RequestMapping()
public class IndexController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/index") //Value is what should be written in browser after server name to get into this method
	public String index(){
		return "index";//this string value is a path to the view that will be used when this method is done
	}
	
	@RequestMapping("/user-register")
	public String showRegister(){
		return "user-register";
	}
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping(value="/user-register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		userService.save(user);
		return "user-register";
	}
}

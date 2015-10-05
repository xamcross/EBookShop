package xam.cross.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xam.cross.entity.Book;
import xam.cross.entity.User;
import xam.cross.service.BookService;
import xam.cross.service.UserService;

@Controller
@RequestMapping()
public class IndexController {

	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/user-register")
	public String showRegister(){
		return "user-register";
	}
	
	@RequestMapping("/add-book")
	public String showBookCreator(){
		return "add-book";
	}
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping(value="/user-register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		userService.save(user);
		return "index";
	}
	
	@ModelAttribute("add-book")
	public Book createBook(){
		return new Book();
	}
	
	@RequestMapping(value="/add-book", method=RequestMethod.POST)
	public String addingNewBook(@ModelAttribute("add-book") Book book){
		bookService.save(book);
		System.out.println("" + book.getTitle() + " added to catalog");
		return "catalog";
	}
}

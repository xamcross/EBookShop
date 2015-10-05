package xam.cross.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xam.cross.entity.ShoppingCart;
import xam.cross.service.BookService;
import xam.cross.service.ShoppingCartService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired 
	private ShoppingCartService cartService;

	@RequestMapping(value="/catalog")
	public String allBooks(Model model){
		
		model.addAttribute("catalog", bookService.findAllWithAuthors());
		return "catalog";
	}

	@RequestMapping(value="/catalog/{id}")
	public String detail(Model model, @PathVariable int id){
		model.addAttribute("book", bookService.findOneWithAuthors(id));
		return "book-details";
	}
	
	@RequestMapping(value="/catalog{id}", method=RequestMethod.POST)
	public String addBookToCart(@PathVariable int id){
		ShoppingCart cart = cartService.getCart();
		cart.getBooks().add(bookService.findOneWithAuthors(id));
		cartService.save(cart);
		return "catalog";
	}
}

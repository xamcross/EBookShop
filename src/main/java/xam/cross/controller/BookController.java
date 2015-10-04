package xam.cross.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import xam.cross.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

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
}

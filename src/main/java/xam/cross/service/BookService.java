package xam.cross.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xam.cross.entity.Author;
import xam.cross.entity.Book;
import xam.cross.entity.User;
import xam.cross.repository.AuthorRepository;
import xam.cross.repository.BookRepository;

@Service
public class BookService {

	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}

	public Book findOne(int id) {
		return bookRepository.findOne(id);
	}

	@Transactional
	public Book findOneWithAuthors(int id) {
		Book book = findOne(id);
		List<Author> authors = authorRepository.findByBooks(book);
		book.setAuthors(authors);
		return book;
	}

	@Transactional
	public List<Book> findAllWithAuthors() {
		List<Book> books = findAll();
		for (Book book : books){
			List<Author> authors = authorRepository.findByBooks(book);
			book.setAuthors(authors);
		}
		return books;
	}

	public void save(Book book) {
		bookRepository.save(book);
	}

}

package xam.cross.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xam.cross.entity.Author;
import xam.cross.entity.Book;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

	
	public List<Author> findByBooks(Book book);
}

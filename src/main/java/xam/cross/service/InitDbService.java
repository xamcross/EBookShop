package xam.cross.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xam.cross.entity.Author;
import xam.cross.entity.Book;
import xam.cross.entity.Role;
import xam.cross.entity.ShoppingCart;
import xam.cross.entity.User;
import xam.cross.repository.AuthorRepository;
import xam.cross.repository.BookRepository;
import xam.cross.repository.RoleRepository;
import xam.cross.repository.ShoppingCartRepository;
import xam.cross.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private ShoppingCartRepository cartRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		ShoppingCart cart = new ShoppingCart();
		cartRepository.save(cart);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userAdmin.setCart(cart);
		userRepository.save(userAdmin);
		
		Author hermanMelvill = new Author();
		hermanMelvill.setFullName("Herman Melvill");
		authorRepository.save(hermanMelvill);
		
		Author aStrugatskiy = new Author();
		aStrugatskiy.setFullName("Arkadiy Strugatskiy");
		authorRepository.save(aStrugatskiy);
		
		Author bStrugatskiy = new Author();
		bStrugatskiy.setFullName("Boris Strugatskiy");
		authorRepository.save(bStrugatskiy);
		
		Book mobbyDick = new Book();
		mobbyDick.setTitle("Mobby Dick");
		List<Author> mobbyDickAuthors = new ArrayList<Author>();
		mobbyDickAuthors.add(hermanMelvill);
		mobbyDick.setAuthors(mobbyDickAuthors);
		mobbyDick.setPrice(5.99);
		bookRepository.save(mobbyDick);
		
		Book picnicAtTheRoadside = new Book();
		picnicAtTheRoadside.setTitle("Picnic at the Roadside");
		List<Author> picnicAuthors = new ArrayList<Author>();
		picnicAuthors.add(aStrugatskiy);
		picnicAuthors.add(bStrugatskiy);
		picnicAtTheRoadside.setAuthors(picnicAuthors);
		picnicAtTheRoadside.setPrice(7.20);
		bookRepository.save(picnicAtTheRoadside);
		
		Book mondayOnSaturday = new Book();
		mondayOnSaturday.setTitle("Monday Starts on Saturday");
		List<Author> mOnSAuthors = new ArrayList<Author>();
		mOnSAuthors.add(aStrugatskiy);
		mOnSAuthors.add(bStrugatskiy);
		mondayOnSaturday.setAuthors(mOnSAuthors);
		mondayOnSaturday.setPrice(12);
		bookRepository.save(mondayOnSaturday);
		
		
		
	}
}

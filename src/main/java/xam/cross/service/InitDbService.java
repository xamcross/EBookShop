package xam.cross.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xam.cross.entity.Author;
import xam.cross.entity.Blog;
import xam.cross.entity.Book;
import xam.cross.entity.Item;
import xam.cross.entity.Role;
import xam.cross.entity.User;
import xam.cross.repository.AuthorRepository;
import xam.cross.repository.BlogRepository;
import xam.cross.repository.BookRepository;
import xam.cross.repository.ItemRepository;
import xam.cross.repository.RoleRepository;
import xam.cross.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogJavaVids = new Blog();
		blogJavaVids.setName("JavaVids");
		blogJavaVids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogJavaVids.setUser(userAdmin);
		blogRepository.save(blogJavaVids);
		
		Item item1 = new Item();
		item1.setBlog(blogJavaVids);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogJavaVids);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
		
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
		bookRepository.save(mobbyDick);
		
		Book picnicAtTheRoadside = new Book();
		picnicAtTheRoadside.setTitle("Picnic at the Roadside");
		List<Author> picnicAuthors = new ArrayList<Author>();
		picnicAuthors.add(aStrugatskiy);
		picnicAuthors.add(bStrugatskiy);
		picnicAtTheRoadside.setAuthors(picnicAuthors);
		bookRepository.save(picnicAtTheRoadside);
		
		Book mondayOnSaturday = new Book();
		mondayOnSaturday.setTitle("Monday Starts on Saturday");
		List<Author> mOnSAuthors = new ArrayList<Author>();
		mOnSAuthors.add(aStrugatskiy);
		mOnSAuthors.add(bStrugatskiy);
		mondayOnSaturday.setAuthors(mOnSAuthors);
		bookRepository.save(mondayOnSaturday);
	}
}

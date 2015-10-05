package xam.cross.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xam.cross.entity.ShoppingCart;
import xam.cross.repository.ShoppingCartRepository;
import xam.cross.repository.UserRepository;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartRepository cartRepository;

	public void save(ShoppingCart cart) {
		cartRepository.save(cart);
	}

	public ShoppingCart getCart() {
		cartRepository.getOne(0);
		return null;
	}	
}

package xam.cross.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xam.cross.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}

package xam.cross.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xam.cross.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

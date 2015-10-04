package xam.cross.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xam.cross.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

}

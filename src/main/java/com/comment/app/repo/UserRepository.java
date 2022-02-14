package com.comment.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comment.app.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmailId(String email);
	User findByEmailIdAndPassword(String email,String password);
}

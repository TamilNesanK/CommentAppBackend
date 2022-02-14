package com.comment.app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.comment.app.model.Comment;
import com.comment.app.model.User;
import com.comment.app.repo.CommentRespository;
import com.comment.app.repo.UserRepository;

@SpringBootApplication
public class CommentAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CommentAppApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CommentRespository commentRespository;
	
	@Override
	public void run(String... args) throws Exception {
	
		User user = new User();
		user.setEmailId("Demo@123");
		user.setPassword("Demo@123");
		user.setSecretCode("Demo@123");
		
		Comment comment = new Comment();
		comment.setComment("Hi Demo 1");
		
		user.setComment(comment);
		userRepo.save(user);
		
		
		
		User user2 = new User();
		user2.setEmailId("Demo2@123");
		user2.setPassword("Demo2@123");
		user2.setSecretCode("Demo2@123");
		
		Comment comment2 = new Comment();
		comment2.setComment("Hi Demo 2");
		
		user2.setComment(comment2);
		userRepo.save(user2);
		
		
		
		User user3 = new User();
		user3.setEmailId("Demo3@123");
		user3.setPassword("Demo3@123");
		user3.setSecretCode("Demo3@123");
		
		Comment comment3 = new Comment();
		comment3.setComment("Hi Demo 3");
		
		user3.setComment(comment3);
		userRepo.save(user3);
	}

}

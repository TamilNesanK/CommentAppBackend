package com.comment.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comment.app.dto.UserCommentDto;
import com.comment.app.model.Comment;
import com.comment.app.model.User;
import com.comment.app.service.CommentService;
import com.comment.app.service.UserService;

@RestController
@CrossOrigin(origins  = "http://localhost:3000/")
@RequestMapping("/comment/api/")
public class CommentAppController {

	  @Autowired
	  private UserService userService;
		
	  @Autowired
	  private CommentService commentService;
	  
	  @PostMapping(value  = "/signUp")
	  public ResponseEntity<User> signUp(@RequestBody User user){
	  User userResult = userService.addUser(user);
	  return new ResponseEntity<>(userResult,HttpStatus.CREATED);
	  }
		
	  @PostMapping(value = "/signIn") 
	  public ResponseEntity<User> signIn(HttpServletRequest request ,@RequestBody User user){
	  User userResult = userService.signIn(user);
	  return new ResponseEntity<>(userResult,HttpStatus.OK);
	  }
	 
	  @PutMapping(value = "/saveComment") 
	  public ResponseEntity<User> saveComment(@RequestBody UserCommentDto userCommentDto){
	  User user = userService.saveComment(userCommentDto); 
	  return new ResponseEntity<>(user,HttpStatus.CREATED);
	  }
	  
	  @GetMapping(value = "/showAllComments") 
	  public ResponseEntity<List<Comment>> ShowAllComments(){
	  List<Comment> commentsList = commentService.ShowAllComments(); 
	  return new ResponseEntity<>(commentsList,HttpStatus.OK);
	  }
	  
	  @GetMapping(value = "/filterComment")
	  public ResponseEntity<Comment> filterComment(HttpSession session,@RequestBody User user){
  	  String emailId = (String) session.getAttribute("emailId");
	  Comment comment =  commentService.filterComment(emailId);
	  return new ResponseEntity<>(comment,HttpStatus.OK); }
	  
	  @PostMapping(value = "/forgotPassword") 
	  public ResponseEntity<String> forgotPassword(@RequestBody User user){
	  String  password = userService.forgotPassword(user); 
	  return new ResponseEntity<>(password,HttpStatus.OK);
	  }

}

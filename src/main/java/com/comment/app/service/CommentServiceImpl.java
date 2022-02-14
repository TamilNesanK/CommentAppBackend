package com.comment.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.comment.app.model.Comment;
import com.comment.app.model.User;
import com.comment.app.repo.CommentRespository;
import com.comment.app.repo.UserRepository;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRespository commentRespository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<Comment> ShowAllComments() {
		List<Comment> commentsList = commentRespository.findAll(); 
		return commentsList;
	}


	@Override
	public Comment filterComment(String emailId) {
		User userResut = userRepository.findByEmailId(emailId);
		Comment comment = null;
		if(!ObjectUtils.isEmpty(userResut)) {
		 comment = userResut.getComment();
		}
		return comment;
	}

}

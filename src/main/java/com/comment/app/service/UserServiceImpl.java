package com.comment.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.comment.app.dto.UserCommentDto;
import com.comment.app.model.Comment;
import com.comment.app.model.User;
import com.comment.app.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		User userResut = userRepository.save(user);
		return userResut;
	}

	@Override
	public User signIn(User user) {
		User userResut = userRepository.findByEmailIdAndPassword(user.getEmailId(),user.getPassword());
		return userResut;
	}

	@Override
	public String forgotPassword(User user) {
		User userResut = userRepository.findByEmailId(user.getEmailId());
		String password = null;
		if(!ObjectUtils.isEmpty(userResut)) {
			password = userResut.getPassword();
		}
		return password;
	}
	
	@Override
	public User saveComment(UserCommentDto userCommentDto) {
	User userResut = userRepository.findByEmailId(userCommentDto.getEmailId());
	Comment commentObj = new Comment();
	if(!ObjectUtils.isEmpty(userResut)) {
			String comment = userCommentDto.getComment();
			commentObj.setComment(comment);
			userResut.setComment(commentObj);
			return	userRepository.save(userResut);
	}
	return null;
	}
}

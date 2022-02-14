package com.comment.app.service;

import com.comment.app.dto.UserCommentDto;
import com.comment.app.model.User;

public interface UserService{
	
	User addUser(User user);
	
	User signIn(User user);

	String forgotPassword(User user);

	User saveComment(UserCommentDto userCommentDto);
}

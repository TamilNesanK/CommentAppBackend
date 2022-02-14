package com.comment.app.service;

import java.util.List;

import com.comment.app.dto.UserCommentDto;
import com.comment.app.model.Comment;

public interface CommentService {

//	Comment saveComment(UserCommentDto comment);

	List<Comment> ShowAllComments();

	Comment filterComment(String emailId);
}

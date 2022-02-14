package com.comment.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comment.app.model.Comment;
@Repository
public interface CommentRespository extends JpaRepository<Comment, Long>{

}

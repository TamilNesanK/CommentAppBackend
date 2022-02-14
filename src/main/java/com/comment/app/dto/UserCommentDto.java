package com.comment.app.dto;

public class UserCommentDto {

	private String emailId;
	private String comment;
	public UserCommentDto() {
		super();
	}
	public UserCommentDto(String emailId, String comment) {
		super();
		this.emailId = emailId;
		this.comment = comment;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}

package com.varchar.www.model.domain.comment;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Comment {
	private int commentNo;
	private String userId;
	private String userName;
	private String commentContent;
	private String commentDate;
	private String commentImage;
	private List<ReplyComment> replyCommentList;
}	

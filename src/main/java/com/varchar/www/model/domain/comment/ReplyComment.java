package com.varchar.www.model.domain.comment;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ReplyComment {
	private int commentNo;
	private String userId;
	private String commentContent;
	private String commentDate;
	private String commentImage;
	List<ReplyComment> replyInReplyComment;
}	

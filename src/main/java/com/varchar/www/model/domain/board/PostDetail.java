package com.varchar.www.model.domain.board;

import java.util.List;

import com.varchar.www.model.domain.comment.Comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PostDetail {
	private int postNo;
	private int boardNo;
	private String userId;
	private String boardName;
	private String postTitle;	
	private String postContents;
	private String postsDate;
	private int postViews;
	List<PostsDetailList> postsDetailList;
	List<Comment> commentList;
}

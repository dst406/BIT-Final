package com.varchar.www.model.domain.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Posts {
	private int postRowNum;
	private int postNo;
	private int boardNo;
	private String boardName;
	private String userId;
	private String userName;
	private String postTitle;	
	private String postContents;
	private String postPreview;
	private String postThumbnail;
	private String postsDate;
	private int postViews;
	private int countComment;
	
	
}


package com.varchar.www.model.domain.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PostsList {
	private int postRowNum;
	private String boardName;
	private String boardIntro;
	private int boardNo;
	private int postNo;
	private String userId;
	private String postTitle;
	private String postContents;
	private String postsDate;
	private int postViews;
	private int commentCount;
	
}

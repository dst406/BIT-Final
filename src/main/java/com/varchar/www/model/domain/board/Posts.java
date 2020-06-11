package com.varchar.www.model.domain.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Posts {
	private int postNo;
	private int postRowNum;
	private String userId;
	private String postTitle;	
	private String postContents;
	private String postsDate;
	private int postViews;
}

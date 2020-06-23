package com.varchar.www.model.domain.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PostsDetailList {
	private int postRowNum;
	private int postNo;
	private String postTitle;
	private int postListCount;
}


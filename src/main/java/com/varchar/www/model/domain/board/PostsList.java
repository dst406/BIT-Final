package com.varchar.www.model.domain.board;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PostsList {
	private int boardNo;
	private String boardName;
	private String boardIntro;
	private List<Posts> posts; 
	
}

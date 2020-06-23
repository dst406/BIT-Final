package com.varchar.www.model.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter @ToString
public class BoardName {
	private String boardName;
	
	public BoardName() {}
	
	@Builder
	public BoardName( String boardName) {
		this.boardName = boardName;
	}
	
}


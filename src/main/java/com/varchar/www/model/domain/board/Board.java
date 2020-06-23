package com.varchar.www.model.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class Board {
	private int boardNo;
	private String boardName;
	private String boardIntro;
	private int boardOrder;
	
	public Board() {}
	
	@Builder
	public Board(int boardNo,  String boardName) {
		this.boardNo = boardNo;
		this.boardName = boardName;
	}
	
}

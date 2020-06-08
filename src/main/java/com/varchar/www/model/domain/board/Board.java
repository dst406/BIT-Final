package com.varchar.www.model.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class Board {
	private int boardNo;
	private int boardGroupNo;
	private String boardName;
	private String boardIntro;
	private int boardOrder;
	
	public Board() {}
	
	@Builder
	public Board(int boardNo, int boardGroupNo, String boardName,int boardOrder) {
		this.boardNo = boardNo;
		this.boardGroupNo = boardGroupNo;
		this.boardName = boardName;
		this.boardOrder = boardOrder;
	}
	
}

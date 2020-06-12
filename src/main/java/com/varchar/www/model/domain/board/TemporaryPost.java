package com.varchar.www.model.domain.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TemporaryPost {
	private int temporaryNo;
	private int boardNo;
	private String boardName;
	private String userId;
	private String temporaryTitle;	
	private String temporaryContents;
	private String temporaryDate;
}

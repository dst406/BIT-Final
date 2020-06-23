package com.varchar.www.model.domain.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TemporaryPostList {
	private int temporaryNo;
	private String userId;
	private String temporaryTitle;	
	private String temporaryDate;
}

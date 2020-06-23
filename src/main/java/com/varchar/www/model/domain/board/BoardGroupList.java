package com.varchar.www.model.domain.board;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BoardGroupList {
	public BoardGroupList() {}
	private String lectureCode;
	private String lectureName;
	private List<BoardGroup> boardGroup;
}

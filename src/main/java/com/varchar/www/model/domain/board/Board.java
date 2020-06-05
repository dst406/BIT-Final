package com.varchar.www.model.domain.board;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("board")
public class Board {
	public String seasonId;
}

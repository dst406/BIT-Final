package com.varchar.www.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.varchar.www.model.domain.board.Board;

@Controller
public class BoardController {
	
	@GetMapping("/boardList")
	public String getBoardList() {
		return "common/board/boardList";
	}
	
	@GetMapping("/postList")
	public String getPostList(Board board) {
		
		return "common/board/postList";
	}
	
	@GetMapping("/edit")
	public String getEditor() {
		return "common/board/editor";
	}
	
	@GetMapping("newPostForm")
	public String newPostForm() {
		return "common/board/newPostForm";
	}
	
}

package com.varchar.www.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.varchar.www.model.domain.board.BoardGroup;
import com.varchar.www.model.domain.board.BoardGroupList;
import com.varchar.www.model.service.BoardService;

@Controller
public class BoardController {
	
	
	@Autowired BoardService boardService;
	
	@GetMapping("/boardList")
	public String getBoardList() {
		return "common/board/boardList";
	}

	
	@GetMapping("/postList")
	public String getPostList(String boardNo) {
		
		return "common/board/postList";
	}
	
	@GetMapping("/edit")
	public String getEditor() {
		return "common/board/editor";
	}
	
	@GetMapping("/newPostForm")
	public String newPostForm() {
		return "common/board/newPostForm";
	}
	
	@GetMapping("/editPage")
	public String editPage() {
		return "common/board/fragment/editPage";
	}
	
	
	@GetMapping("/getNavbar/{userId}")
	public String getNavbar(@PathVariable("userId") String userId,Model model){
		model.addAttribute("boardGroupList",boardService.getNavbar(userId));
		
		return "include/nav/boardNavbar";
	}
	
	
	
	
}

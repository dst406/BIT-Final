package com.varchar.www.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
		//System.out.println("와썹맨");
		return "common/board/postList";
	}
	
	@GetMapping("/board/postList/{boardNo}")
	public String getPostList(@PathVariable int boardNo,Model model) {
		
		model.addAttribute("postsList",boardService.getPostList(boardNo));
		
		System.out.println(boardService.getPostList(boardNo));
		
		/* return "common/board/postList"; */
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
	

	@PostMapping("/insertBoardGroup")
	public String insertBoardGroup(String content, String lectureCode) {
		boardService.insertBoardGroup(content, lectureCode);
		//RedirectAttributes redirectAttributes
		//redirectAttributes.addFlashAttribute("result", "success");
		return "redirect:/getNavbar/jin2020";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard (String content, int boardGroupNo) {
		boardService.insertBoard(content, boardGroupNo);
		return "redirect:/getNavbar/jin2020";
		
	}
	
	@GetMapping("/getPost/{boardNo}/{postNo}")
	public String getPost(@PathVariable("boardNo") int boardNo,@PathVariable("postNo") int postNo,Model model) {
		model.addAttribute("posts", boardService.getPost());
		System.out.println(boardService.getPost());
		return "common/board/postInfo";
	}

	
	
	
}

package com.varchar.www.controller.response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.varchar.www.model.domain.board.Board;
import com.varchar.www.model.domain.board.TemporaryPost;
import com.varchar.www.model.service.BoardService;
import com.varchar.www.util.CustomParser;

@RestController
public class ResponseBoardController {
	
	@Autowired BoardService boardService;
	
	@PostMapping("/rest/board/imageUpload")
	public List<String> editorImageUpload( MultipartHttpServletRequest multipartHttpServletRequest ){
		System.out.println("여기는 왔어요 ? "+multipartHttpServletRequest.getFiles("files"));
		try {
			return new CustomParser().fileParser(multipartHttpServletRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@GetMapping("/getBoardNavBar")
	public List<Board> getBoardNavBar(){
		
		List<Board> boardList = new ArrayList<Board>();
		
		
		//int boardNo, int boardGroupNo, String boardName,int boardOrder
//		boardList.add(new Board(1,1,"엄쌤 무비 더 비기닝",1));
//		boardList.add(new Board(2,1,"엄쌤 무비 더 비기닝",2));
//		boardList.add(new Board(3,1,"엄쌤 무비 더 비기닝",3));
//		boardList.add(new Board(4,1,"엄쌤 무비 더 비기닝",4));
//		boardList.add(new Board(5,1,"엄쌤 무비 더 비기닝",5));
		
		return boardList;
		
	}
	
	@PostMapping("/updateBoardGroupName")
	public void updateBoardGroupName(String boardGroupName, String changeName, int boardGroupNo) {
		boardService.updateBoardGroupName(boardGroupName,changeName, boardGroupNo);
	}
	
	// 게시글 임시저장
//	@PostMapping("/insertTemporaryPost")
//	public TemporaryPost insertTemporaryPost(TemporaryPost temporaryPost, Model model) {
//		temporaryPost.setUserId("jin2020");
//		System.out.println(temporaryPost);
//		boardService.insertTemporaryPost(temporaryPost);
//		//model.addAttribute("temporaryPostList", boardService.getTemporaryPostList("jin2020"));
//		
//		return  null;
//	}



	
}





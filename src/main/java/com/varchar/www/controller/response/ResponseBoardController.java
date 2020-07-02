package com.varchar.www.controller.response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.varchar.www.model.dao.BoardDAO;
import com.varchar.www.model.service.BoardService;
import com.varchar.www.util.ImgUpload;

@RestController
public class ResponseBoardController {
	
	@Autowired BoardService boardService;

	@Autowired BoardDAO boardDAO;
 	
	@PostMapping("/board/imageUpload/{boardNo}")
	public List<String> editorImageUpload( MultipartHttpServletRequest   multipartHttpServletRequest, 
											@PathVariable int boardNo){
		try {
			// 이미지 저장 및 미리보기 파일명 [] return
			return new ImgUpload().uploadMultiFile(multipartHttpServletRequest,boardNo);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/board/updateBoardGroupName")
	public void updateBoardGroupName(String boardGroupName, String changeName, int boardGroupNo) {
		boardService.updateBoardGroupName(boardGroupName,changeName, boardGroupNo);
	}
	
	@GetMapping("/board/deleteTemporaryPost")
	public void deleteTemporaryPost(int temporaryNo) {
		boardService.deleteTemporaryPost(temporaryNo);
		
	}

	//게시판 수정
	@GetMapping({"/board/updateBoard/{boardNo}/{boardName}/", "/board/updateBoard/{boardNo}/{boardName}/{boardIntro}"})
	public void updateBoard(@PathVariable int boardNo, @PathVariable String boardName , 
							@PathVariable(name="boardIntro",required = false) Optional<String> boardIntro) {
		if(! boardIntro.isPresent()) 
			boardIntro = Optional.of("");
		
		boardDAO.updateBoard(boardNo,boardName, boardIntro.get());
	}
	

}





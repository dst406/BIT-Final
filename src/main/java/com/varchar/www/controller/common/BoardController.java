package com.varchar.www.controller.common;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.varchar.www.model.dao.BoardDAO;
import com.varchar.www.model.domain.board.Posts;
import com.varchar.www.model.domain.board.TemporaryPost;
import com.varchar.www.model.domain.comment.Comment;
import com.varchar.www.model.service.BoardService;

@Controller
public class BoardController {
	
	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new 
	    SimpleDateFormat("yyyy-MM-dd HH:mm:SS"), true));
	 }
	
	@Autowired BoardService boardService;
	@Autowired BoardDAO boardDAO;
	
	// 유저에 따른 내비게이션바 호출 
	@GetMapping("/getNavbar/{userId}")
	public String getNavbar(@PathVariable("userId") String userId,Model model){
		model.addAttribute("boardGroupList",boardService.getNavbar(userId));
		return "include/nav/boardNavbar";
	}
	
	
	/* 게시판 */
	
	//게시판 그룹 등록
	@PostMapping("/insertBoardGroup")
	public String insertBoardGroup(String content, String lectureCode) {
		boardService.insertBoardGroup(content, lectureCode);
		return "redirect:/getNavbar/jin2020";
	}
	
	//게시판 등록
	@PostMapping("/insertBoard")
	public String insertBoard (String content, int boardGroupNo) {
		boardService.insertBoard(content, boardGroupNo);
		return "redirect:/getNavbar/jin2020";
	}
	
	
	/* 게시글 */

	
	@PostMapping("/getSearchDatePostList")
	public String getSearchDatePostList( int boardNo, String startDate, String endDate, Model model) {
		System.out.println(boardNo+"  " +startDate+"  "+ endDate);
		
		model.addAttribute("posts",boardService.getSearchDatePostList(boardNo, startDate, endDate));
		model.addAttribute("boardNo", boardNo);
		return "common/board/fragment/postListFragment :: boardPostList";
	}
	
	// 게시글 리스트 조회
	@GetMapping("/board/postList/{boardNo}")
	public String getPostList(@ModelAttribute @PathVariable int boardNo,Model model) {
		model.addAttribute("postsList",boardService.getPostList(boardNo));
		System.out.println(boardService.getPostList(boardNo));
		return "common/board/postList";
	}

	// 내 게시글 리스트 조회 
	@GetMapping("/getSearchMyPostList/{boardNo}")
	public String getSearchMyPostList(@PathVariable @ModelAttribute int boardNo, Model model) {
		String userId="jin2020";
		model.addAttribute("posts",boardDAO.postList(boardNo, userId));
		System.out.println(boardDAO.postList(boardNo, userId));
		return "common/board/fragment/postListFragment :: boardPostList";
	}
	
	//게시글 등록폼
	@GetMapping("/newPostForm/{boardNo}/{boardName}")
	public String newPostForm(Posts posts, @ModelAttribute @PathVariable String boardName,
			 				   			   @ModelAttribute @PathVariable int boardNo, Model model) {
		model.addAttribute("temporaryPostList", boardService.getTemporaryPostList("jin2020"));
		return "common/board/newPostForm";
	}

	//게시글 등록
	@PostMapping("/insertPosts")
	public String insertPosts(Posts posts) {
		posts.setUserId("187-004");
		boardService.insertPosts(posts);
		System.out.println(posts);
		return "redirect:/board/postList/"+posts.getBoardNo();
	}
	
	// 게시글 임시저장
	@PostMapping("/insertTemporaryPost")
	public String insertTemporaryPost(TemporaryPost temporaryPost, Model model) {
		temporaryPost.setUserId("jin2020");
		boardService.insertTemporaryPost(temporaryPost);
		return  "redirect:/getTemporaryList/jin2020";
	}
	
	// 게시글 Detail
	@GetMapping("/getPost/{boardNo}/{postNo}")
	public String getPost(@PathVariable("boardNo") int boardNo,
						  @PathVariable("postNo")  int postNo ,  Model model) {
		model.addAttribute("posts", boardService.getPost(boardNo, postNo));
		return "common/board/postInfo";
	}
	
	
	// 임시저장된 게시글 조회
	@GetMapping("/getTemporaryPost/{temporaryNo}")
	public String getTemporaryPost(@PathVariable("temporaryNo") int temporaryNo, Model model) {
		model.addAttribute("temporaryPost", boardService.getTemporaryPost(temporaryNo));
		model.addAttribute("temporaryPostList", boardService.getTemporaryPostList("jin2020"));
		return "common/board/temporaryPostDetail";
	}
	
	// 임시저장리스트 조회
	@GetMapping("/getTemporaryList/{userId}")
	public String getTemporaryList(Model model, @PathVariable String userId) {
		model.addAttribute("temporaryPostList", boardService.getTemporaryPostList(userId));
		return "common/board/fragment/temporaryPostList :: temporaryPostList";
	}
	
	
	/* 댓글 */
	
	//댓글 등록
	@PostMapping("/insertPostComment")
	public String insertPostComment(Comment comment, int postNo,Model model) {
		comment.setUserId("jin2020");
		boardService.insertPostComment(comment,postNo);
		model.addAttribute("commentList", boardDAO.getCommentList(postNo));
		
		return "common/board/fragment/commentList :: getCommentList";
	}
	
	//답글 등록
	@PostMapping("/insertReply")
	public String insertReply(Comment comment, int postNo, Model model) {
		comment.setUserId("kojae2020");
		boardDAO.insertReply(comment, postNo);
		model.addAttribute("replyList", boardDAO.getReplyInReply(comment.getCommentNo()));
		return "common/board/fragment/replyList :: getReplyList";
	}

	
	
}

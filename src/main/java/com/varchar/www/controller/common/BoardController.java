package com.varchar.www.controller.common;

import java.security.Principal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varchar.www.login.AcademyUser;
import com.varchar.www.model.dao.BoardDAO;
import com.varchar.www.model.domain.board.Posts;
import com.varchar.www.model.domain.board.TemporaryPost;
import com.varchar.www.model.domain.comment.Comment;
import com.varchar.www.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, 
	    		new CustomDateEditor(new  SimpleDateFormat("yyyy-MM-dd HH:mm:SS"), true));
	 }
	
	@Autowired BoardService boardService;
	@Autowired BoardDAO boardDAO;
	
	// 유저에 따른 내비게이션바 호출  (처음에만 호출)
	@GetMapping("/getNavbar")
	public String getNavbar(@AuthenticationPrincipal AcademyUser user, Model model){
		model.addAttribute("boardGroupList",boardService.getNavbar( user.getUserId() , user.getAuthorityCode() ) );
		return "layout/navBar :: leftNavBar";
	}
	

	// ModelAttribute method Level에서  게시판 상태값 유지  
	@ModelAttribute
	public void getBoardNavbar(@AuthenticationPrincipal AcademyUser user ,Model model ){
		model.addAttribute("boardGroupList",boardService.getNavbar(user.getUserId() , user.getAuthorityCode()));
	}
	
	// 토큰으로 userId 꺼냄. 매번 요청   
	@ModelAttribute
	public String userId(@AuthenticationPrincipal AcademyUser user) {
		return user.getUserId();
	}
	
	
	
	
	
	/* 게시판 */
	
	//게시판 그룹 등록
	@PostMapping("/insertBoardGroup")
	public String insertBoardGroup( @ModelAttribute String userId, String content, String lectureCode) {
		boardService.insertBoardGroup(content, lectureCode);
		return "redirect:/board/getNavbar";
	}
	
	//게시판 등록
	@PostMapping("/insertBoard")
	public String insertBoard ( @ModelAttribute String userId, String content, int boardGroupNo) {
		boardService.insertBoard(content, boardGroupNo);
		return "redirect:/board/getNavbar";
	}
	
	/* 게시글 */
	
	// 게시글 일자로 검색
	@PostMapping("/getSearchDatePostList")
	public String getSearchDatePostList( int boardNo, String startDate, String endDate, Model model) {
		model.addAttribute("posts",boardService.getSearchDatePostList(boardNo, startDate, endDate));
		model.addAttribute("boardNo", boardNo);
		return "common/board/fragment/postListFragment :: boardPostList";
	}
	
	// 게시글 리스트 조회
	@GetMapping({"/postList","/postList/{boardNo}"})
	public String getPostList(@ModelAttribute @PathVariable(name="boardNo",required = false) Optional<Integer> boardNo,
								@ModelAttribute String userId, Model model) {
		// 학생이 접속하면 Pathvariable로 못받으니  boardNo가 없어서 
		if(! boardNo.isPresent()) {
			// Default로 0으로 셋팅해주고
			boardNo = Optional.of(0);
			// 0으로 DB로 접근해서 동적으로 결제내역으로 lectureCode를 구한 후 boardNo를 구한다.
			model.addAttribute("postsList",boardService.getPostList(boardNo.get().intValue(),userId));
		}else {
			// 그냥 접속하는거면 Pathvariable로 접근.  boardNo 가 있음. Integer 로 받아서 int로 형변환
		model.addAttribute("postsList",boardService.getPostList(boardNo.get().intValue(), userId));
		}
		return "common/board/postList";
	}

	// 내 게시글 리스트 조회 
	@GetMapping("/getSearchMyPostList/{boardNo}")
	public String getSearchMyPostList( @ModelAttribute String userId,@PathVariable @ModelAttribute int boardNo, Model model) {
		model.addAttribute("posts",boardDAO.postList(boardNo, userId));
		return "common/board/fragment/postListFragment :: boardPostList";
	}
	
	//게시글 등록폼
	@GetMapping("/newPostForm/{boardNo}/{boardName}")
	public String newPostForm(Posts posts, @ModelAttribute @PathVariable String boardName,
			 				   			   @ModelAttribute @PathVariable int boardNo,
			 				   			   @ModelAttribute String userId, Model model) {
		model.addAttribute("temporaryPostList", boardService.getTemporaryPostList(userId));
		return "common/board/newPostForm";
	}

	//게시글 등록
	@PostMapping("/insertPosts")
	public String insertPosts(Posts posts, Authentication auth) {
		posts.setUserId( ((AcademyUser) auth.getPrincipal()).getUserId()  );
		boardService.insertPosts(posts);
		return "redirect:/board/postList/"+posts.getBoardNo();
	}
	
	// 게시글 임시저장
	@PostMapping("/insertTemporaryPost")
	public String insertTemporaryPost( @ModelAttribute String userId ,TemporaryPost temporaryPost, Model model) {
		temporaryPost.setUserId(userId);
		boardService.insertTemporaryPost(temporaryPost);
		return  "redirect:/board/getTemporaryList";
	}
	
	// 게시글 Detail
	@GetMapping("/getPost/{boardNo}/{postNo}")
	public String getPost(@PathVariable("boardNo") int boardNo,
						  @PathVariable("postNo")  int postNo ,  Model model) {
		model.addAttribute("posts", boardService.getPost(boardNo, postNo));
		return "common/board/postInfo";
	}
	
	// 게시글 수정폼
	@GetMapping("/updatePostForm/{postNo}")
	public String updatePostForm(@PathVariable @ModelAttribute int postNo,
			  					 @ModelAttribute String userId, Model model) {
		// DB접근 후 게시글 디테일 가져오기 1:다 필요없으니까 새로 가져오기
		model.addAttribute("post", boardService.getPostUpdateForm(postNo));
		model.addAttribute("temporaryPostList", boardService.getTemporaryPostList(userId));
		return "common/board/updatePostForm";
	}
	
	@PostMapping("/updatePost")
	public String updatePost(Posts post, Authentication auth) {
		boardService.updatePost(post);
		return "redirect:/board/getPost/"+post.getBoardNo()+"/"+post.getPostNo();
	}
	
	
	// 게시글 삭제
	@GetMapping("/deletePost/{postNo}/{boardNo}")
	public String deletePost(@PathVariable int postNo, @PathVariable int boardNo) {
		boardDAO.deletePost(postNo);
		return "redirect:/board/postList/"+boardNo;
	}
	
	// 임시저장된 게시글 조회
	@GetMapping("/getTemporaryPost/{temporaryNo}")
	public String getTemporaryPost(  @ModelAttribute String userId ,
									@PathVariable("temporaryNo") int temporaryNo, Model model) {
		model.addAttribute("temporaryPost", boardService.getTemporaryPost(temporaryNo));
		model.addAttribute("temporaryPostList", boardService.getTemporaryPostList(userId));
		return "common/board/temporaryPostDetail";
	}
	
	// 임시저장리스트 조회
	@GetMapping("/getTemporaryList")
	public String getTemporaryList(Model model,  @ModelAttribute String userId) {
		model.addAttribute("temporaryPostList", boardService.getTemporaryPostList(userId));
		return "common/board/fragment/temporaryPostList :: temporaryPostList";
	}
	
	
	/* 댓글 */
	
	//댓글 등록
	@PostMapping("/insertPostComment")
	public String insertPostComment( @ModelAttribute String userId , Comment comment, int postNo,Model model) {
		comment.setUserId(userId);
		boardService.insertPostComment(comment,postNo);
		model.addAttribute("commentList", boardDAO.getCommentList(postNo));
		
		return "common/board/fragment/commentList :: getCommentList";
	}
	
	//답글 등록
	@PostMapping("/insertReply")
	public String insertReply(@ModelAttribute String userId, Comment comment, int postNo,Model model) {
		comment.setUserId(userId);
		boardDAO.insertReply(comment, postNo);
		model.addAttribute("replyList", boardDAO.getReplyList(comment.getCommentNo()));
		model.addAttribute("comment", comment);
		return "common/board/fragment/replyList :: getReplyList";
		
	}
	
	//답글의 답글 등록
	@PostMapping("/insertReplyInReply")
	public String insertReplyInReply(@ModelAttribute String userId, Comment comment, int postNo,Model model) {
		comment.setUserId(userId);
		boardDAO.insertReply(comment, postNo);
		model.addAttribute("replyInReplyComment", boardDAO.getReplyList(comment.getCommentNo()));
		model.addAttribute("replyCommentNo", comment.getCommentNo());
		return "common/board/fragment/replyInReply :: getReReplyList";
	}
	
	
}

package com.varchar.www.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varchar.www.model.dao.BoardDAO;
import com.varchar.www.model.domain.board.BoardGroupList;
import com.varchar.www.model.domain.board.PostDetail;
import com.varchar.www.model.domain.board.Posts;
import com.varchar.www.model.domain.board.PostsList;
import com.varchar.www.model.domain.board.TemporaryPost;
import com.varchar.www.model.domain.board.TemporaryPostList;
import com.varchar.www.model.domain.comment.Comment;
import com.varchar.www.model.service.BoardService;

@Service("boardServiceImpl")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDAO boardDAO;
	
	@Override
	public List<BoardGroupList> getNavbar(String userId) {
		
		return boardDAO.getNavbar(userId);
	}

	@Override
	@Transactional
	public void insertBoardGroup(String content, String lectureCode) {
		boardDAO.insertBoardGroup(content, lectureCode);
		
	}

	@Override
	public void updateBoardGroupName(String boardGroupName, String changeName,int boardGroupNo) {
		boardDAO.updateBoardGroupName(boardGroupName, changeName,boardGroupNo);
		
	}

	@Override
	public void insertBoard(String content, int boardGroupNo) {
		boardDAO.insertBoard(content, boardGroupNo);
		
	}

	@Override
	public PostsList getPostList(int boardNo) {
		return boardDAO.getPostList(boardNo);
	}

	
	@Override
	public PostDetail getPost(int boardNo, int postNo) {
			   boardDAO.updatePostViewCount(postNo);
		return boardDAO.getPost( boardNo, postNo);
	}

	@Override
	public void insertPosts(Posts posts) {
		try {
		boardDAO.insertPosts(posts);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TemporaryPostList> getTemporaryPostList(String userId) {
		return boardDAO.getTemporaryPostList(userId);
	}

	@Override
	public void insertTemporaryPost(TemporaryPost temporaryPost) {
		boardDAO.insertTemporaryPost(temporaryPost);
	}

	@Override
	public TemporaryPost getTemporaryPost(int temporaryNo) {
		TemporaryPost temporaryPost = boardDAO.getTemporaryPost(temporaryNo);
		temporaryPost.setBoardName(boardDAO.getBoardName(temporaryPost.getBoardNo()));
		return temporaryPost;
	}

	@Override
	public void insertPostComment(Comment comment, int postNo) {
		boardDAO.insertPostComment(comment,postNo);
		
	}

	@Override
	public void insertReply(Comment comment,int postNo) {
		boardDAO.insertReply(comment, postNo);
	}

	@Override
	public List<Posts> getSearchDatePostList(int boardNo, String startDate, String endDate) {
		return boardDAO.getSearchDatePostList(boardNo, startDate, endDate);
	}

	@Override
	public void deleteTemporaryPost(int temporaryNo) {
		boardDAO.deleteTemporaryPost(temporaryNo);
		
	}



}

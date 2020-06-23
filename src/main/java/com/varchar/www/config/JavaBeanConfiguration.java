package com.varchar.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import com.varchar.www.model.domain.board.Board;
import com.varchar.www.model.domain.board.BoardGroup;
import com.varchar.www.model.domain.board.BoardGroupList;

import com.varchar.www.model.domain.board.PostDetail;
import com.varchar.www.model.domain.board.Posts;
import com.varchar.www.model.domain.board.PostsDetailList;
import com.varchar.www.model.domain.board.PostsList;
import com.varchar.www.model.domain.comment.ReplyComment;

@Configuration
public class JavaBeanConfiguration {
	
	@Bean
	public LogAspectJ logAspectJ() { return new LogAspectJ(); }
	 
	//  @Bean public Season season() {return new Season();}
	 
	 @Bean public Board board() {return new Board();}
	 @Bean public BoardGroup boardGroup() {return new BoardGroup();}
	 @Bean public BoardGroupList boardGroupList() {return new BoardGroupList();}

	 @Bean public Posts posts() {return new Posts();}
	 @Bean public PostsList postsList() {return new PostsList();}
	 @Bean public PostDetail postDetail() {return new PostDetail();}
	 @Bean public PostsDetailList postsDetailList() {return new PostsDetailList();}
	 @Bean public ReplyComment replyComment() {return new ReplyComment();}
	 
	 @Bean
	 public MultipartResolver multipartResolver() {
	     return new StandardServletMultipartResolver();
	 }
	 
}

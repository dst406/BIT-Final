package com.varchar.www.controller.response;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.varchar.www.util.CustomParser;

@Controller
public class ResponseBoardController {
	
	@PostMapping("rest/board/imageUpload")
	@ResponseBody
	public List<String> editorImageUpload( MultipartHttpServletRequest multipartHttpServletRequest ){
		System.out.println("여기는 왔어요 ? "+multipartHttpServletRequest.getFiles("files"));
		try {
			return new CustomParser().fileParser(multipartHttpServletRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}





package com.varchar.www.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

public class CustomParser {
	public List<String> fileParser(MultipartRequest multipartRequest) throws IOException {
		String filePath = "D:/varchar/images/";
		//파일들을 List형식으로 보관
		List<MultipartFile> files = multipartRequest.getFiles("files");
		
		File file = new File(filePath);
		//파일이 없다면 디렉토리를 생성
		if (file.exists() == false) {
			file.mkdirs();
		}
//      ------------주요 메소드-------------		
//		String getName() : 파라미터 이름을 구한다.   
//		String getOriginalFilename() : 업로드 한 파일의 실제!! 이름을 구한다.  
//		boolean isEmpty() : 업로드 한 파일이 존재하지 않는 경우 true를 리턴한다.  
//		long getSize() : 업로드한 파일의 크기를 구한다.  
//		byte[] getBytes() throws IOException : 업로드 한 파일 데이터를 구한다. --> 이걸로 파일 쓰면된다. 
//		InputStream getInputStream() : InputStrem을 구한다. 
//		void transferTo(File dest) : 업로드 한 파일 데이터를 지정한 파일에 저장한다. --> 요고도 파일쓰는거다.

		List<String> imageList = new ArrayList<String>();
		for (int i = 0; i < files.size(); i++) {
			//파일 업로드 소스 여기에 삽입
			file = new File(filePath+files.get(i).getOriginalFilename());
			files.get(i).transferTo(file);	
			imageList.add(file.getName());
		}		
		//new Gson().toJson(imageList)
		return imageList;
	}
}


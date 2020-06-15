# varchar
비트캠프 3조 최종프로젝트 

------------------------------------------------------------------------------
                              Project Code 설명
                              
                              
                             < magnific-popup > 
                             
Modal창으로 gitbook EditPage 구현하는 방법. ( gitbook Layout을 벤치마킹 ) 
1. 팝업이 뜨면 보여줄 Layer를 Html파일로 작성한다.
2. 이벤트가 일어날 태그에 data-mfp-src= "Layer 최상단 class 이름" 을 붙혀준다.
  
  ex) 
  ```
  <a href="javascript:void(0)" data-mfp-src=".editBoardGroupPanelWrapper " class="editPage-popup-link"></a>
  ```
  
  
3. jquery 명령어로 getModalFormEditPage("이벤트가 일어날 class명", "모달창을 닫히게 할 수 있는 버튼의 class명") 을 적어준다.
 


 - html -
 ```
 <div th:replace="~{common/board/fragment/editPage :: editPage ( ${boardGroupList} ) }">
 <a href="javascript:void(0)" data-mfp-src=".editBoardGroupPanelWrapper " class="editPage-popup-link">
   <i class="fas fa-plus group_plus"></i>
  </a>
 ``` 
  
- js - 
```
$(function(){
  getModalFormEditPage("editPage-popup-link", ".boardGroupPanelHeaderClose");
})
```

 
------------------------------------------------------------------------------
                              Update 로그
------------------------------------------------------------------------------
06-02 09:46 :  Create Git repository
06-02 17:00 :  kojae merge Git Repository 
<<<<<<< HEAD
=======

06-05  09:33 : kojae merge Master Git Repository 
06-05  19:10 : kojae merge Master Git Repository 

06-08 20:26 : kojae merge Master Git Repository 

------------------------------------------------------------------------------


#고재현
06-02 : 패키지구조 설정, SpringBoot Project DB까지 설정 완료 



#김종성


#진보형 
06-02 : 샘플데이터 작성중
깃 브랜치 생성, 커밋완료!!!
>>>>>>> 17eeb77bb5397b69981c3edbbc3c4035a08e7e3e

06-05  09:33 : kojae merge Master Git Repository 
06-05  19:10 : kojae merge Master Git Repository 

06-08 20:26 : kojae merge Master Git Repository 

------------------------------------------------------------------------------

06-02 : 패키지구조 설정, SpringBoot Project DB까지 설정 완료 

------------------------------------------------------------------------------

06-03 : JDBC 로그 레벨 상승. TEST로 데이터 잘 넘어오는지 확인
        thymeleaf 템플릿으로 반복적인 게시판 View 부분 Fragment 설정



------------------------------------------------------------------------------

06-04 : 게시글 리스트 , 게시글 등록 폼 제작.
- 텍스트 에디터 제작 -
H1,H2,H3,H4, Bold, Itelic, blackQuote, link, image - drag&drop 으로 올리기

------------------------------------------------------------------------------
<<<<<<< HEAD

#고재현
06-05 : 
customEditor : 이미지 등록 후 해당 강의에 맞는 폴더에 이미지 저장
navBar : 드롭업, 드롭다운 이벤트 구현
=======

06-05 : 
customEditor : 이미지 등록 후 해당 강의에 맞는 폴더에 이미지 저장
navBar : 드롭업, 드롭다운 이벤트 구현


------------------------------------------------------------------------------

06-08 : 
magnific js lib를 사용해
게시판 그룹 명 수정 Modal, 게시판  그룹 등록 Popup 작성
내비게이션 이벤트 : 여러개 요소 있을 때 클릭 시 나열되는 이벤트 구현
MockMvc Test 코드로 Test 구현 


------------------------------------------------------------------------------

06-09 : 
Thymeleaf Layout lib 를 사용하여 layout 지정.

강의별 게시판 완료.  Collection 사용해서 1:N SELECT
게시판 그룹 완료. INSERT 이후 강의별 게시판 컨트롤러 갔다오기


------------------------------------------------------------------------------

06-10 :
좌측 내비게이션 바 이벤트 처리 완료

( 강의별 게시판그룹 ON,OFF
  강의별 게시판그룹별 게시판 리스트 ON,OFF)
게시판그룹 등록, 게시판 그룹 수정. 게시판 등록 완료
게시판 클릭 시 게시글 리스트 뜨게하기.

------------------------------------------------------------------------------

06-11 :
게시판 클릭 시 게시글 조회 : 한개의 게시판에 여러개의 게시글리스트 조회 - 완료

게시글 등록 : execCommend로 만든 HTML 마크업 코드들 모두 DB에 저장   - 완료
게시글 조회 : DB에서 불러온 HTML 마크업 코드들을 적용. 게시글 상세에서 해당 게시판의 게시글이 뜨게끔 내비게이션 기능 적용.  - 완료
게시글 조회 - 게시글 내비게이션에 해당하는 HTML, CSS 적용 완료

------------------------------------------------------------------------------

06-12 :
게시글 등록 - 게시판명이 보이고 클릭 시 해당 게시판으로 이동.

임시저장 - 비동기로 임시저장 후,  임시저장 리스트 등록 , 임시저장 DB에 등록
임시저장 리스트 클릭 시 임시저장 게시글을 조회, 수정가능
게시글리스트 검색기능  - 검색한 텍스트가 노란색으로 마크됨.
내비게이션바 ON/OFF 화살표 이벤트 처리
구현했는데 자잘한 버그 수정..

------------------------------------------------------------------------------

06-14 :
댓글 조회, 댓글등록, 답글등록, 답글조회, 답글의 답글조회 완료

미완성 : 답글의 답글 등록,  댓글 등록 시 comment.js 이벤트가 끊김




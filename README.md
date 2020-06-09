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
MockMvc Test 코드로 구현 방법을 배움.
>>>>>>> 32d980a0133fd074f79e09579a782fe5805c9703


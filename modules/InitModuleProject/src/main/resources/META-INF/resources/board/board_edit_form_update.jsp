<%@page import="InitModuleProject.constants.ConstantsCommands"%>
<%@page import="javax.portlet.WindowState"%>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>



<!-- 게시판 목록으로 -->
<liferay-portlet:renderURL var="BoardListURL" windowState="<%=WindowState.MAXIMIZED.toString()%>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=ConstantsCommands.HHLBOARD_LIST_PROJECT%>"/>
</liferay-portlet:renderURL>

<!-- 게시글 보기 -->
<liferay-portlet:renderURL var="SubjectViewURL" windowState="<%=WindowState.MAXIMIZED.toString() %>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=ConstantsCommands.HHLBOARD_VIEW_PROJECT%>"/>
</liferay-portlet:renderURL>


<!-- 글수정 -->
<liferay-portlet:actionURL var="UpdateSubjectURL" name="<%=ConstantsCommands.HHLBOARD_UPDATE_PROJECT%>">
<liferay-portlet:param name="bno" value="${tbl.bno}"/>
</liferay-portlet:actionURL>

<!-- 파일업로드 -->
<liferay-portlet:resourceURL var="FileUploadURL" id="<%=ConstantsCommands.HHLBOARD_FILEUPLOAD_PROJECT%>">
<liferay-portlet:param name="bno" value="${tbl.bno}"/>
</liferay-portlet:resourceURL>

<!-- 파일삭제 리소스 -->
<liferay-portlet:resourceURL var="FileFormDeleteURL" id="<%=ConstantsCommands.HHLBOARD_FILEDELETE_PROJECT %>"/>





<div>글번호 : ${tbl.bno}</div>
<div class="container mt-5 justify-content-center">
		<div class="d-flex justify-content-end">
			<a class="btn btn-outline-dark" href="${BoardListURL}
				&<portlet:namespace/>i=${currentPage}
				&<portlet:namespace/>cntPerPage=${cntPerPage}
				&<portlet:namespace/>option=${option}
				&<portlet:namespace/>keyword=${keyword}
				&<portlet:namespace/>ORDER=${ORDER}">
				목록
			</a>
		</div>
		<hr>	
   <div class="w-100 shadow p-5">
      <h3 class="mb-5">글수정</h3>
      <form id="editForm" name="editForm" onsubmit="return false;" method="post" action="${UpdateSubjectURL}" enctype="multipart/form-data">          
         <div class="d-flex form-group">
            <label for="writer" class="col-md-1 mt-2">작성자</label>
            <span>${userName}</span>
          	<input type="hidden" value="${userName}" name="<portlet:namespace/>writer"/>
         </div>
         
         <div class="d-flex form-group">
            <label for="subject" class="col-md-1 mt-2">제목</label>
            <input id="subject" type="text" class="form-control col-md-11" value="${tbl.subject}" name="<portlet:namespace/>subject" placeholder="제목을 입력하세요."/>
         </div>
         
         <div class="d-flex form-group">
            <label for="contents" class="col-md-1 mt-2">내용</label>
            <textarea class="form-control" rows="10" id="editor4" name="<portlet:namespace/>contents" title="내용을 입력해 주세요">${tbl.subject}</textarea>
          </div>
			
  			
         	<div class="d-flex form-group">
         	 	<label for="contents" class="col-md-1 mt-2">첨부</label>
            	<button  id="btn-upload" type="button" class="btn btn-success m-1"><i class="fa-solid fa-circle-plus"></i> 추가</button>
            	
            	<input id="input_file" multiple="multiple" type="file" style="display:none;">
         	</div>
         	
         	
         	<div class="d-flex form-group data_file_txt">
         	 	<label class="col-md-1 mt-2">상세:</label>
				<br />
				<div id="detailfileChange" class="w-100 border">
					<span style="color: gray;">※첨부파일은 최대 10개까지 등록이 가능합니다.</span>
					<hr/>
				</div>
         	</div>
         	

        <hr>
         
         <c:if test="${fileList != null}">
		<div class="d-flex row justify-content-between">
<!-- 			<div class="d-flex justify-content-start">

			</div> -->
					
			<!-- 파일테이블 --> 		
			<c:forEach var="li" items="${fileList}">
				<hr>
				<div id="li-${li.fno}" class="d-flex align-items-center">
					<button class="btn btn-primary" type="button" onclick="fileDown(${li.fno})">${li.FName}</button><i class="fa-solid fa-trash" onclick="fileDeleteDB(${li.fno})"></i>
				</div>
				<hr>
			</c:forEach>					
		</div>
		</c:if>
         
         <div class="form-group mt-4 text-center">
            <button type="submit" class="btn btn-primary m-1" ><i class="fa-solid fa-check"></i> 등록</button>
            <a type="button" class="btn btn-danger m-1" href='${BoardListURL}'><i class="fa-solid fa-x"></i> 취소</a>
         </div>		
      </form>
   </div>
</div>



<!-- 파일 업로드 스크립트 -->
<script>

$(document).ready(function(){
	
			// input file 파일 첨부시 fileCheck 함수 실행		
			$("#input_file").on("change", fileCheck); // 해당 셀렉터 태그에 값이 변함을 감지(change)
		});

/*
 * 첨부파일로직
 */
$(function () {
    $('#btn-upload').click(function (e) {
        e.preventDefault(); // 기본버튼클릭동작 방지 #input_file이 처리되야하기 때문
        $('#input_file').click();
    });
});
function fileDeleteDB(fno){
	var pass = confirm('파일을 삭제하시겠습니까?');
	if(pass){
		$.ajax({
			url : "${FileFormDeleteURL}",
			type : 'POST',
			data : {
				<portlet:namespace/>fno : fno
			},
			dataType : 'json',
			error : function(xhr, status, error) {
	   	    	alert("파일 삭제 실패!");
	   	     return false;
	   	      },
			success: function (data) {
	   	    	  console.log("data : ", data)
	   	    	if(data['result'] == "OK"){
	   	    		alert("파일이 삭제되었습니다.");
	   	    		$('#li-'+fno).remove();
				} else
					alert("서버오류입니다! 잠시 후 다시 시도해주세요");
	   	      }
		});
	}
}
/* ------ START : 변수설정------ */

// 파일 현재 필드 - 설정한 배열의갯수만큼 fileCount가 세팅
var fileCount = 0;
// 전체 업로드 갯수 설정 (10개로 세팅)
var totalCount = 10;
// 파일 고유넘버링
var fileNum = 0;
// 첨부파일 배열에 담기
var content_files = new Array();


/* ------ END : 변수설정------ */



$("#editForm").on("submit",function(e){
	
	//FormData 새로운 객체 생성 
	var formData = new FormData();
	
	
	

	 //제목 필수입력 
   var subject = $("#subject").val();
	if(subject.length == 0){
		alert("제목을 입력해주세요!");
		editForm.subject.focus();
		return;
	}
	
	


	 //제목 필수입력(정규식) 
	var subjectVaild = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|\s]+$/;
	if(subjectVaild.test(editForm.subject.value) == false){
		alert("제목 입력에는 (영문+한글+숫자)의 조합으로만 작성이 가능합니다. ");
		editForm.subject.focus();
		return false;
	}
	formData.append('<portlet:namespace/>subject', subject);
	 //내용 필수입력 
	var contents = CKEDITOR.instances.editor4.getData()
	if(contents.length < 1){
		alert("내용을 입력해주세요!");
		
		return false;
	}
	formData.append('<portlet:namespace/>contents', contents);
	var form = $("form")[0]; // [0]첫번째 form태그를 가져온다       
//  	var formData = new FormData(form); // fome태그 내부의 key와 value 전부를 가져온다
 		
		for (var j = 0; j < content_files.length; j++) {
			
			// 삭제 안한것만 담아 준다. 
			if(!content_files[j].is_delete){
				 formData.append("content_file", content_files[j]); // key와 value형태로 formData에 세팅
			}
		}
		 console.log(formData);
 	// 파일업로드 multiple ajax처리
	$.ajax({
   	      type: "POST",
   	   	  enctype: "multipart/form-data",
   	      url: "${FileUploadURL}",
       	  data : formData, // form형태를 배열로받아와 데이터 전송
       	  dataType :"json",
       	  processData: false, //파일 전송시  query string의 형태는 처리하지 못하므로 false처리
   	      contentType: false, 	// multipart form-data의 경우 false처리
   	      success: function (data) {
   	    	  console.log("data : ", data)
   	    	if(data['result'] == "OK"){
   	    		alert("게시글이 수정되었습니다.");
   	    		window.location.href = '${SubjectViewURL}&<portlet:namespace/>bno='+data['bno'];
			} else
				alert("서버오류입니다! 잠시 후 다시 시도해주세요");
   	      },
   	      error: function (xhr, status, error) {
   	    	window.location.href = '${SubjectViewURL}&<portlet:namespace/>bno='+data['bno'];
   	     return false;
   	      }
   	    });
   	    return false;
	
// 	document.editForm.submit();
	
})



/*-----START : fileCheck 이벤트--------- */
function fileCheck(e) {
	
	// 선택한 파일의 files 객체를 취득
    var files = e.target.files;
    
    // 객체를 파일 배열로 담기
    var filesArr = Array.prototype.slice.call(files); // 배열로 변환
    
    // 파일 개수 확인 및 제한(10개제한)
    if (fileCount + filesArr.length > totalCount) {
      $.alert('파일은 최대 '+totalCount+'개까지 업로드 할 수 있습니다.');
      return;
      
    } else {
    	 fileCount = fileCount + filesArr.length; // fileCount = 가져온 파일배열의 갯수(길이)
    }
    
    // 가져온 파일 배열을 각각으담기 및 기타
    filesArr.forEach(function (f) {
      var fileReader = new FileReader(); // 각각의 파일을 읽어서 result 속성에 저장
      fileReader.onload = function (e) {
        content_files.push(f); // 빈배열(var content_files)에 각각의 파일을 담기
        $('#detailfileChange').append( // 준비된 빈 태그에 가져온 파일의 결과 표시
       		'<div id="file' + fileNum + '" onclick="fileDelete(\'file' + fileNum + '\')">' // 클릭시 제거 가능하도록처리 
       		+ '<font style="font-size:12px">' + fileNum +'. ' + f.name + '</font>'  
       		+ '<i class="fa-solid fa-circle-minus" style="color:red"></i>' 
       		+ '<div/>'
       		+ '<hr/>'
		);
        fileNum ++; // 넘버링 반복할때마다 추가
      };
      fileReader.readAsDataURL(f); // 데이터를 URL로 표현으로 변환
    });
    console.log(content_files); //콘솔에 첨부한 파일의 배열표시
    
    // 첨부파일 태그 값 초기화 (다시 담을수 있게하기위함)
    // *input file multiple 특성상 중복파일은 업로드안됨 초기화 해야 중복파일도 업데이트가 가능
    $("#input_file").val("");
    
  }/*-----END : fileCheck 함수--------- */
  
  
  

// 파일 부분 삭제 함수 처리
function fileDelete(fileNum){ // 해당 넘버링 인자로 받음
	
    var no = fileNum.trim().replace(/[^0-9]/g, ""); // 문자열에서 숫자만 가져오기위해 정규식을 이용해 필터링처리
    content_files[no].is_delete = true; // content_files배열에 인덱스와 fileNum이 일치함으로 번호로 삭제가능
    	$('#' + fileNum).remove();
    	fileCount --;
        console.log(content_files);

}



	
</script>


<!-- ckEditor4 풀버전 -->
<script src="http://cdn.ckeditor.com/4.19.1/full/ckeditor.js"></script>
<!-- 텍스트ui설정 -->
<script type="text/javascript" src="${ctx}/js/editor4_setting.js"></script>
<!-- 제목/내용 필수입력(유효성검사).js -->
<%-- <script type="text/javascript" src="${ctx}/js/edit_valid.js"></script>
 --%><!-- 파일처리 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
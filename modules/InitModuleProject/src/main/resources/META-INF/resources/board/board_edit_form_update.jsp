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


<!-- 글수정 -->
<liferay-portlet:actionURL var="UpdateSubjectURL" name="<%=ConstantsCommands.HHLBOARD_UPDATE_PROJECT%>">
<liferay-portlet:param name="bno" value="${tbl.bno}"/>
</liferay-portlet:actionURL>


<div>글번호 : ${tbl.bno}</div>
<div class="container mt-5 justify-content-center">
		<div class="d-flex justify-content-end">
			<a class="btn btn-outline-dark" href="${BoardListURL}&<portlet:namespace/>i=${currentPage}&<portlet:namespace/>cntPerPage=${cntPerPage}&<portlet:namespace/>ORDER=${ORDER}">목록</a>
		</div>
		<hr>	
   <div class="w-100 shadow p-5">
      <h3 class="mb-5">글수정</h3>
      <form name="editForm" method="post" action="${UpdateSubjectURL}" enctype="multipart/form-data">          
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
				<div id="articlefileChange" class="w-100 border">
					<span style="color: gray;">※첨부파일은 최대 10개까지 등록이 가능합니다.</span>
					<hr/>
				</div>
         	</div>
         	

         <hr>
         
         <div class="form-group mt-4 text-center">
            <button type="button" onclick="inputChk()" class="btn btn-primary m-1" ><i class="fa-solid fa-check"></i> 수정</button>
            <a type="button" class="btn btn-danger m-1" 
            		href='${BoardListURL}
            		&<portlet:namespace/>i=${currentPage}
            		&<portlet:namespace/>cntPerPage=${cntPerPage}
            		&<portlet:namespace/>ORDER=${OREDER}'>
            		<i class="fa-solid fa-x"></i> 
            		취소
            </a>
         </div>		
      </form>
   </div>
</div>


<!-- 파일 업로드 스크립트 -->
<script>
$(document).ready(function()
		// input file 파일 첨부시 fileCheck 함수 실행
		{
			$("#input_file").on("change", fileCheck);
		});

/**
 * 첨부파일로직
 */
$(function () {
    $('#btn-upload').click(function (e) {
        e.preventDefault();
        $('#input_file').click();
    });
});

// 파일 현재 필드 숫자 totalCount랑 비교값
var fileCount = 0;
// 해당 숫자를 수정하여 전체 업로드 갯수를 정한다.
var totalCount = 10;
// 파일 고유넘버
var fileNum = 0;
// 첨부파일 배열
var content_files = new Array();

function fileCheck(e) {
    var files = e.target.files;
    
    // 파일 배열 담기
    var filesArr = Array.prototype.slice.call(files);
    
    // 파일 개수 확인 및 제한
    if (fileCount + filesArr.length > totalCount) {
      $.alert('파일은 최대 '+totalCount+'개까지 업로드 할 수 있습니다.');
      return;
    } else {
    	 fileCount = fileCount + filesArr.length;
    }
    
    // 각각의 파일 배열담기 및 기타
    filesArr.forEach(function (f) {
      var reader = new FileReader();
      reader.onload = function (e) {
        content_files.push(f);
        $('#articlefileChange').append(
       		'<div id="file' + fileNum + '" onclick="fileDelete(\'file' + fileNum + '\')">'
       		+ '<font style="font-size:12px">' + fileNum +'. ' + f.name + '</font>'  
       		+ '<i class="fa-solid fa-circle-minus" style="color:red"></i>' 
       		+ '<div/>'
       		+ '<hr/>'
		);
        fileNum ++;
      };
      reader.readAsDataURL(f);
    });
    console.log(content_files);
    //초기화 한다.
    $("#input_file").val("");
  }

// 파일 부분 삭제 함수
function fileDelete(fileNum){
	
        var no = fileNum.replace(/[^0-9]/g, "");
        content_files[no].is_delete = true;
    	$('#' + fileNum).remove();
    	fileCount --;
        console.log(content_files);

}

/*
 * 폼 submit 로직
 */
	function registerAction(){
		
	var form = $("form")[0];        
 	var formData = new FormData(form);
		for (var x = 0; x < content_files.length; x++) {
			// 삭제 안한것만 담아 준다. 
			if(!content_files[x].is_delete){
				 formData.append("article_file", content_files[x]);
			}
		}
   /*
   * 파일업로드 multiple ajax처리
   */    
	$.ajax({
   	      type: "POST",
   	   	  enctype: "multipart/form-data",
   	      url: "${UploadURL}",
       	  data : formData,
       	  processData: false,
   	      contentType: false,
   	      success: function (data) {
   	    	if(JSON.parse(data)['result'] == "OK"){
   	    		alert("파일업로드 성공");
			} else
				alert("서버내 오류로 처리가 지연되고있습니다. 잠시 후 다시 시도해주세요");
   	      },
   	      error: function (xhr, status, error) {
   	    	alert("서버오류로 지연되고있습니다. 잠시 후 다시 시도해주시기 바랍니다.");
   	     return false;
   	      }
   	    });
   	    return false;
	}
</script>


<!-- ckEditor4 풀버전 -->
<script src="http://cdn.ckeditor.com/4.19.1/full/ckeditor.js"></script>
<!-- 텍스트ui설정 -->
<script type="text/javascript" src="${ctx}/js/editor4_setting.js"></script>
<!-- 제목/내용 필수입력(유효성검사).js -->
<script type="text/javascript" src="${ctx}/js/edit_valid.js"></script>
<!-- 파일처리 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
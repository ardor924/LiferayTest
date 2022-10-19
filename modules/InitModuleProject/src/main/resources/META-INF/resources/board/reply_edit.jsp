<%@page import="InitModuleProject.constants.ConstantsCommands"%>
<%@page import="javax.portlet.WindowState"%>
<%@ include file="../init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet"%>


<!-- 댓글 등록 -->
<liferay-portlet:resourceURL var="AddReplyURL" id="<%=ConstantsCommands.HHLBOARD_REPLY_ADDLIST_PROJECT %>"/>

<!-- 댓글 리스트 -->
<liferay-portlet:resourceURL var="ShowListReplyURL" id="<%=ConstantsCommands.HHLBOARD_REPLY_SHOWLIST_PROJECT %>"/>

<!-- 댓글삭제 -->
<liferay-portlet:resourceURL var="DeleteReplyURL" id="<%=ConstantsCommands.HHLBOARD_REPLY_DELETE_PROJECT %>"/>

<!-- 댓글수정 -->
<liferay-portlet:resourceURL var="UpdateReplyURL" id="<%=ConstantsCommands.HHLBOARD_REPLY_UPDATE_PROJECT %>"/>

<!-- // START : 댓글 등록  -->
<div class="shadow p-3">
	<div class="d-flex justify-content-between p-3">
		<div class="col-13 w-100 d-flex justify-content-start">
			<span class="col-1">${userName}</span>
			<textarea id="rContents" name="rContents" class="col-11" rows="5" placeholder="댓글을 입력하세요"></textarea>
		</div>
	</div>
	<div class="d-flex justify-content-end mt-2">
		<p id="btn_reply_regist" class="btn btn-sm btn-success">댓글쓰기</p>
	</div>
</div>

<hr/>
<!-- // END : 댓글 등록  -->


<!-- // START : 댓글 목록 영역  -->
<div>
	<h4>답글내용</h4>
	<ul id="reply_list">
	
	</ul>
</div>
<!-- // END : 댓글 목록 영역  -->


<script type="text/javascript">
/* --------------- START : 파라미터---------------- */
var rWriter = "${userName}";
var bno = ${tbl.bno};
var rContents = $('textarea[name=rContents]').val();

/* --------------- END : 파라미터---------------- */


/* ------- START : document ready ---------------- */
$(function(){

	getList()
})	
/* ------- END : document ready ---------------- */




/* ----// START : 댓글정보 호출 이벤트(getList)---- */	
	function getList(){
	console.log("bno : " + bno)	
	console.log("rWriter : " + rWriter)	
	
	$.ajax({
		type : "get",
		url : "${ShowListReplyURL}",
		data : Liferay.Util.ns('<portlet:namespace/>',{
			bno : bno,
		}),
		dataType : "json",
		success : function(data){
			console.log("data : "+data)
			
			
			var html = "<li>";
			
			for(var i=0;i<data.length;i++){
				var length = data.length;
				console.log("데이터갯수 : "+length)
				var reply = JSON.parse(JSON.stringify(data[i]));
				var num = i
				
				     html += "<div>";
				     html +=     '<div class="d-flex justify-content-between p-3">';
				     html +=         '<div class="d-flex-row justify-content-start">';
				     html +=             '<h5>'+ reply.rWriter +'</h5>';
				     html +=         '<p>'+ reply.rContents +'</p>';
				     html +=         '<div>';
				     html +=             '<span>'+ reply.rRegDate +'</span>';
				     html +=         '</div>';
				     html +=      '</div>';
				     html +=      '<div id="toggle_end" class="d-flex justify-content-end m-2">';
				     html +=              '<h3 class="col-2 m-0 p-0" >';
				     html +=              	'<a id="toggle'+num+'" onclick="btn_toggle()" type="button"><i class="fa-solid fa-ellipsis-vertical"></i></a>';
				     html +=              '</h3>';
				     html +=              '<div id="toggle_side'+num+' class="toggle_side" class="m-0 d-flex row">';
				     html +=              	'<div class="update_reply btn btn-success text-white mb-2" onclick="update_reply('+num+')">수정</div>';
				     html +=              	'<div class="delete_reply btn btn-danger text-white mb-2" onclick="delete_reply('+reply.rno+')">삭제</div>';
				     html +=              '</div>';
				     html +=      '</div>';
				     html += '</div><hr>';
				     html += '<div id="addRepFrm'+num+'"></div>';

					num += 1
			}// END :for문
			
					
			html += "</li>";				
			
			$("#reply_list").html(html);
			$("#rContents").val("") //텍스트박스 댓글 초기화(댓글 작성 완료후)
				
				
			},  // END : success
			
		
	});  // END :ajax
		
		
		
	}	// END  : getList()	
/* ----// START : 댓글정보 호출 이벤트(getList)---- */		
	
	

/*---------//START : 클릭 이벤트(댓글등록) ----------*/
	$("#btn_reply_regist").click(function(){
		
		var rContents = $('textarea[name=rContents]').val();
		
		console.log("-----------btn_reply_regist------------")
		console.log("rContents : "+rContents)
		console.log("rWriter : "+rWriter)
		console.log("bno : "+bno)
		
		
		/* 파라미터 (DOM 실행 순서 주의) */
		$.ajax({
			type : 'post',
			url : '${AddReplyURL}',
			data : Liferay.Util.ns('<portlet:namespace/>',{		
				rContents : rContents,
				rWriter : rWriter,
				bno : bno,
			}),
			dataType : 'text',		
			success : function(data){
				console.log("data :"+data)
				alert("댓글등록 성공!")
				getList()
			},
			
			error : function(err){
				alert('통신에러 발생!')
			}
		});		
	});
/*---------//END : 클릭 이벤트(댓글등록) ---------*/












</script>

<!-- // END : 댓글 목록 영역  -->
<link rel="stylesheet" type="text/css" href="${ctx}/css/reply.form.css">

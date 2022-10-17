<%@page import="InitModuleProject.constants.ConstantsCommands"%>
<%@page import="javax.portlet.WindowState"%>
<%@ include file="../init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet"%>


<!-- // START : 댓글 등록 영역  -->
<liferay-portlet:resourceURL var="AddReplyURL" id="<%=ConstantsCommands.HHLBOARD_REPLY_ADDLIST_PROJECT %>"/>

<!-- 댓글삭제 -->
<liferay-portlet:resourceURL var="DeleteReplyURL" id="<%=ConstantsCommands.HHLBOARD_REPLY_DELETE_PROJECT %>"/>

<!-- 댓글수정 -->
<liferay-portlet:resourceURL var="UpdateReplyURL" id="<%=ConstantsCommands.HHLBOARD_REPLY_UPDATE_PROJECT %>"/>

<!-- // START : 댓글 등록 영역  -->
<div class="shadow p-3">
	<div>
	<form name="frm_reply">
		<div class="d-flex justify-content-between p-3">
			<div class="col-13 w-100 d-flex justify-content-start">
				<span class="col-1">${userName}</span>
				<textarea id="rep_contents" name="rep_contents" class="col-11" rows="5" placeholder="댓글을 입력하세요"></textarea>
			</div>
		</div>
			<div class="d-flex justify-content-end mt-2">
				<p id="btn_reply_regist" class="btn btn-sm btn-success">댓글쓰기</p>
			</div>
	</form>
	</div>
</div>

<hr/>
<!-- // END : 댓글 등록 영역  -->


<!-- // START : 댓글 목록 영역  -->
	<!-- 댓글헤드 고정 -->
	<div>
		<h4>답글내용</h4>
		<p id="replyList"></p>
	</div>
	<!-- 댓글헤드 고정 -->
<!-- // END : 댓글 목록 영역  -->


<script type="text/javascript">

var page = 1;

$(function(){
    $(window).scroll(function(){
        let $window = $(this);
        let scrollTop = $window.scrollTop();
        let windowHeight = $window.height();
        let documentHeight = $(document).height();
        
        console.log("documentHeight:" + documentHeight + " | scrollTop:" + scrollTop + " | windowHeight: " + windowHeight );
        
        // scrollbar의 thumb가 바닥 전 30px까지 도달 하면 리스트를 가져온다.
        if( scrollTop + windowHeight + 30 > documentHeight ){
            fetchList(page);
            page++;

        }
    })
    fetchList(page); //  최초에 리스트 가져온다.

    
})


//START : 클릭 이벤트
$("#btn_reply_regist").click(function(){

	/* 파라미터 (DOM 실행 순서 주의) */
	var rno;
	var bno = ${tbl.bno};
	var rWriter = '${userName}';
	var rContents = $('textarea[name=rep_contents]').val();

	$.ajax({
		type : 'post',
		url : '${AddReplyURL}',
		data : Liferay.Util.ns('<portlet:namespace/>',{		
			rContents : rContents,
			rWriter : rWriter,
			bno : bno,
			ajaxType : "post"

		}),
		dataType : 'text',
		
		success : function(data){
			alert("댓글등록 성공!")
			fetchList(page)
		},
		
		error : function(err){
			alert('통신에러 발생!')
		}
	});		
});
// END : 클릭 이벤트

	// START : DB정보 호출 이벤트
	function fetchList(page){
		var bno = ${tbl.bno}; 
		console.log("page : "+page)
		$.ajax({
			type : "post",
			url : "${AddReplyURL}",
			data : Liferay.Util.ns('<portlet:namespace/>',{		
				bno : bno,
				page : page,
				ajaxType :"get"
			}),
			dataType : "json",
			success : function(data){

		        
				//$("#replyList").html('');
				var html = "<div>";
				
				// data에 있는 JSONArray 파싱(반복문)
				for(var i=0; i<data.length; i++){
	                let length = data.length;
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
					     html +=              	'<div class="delete_reply btn btn-danger text-white mb-2" onclick="delete_reply('+reply.rno+','+page+')">삭제</div>';
					     html +=              '</div>';
					     html +=      '</div>';
					     html += '</div><hr>';
					     html += '<div id="addRepFrm'+num+'"></div>';

						
						num += 1
				}// END :for문
				
				 html += "</div>";
				 $("#replyList").append(html);	
				 $("#rep_contents").val("") //텍스트박스 댓글 초기화(댓글 작성 완료후)
				
		 
				
				 
			}, // END :success
			
		}); // END :ajax

		
	}; // END : DB정보 호출 이벤트





</script>

<!-- // END : 댓글 목록 영역  -->
<link rel="stylesheet" type="text/css" href="${ctx}/css/reply.form.css">

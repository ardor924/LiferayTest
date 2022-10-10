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


<div class="panel panel-default p-3">
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



<script type="text/javascript">
<!-- AjaxTest  -->
	
 	var page = 1;  //페이징과 같은 방식
 	
 	$(function(){  //페이지가 로드되면 데이터를 가져오고 page를 증가시킨다. (== document.ready와 같음)
         setAjax(page);
	console.log(page+"페이지")
         page++;
    });	
 	

    $(window).scroll(function(){   //스크롤이 최하단 으로 내려가면 리스트를 조회하고 page를 증가시킨다.
             if ($(window).scrollTop() >= $(document).height() - $(window).height()) {
			    setAjax(page);
        console.log(page+"페이지")
                   page++;
				}  
        });
	 
	
	// START : 클릭 이벤트
	$("#btn_reply_regist").click(function(){
	
		/* 파라미터 (DOM 실행 순서 주의) */
		var rno;
		var bno = ${tbl.bno};
		var rWriter = '${userName}';
		var rContents = $('textarea[name=rep_contents]').val();
		/* var rContents = $('#rep_contents').val();  */
		var regDate;
		var rIndent = 0;
		var rAnsNum = 0;
		var page = 1;

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
				setAjax(page)
			},
			
			error : function(err){
				alert('통신에러 발생!')
			}
		});		
	});
	// END : 클릭 이벤트
	
	
	// START : DB정보 호출 이벤트
	function setAjax(page){
		var bno = ${tbl.bno}; 
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
				
				 
				if(data.length < 1 ){
					html = '<div>댓글이 더이상 존재하지 않습니다.</div>';
					 $("#replyList").append(html);	
					 $("#rep_contents").val("") //텍스트박스 댓글 초기화(댓글 작성 완료후)
					alert("댓글이 더이상 존재하지 않습니다")
					 event.stopImmediatePropagation()
				} 
				
				//$("#replyList").html('');
				var html = "<div>";
				
				// data에 있는 JSONArray 파싱(반복문)
				for(var i=0; i<data.length; i++){
					var reply = JSON.parse(JSON.stringify(data[i]));
					var num = i
					
					     html += "<li class='list-group-item comments'>";
					     html +=     '<div class="d-flex justify-content-between p-3">';
					     html +=         '<div class="d-flex-row justify-content-start">';
					     html +=             '<h5>'+ reply.rWriter +'</h5>';
					     html +=         '<p>'+ reply.rContents +'</p>';
					     html +=         '<div>';
					     html +=             '<span>'+ reply.rRegDate +'</span>';
					     html +=             '<label class="text-black addRep" onclick="addRep('+num+')">   답글쓰기</label>';
					     html +=         '</div>';
					     html +=      '</div>';
					     html +=      '<div id="toggle_end" class="d-flex justify-content-end m-2">';
					     html +=              '<h3 class="col-2 m-0 p-0" >';
					     html +=              	'<a id="toggle'+num+'" onclick="btn_toggle()" type="button"><i class="fa-solid fa-ellipsis-vertical"></i></a>';
					     html +=              '</h3>';
					     html +=              '<div id="toggle_side'+num+' class="toggle_side" class="m-0 d-flex row">';
					     html +=              	'<div class="modify_reply btn btn-success text-white mb-2" onclick="update_reply('+reply.rno+','+reply.bno+','+reply.rWriter+','+reply.rContents+','+reply.rRegDate+','+page+')">수정</div>';
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


//STRAT : 답글 폼생성
function addRep(num){
	
	let showHide = document.querySelector('#addRepFrm'+num)
	showHide.classList.toggle("active");
	
	   var rAddWriter  = '${userName}';
	   /* var addRepFrmVal = $('#addRepFrm'+num).val() */
	  var addrep = '<div class="panel panel-default p-3 w-70 justify-content-center">'
	              +'	<div>                                                                                                                             '	
	              +'	<form name="frm_reply">                                                                                                           '
	              +'		<div class="d-flex justify-content-between p-3">                                                                              '
	              +'			<div class="col-13 w-100 d-flex justify-content-start">                                                                   '
	              +'				<span class="col-1"> '+rAddWriter+' </span>																			  '                                                                                
	              +'				<textarea id="rep_contents" name="rep_contents" class="col-11" rows="5"placeholder="댓글을 입력하세요"></textarea>    '
	              +'			</div>                                                                                                                    '
	              +'		</div>                                                                                                                        '
	              +'			<div class="d-flex justify-content-end mt-2">                                                                             '
	              +'				<p id="btn_active'+num+'" class="btn btn-sm btn-danger m-2" onclick="addrep_cancel('+num+')">취소</p>                                                      '
	              +'				<p id="btn_reply_regist" class="btn btn-sm btn-success m-2">등록</p>                                                      '
	              +'			</div>                                                                                                                    '
	              +'	</form>                                                                                                                           '
	              +'	</div>                                                                                                                            '
	              +'</div>                                                                                                                                '
	              +'                                                                                                                                      '
	              +'<hr/>'	          
	  		$('#addRepFrm'+num).html(addrep);	
	
	
}




//답글 폼 제거
function addrep_cancel(num){
	let showHide = document.querySelector('#addRepFrm'+num)
	showHide.classList.toggle("active");
}

// 토글 이벤트(수정/삭제)
function btn_toggle(){
	alert("토글!")
	let showHide = document.querySelector('#toggle'+num)
	showHide.classList.toggle("active");
}


//START : 클릭이벤트(삭제)
function delete_reply(rno,page){
		console.log(page+"페이지")
	$.ajax({
		type :"post",
		url : "${DeleteReplyURL}",
		data : Liferay.Util.ns('<portlet:namespace/>',{		
			rno : rno,
		}),
		dataType : "text",
		success : function(data){
			setAjax(page)
			alert(data+"댓글 삭제 성공했습니다")			
		},
		error : function(err){
			alert("댓글 삭제 실패했습니다")
		}
		
	})
	
}


//////
function update_reply(rno,bno,rWriter,rContents,rRegDate,page){
	console.log(page+"페이지")
	$.ajax({
		type :"post",
		url : "${UpdateReplyURL}",
		data : Liferay.Util.ns('<portlet:namespace/>',{		
			rno : rno,
			bno : bno,
			rWriter : rWriter,
			rContents : rContents,
			rRegDate : rRegDate,
			rindent : 0,
			rAnsNum : 0,
		}),
		dataType : "text",
		success : function(data){
			alert(data)
			alert(data+"댓글 수정 성공했습니다")			
		},
		error : function(err){
			alert("댓글 수정 실패했습니다")
		}
		
	})
	
	
}



</script>

<!-- // END : 댓글 목록 영역  -->

<style>
.addRep:hover{
	cursor: pointer;
	text-decoration: underline;
}

#replyList div~div:nth-child(3) {
display: none;
}

#replyList div~div:nth-child(3).active {
display: block;
}

#btn_active{
	display: none;
}
#btn_active.active{
	display: block;
}

#toggle-side{

}


</style>

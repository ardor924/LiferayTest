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

<!-- 댓글 권한설정 -->
<liferay-portlet:resourceURL var="AuthorizationReplyURL" id="<%=ConstantsCommands.HHLBOARD_REPLY_AUTHORIZATION_PROJECT %>"/>




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


<!-- 추가요소 -->
<ul id="reply_list">

</ul>



<!-- 감시대상 -->
<div id="observer"></div>








<script type="text/javascript">
/*----------/0/START : 파라미터-------------------*/

var page = 1
var bno = ${tbl.bno}
var userName = '${userName}'

var bool_sw = true;
var isEnd = false;

let timer;
const $observer = document.getElementById("observer");
/*----------//END : 파라미터-------------------*/

//x
//x

/*----------/0/START : Intersection Observer API-------------------*/

if(bool_sw){
	getList(page)
}

const io = new IntersectionObserver((entries) => {
	  clearTimeout(timer);
	  if (isEnd ==false && entries[0].isIntersecting) {
	    timer = setTimeout(() => getList(++page), 1000);			
	};
});

io.observe($observer); // 타겟 감시 활성화

/*---------/0/END : Intersection Observer API-------------------*/

//x
//x

/*----------/1/START : 댓글목록 로드-------------*/
function getList(page){
	console.log("page : getList("+page+")진입")
	$.ajax({
		type:"get",
		url : "${ShowListReplyURL}",
		data : Liferay.Util.ns("<portlet:namespace/>",{
			bno : bno,
			page : page,
	
		}),
		dataType: "json",
		success : function(data){			
					
			drawHtml(data,page)

		},error : function(err){
			alert("서버 연결 실패")
		}
	}) /* END : ajax */
	
}; /* END : getList() 함수 */


//START : success 콜백 
function drawHtml(data,page){
	
	var html = '<li>'
	
		
		for(var i =0;i<data.length;i++){
			
		var reply = JSON.parse(JSON.stringify(data[i]))
		if(data.length<10){ // 다음페이지 댓글수가 10개 미만 일때 마지막 페이지 체크
			isEnd = true;
		}
		var rno = reply.rno
		var bno = reply.bno
		var rWriter = reply.rWriter
		var rContents = reply.rContents
		var rRegDate = reply.rRegDate
		
		var pageCode = page+""+i // pageCode = 페이지+식별번호
		
			/*--------------------START : DB 댓글 정보 출력-----------------------*/	
		     html += "<div>";
		     html +=     '<div class="d-flex justify-content-between p-3">';
		     html +=         '<div class="d-flex-row justify-content-start">';
		     html +=             '<h5>'+rWriter +'</h5>';
		     html +=         '<p>'+rContents+'</p>';
		     html +=         '<div>';
		     html +=             '<span>'+rRegDate +'</span>';
		     html +=         '</div>';
		     html +=      '</div>';
		     html +=      '<div id="toggle_end" class="d-flex justify-content-end m-2">';
		     html +=              '<h3 class="col-2 m-0 p-0" >';
		     html +=              	'<a id="toggle'+pageCode+'" onclick="btn_toggle('+pageCode+')" type="button"><i class="fa-solid fa-ellipsis-vertical"></i></a>';
		     html +=              '</h3>';
		     html +=              '<div id="toggle_side'+pageCode+'" class="toggle_side" class="m-0 d-flex row">';
										/* 이곳에 수정삭제 넣기 */
		     html +=              '</div>';
		     html +=              '<input id="rno'+pageCode+'" type="hidden" name="rno" value="'+rno+'">'; // PK값 히든으로 표시안되게 처리
		     html +=              '<input id="rWriter'+pageCode+'" type="hidden" name="rWriter" value="'+rWriter+'">'; // PK값 히든으로 표시안되게 처리
		     html +=      '</div>';
		     html += '</div><hr>';
		     html += '<div id="writeRepFrm'+pageCode+'"></div>';
			console.log("pageCode : "+pageCode)
			/*--------------------END : DB 댓글 정보 출력-----------------------*/
	} // END : for문
			console.log("-----------------------END : "+page+"page----------------------------------------")
	html += '</li>'
	$("#reply_list").append(html);
	$("#rContents").val("") //텍스트박스 댓글 초기화(댓글 작성 완료후)
	
} // END : drawHtml(data)


/*----------/1/END : 댓글목록 로드-------------*/
//x
//x
/*---------/2/START : 클릭 이벤트(댓글등록) ----------*/
$("#btn_reply_regist").click(function(){
console.log("-----------#btn_reply_regist------------")

var rContents = $('textarea[name=rContents]').val();

console.log("page : "+page)

	$.ajax({
		type : "post",
		url : "${AddReplyURL}",
		data : Liferay.Util.ns("<portlet:namespace/>",{
			bno : bno,
			rWriter : userName, // 현재 작성자로 글등록
			rContents : rContents			
		}),
		dataType : "text",
		success : function(data){
			alert("댓글등록 성공!")
			console.log(data)
			getList(page)
		},
		error : function(err){
			alert("통신에러 발생!")
			console.log(err)
		}
	}) // END : ajax
	
})
/*---------/2/END : 클릭 이벤트(댓글등록) ----------*/



/*---------/3/START : 온클릭 이벤트(토글:권한체크)----------*/
function btn_toggle(pageCode){
console.log("-----------btn_toggle(pageCode)------------")
	var rno = $('#rno'+pageCode).val();
	$.ajax({
		type : "post",
		url : "${AuthorizationReplyURL}",
		data : Liferay.Util.ns("<portlet:namespace/>",{
			rno : rno
		}),
		dataType : "json",
		success : function(data){			
			if(data["result"] == "OK"){
				
				// 토글 클릭시 
				var toggle_active = document.querySelector("#toggle"+pageCode)
					toggle_active.classList.toggle("active")
				var toggle_side_active = document.querySelector("#toggle_side"+pageCode)
					toggle_side_active.classList.toggle("active")
					
				if($("#toggle_side"+pageCode).hasClass("acticve") === true){
					
/* 					var outFrm  = ` <div class="btn btn-success text-white mb-2" onclick="update_reply_frm("+page+","+num+")">수정</div>
								    <div class="btn btn-danger text-white mb-2" onclick="delete_reply("+page+","+num+")">삭제</div>
								  ` */
					var outFrm = '<div class="btn btn-success text-white mb-2" onclick="update_reply_frm('+pageCode+')">수정</div>'
					     	   + '<div class="btn btn-danger text-white mb-2" onclick="delete_reply('+pageCode+')">삭제</div>'	
					
					$("#toggle_silde"+pageCode).html(outFrm)
					
				}else if($("#toggle_side"+pageCode).hasClass("active") === false){
					
					$("#toggle_silde"+pageCode).html("")
					
				}
	
				
				
			}else{
				alert("수정삭제는 작성자 본인만 가능합니다.")
				return;
			}
			
		
		},
		error : function(errr){
			console.log("err : "+err)
		}
	})
	
	
};




/*--------/3/END : 클릭 이벤트(토글)----------*/



</script>



<!-- // END : 댓글 목록 영역  -->
<link rel="stylesheet" type="text/css" href="${ctx}/css/reply_form.css">

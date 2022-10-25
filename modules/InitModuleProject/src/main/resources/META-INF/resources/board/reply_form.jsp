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

<div>....로딩중....</div>
<!-- 감시대상 -->
<div id="observer"></div>








<script type="text/javascript">
/* --------------- START : 파라미터---------------- */
var rWriter = "${userName}";
var bno = ${tbl.bno};
var rContents = $('textarea[name=rContents]').val();
var page = 1;
var lastPage =3;

/* 
$.ajax({ // lastPage :전역변수로
	type : "post",
	url : "${ShowListReplyURL}",
	async : "false", // 비동기 false
	data : Liferay.Util.ns("<portlet:namespace/>",{
		bno : bno
	}),
	dataType : "json",
	success : function(data){
		var length = data.length;
		lastPage = Math.ceil(length/10);

	}
}) */

const $ul = document.getElementById('reply_list');

let isEnd = false; // 페이지수가 10이상일경우 계속 다음페이지 탐색 , 10미만일경우 마지막페이지 이므로 탐색중지
/* --------------- END : 파라미터---------------- */





























/* ----// START : 댓글정보 호출 이벤트(getList)---- */	
	function getList(page){
	console.log("bno : " + bno)	
	console.log("rWriter : " + rWriter)	
	console.log("------------------getList-------------------")	
	console.log("page : " + page)	
	
	$.ajax({
		type : "get",
		url : "${ShowListReplyURL}",
		data : Liferay.Util.ns('<portlet:namespace/>',{
			bno : bno,
			page : page,
		}),
		dataType : "json",
		success : function(data){
				var length = data.length;



			console.log("data.length : "+data.length)


			var html = "<li>";
			

							
				for (var i =0; i<data.length; i++){
				
				console.log("데이터갯수 : "+length)
				var reply = JSON.parse(JSON.stringify(data[i]));
				var num = i
				
				     html += "<div>";
				     html +=     '<div class="d-flex justify-content-between p-3">';
				     html +=         '<div class="d-flex-row justify-content-start">';
				     html +=             '<h5>'+ reply.rWriter +'</h5>';
				     html +=         '<p>'+reply.rContents+'</p>';
				     html +=         '<div>';
				     html +=             '<span>'+ reply.rRegDate +'</span>';
				     html +=         '</div>';
				     html +=      '</div>';
				     html +=      '<div id="toggle_end" class="d-flex justify-content-end m-2">';
				     html +=              '<h3 class="col-2 m-0 p-0" >';
				     html +=              	'<a id="toggle'+page+'-'+num+'" onclick="btn_toggle('+page+','+num+')" type="button"><i class="fa-solid fa-ellipsis-vertical"></i></a>';
				     html +=              '</h3>';
				     html +=              '<div id="toggle_side'+page+'-'+num+'" class="toggle_side" class="m-0 d-flex row">';
												/* 이곳에 수정삭제 넣기 */
				     html +=              '</div>';
				     html +=              '<input id="rno'+num+'" type="hidden" name="rno" value="'+reply.rno+'">'; // PK값 히든으로 표시안되게 처리
				     html +=              '<input id="rWriter'+num+'" type="hidden" name="rWriter" value="'+reply.rWriter+'">'; // PK값 히든으로 표시안되게 처리
				     html +=      '</div>';
				     html += '</div><hr>';
				     html += '<div id="addRepFrm'+num+'"></div>';

					num += 1
					

					
			}// END :for문
			
					
			html += "</li>";				
			
			$("#reply_list").append(html);
			$("#rContents").val("") //텍스트박스 댓글 초기화(댓글 작성 완료후)

				console.log("page : "+page)
				if(length < 10){
					isEnd = true;
				}

			},  // END : success
			
	});  // END :ajax
		
		
	
	}	// END  : getList()	
/* ----// START : 댓글정보 호출 이벤트(getList)---- */		


getList(page);


let timer;
const $observer = document.getElementById('observer');
const io = new IntersectionObserver((entries) => {
  clearTimeout(timer);
  if (isEnd ==false && entries[0].isIntersecting) {
    timer = setTimeout(() => getList(++page), 1000);

};

});

io.observe($observer);















/*---------//START : 클릭 이벤트(댓글등록) ----------*/
$("#btn_reply_regist").click(function(){	
	

	var rContents = $('textarea[name=rContents]').val();

	console.log("-----------#btn_reply_regist------------")
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
			getList(page)
		},
		
		error : function(err){
			alert('통신에러 발생!')
		}
	});		
});
/*---------//END : 클릭 이벤트(댓글등록) ---------*/


/*---------//START : 클릭 이벤트(댓글삭제) ---------*/
function delete_reply(){
var rno = $('input[name=rno]').val(); // hidden으로 받은 답글 PK값	
var pass = confirm('댓글을 삭제하시겠습니까?');
if(pass){
	$.ajax({
		type :"post",
		url : "${DeleteReplyURL}",
		data : Liferay.Util.ns('<portlet:namespace/>',{		
			rno : rno,
		}),
		dataType : "text",
		success : function(data){
			getList()
		},
		error : function(err){
			alert("댓글 삭제 실패했습니다")
		}
		
	})
}	


}
/*---------//END : 클릭 이벤트(댓글삭제) ---------*/







/*----------- // START :  댓글 수정 폼생성--------------  */
function update_reply_frm(num){	
console.log("------------------update_reply_frm------------------------")
var rAddWriter  = '${userName}';
var rno = $("#rno"+num).val();	

btn_toggle(page,num)


/* !!DEL :  잘찍히나확인	
console.log("rno : "+rno)
console.log("num : "+num)
*/
let showHide = document.querySelector('#addRepFrm'+num)
showHide.classList.toggle("active");

  
  var addrep = '<div class="panel panel-default p-3 w-70 justify-content-center">                                                                     '
              +'		<div class="d-flex justify-content-between p-3">                                                                              '
              +'			<div class="col-13 w-100 d-flex justify-content-start">                                                                   '
              +'				<span id="frm_rWriter" class="col-1"> '+rWriter+' </span>															  '                                                                                
              +'				<textarea id="frm_rContents" name="frm_rContents" class="col-11" rows="5" placeholder="댓글을 입력하세요"></textarea> '
              +'			</div>                                                                                                                    '
              +'		</div>                                                                                                                        '
              +'		<div class="d-flex justify-content-end mt-2">                                                                             	  '
              +'			<p id="btn_active'+num+'" class="btn btn-sm btn-danger m-2" onclick="addrep_cancel('+num+')">취소</p>                     '
              +'			<p id="btn_reply_update" class="btn btn-sm btn-success m-2" onclick="update_reply('+num+')">수정</p>              '
              +'		</div>                                                                                                                        '                                                                                                                       
              +'		<input name="frm_rWriter" type="hidden" value="'+rWriter+'"/>														          '                                                                                
              +'		<input name="rno" type="hidden" value="'+rno+'"/>														          '                                                                                
              +'</div>                                                                                                                                '
              +'                                                                                                                                      '	          
  		$('#addRepFrm'+num).html(addrep);	

};
/*----------- // END :  댓글 수정 폼생성--------------  */




/*---------//START : 클릭 이벤트(댓글수정) ---------*/
function update_reply(num){
	console.log("----------update_reply--------------")
	/* --------------파라미터받기-------------------*/
var rWriter = $('input[name=frm_rWriter]').val(); 
	var rno = $("#rno"+num).val(); 
var rContents = $('textarea[name=frm_rContents]').val(); 
var bno  = ${tbl.bno}

console.log("num : "+num);
console.log("rno : "+rno);
console.log("rWriter : "+rWriter);
console.log("rContents : "+rContents);

/* !!DEL :  잘찍히나확인	 	
console.log("num : "+num);
console.log("rno : "+rno);
console.log("rWriter : "+rWriter);
console.log("rContents : "+rContents);
*/	


$.ajax({
type: "post",
url : "${UpdateReplyURL}",
data : Liferay.Util.ns('<portlet:namespace/>',{
	rno : rno,
	bno : bno,
	rWriter : rWriter,
	rContents : rContents,

}),
dataType : "text",
success : function(data){
	alert(data)
	getList()
	
}
	
	
})


}
/*---------//END : 클릭 이벤트(댓글수정) ---------*/





//답글 폼 제거
function addrep_cancel(num){
console.log("------답글폼제거-------")

let showHide = document.querySelector('#addRepFrm'+num)
showHide.classList.toggle("active");
}

//토글 클릭 이벤트(수정/삭제)
function btn_toggle(page,num){


var rAddWriter  = '${userName}';
var rno = $("#rno"+num).val();

console.log("rAddWriter:"+rAddWriter)
console.log("rWriter:"+rWriter)



$.ajax({
	type : "post",
	url : "${AuthorizationReplyURL}",
	data :Liferay.Util.ns("<portlet:namespace/>",{
		rno : rno,
	}),
	dataType : "json",
	success : function(data){
		if(data['result'] == "OK"){
			
			let toggle_show_hide = document.querySelector('#toggle'+page+'-'+num)
			toggle_show_hide.classList.toggle("active");
			
			let toggle_side_show_hide = document.querySelector('#toggle_side'+page+'-'+num)
			toggle_side_show_hide.classList.toggle("active");

				
					if($('#toggle_side'+page+'-'+num).hasClass("active") === true) {
				
							var mod = '<div class="btn btn-success text-white mb-2" onclick="update_reply_frm('+page+','+num+')">수정</div>'
						     		+ '<div class="btn btn-danger text-white mb-2" onclick="delete_reply()">삭제</div>'
				
							$('#toggle_side'+page+'-'+num).html(mod);	
						
					}else if($('#toggle_side'+page+'-'+num).hasClass("active") === false) {
							$('#toggle_side'+page+'-'+num).html("");
				
					}
			
			
		}else{
			alert("수정삭제는 작성자 본인만 가능합니다.")
			return;
		}
		
		
	}
		
		
	})	







}


</script>



<!-- // END : 댓글 목록 영역  -->
<link rel="stylesheet" type="text/css" href="${ctx}/css/reply_form.css">

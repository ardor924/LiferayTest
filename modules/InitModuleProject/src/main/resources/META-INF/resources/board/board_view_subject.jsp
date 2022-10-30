<%@page import="javax.portlet.WindowState"%>
<%@page import="InitModuleProject.constants.ConstantsCommands"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="../init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet"%>

<!-- 게시판 리스트 -->
<liferay-portlet:renderURL var="BoardListURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=ConstantsCommands.HHLBOARD_LIST_PROJECT%>"/>
</liferay-portlet:renderURL>

<!-- 글수정(폼) -->
<liferay-portlet:renderURL var="UpdateFormEditURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=ConstantsCommands.HHLBOARD_EDIT_UPDATE_PROJECT%>"/>
</liferay-portlet:renderURL>

<!-- 글 삭제 액션 -->
<liferay-portlet:actionURL var="SubjectDeleteURL" name="<%=ConstantsCommands.HHLBOARD_DELETE_PROJECT%>"/>


<!-- 파일 다운로드 액션 -->
<liferay-portlet:actionURL var="DownFileURL" name="<%=ConstantsCommands.HHLBOARD_FILEDOWNLOAD_PROJECT%>"/>	

<!-- 이미지 미리보기 액션 -->
<liferay-portlet:actionURL var="ImageShowURL" name="<%=ConstantsCommands.HHLBOARD_IMAGESHOW_PROJECT%>"/>



<div class="container p-5">
		<div class="d-flex justify-content-end">
				<form id="goBoardListFrm" action="${BoardListURL}" method="post">
					<input name="<portlet:namespace/>i" type="hidden" value="${currentPage}"/>
					<input name="<portlet:namespace/>cntPerPage" type="hidden" value="${cntPerPage}"/>
					<input name="<portlet:namespace/>ORDER" type="hidden" value="${ORDER}"/>
					<input name="<portlet:namespace/>option" type="hidden" value="${option}"/>
					<input name="<portlet:namespace/>keyword" type="hidden" value="${keyword}"/>
					<button class="btn btn-outline-dark" type="submit" onclick="document.getElementById('goBoardListFrm').submit()">목록</button>
				</form>	
			
			
			
		</div>
		<hr>
<div class="shadow p-4">
	<form id="updateFrm" action="${UpdateFormEditURL}" method="post">
	
		<input type="hidden" value="${userName}" name="<portlet:namespace/>userName">
		<input type="hidden" value="${tbl.bno}" name="<portlet:namespace/>bno">
		<input type="hidden" value="${currentPage}" name="<portlet:namespace/>currentPage">
		<input type="hidden" value="${cntPerPage}" name="<portlet:namespace/>cntPerPage">
		<input type="hidden" value="${option}" name="<portlet:namespace/>option">
		<input type="hidden" value="${keyword}" name="<portlet:namespace/>keyword">
		<input type="hidden" value="${ORDER}" name="<portlet:namespace/>ORDER">
		<h2>${tbl.subject}</h2>
			<div class="d-flex justify-content-between">
				<div>
					<span>${tbl.writer}</span> 
					<span>${tbl.regDate}</span>
				</div>
				<div>
					<span>조회수 : ${tbl.hit}</span>
				</div>
			</div>
		<hr>
		<div>
			<section>${tbl.contents}</section><!-- 큰 이미지 화면 처리방법 구상할것 -->
		</div>

		<hr>

	<!-- START : 이미지 슬라이더 -->
	<c:if test="${fileList.size() > 0}">
 		<div class="post-container shadow mb-5">
      		<div class="post-slider">
        		<h1 class="silder-title">이미지 슬라이더</h1>
        		<i class="fas fa-chevron-left prev"></i>  
        		<i class="fas fa-chevron-right next"></i> 
        		<div class="post-wrapper">
					<c:forEach var="li" items="${fileList}">
          				<div class="post">
          					<div class="post-box">
            					<img src="${ImageShowURL}&<portlet:namespace/>fno=${li.fno}" class="slider-image">
          					</div>
            				<div class="post-info">
              					<h4><i class="fa-solid fa-image"></i>${li.FName}</h4>
              					<h4><button type="button" class="btn btn-info" onclick="fileDown(${li.fno})">다운로드</button></h4>
            				</div>
          				</div>
					</c:forEach>
        		</div>
      		</div>
    	</div>
    </c:if>
	<!-- END :이미지 슬라이더 -->		


		<hr>
		
			
		<!-- 작성자 본인인경우 -->
		<c:if test="${tbl_mine}">
			<div class="d-flex justify-content-end">
				<button type="button" class="btn btn-success m-1" onclick="updateSubject()">글수정</button>
				<button type="button" class="btn btn-danger m-1" onclick="delSubject()">글삭제</button>
			</div>

		</c:if>		
		</form>
		<!-- 글삭제폼 -->
		<form id="delFrm" action="${SubjectDeleteURL}" method="post">
			<input type="hidden" name="<portlet:namespace/>bno" value="${tbl.bno}">
		</form>
</div>
</div>









<%@ include file="/board/reply_form.jsp"%>
<script type="text/javascript">

function fileDown(fno){
	window.location.href = '${DownFileURL}&<portlet:namespace/>fno='+fno;	
}

function updateSubject(){
	var pass = confirm('글을 수정하시겠습니까?');
	if(pass){
	document.getElementById('updateFrm').submit();		
	}
}

function delSubject(){
	var pass = confirm('글을 삭제하시겠습니까?');
	if(pass){
	document.getElementById('delFrm').submit();		
	}
}
</script>


<!-- slick-slider CSS -->
<link rel="stylesheet" type="text/css" href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<!-- Jquery -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- slick-slider JS -->
<script type="text/javascript" src="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>			
<!-- css -->
<link rel="stylesheet" type="text/css" href="${ctx}/css/slider.css"/>

<!-- js -->
<script type="text/javascript" src="${ctx}/js/slider.js"></script>			



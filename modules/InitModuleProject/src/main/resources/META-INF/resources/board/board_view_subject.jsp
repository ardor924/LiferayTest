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
<div class="shadow p-4">
	<form action="${UpdateFormEditURL}" method="post">
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
		

		<!-- 이미지 다운 & 이미지 슬라이드 -->	
		<div class="d-flex justify-content-between">	
			<c:forEach var="li" items="${fileList}">	
			<span>이미지 다운</span>	
				<hr>
				<li class="row">	
				<button class="btn btn-primary" type="button" onclick="fileDown(${li.fno})">${li.FName}</button>
				<img src="${ImageShowURL}&<portlet:namespace/>fno=${li.fno}">
				</li>		
				<hr>
			</c:forEach>
			</div>	
			<!-- 작성자 본인인경우 -->
			<c:if test="${mine}">
			<div class="d-flex justify-content-end">
				<button type="submit" class="btn btn-success m-1">수정</button>
				<a class="btn btn-danger m-1" id='btn-delete' href="${SubjectDeleteURL}&<portlet:namespace/>bno=${tbl.bno}">삭제</a>		
			</div>
			</c:if>			
	</form>
</div>		
	<hr>
	
	
	
<script type="text/javascript">

function fileDown(fno){
	window.location.href = '${DownFileURL}&<portlet:namespace/>fno='+fno;	
}




</script>
	
	
	
	
	
	
<%@ include file="/board/reply_form.jsp"%>
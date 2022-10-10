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



<div class="container p-5">
		<div class="d-flex justify-content-end">
			<a class="btn btn-outline-dark" href="${BoardListURL}&<portlet:namespace/>i=${currentPage}&<portlet:namespace/>cntPerPage=${cntPerPage}&<portlet:namespace/>ORDER=${ORDER}">목록</a>
		</div>
		<hr>
<div class="shadow p-4">
	<form action="${UpdateFormEditURL}" method="post">
		<input type="hidden" value="${userName}" name="<portlet:namespace/>userName">
		<input type="hidden" value="${tbl.bno}" name="<portlet:namespace/>bno">
		<input type="hidden" value="${currentPage}" name="<portlet:namespace/>currentPage">
		<input type="hidden" value="${cntPerPage}" name="<portlet:namespace/>cntPerPage">
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
		<c:if test="${file == null}">
		<div class="d-flex justify-content-between">
			<div class="d-flex justify-content-start">
				<button type="button" class="btn btn-primary m-1" onclick="javascript:alert('다운받을 데이터가 없습니다.')"><i class="fa-solid fa-check"></i>이미지 다운로드</button>
			</div>
			<!-- 작성자가 본인이 아니거나 게스트인경우 -->
			<c:if test="${(userName != tbl.writer || userName == 'guest') && userName != 'admin'}">
			<div class="d-flex justify-content-end">
				<button type="button" class="btn btn-success m-1" onclick="userValModifyChk()" >수정</button>
				<button type="button" class="btn btn-danger m-1" onclick="userValDeleteChk()" >삭제</button>		
			</div>			
			</c:if>
			<!-- 일반 유저의 경우 본인것만 수정 / 삭제 가능 -->
			<c:if test="${userName == tbl.writer && userName != 'admin'}">
			<div class="d-flex justify-content-end">
				<button type="submit" class="btn btn-success m-1" >수정</button>
				<a class="btn btn-danger m-1" id='btn-delete' href="${SubjectDeleteURL}&<portlet:namespace/>bno=${tbl.bno}">삭제</a>		
			</div>			
			</c:if>
			<!-- 관리자: 모두 수정 / 삭제 가능 -->
			<c:if test="${userName == 'admin'}">
			<div class="d-flex justify-content-end">
				<button type="submit" class="btn btn-success m-1" >수정</button>
				<a class="btn btn-danger m-1" id='btn-delete' href="${SubjectDeleteURL}&<portlet:namespace/>bno=${tbl.bno}">삭제</a>		
			</div>			
			</c:if>
		</div>
		</c:if>
		
		
<%-- 		<c:if test="${file != null}">
		<div class="d-flex justify-content-between">
			<div class="d-flex justify-content-start">
				<button class="btn btn-primary m-1"><i class="fa-solid fa-check"></i>이미지 다운로드</button>
			</div>
			<div class="d-flex justify-content-end">
				<button type="submit" class="btn btn-success m-1">수정</button>
				<a class="btn btn-danger m-1" id='btn-delete' href="${DeleteSubject}&<portlet:namespace/>bno=${tbl.bno}">삭제</a>		
			</div>			
		</div>
		</c:if> --%>
		
		
	</form>
	<hr>
	
	
<%@ include file="/board/reply_form.jsp"%>
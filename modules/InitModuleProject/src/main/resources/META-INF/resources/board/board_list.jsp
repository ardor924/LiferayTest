<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="InitModuleProject.constants.ConstantsCommands"%>
<%@page import="javax.portlet.WindowState"%>
<%@ include file="../init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>


<!-- 게시판 리스트 -->
<liferay-portlet:renderURL var="BoardListURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=ConstantsCommands.HHLBOARD_LIST_PROJECT%>"/>
</liferay-portlet:renderURL>

<!-- 글쓰기(폼) -->
<liferay-portlet:renderURL var="WriteFormEditURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=ConstantsCommands.HHLBOARD_EDIT_WRITE_PROJECT%>"/>
</liferay-portlet:renderURL>



<!-- 게시글 보기 -->
<liferay-portlet:renderURL var="SubjectViewURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString() %>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=ConstantsCommands.HHLBOARD_VIEW_PROJECT%>"/>
</liferay-portlet:renderURL>


	
<h2>${userName} 님 안녕하세요!</h2>
<!-- 검색 -->
<%@ include file="./board_search.jsp" %>

<!-- 게시판 -->
<div>
	<table class="table table-hover mt-3">
		<thead>
		  <th>
			<form id="numOrderFrm" action="${BoardListURL}" method="post">
			    <input id="cntPerPage" name="<portlet:namespace/>cntPerPage" type="hidden" value="${bp.cntPerPage}"/>
			    <input id="keyword" name="<portlet:namespace/>keyword" type="hidden" value="${keyword}"/>
			    <input id="option" name="<portlet:namespace/>option" type="hidden" value="${option}"/>
			    
			<c:if test="${ORDER eq 'bnoUp'}">
			    <input id="option" name="<portlet:namespace/>ORDER" type="hidden" value="bnoDown"/>
			    <a href="#" onclick="numOrderFrm()">번호</a>
			    <i class='fa-solid fa-sort-up'></i>
			    </c:if>
			<c:if test="${ORDER eq 'bnoDown'  or ORDER == null  or ORDER != 'bnoUp'}">
			    <input id="option" name="<portlet:namespace/>ORDER" type="hidden" value="bnoUp"/>
			    <a href="#" onclick="numOrderFrm()">번호</a>
			    <i class='fa-solid fa-sort-down'></i>
		    </c:if>
		    </form>
		   </th>
		   <th>제목</th>
		   <th>작성자</th>
		   <th>
			<form id="regOrderFrm" action="${BoardListURL}" method="post">
			    <input id="cntPerPage" name="<portlet:namespace/>cntPerPage" type="hidden" value="${bp.cntPerPage}"/>
			    <input id="keyword" name="<portlet:namespace/>keyword" type="hidden" value="${keyword}"/>
			    <input id="option" name="<portlet:namespace/>option" type="hidden" value="${option}"/>
			    		   
	        <c:if test="${ORDER eq 'regUp'}">
	            <input id="ORDER" name="<portlet:namespace/>ORDER" type="hidden" value="regDown"/>
	            <a href="#" onclick="regOrderFrm()">작성일</a>
	            <i class='fa-solid fa-sort-up'></i>
	        </c:if>
	        <c:if test="${ORDER eq 'regDown'  or ORDER == null or ORDER != 'regUp'}">
	            <input id="ORDER" name="<portlet:namespace/>ORDER" type="hidden" value="regUp"/>
	            <a href="#" onclick="regOrderFrm()">작성일</a>
	            <i class='fa-solid fa-sort-down'></i>
	        </c:if>
	        </form>
		   </th>
		   <th>
			<form id="hitOrderFrm" action="${BoardListURL}" method="post">
			    <input id="cntPerPage" name="<portlet:namespace/>cntPerPage" type="hidden" value="${bp.cntPerPage}"/>
			    <input id="keyword" name="<portlet:namespace/>keyword" type="hidden" value="${keyword}"/>
			    <input id="option" name="<portlet:namespace/>option" type="hidden" value="${option}"/>
			    		   
	        <c:if test="${ORDER eq 'hitUp'}">
	            <input id="ORDER" name="<portlet:namespace/>ORDER" type="hidden" value="hitDown"/>
	            <a href="#" onclick="hitOrderFrm()">조회수</a>
	            <i class='fa-solid fa-sort-up'></i>
	        </c:if>
	        <c:if test="${ORDER eq 'hitDown'  or ORDER == null or ORDER != 'hitUp'}">
	            <input id="ORDER" name="<portlet:namespace/>ORDER" type="hidden" value="hitUp"/>
	            <a href="#" onclick="hitOrderFrm()">조회수</a>
	            <i class='fa-solid fa-sort-down'></i>
	        </c:if>
	        </form>
		   </th>
		
		</thead>		
		<tbody>
			<c:if test="${board_list == null}">
			<tr>
				<td class="text-center" colspan="5"><h2>게시판에 게시글이 없습니다.</h2><td>
			</tr>
			</c:if>
			<c:if test="${board_list != null}">
			<c:forEach var="li" items="${board_list}">
			<tr>
			
				<td>${li.subject_id}</td>
				<td>
				<form id="viewFrm" action="${SubjectViewURL}" method="post">
					<input name="<portlet:namespace/>bno" type="hidden" value="${li.bno}"/>
					<input name="<portlet:namespace/>currentPage" type="hidden" value="${bp.currentPage}"/>
					<input name="<portlet:namespace/>cntPerPage" type="hidden" value="${bp.cntPerPage}"/>
					<input name="<portlet:namespace/>ORDER" type="hidden" value="${ORDER}"/>
					<input name="<portlet:namespace/>option" type="hidden" value="${option}"/>
					<input name="<portlet:namespace/>keyword" type="hidden" value="${keyword}"/>
					<input name="<portlet:namespace/>userName" type="hidden" value="${userName}"/>
					<a href="#" onclick="document.getElementById('viewFrm').submit()">${li.subject}</a>
				</form>
				</td>
				<td>${li.writer}</td>				
				<td>${li.regDate}</td>
				<td>${li.hit}</td>
			</tr>		
			<c:set var="start" value="${start-1}"/>
			</c:forEach>
			</c:if>								
		</tbody>
	</table>
	<hr>
	
<div class="d-flex justify-content-between">

	<div class="d-flex justify-content-end">		
		<form id="searchForm" method="post" action="${BoardListURL}">
			<input type="hidden" value="${ORDER}" name="<portlet:namespace/>ORDER">
			<input type="hidden" value="${keyword}" name="<portlet:namespace/>keyword">
			<input type="hidden" value="${option}" name="<portlet:namespace/>option">
			<div class="d-flex justify-content-end">		
				 <select id='cntPerPage' class="form-select me-2" onchange="changeCntPerPage()" name="<portlet:namespace/>cntPerPage" style="width:100px">
					<option value="10" ${bp.cntPerPage eq 10 ? 'selected' : ''}>10개씩</option>
					<option value="15" ${bp.cntPerPage eq 15 ? 'selected' : ''}>15개씩</option>
					<option value="20" ${bp.cntPerPage eq 20 ? 'selected' : ''}>20개씩</option>
					<option value="30" ${bp.cntPerPage eq 30 ? 'selected' : ''}>30개씩</option>
				 </select>
			   <button type="submit" class="btn btn-dark rounded-0 rounded-end" style="width:50px;  color:white" >
			      <i class="xi-filter"></i>
			   </button> 
			</div>
		</form>
	</div>		
	<div class="text-center">
		<c:if test="${userName == 'guest'}">
		<button class="btn btn-outline-dark" onclick="javascript:alert('글을 쓰기 위해서는 로그인이 필요합니다!')">글쓰기</button>
		</c:if>
		<c:if test="${userName != 'guest'}">
		<a class="btn btn-outline-dark" href='${WriteFormEditURL}
										&<portlet:namespace/>bno=${li.bno}
										&<portlet:namespace/>userName=${userName}'>글쓰기</a>
		</c:if>
	</div>
</div>
		
<!-- 페이지 네비게이션(블럭) -->

	<ul class="pagination justify-content-center my-5">
	  <li class="page-item ${bp.prevPage <=0 ? 'hide' : ''}"><!--이전 페이징 블럭이 0이하 일 경우, 이전 버튼 비활성화-->
	     <a class="page-link" href="${BoardListURL}&<portlet:namespace/>i=${bp.prevPage}&<portlet:namespace/>cntPerPage=${bp.cntPerPage}&<portlet:namespace/>ORDER=${ORDER}&<portlet:namespace/>keyword=${keyword}&<portlet:namespace/>option=${option}"><i class="fa-solid fa-angle-left"></i>이전</a>
	  </li>
	  
	  <c:forEach var="i" begin="${bp.blockStart}" end="${bp.blockEnd}">	  
	     <li class="page-item ${bp.currentPage == i ? 'active':''}"><!-- 현재 페이지가 i일 경우 active(현재위치표시역할) -->
	        <a class="page-link" href="${BoardListURL}&<portlet:namespace/>i=${i}&<portlet:namespace/>cntPerPage=${bp.cntPerPage}&<portlet:namespace/>ORDER=${ORDER}&<portlet:namespace/>orderOn=on&<portlet:namespace/>keyword=${keyword}&<portlet:namespace/>option=${option}">${i}</a><!-- i로 페이지 이동 -->
	     </li>
	  </c:forEach>
	  
	  <li class="page-item ${bp.blockEnd >= bp.totalPage ? 'hide': ''}"><!-- 전체게시글 수가 페이징 블럭의 끝번호 보다 작을 경우 disabled(버튼 비활성화) -->
	     <a class="page-link" href="${BoardListURL}&<portlet:namespace/>i=${bp.nextPage}&<portlet:namespace/>cntPerPage=${bp.cntPerPage}&<portlet:namespace/>ORDER=${ORDER}&<portlet:namespace/>keyword=${keyword}&<portlet:namespace/>option=${option}">다음<span></span><i class="fa-solid fa-angle-right"></i></a>
	  </li>
	</ul>	


	<!-- 필터링확인 -->
	<span>order : ${ORDER} // </span><span>search : ${option} //</span>
	<span>currentPage : ${bp.currentPage }</span>


</div>


<script type="text/javascript">


/************* 검색 ****************/
var sf = $('#searchForm');

$('#btn-search').on('click', function(e){
   if(!sf.find("input[name='<portlet:namespace/>keyword']").val()){
      alert("키워드를 입력하세요!!");
      $('#keyword').focus();
      return false;
   }
   
   sf.submit();
});


<!-- 페이지에 보여질 갯수 -->

	function changeCntPerPage(){
		
		var selectedOption = document.getElementById("cntPerPage");	
		var selectedValue = selectedOption.options[selectedOption.selectedIndex].value;
		console.log(selectedValue);
	}
	// cnt 로그 확인용
	function goEvt(){
		var cnt = <c:out value="${bp.cntPerPage}"/>
		console.log(cnt);
	}
	
	
<!-- 컬럼정렬 -->
/* -----------------오더 정렬 폼 제출-------------------- */
function hitOrderFrm(){
	document.getElementById("hitOrderFrm").submit()
}
function numOrderFrm(){
	document.getElementById("numOrderFrm").submit()
}
function regOrderFrm(){
	document.getElementById("regOrderFrm").submit()
}
/* -----------------오더 정렬-------------------- */

</script>

<link rel="stylesheet" type="text/css" href="${ctx}/css/board_list.css">

<%@page import="javax.portlet.WindowState"%>
<%@ include file="../init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>



<div class="d-flex justify-content-between">
<!-- 현재 페이지 표시-->
	<div class="m-0 my-1 justify-content-start"><b>${bp.currentPage}</b> / ${bp.totalPage} pages | total : ${bp.cntPerTotal}</div>


	<!-- 검색기능 -->
	<div class="d-flex justify-content-end">		
 		<form id="searchForm" method="post" action="${BoardListURL}">
		   <div class="d-flex justify-content-end">
		   <input type="hidden" value="on" name="<portlet:namespace/>searchOn">
		   <input type="hidden" value="${bp.cntPerPage}" name="<portlet:namespace/>cntPerPage">
		   <input type="hidden" value="${ORDER}" name="<portlet:namespace/>ORDER">
		   
		      <!-- 검색 -->
 		      <select id="option" class="form-select me-2"  onchange="changeOption()" name="<portlet:namespace/>option" style="width:100px">
		         <option id="select_none" value="keyword_X" ${option eq 'keyword_X' ? 'selected' : ''}>선택</option>
		         <option value="keyword_S" ${option eq 'keyword_S' ? 'selected' : ''}>제목</option>
		         <option value="keyword_C" ${option eq 'keyword_C' ? 'selected' : ''}>내용</option>
		         <option value="keyword_W" ${option eq 'keyword_W' ? 'selected' : ''}>글쓴이</option>
		      </select>
      
		      
		      
		      
		      
		      
		      
		      <!-- 검색창 -->
		      <input id="keyword" value="${keyword}" class="form-control rounded-0 rounded-start" type="text" name="<portlet:namespace/>keyword" placeholder="검색어를 입력 하세요" 
		      style="width:250px">
		         
		      <!-- 검색버튼 -->
		      <button id="btn-search" class="btn btn-primary rounded-0 rounded-end" onclick="javascript:selectChk()" style="width:50px;  color:white" >
		         <i class="fa fa-search"></i>
		      </button> 
		   </div>
		</form>
	</div>
</div>

<script type="text/javascript">

<!-- 검색 키워드 유지 -->

	function changeOption(){
		
		var selectedOption = document.getElementById("option");	
		var selectedValue = selectedOption.options[selectedOption.selectedIndex].value;
		console.log(selectedValue);
	}
</script>

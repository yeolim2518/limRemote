``` html
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<table class="mainTable">
  <tr> 
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td height="25"><img src="image/icon.gif" width="9" height="9" align="absmiddle"> 
      <strong>사원조회</strong></td>
  </tr>
  <tr> 
    <td><table width="640" border="0" cellspacing="0" cellpadding="0">
    	
    	 <tr> 
            <td bgcolor="#E4EBF1">
               <table width="500" border="0" cellspacing="1" cellpadding="1">
                  <tr> 
                     <td width="102" align="right"><strong>성별 :&nbsp; </strong></td>
                     <td width="391" class=""> 
                     	<input type="radio" name="multSex" value="" class="radioMult"
                     		checked="checked">전체
                     	<input type="radio" name="multSex" value="남자" class="radioMult"
                     		<c:if test="${pagingVo.searchSex eq '남자'}">  checked="checked" </c:if>>남자
                        <input type="radio" name="multSex" value="여자" class="radioMult"
                        	<c:if test="${pagingVo.searchSex eq '여자'}">  checked="checked" </c:if>>여자
                     </td>
                  </tr>
               </table>
             </td>
         </tr>
         <tr> 
            <td bgcolor="#E4EBF1">
               <table width="500" border="0" cellspacing="1" cellpadding="1">
                  <tr> 
                     <td width="102" align="right"><strong>기술등급 :&nbsp; </strong></td>
                     <td width="391" class=""> 
                     	<input type="radio" name="multTechLev" value="" class="radioMult"
                     		checked="checked">전체
                     	<input type="radio" name="multTechLev" value="초급" class="radioMult"
                     		<c:if test="${pagingVo.searchTechLev eq '초급'}">  checked="checked" </c:if>>초급
                        <input type="radio" name="multTechLev" value="중급" class="radioMult"
                        	<c:if test="${pagingVo.searchTechLev eq '중급'}">  checked="checked" </c:if>>중급
                        <input type="radio" name="multTechLev" value="고급" class="radioMult"
                        	<c:if test="${pagingVo.searchTechLev eq '고급'}">  checked="checked" </c:if>>고급
                     </td>
                  </tr>
               </table>
             </td>
         </tr>
         
        
        <tr> 
          <td height="30" align="right">
            <select name="select" class="INPUT">
              <option value="" 
              	<c:if test="${empty pagingVo.searchCol}">selected</c:if>
              >::::: 전체 :::::</option>
              <option value="KOR_NAME" 
              	<c:if test="${pagingVo.searchCol eq 'KOR_NAME'}">selected</c:if>
              >이름</option>
              <option value="SEX"
              	<c:if test="${pagingVo.searchCol eq 'SEX'}">selected</c:if>
              >성별</option>
              <option value="TECH_LEV"
              	<c:if test="${pagingVo.searchCol eq 'TECH_LEV'}">selected</c:if>
              >기술등급</option>
            </select> 
            <input name="textfield" value="<c:out value="${pagingVo.searchVal}" />"
            	type="text" class="INPUT"> <a class="paging" data-page="1" href="#">
            	<img src="image/search.gif" width="49" height="18" border="0" align="absmiddle"></a></td>
        </tr>
        <tr> 
          <td><table width="640" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td height="3" background="image/bar_bg1.gif"></td>
              </tr>
              <tr align="center" bgcolor="F8F8F8"> 
                <td height="26" align="right" bgcolor="F8F8F8" style="padding-right:10"><img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#" id="empViewModForm" class="upDel">수정</a> <img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">인사기록카드</a> <img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">경력정보</a> <img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">근무정보</a> </td>
              </tr>
              <tr align="center" bgcolor="F8F8F8"> 
                <td height="1" align="right" bgcolor="B1B1B1"></td>
              </tr>
              <tr> 
                <td>
				<!-------------------------  리스트 ------------------------------>
				<form id="listFrm" action="">
				<input type="hidden" name="pageName" >
				<table width="640" border="0" cellspacing="0" cellpadding="0">
					<tr>
					  <th width="35" height="20" align="center"><input type="checkbox" name="kingChk" 
	                      		value=""></th>
                      <th width="85" align="center">이름</th>
                      <th width="153" align="center">주민번호</th>
                      <th width="91" align="center">성별</th>
                      <th width="91" align="center">기술등급</th>
                      <th width="91" align="center">상태</th>
                      <th width="94" align="center">근무</th>
					</tr>
					<c:forEach items="${empList}" var="empList">
	                    <tr id="oneRow"> 
	                      <td width="35" height="20" align="center"><input type="checkbox" name="checkbox" 
	                      		value="<c:out value="${empList.no}" />"></td>
	                      <td width="85" align="center"><c:out value="${empList.korName}" /></td>
	                      <td width="153" align="center"><c:out value="${empList.juminNof}" />-
	                      		<c:out value="${empList.juminNob}" /></td>
	                      <td width="91" align="center"><c:out value="${empList.sex}" /></td>
	                      <td width="91" align="center"><c:out value="${empList.techLev}" /></td>
	                      <td width="91" align="center"><c:out value="${empList.jopType}" /></td>
	                      <td width="94" align="center"><c:out value="${empList.desireDept}" /></td>
	                    </tr>
	                    <tr> 
	                      <td colspan="7" background="image/line_bg.gif"></td>
	                    </tr>
                     </c:forEach>
                    <tr> 
                      <td height="35" colspan="7" align="center" style="padding-bottom:3" class="pagingTd">
                      	<div>
	                      	<a href="#" class="paging" data-page="1">
	                      		<img src="image/prev.gif" width="22" height="15" border="0" align="absmiddle"><!-- << -->
	                      	</a>
	                      	<a href="#" class="paging" data-page="<c:out value="${pagingVo.prePage}" />">
	                      		<img src="image/pre.gif" width="42" height="15" border="0" align="absmiddle"><!-- pre -->
	                      	</a>
	                        <ul>
	                        	<c:forEach begin="${pagingVo.nowStartPage}" end="${pagingVo.nowEndPage}" varStatus="status">
	                        		<li 
	                        			<c:if test="${pagingVo.page eq status.index}"> class="nowPage" </c:if>>
	                        			<a href="#" class="paging" data-page="<c:out value="${status.index}" />">
	                        				<c:out value="${status.index}" />
	                        			</a>
	                        		</li>
	                        	</c:forEach>
	                        </ul>
	                        <a href="#" class="paging" data-page="<c:out value="${pagingVo.nextPage}" />">
	                        	<img src="image/next.gif" width="42" height="15" border="0" align="absmiddle"><!-- next -->
	                        </a>
	                        <a href="#" class="paging" data-page="<c:out value="${pagingVo.totalPage}" />">
	                        	<img src="image/next_.gif" width="22" height="15" border="0" align="absmiddle"><!-- >> -->
	                        </a>
	                     </div>   
                       </td>
                    </tr>
                  </table>
                  </form>
 				<!-------------------------  리스트 ------------------------------>
				  </td>
              </tr>
              <tr align="center" bgcolor="F8F8F8"> 
                <td height="1" align="right" bgcolor="B1B1B1"></td>
              </tr>
              <tr align="center" bgcolor="F8F8F8"> 
                <td height="26" align="right" bgcolor="F8F8F8" style="padding-right:10"><img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#" id="empDelete" class="upDel">삭제</a> <img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">인사기록카드</a> <img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">경력정보</a> <img src="image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">근무정보</a> </td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td height="3" background="image/bar_bg1.gif"></td>
        </tr>
      </table></td>
  </tr>
</table>

<form id="pagingFrm">
	<input type="hidden" name="page">
	<input type="hidden" name="searchCol">
	<input type="hidden" name="searchVal">
	
	<input type="hidden" name="searchSex">
	<input type="hidden" name="searchTechLev">
</form>

<script type="text/javascript">
	
	var empList = {
			
			pageMove : function() {
				
				/* 체크박스 선택후 수정버튼 또는 삭제버튼 선택시 
				   1. 단일만  수정가능하게끔 조건문, 2. 다중삭제 가능하게.*/
				$(".upDel").click(function() {		
					var no 		 = $("#oneRow [name=checkbox]:checked").val(),
						pageName = $(this).attr("id");
					
					if(pageName === "empViewModForm") {		// 수정버튼일때
						
						if ($("#oneRow [name=checkbox]:checked").length !== 1) {
							alert("하나만 체크해주세요~");
							return;
						}
					}
					
					$("[name=pageName]").val(pageName);
					
					$("#listFrm").attr("action", pageName + ".do");
					$("#listFrm").submit();
				})
			},
			
			pagingMove : function() {
				
				$(".paging").click(function() {
					var pageNo = $(this).data("page");	// 내가 클릭한 이미지의 data-page속성의 값 가져오기=> 페이지 번호.
					
					// 셀렉트박스 검색
					if ($("[name=select] option:selected").val() !== "") {
						$("[name=searchCol]").val($("[name=select] option:selected").val());
						$("[name=searchVal]").val($("[name=textfield].INPUT").val());
					}
					
					// 다중검색-라디오버튼
					if ($(".radioMult").is(":checked")) {
						$("[name=searchSex]").val($("[name=multSex]:checked").val());
						$("[name=searchTechLev]").val($("[name=multTechLev]:checked").val());
					}
					
					$("[name=page]").val(pageNo);	// 현재 페이지 번호를 담아서 서브밋. 그럼 그 페이지번호를 가지고 컨트롤러에서 MVC
					$("#pagingFrm").attr("action", "empList.do");
					$("#pagingFrm").submit();		
				})
			},
			
			// 상단 체크박스 선택시, 하단의 체크박스가 전체 선택되게 하기.
			kingCheckBox : function() {
				
				$("[name=kingChk]").change(function() {
					
					// name이 checkbox인 것을 다 타겟잡아서.prop(뒤에 값이(킹체크가 체크되어있으면) 타겟에 체크드 해준다~
					$("#oneRow [name=checkbox]").prop("checked", this.checked);
				})
			}
	}
	
	$(function() {
		empList.pageMove();
		empList.pagingMove();
		empList.kingCheckBox();
	})
</script>
```

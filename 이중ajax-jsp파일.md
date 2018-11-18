``` html
<!-- ::::: left.jap ::::: -->
<script>
	$(document).ready(function() {
		var pageName = "<c:out value="${param.pageName}"/>";
		 
		if (pageName != "") {
			$(".menu").removeClass("active");
			$("#" + pageName).addClass("active");
		}
		
		$(".menu").click(function() {
			var menu = $(this).attr("id");
			left.pageSubmitFn(menu);	
		});
	});
	
	var left = {
			pageSubmitFn : function(menu) {
				$("#frm").attr("action", menu + ".do");
				$("#pageName").val(menu);
				$("#frm").submit();
			}		
		};
</script>

<li id="selectBox" class="menu">
    <a href="#">
        <i class="pe-7s-refresh-2"></i>
        <p>멀티 셀렉트박스</p>
    </a>
</li>

<!-- ::::: selectBox.jap ::::: -->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>

/* 과제: 첫번째 브랜드가 상품을 가지고 있지 않다면
첫번째 셀렉트 박스는 빈폴만, 그리고 멋진고글2가 위로 올라가게끔 처리 */
var select = {
  ifElse 			: true,

  ajaxCmmn			  : function(selectBrandCd) {

    $.ajax({
      url		: "childSelectBox.do",
      data	: {"param" : selectBrandCd},
      success	: function(data) {
        var jObj = JSON.parse(data); 	// JSON.parse를 사용해서 객체로 다시 만들어줌. JSON.parse 안쓰려면 
                        // data프로퍼티 아래  dataType : "json" 써줘야함.위치는 관계없음(success프로퍼티 바깥에 써줌)
        console.log(data);		// 서버에서 보낸 제이스타입의 문자열 상태임  ex) {"prdCd":"P00003","prdNm":"별점퍼2"}
        console.log(jObj);		// JSON타입의 객체로 됨.(제이슨타입은 자바스크립트에서 그냥 객체임), 0: {prdCd: "P00002", prdNm: "별점퍼"}

        if (jObj.result === "SUCCESS") {
          select.displayChildSelectBox(jObj.childList);
        }
      }
    })	
  },
			
  displayChildSelectBox : function(childList) {
    var that = this;

    if (childList.length > 0) {

      $.each(childList, function(i, item) {
        var optionStr = "<option value=" + item.prdCd + ">" + 
            item.prdNm + "</option>";

        // else를 갖다온 childList만 역방향으로 출력하기
        if (!that.ifElse) {
          $("#childSelectBox").prepend(optionStr);		
          $("[value=" + item.prdCd + "]").prop("selected", true);  // 첫번째로 prepend된 prdCd로 선택하겟다="selected", true
        } else {
          $("#childSelectBox").append(optionStr);		
        }	
      })
    } else {		// 반스선택햇을시(=childList가 없을시)
      var brandCd = "B00003";

      this.ifElse = false;

      $("#parentSelectBox").children().not($("[value=" + brandCd + "]")).remove();

      this.ajaxCmmn(brandCd);
    }
  }	
} // select 클래스 종료.

	$(function() {
		$("#parentSelectBox").change(function() {
			var thisParam  = $(this).val();
			
			$("#childSelectBox").children().remove();			
			
			select.ajaxCmmn(thisParam);
		}) // change 이벤트종료.
	}) 
</script>
<div class="content">
	<div class="container-fluid">
      	<div class="row">
          	<div class="col-md-12">
              	<div class="card ">
	                <div class="header">
	                    <h4 class="title">셀렉트박스</h4>
	                    <p class="category">ajax 잘 모르고 쓰면 어렵지~</p>
	                </div>
	                <div class="content">
		                <select id="parentSelectBox" name="parentSelectBox">
		                	<!-- <option value="">없음</option> -->
		                	<c:forEach items="${parentList}" var="parentList">
		                		<option value="<c:out value='${parentList.brandCd}' />"><c:out value="${parentList.brandNm}" /></option>
		                	</c:forEach>
		                </select>
	                	
	                	<select id="childSelectBox" name="childSelectBox">
	                		<option value="">없음</option>
	                	</select>
	                </div>
                </div>
            </div>
        </div>
    </div>
</div>
```

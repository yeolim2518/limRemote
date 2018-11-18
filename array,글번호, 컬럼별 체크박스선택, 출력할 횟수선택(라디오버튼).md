 ![20181118_1111](https://user-images.githubusercontent.com/39145967/48669775-bddaa700-eb4e-11e8-8336-62d1c6497efa.jpg)	
 
 ``` html
 <!-- ::::: left.jsp ::::: -->
 <li id="array2" class="menu">
      <a href="#">
          <i class="pe-7s-note"></i>
          <p>게시글 조회222</p>
      </a>
  </li>
  
  <!-- ::::: 컨트롤러 array2.do ::::: -->
  @RequestMapping("array2.do")
	public String initArray1(HttpServletRequest request, ModelMap model) throws Exception{
		model.addAttribute("seqNoList", arrayService.selectSeqNoList());
		
		List<String> list = new ArrayList<>();
	      
	  // forEach 사용해서 각각의 컬럼에 맞는 출력횟수 선택할수 클래스의 이름주려고 arrayList만들어서 add.
      list.add("seqNo");
	    list.add("userName");
	    list.add("age");
	    list.add("country");
	    list.add("etc");
	      
	    model.addAttribute("list", list);
		
		return "array_8week/array_homeWork.tiles";
	}

<!--  ::::: array.xml ::::: -->			
<mapper namespace="egovframework.example.array.service.impl.ArrayMapper">
	<select id="selectSeqNoList" resultType="egovMap">
		SELECT SEQ_NO
  		  FROM WELCOME_WEB
	</select>
</mapper>			
  
 <!--  ::::: array_homeWork.jsp ::::: -->
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
$(function() {
   
   $("[name=selectColumn]").change(function() {       // 컬럼 체크박스에 체인지가 발생하면
      var $this 	= $(this);
      var inputVal 	= $this.val();                    // 각 인풋의 밸류값엔 컬럼명이 값으로 들어가 있음.
      
      if ($this.is(":checked")) {                     // 각 컬럼에 맞는 라디오버튼의 disabled를 풀어서 클릭할수 잇게 해줌.
    	  $("." + inputVal).removeClass("disabled");
    	  
    	  $("input[name=" + inputVal + "]").prop("disabled", false);
      } else {
		  $("." + inputVal).addClass("disabled");         // $("." + inputVal)를 위해 컨트롤러에서 list에 각 컬럼명을 add함.
    	  
    	  $("input[name=" + inputVal + "]").prop("disabled", true);
      }
   });
});
</script>

<div class="content">
   <div class="container-fluid">
         <div class="row">
             <div class="col-md-12">
                 <div class="card ">
                   <div class="header">
                       <h4 class="title">게시글 조회</h4>
                   </div>
                   <div class="content">
                      <form id="selectSeqNoFrm" class="form-horizontal" action="welcomeWeb5.do">
                          <div class="row">
                                <div class="form-group">
                                      <label class="col-sm-2 control-label">글 번호 선택</label>
                                      <div class="col-sm-8">
                                         <c:forEach items="${seqNoList}" var="seqNoList">
                                           <label class="checkbox checkbox-inline">
                                               <input type="checkbox" data-toggle="checkbox" name="selectSeqNo" value="${seqNoList.seqNo}"> ${seqNoList.seqNo}
                                           </label>
                                        </c:forEach>
                                      </div>
                                </div>
                           </div>
                           <div class="row">
                        <div class="form-group">
                           <label class="col-sm-2 control-label">컬럼 선택</label>
                           <div class="col-sm-8 arrayLabel">
                              <label class="checkbox checkbox-inline column">
                                 <input type="checkbox" data-toggle="checkbox" name="selectColumn" value="seqNo" />
                                 <span class="labelText">seqNo</span>
                              </label>
                              <label class="checkbox checkbox-inline column">
                                 <input type="checkbox" data-toggle="checkbox" name="selectColumn" value="userName" />
                                 <span class="labelText">userName</span>
                              </label>
                                        <label class="checkbox checkbox-inline column">
                                 <input type="checkbox" data-toggle="checkbox" name="selectColumn" value="age" />
                                 <span class="labelText">age</span>
                              </label>
                              <label class="checkbox checkbox-inline column">
                                 <input type="checkbox" data-toggle="checkbox" name="selectColumn" value="country" />
                                 <span class="labelText">country</span>
                              </label>
                              <label class="checkbox checkbox-inline column">
                                           <input type="checkbox" data-toggle="checkbox" name="selectColumn" value="etc" />
                                           <span class="labelText">etc</span>
                              </label>
                           </div>
                        </div>
                     </div>
                     <div class="row">
                        <div class="form-group">
                           <label class="col-sm-2 control-label">출력횟수 선택</label>
                           <c:forEach items="${list}" var="list">
                              <div class="col-sm-1 arrayLabel">
                                 <label class="radio checked <c:out value='${list}'/>">
                                    <span class="icons">
                                       <span class="first-icon fa fa-circle-o"></span>
                                       <span class="second-icon fa fa-dot-circle-o"></span>
                                    </span>
                                         <input type="radio" data-toggle="radio" name="<c:out value='${list}'/>" value="1" checked="checked" disabled>
                                    <span class="labelText">1</span>
                                 </label>
                        
                                 <label class="radio <c:out value='${list}'/>">
                                    <span class="icons">
                                       <span class="first-icon fa fa-circle-o"></span>
                                       <span class="second-icon fa fa-dot-circle-o"></span>
                                    </span>
                                    <input type="radio" data-toggle="radio" name="<c:out value='${list}'/>" value="2" disabled>
                                    <span class="labelText">2</span>
                                 </label>
                              </div>
                           </c:forEach>   
                        </div>
                     </div>
                             <div class="row">
                              <div class="col-md-2 col-md-offset-5">
                                  <!-- *** 인풋타입이 submit이면 밸류값인 검색하기 누르면 자동으로 넘어감. 대신 form 태그안에 감싸져있어야함.
                               		위에 폼의 액션값인 welcomeWeb5.do 로 서브밋 됨. -->
                                     <input type="submit" class="btn btn-wd btn-success" value="검색하기">
                                </div>
                             </div>
                          </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--  ::::: 컨트롤러 welcomeWeb5.do ::::: -->
@RequestMapping("welcomeWeb5.do")
	public String welcomeWeb5(HttpServletRequest request,
			@RequestParam(value="selectSeqNo", required=false) List<String> selectSeqNo, 
			@RequestParam(value="selectColumn", required=false) List<String> selectColumn, 
			@RequestParam Map map,
			ModelMap model) throws Exception {
		
		// String[] selectSeqNo = request.getParameterValues("selectSeqNo");
		// System.out.println(Arrays.toString(selectSeqNo));
		
		model.addAttribute("selectSeqNo",  selectSeqNo);
		model.addAttribute("selectColumn", selectColumn);
		model.addAttribute("map", 		   map);
		
		System.out.println("selectSeqNo 선택한 글번호 : " + selectSeqNo);	// selectSeqNo 선택한 글번호 : [1, 7]
		System.out.println("selectColumn 선택한 컬럼 : " + selectColumn); // selectColumn 선택한 컬럼 : [seqNo, userName, country]
		System.out.println("map 컬럼별 출력횟수 찍어보기 : " + map); // {selectSeqNo=1, selectColumn=seqNo, seqNo=1, userName=2, country=2}
		
		List<EgovMap> welcomeWebList = welcomeWebService.selectWelcomeWebServiceList();
		
		model.addAttribute("welcomeWebList", welcomeWebList);
		
		return "welcomeWeb/welcomeWeb5.tiles";
	}
```

```html
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<table class="empInsertTable">
  <tr> 
    <td width="640">&nbsp;</td>
  </tr>
  <tr> 
    <td height="25"><img src="image/icon.gif" width="9" height="9" align="absmiddle"> 
      <strong>사원 기본 정보 등록</strong></td>
  </tr>
  <tr> 
    <td>
     						<!-- 파일업로드 사용시 꼭 폼에 적어주기 -->
    <form id="empInsertFrm" enctype="multipart/form-data" method="post"> 
    	<input type="hidden" name="pageName" >
    <table width="640" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td height="15" align="left"><table width="640" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td><table width="640" border="0" cellspacing="1" cellpadding="0">
                    <tr> 
                      <td height="2" background="image/bar_bg1.gif"></td>
                    </tr>
                    <tr align="center" bgcolor="F8F8F8"> 
                      <td height="26" align="center" bgcolor="#E4EBF1" style="padding-right:10"><table width="600" border="0" cellspacing="0" cellpadding="0">
                          <tr> 
                            <td align="center"><strong>교육정보 | 자격증. 보유기술정보 | 프로젝트 
                              정보 |경력정보 | 근무정보</strong></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr align="center" bgcolor="F8F8F8"> 
                      <td height="3" align="right" background="image/bar_bg1.gif"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td height="6" align="center" valign="top">&nbsp;</td>
        </tr>
        <tr>
          <td height="7" align="center" valign="top"><table width="600" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td bgcolor="#CCCCCC"><table width="600" border="0" cellspacing="1" cellpadding="0">
                    <tr> 
                      <td height="135" align="center" bgcolor="#E4EBF1"><table width="600" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="144" height="119" align="center"><table width="100" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td height="112" bgcolor="#CCCCCC"><table width="100" border="0" cellspacing="1" cellpadding="0">
                                  <tr>
                                    <td height="110" bgcolor="#FFFFFF">
                                    	<img class="preview" alt="" style="width:98px; height:110px">
                                    </td>
                                  </tr>
                              </table></td>
                            </tr>
                          </table></td>
                          <td width="456"><table width="423" border="0" cellspacing="2" cellpadding="0">
                            <tr>
                              <td height="2" colspan="2"></td>
                              </tr>
                            <tr>
                              <td width="107" height="26" align="right"><strong>한글이름 :</strong>&nbsp;</td>
                              <td width="310" height="26">
                                <input type="text" name="korName" class="memo" title="한글이름" data-valid="string">
                                <span class="error"></span>
                              </td>
                            </tr>
                            <tr>
                              <td height="26" align="right"><strong>영문이름 :&nbsp;</strong></td>
                              <td height="26">
                              <input type="text" name="engName" class="memo" title="영문이름" data-valid="string">
                              <span class="error"></td>
                            </tr>
                            <tr>
                              <td height="26" align="right"><strong>한문이름:</strong>&nbsp;</td>
                              <td height="26">
                              <input type="text" name="chnName" class="memo" title="한문이름" data-valid="string">
                              <span class="error"></td>
                            </tr>
                            <tr>
                              <td height="26" align="right"><strong>주민등록번호 :</strong>&nbsp;</td>
                              <td height="26"><input name="juminNof" type="text" size="15" class="memo juMin" title="주민등록번호" data-valid="int">
      -
        <input name="juminNob" type="text" size="15" class="memo juMin" title="주민등록번호" data-valid="int">
        <span class="error"></span></td>
                            </tr>
                          </table></td>
                        </tr>
                      </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td height="7" align="center" valign="top">&nbsp;</td>
        </tr>
        <tr> 
          <td height="13" align="center"><table width="600" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td bgcolor="#CCCCCC"><table width="600" border="0" cellspacing="1" cellpadding="0">
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="526" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="102" align="right"><strong>사진파일명 :&nbsp;</strong></td>
                            <td width="268">
                            	<input name="textfield33" type="text" size="40" readonly="readonly">
                            </td>
                            <td width="146"><font color="#FF0000">
                            	<img id="imgSearch" src="image/bt_search.gif" width="49" height="18"></font>
                            	<input type="file" name="profile" style="display: none;">	
                            </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="102" align="right"><strong>생년월일 :&nbsp;</strong></td>
                            <td width="391"><input name="birthY" type="text" size="10" class="memo birth" title="생년월일" data-valid="int">
                              년 
                              <input name="birthM" type="text" size="7" class="memo birth" title="생년월일" data-valid="int">
                              월 
                              <input name="birthD" type="text" size="7" class="memo birth" title="생년월일" data-valid="int">
                              일 ( 
                              <input type="radio" name="solFlag" value="양력" checked="checked">
                              양력 
                              <input type="radio" name="solFlag" value="음력">
                              음력 )</td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="102" align="right"><strong>성별 :&nbsp; </strong></td>
                            <td width="391"> <input type="radio" name="sex" value="남자" checked="checked">
                              남자 
                              <input type="radio" name="sex" value="여자">
                              여자</td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="102" align="right"><strong>결혼유무 :&nbsp;</strong></td>
                            <td width="391"> <input type="radio" name="marryFlag" value="미혼" checked="checked">
                              미혼 
                              <input type="radio" name="marryFlag" value="기혼">
                              기혼</td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>년차 :&nbsp;</strong></td>
                            <td width="392">
                            <input name="workYear" type="text" size="10" class="memo" title="년차" data-valid="int"> 
                            <span class="error"></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>급여 지급유형 :&nbsp;</strong></td>
                            <td width="392"> <select name="paymentType">
                                <option>월급</option>
                                <option>주급</option>
                              </select> </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>희망직무 :&nbsp;</strong></td>
                            <td width="392"> <select name="desireDept">
                                <option>SI</option>
                                <option>SM</option>
                              </select> </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>입사유형:&nbsp;</strong></td>
                            <td width="392"> <select name="jopType">
                                <option>정규직</option>
                                <option>계약직</option>
                              </select> </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>주소:&nbsp;</strong></td>
                            <td width="392">
                              <input name="address" type="text" size="60"> 
                            </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>연락처:&nbsp;</strong></td>
                            <td width="392"><input name="phoneF" type="text" size="10" class="memo" title="연락처" data-valid="int">
                              - 
                              <input name="phoneM" type="text" size="10" class="memo" title="연락처" data-valid="int">
                              - 
                              <input name="phoneL" type="text" size="10" class="memo" title="연락처" data-valid="int">
                              <span class="error"></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>이메일:&nbsp;</strong></td>
                            <td width="392"><input name="email" type="text" size="20"> 
                            </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>기술등급:&nbsp;</strong></td>
                            <td width="392"><input name="techLev" type="text" size="20" class="memo" title="기술등급" data-valid="string"> 
                            <span class="error"></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>주량:&nbsp;</strong></td>
                            <td width="392"><input name="liquor" type="text" size="20"> 
                            </td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td height="3" align="center">&nbsp;</td>
        </tr>
        <tr>
          <td height="3" align="center"><table width="107" border="0" cellpadding="1" cellspacing="1">
            <tr>
              <td width="49"><img class="insertBtn" src="image/bt_insert.gif" width="49" height="18"></td>
              <td width="51"><img class="pageMove" data-id="empList" src="image/bt_cancel.gif" width="49" height="18"></td>
            </tr>
          </table>            </td>
        </tr>
        <tr> 
          <td height="7" align="right">&nbsp;</td>
        </tr>
      </table>
      </form>
      </td>
  </tr>
</table>

<script>
	var img = {
			
			imgUpload : function() {
				
				// 이미지 파일첨부 눌럿을시 클릭이벤트리스너
				$("#imgSearch").click(function() {
					$("[name=profile]").trigger("click"); // 네임이 profile인 것을 찾아 클릭한 효과를 줌.
				})

				// 인풋파일에서 업로드 된 파일 가져오기.파일 1개임.
				$("[name=profile]").change(function(e) {
					var reader 	 = new FileReader(), 
						file 	 = e.target.value.split("\\"), // \기준으로 스플릿(배열로됨):\는 \\로 써줘야함.
						fileName = file.pop();	// file(위에서 스플릿써서 배열됨)배열의 젤 마지막 값임(파일의 실제 이름)

					// 확장자 jpg만 등록 가능하게.
					if (fileName.split(".").pop() !== "jpg") {	// cat.jpg을 스플릿.파일이름사이에 .있을수도 있어서 젤 마지막(pop()가져옴)
						alert("jpg파일만 등록 가능합니다.");
						$(this).val("");	// 실제로 위에 체인지가 일어낫을때 업로드 됨. 알럿창 뜨고 그 후에 업로드된 png파일을 없앰. this의 값을 빈문자열로 줌.
						return;
					}
					
					reader.onload = function(e) {
						$(".preview").attr("src", e.target.result);		// 미리보기창 타겟잡은후 src속성에 값 넣기.
						// e.target: 내가 선택한 파일, result:바이너리 데이터
						// 아직까지 데이터를 로컬이나 서버에 저장한게 아니라서 바이너리 데이터 자체를 src에 바로 저장해서 화면에 이미지 보여지게함.
					}
					reader.readAsDataURL(e.target.files[0]);	// e.target의 파일들 중 첫번째 파일.

					$("[name=textfield33]").val(fileName); // file 배열이 젤 마지막 값이 필요함. fileName=cat.jpg
				})
			}
	}

	var memo = {

		btnClick : function() { 
			var	$memo = $(".memo");
			
			return this.validationChkFn($memo);
		},

		validationChkFn : function(obj) {
			var inputNotEmpty = true;

			obj.each(function() {
				var $this = $(this);

				if ($this.val() === "") {
					alert($this.attr("title") + "는(은) 필수 입니다.");

					$this.focus();

					inputNotEmpty = false;
				} else if ($this.data("valid") === "string") {		// 위 인풋의 값이 빈문자열이 아니고, date속성의 값이  스트링인 this 일떄.
					var reg = /^[a-zA-Z가-힣一-龥]*$/		// 정규식, 공식: /^[]*$/ 임. []사이에 넣어줌...
					
						// 정규식일 잘되어있는지 확인하는 함수: reg.test()임. 파라미터로 현재 이치문 돌고있는 네임의 값을 넣어줌.
					if (!reg.test($this.val())) {	// 만족하면 true를 반환함. 그래서 위에 정규식을 만족하지못할때 if문 스코프 타기.
						alert($this.attr("title") + "는(은) 문자만 가능합니다.");

						$this.focus();

						inputNotEmpty = false;
					}
				} else if ($this.data("valid") === "int") {
					var reg = /^[0-9]*$/		// 정규식, 공식: /^[]*$/ 임. []사이에 넣어줌...숫자만 입력.
						
					if (!reg.test($this.val())) {	// 만족하면 true를 반환함. 그래서 위에 정규식을 만족하지못할때 if문 스코프 타기.
						alert($this.attr("title") + "는(은) 숫자만 가능합니다.");

						$this.focus();

						inputNotEmpty = false;
					}
				} // 현재 이치문에서 돌고있는 this의 data속성값이 int인 객체의 else if 완료.
						return inputNotEmpty; // 포이치 문을 벗어나서 true 또는 false 반환(true일시 포이치문 계속 돌고, false면 여기서 중지.)
			}) // for이치문 종료.

			return inputNotEmpty;
		} // validationChkFn 메서드 종료.
	}	// 객체 종료.
	
	$(function() {

		img.imgUpload();

		$(".insertBtn").click(function() {		// 등록버튼 누를시 이벤트

			var pageName = "empInsert";
			$("[name=pageName]").val(pageName);
			
			if (!memo.btnClick()) {			// memo.btnClick() 반환값이 false 이면 스코프 타서.. 리턴함.(여기서 끝)
				return;						// 아래 코드로 안넘어감.(=서브밋이 안됨)
			}

			$("#empInsertFrm").attr("action", pageName + ".do");
			$("#empInsertFrm").submit();
		}) // 등록버튼 이벤트 종료.
		
		// 생년월일 자동입력해주기~~ juMin클래스를 가진 첫번째를 타겟.
		$(".juMin").first().keyup(function() {		// keyup이벤트-키보드를 눌럿다 뗏을때...비동기 유효검사때도 사용.
			var reg = /^[0-9]{6}$/;		// 정규식, 공식: /^[]*$/ 임. [숫자만 입력]사이에 넣어줌.6자리까지라서 * 대신 {6}로 표기.
				
				if (reg.test($(this).val())) {	// 6자리 숫자일시(true) if문 스코프 타기.
					var value = $(this).val();	// 6자리 숫자 들어가 있음.
					
					$(".birth").first().val("19" + value.slice(0,2));  // slice(0,2)첫번째부터~ 2번째 인자값의 앞번호까지.(2번째번호:3임)
					$(".birth").eq(1).val(value.slice(2,4));	// 3,4  인덱스:2,4
					$(".birth").last().val(value.slice(4,6));	// 5,6  인덱스:4,6
				}
		}) // 생년월일 자동입력해주기 종료.
		
		// 주민번호 중복시 알럿창 띄우기(뒷자리 주민번호로 중복체크)
		$(".juMin").last().keyup(function() {
			var reg 	= /^[0-9]{7}$/,
				$this 	= $(this);
			
			if (reg.test($(this).val())) {
				
				// ajax간편히. (url, 보낼 데이타, function(서버에서 받은 데이타) {}, 서버에서 보내온 데이타 타입)
				$.post("juminCheck.do", {jumin : $(this).val()}, 
						function(data) {
							
							if (data.result === "fail") {
								alert("동일한 주민번호가 있습니다.");
								$this.val("");
							}
				       }, "json")
			}
		})	// 주민 중복처리 ajax 종료.
		
		// 인풋 유효성 검사 비동기로.
		$(".memo").keyup(function() {
			var $this = $(this),
				valid = $this.data("valid");	// 각 인풋에 data-valid="" 의 값으로 string , int 넣음
			
			$.ajax({
				url 	 : "vaild.do",
				type 	 : "post",
				data 	 : {param : valid, value : $this.val()},
				dataType : "json",
				success  : function(data) {
					var $error = $this.nextAll().last(); // this의 형제에서 다음에 있는것중 가장 마지막 형제:<span class="error">태그임.
					
					if (data.result === "success") {
						$error.removeClass("errorSpan");
						$error.text("");
					} else {
						$error.addClass("errorSpan");
						
						if (valid === "string") {
							$error.text("문자만 입력 가능합니다.");
						} else if (valid === "int") {
							$error.text("숫자만 입력 가능합니다.");
						}
					}
				}
			})
		
		})
	})
</script>
```

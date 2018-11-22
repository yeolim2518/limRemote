```js
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
엑셀 업로드

<form id="fileForm">
	<input type="file" id="excelBtn" name="excel">
	<input type="hidden" name="name" value="excel">
</form>

<button id='DBdownBtn'>DB 다운로드</button>

<div id="excelDiv"></div>		<!-- 출력될 화면 감싸는 부분 -->
<script>
	var excel = {
		$excelBn 	: $,		// 엑셀 업로드 버튼
		$form		: $,		// 엑셀 업로드 버튼을 둘러싸고 있는 form
		$div		: $,		// 테이블을 그릴 div
		
		init : function() {
			this.$excelBn 	= $("#excelBtn");
			this.$form 		= $("#fileForm");
			this.$div		= $("#excelDiv");
		},
		
		excelUpload : function() {
			var that = this;
			
			// 클릭이벤트 안됨.클릭은 업로드된 파일이 인풋에 저장되기전에 실행. 체인지는 인풋에 저장된 후에 호출됨.(다른파일에 대해서만 이벤트발생, 동일파일은 이벤트실행안됨)
			this.$excelBn.change(function() {		
				
			 // FormData클래스는 js에서 제공. $form은  제이쿼리라서 js돔객체로 파라미터 넣어야해서 that.$form[0]를 호출해서 넣어줌. 폼이 한개라 인덱스0번으로 호출.
				var formData = new FormData(that.$form[0]);	 // 파라미터로 받은 폼태그를 FormData클래스가 객체로 바꿔줌.
				
				$.ajax({
					url 		: "excelUploadAjax.do",
					data 		: formData,				// 폼태그(=객체로 바뀜)를 데이타로 넘김.
					type 		: "post",
					processData	: false, 
					contentType	: false,
					dataType 	: "json",
					success		: function(data) {    // data = 컨트롤러에서 excelList가 넘어옴
						var table 	  = "",
							theadData = data.shift(),	// shift(): 배열중 제일 앞에있는 걸 가져옴(excelList에서 컬럼명에 해당하는걸 가져옴)
							tbodyData = data;		// shift()사용하면 배열의 0번째 인덱스를 반환하면서 배열에서 제거됨. 그래서 th제외한 나머지 부분만
											// tbodyData에 들어가게됨.
						table += "<table id='table'><thead><tr>";
						table += that.getTag(theadData, "th");
						table += "</tr></thead><tbody>";
						table += that.stringAdd(tbodyData, that.getTag, "td");	//that.getTag에서 ()없는이유는 여기서 바로 호출할게 아니라서.
						table += "</tbody></table>";		
								
					// that=excel객체. $div.get(0)=1번째 div태그. innerHTML 안에 넣기.
						that.$div.get(0).innerHTML = table;
						
						$("body").append("<button id='downBtn'>다운로드</button>");
						
					}
				});	// ajax 종료.
			}); // $excelBn.change 이벤트종료.
		},
		
		stringAdd : function(array, func, data) {
			var result = "";
			
			for (var i = 0, length = array.length; i < length; i++) {
				result += "<tr>" + func(array[i], data) + "</tr>";
			}
			
			return result;
		},
		
		getTag : function(data, tag) {
			var result = "",
				value;
			
			for (var prop in data) {	// 받아온 data의 키이름을 변수 prop에 하나씩 넣어주기.
				result += "<" + tag + ">" + data[prop] + "</" + tag + ">";	// 데이터의 키 네임의 값을 한개씩 추가해줌 +=
			}
			
			return result;
		},
		
		excelDownload : function() {
			
			$(document).on("click", "#downBtn", function() {
				var $table 		= $("#table"),
					titles 		= [],
					contents 	= [],
					map			= {};
				
				// Array.prototype.forEach = $.each 와 같음.
				// call()을 쓰는이유: call앞에 forEach안에서의 this를 call의 첫번째 인자값으로 정하기 위해서(=$table.find("th")).
				// function(title)=call()의 두번째 인자값임. title이 th임. 배열의 0번째 인덱스의 값부터 하나씩 넣어줌.th의 값을 한개씩 가져와서 넣어줌. 
				Array.prototype.forEach.call($table.find("th"), function(title) {
					titles.push(title.innerHTML);  // title.innerHTML : th에 감싸져있는 글자들(태그까지포함) <th>이름</th>
				});
				
				// $table.find("tbody tr")의 값이 한개,한개씩  function(row) row안에 들어감.
				Array.prototype.forEach.call($table.find("tbody tr"), function(row) {	// 한줄.
					var content = [];
					
					Array.prototype.forEach.call(row.querySelectorAll("td"), function(td) { // 위에 한줄을 갖고 다시 포이치.
						content.push(td.innerHTML);	// row가 여러줄이라 한줄한줄 감싸려고. content에 넣어준후 아래에서 한번에 넣음.
					});
					
					contents.push(content);
				});
				
				map.titles   = titles;		// map에 th 한줄 넣음.
				map.contents = contents;	// map에 td 한줄 넣음.(row)
				
				$.ajax({
					url 		: "excelDownloadAjax.do",
					type 		: "post",
					data 		: JSON.stringify(map),	// map을 제이슨형태의 문자열로 보냄(오브젝트가 아니라..문자열로 보내짐..아래 컨텐트타입과 같이써야 함)
					dataType 	: "json",
					contentType : "application/json",	// data짝꿍: 제이슨형태의 문자열을 보냇지만 서버엔 오브젝트로 넘어감.
					success 	: function(data) {
						
						if (data.result === "SUCCESS") {
							alert("다운로드를 완료 하였습니다.");
						}
					}
				});
			});
		},
		
		dbDownload : function() {
			
			$("#DBdownBtn").click(function() {
				
				$.ajax({
					url 		: "DBdownloadAjax.do",
					type 		: "post",
					dataType 	: "json",
					success 	: function(data) {
						
						if (data.result === "SUCCESS") {
							alert("다운로드를 완료 하였습니다.");
						}
					}
				});
			})
		}
		
	}
	
	$(function() {
		excel.init();
		excel.excelUpload();
		excel.excelDownload();
		excel.dbDownload();
	});
</script>
```

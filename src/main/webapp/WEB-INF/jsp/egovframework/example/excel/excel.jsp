<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>엑셀 업로드</title>
</head>
<body>
<form id="form">
	<input type="file" id="file" name="excel">
</form>

<button id="downBtn">다운로드</button>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	var excel = {
		$form : $,
		$file : $,
		$down : $,
		
		init : function() {
			this.$form = $("#form");
			this.$file = $("#file");
			this.$down = $("#downBtn");
		},
		
		excelUpload : function() {
			var that = this;
			
			this.$file.change(function() {
				var formData = null;
				
				that.$form.append("<input type='hidden' name='uploadName' value='" + that.$file.attr("name") + "'>");
				
				formData = new FormData(that.$form[0]);
				
				// processData : false, contentType	: false 둘다 넣었을 때만 정상적으로 실행 됨
				$.ajax({
					url 		: "excelUpload.do",
					type 		: "post",
					data 		: formData,
					dataType 	: "json",
					processData	: false, 
					contentType	: false,
					success		: function(data) {
						
					} 
				});
			});
		},
		
		excelDownload : function() {
			
			this.$down.click(function() {
				
				$.ajax({
					url 		: "excelDownload.do",
					type		: "post",
					dataType	: "json",
					success 	: function(data) {
						
						if (data.result === "SUCCESS") {
							alert("다운로드에 성공하였습니다.");
						}
					}
				})
			});
		}
		
	}
	
	$(function() {
		excel.init();		
		excel.excelUpload();		
		excel.excelDownload();		
	});
</script>
</body>
</html>
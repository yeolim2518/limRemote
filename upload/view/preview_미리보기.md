# 이미지 미리보기

해당 페이지는 이미지 미리보기를 위한 페이지입니다. 이미지를 서버로 보내기 위한 속성이나 기능은 일부 생략해서 작성하였으므로 미리보기 부분만 참고 하시길 바랍니다.

## 1. html 태그 작성

1. 이미지를 업로드 할 form, input태그를 작성합니다.

1. 이미지 미리보기를 할 영역(div)를 작성합니다.

```html
<form id="form">
    <input type="file" id="file">
</form>

<div id="preview"></div>
```

## 2. 자바스크립트 작성

## 2-1. 이미지가 변경될때 이벤트

이미지가 변경될때 마다 미리보기 영역에 해당하는 이미지가 출력 될수있도록 이벤트를 설정합니다. 그리고 이벤트의 콜백함수로 preview를 넘겨줍니다(해당 함수는 다음 단계에서 작성합니다).

```js
<script>
    $(function() {
        $("#file").change(preview);
    });
</script>
```

## 2-2. 이벤트의 콜백함수

해당 함수를 script 내부에 작성합니다.

```js
function preview(e) {
    var files 		= e.target.files,           // 이미지 찾기에서 선택한 파일들 객체
        length		= files.length,             // 총 선택한 파일 개수
        preview	    = document.querySelector("#preview"),        // 이미지를 그려줄 영역 = $("#preview")
        reader 		= null;                     // 선택한 파일을 읽어들일 때 사용할 객체를 저장할 변수
    
    preview.innerHTML = "";                     // 영역에 이미 이미지 미리보기가 존재한다면 모두 제거
    
    for (var i = 0; i < length; i++) {
        reader = new FileReader();              // FileReader객체 생성. 해당 객체로 파일을 읽어드림
        
        reader.onload = function(e) {           // 파일을 읽어들였을 때 실행할 콜백함수 정의
            var result  = e.target.result,      // e.target.result에는 파일데이터가 저장되어 있음
                img     = document.createElement("img");

            img.src = result;                   // img태그의 src에 result를 넣어주면 이미지 출력 가능

            preview.appendChild(img);           
        }
        
        reader.readAsDataURL(files[i]);         // reader를 통해서 읽어들일 File객체를 넘겨줌
    } 
}
```

#### [돌아가기](../view.md)
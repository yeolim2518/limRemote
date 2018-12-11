# ajax를 활용한 파일 넘기기

## 1. form 태그와 input태그 작성하기
form을 활용한 파일넘기기 처럼 form태그와 input태그를 작성합니다. 이는 로컬로부터 업로드할 파일을 선택하기 위해서 필요합니다. 이때 form을 활용한 것처럼 enctype속성을 추가 할 필요는 없습니다.

```html
<form name="form">
	<input type="file" name="file" multiple>
</form>
```

## 2. form태그를 데이터로 만들기

ajax로 서버로 data를 보낼때 form을 data로 만들어서 보낼 필요가 있습니다. 이때 form을 data로 만들어주는 객체가 FormData객체입니다.

```js
var form        = document.form;
    formData    = new FormData(form);
```

## 3. ajax로 데이터 보내기

- ajax는 jquery를 사용합니다. 
- ajax 필수옵션
    1. processData : false
        processData옵션을 설정하지 않으면 기본값은 true. true로 설정할 경우 data를 serialize하여 Query String으로 변경하여 주기 때문에 이를 막기 위해서 입니다. 
    2. contentType : false
        contentType은 false로 하는 경우 브라우저에서 FormData를 사용하여 전송시에 자동으로 "multipart/form-data"로 셋팅하여 줍니다.

```js
var form        = document.form;
    formData    = new FormData(form);

$.ajax({
    url             : "fileUpload.do",
    type            : "post",
    data            : formData,
    contentType     : false,
    processData     : false,
    success         : function() {
        alert("성공하였습니다.")
    }
});
```

#### [돌아가기](../view.md)
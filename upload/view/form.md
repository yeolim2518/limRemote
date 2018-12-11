# form을 활용한 파일 넘기기

## 1. form 속성

form의 속성으로 `enctype="multipart/form-data"`를 작성해주어야만 컨트롤러에서 파일을 받아올수 있습니다.

```html
<form enctype="multipart/form-data"></form>
```

## 2-1. 단일 파일 업로드

파일은 input `type`중의 `file`이라는 값으로 업로드 할수있습니다. input type중의 file은 로컬에 존재하는 파일을 선택할수 있게 해줍니다.

```html
<!-- 단일 파일 넘기기 -->
<form enctype="multipart/form-data">
    <input type="file" name="file">
</form>
```

## 2-2. 다중 파일 업로드

input의 속성중 multiple를 넣으면 파입업로드시에 여러 파일들을 선택할수 있습니다.

```html
<!-- 다중 파일 넘기기 -->
<form enctype="multipart/form-data">
    <input type="file" name="files" multiple>
</form>
```

## 3. 서버로 넘기기

form의 속성 중 action은 서버로 보낼 url 주소, method는 폼데이터를 보내는 방식을 설정하는 것으로 **post방식**으로 작성합니다. 파일을 선택 한 후에 해당 form을 submit해주면 됩니다(아래 코드에서는 보내기 버튼 클릭).

```html
<!-- form의 action속성과 method 속성 작성하기 -->
<form enctype="multipart/form-data" action="fileUpload.do" method="post">
    <input type="file" name="files" multiple>
    <input type="submit" value="보내기">
</form>
```

#### [돌아가기](../view.md)
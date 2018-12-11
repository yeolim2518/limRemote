# 업로드하는 파일에 대한 유효성 검사

해당 페이지는 파일에 대한 유효성 검사를 하기 위한 페이지입니다. 이미지를 서버로 보내기 위한 속성이나 기능은 일부 생략해서 작성하였으므로 미리보기 부분만 참고 하시길 바랍니다.

## 1. html 태그 작성

1. 이미지를 업로드 할 form, input태그를 작성합니다.

```html
<form id="form">
    <input type="file" id="file">
</form>
```

## 2. 자바스크립트 작성

## 2-1. 확장자 체크
```html
$("#file").change(function(e) {
    var files 		= e.target.files,
        length		= files.length,
        extentions	= ["jpg", "png"];
    
    for (var i = 0; i < length; i++) {
        
        if (checkExt(files[i].name, extentions)) {
            alert("성공");
        } else {
            alert("옳지 않은 확장입니다.");
        }
    }
});

/* 파일이름과 허용할 확장자 리스트를 받아서 확장자 리스트 중에
 * 하나라도 해당한다면 true를 아니면 false를 반환
 *
 * @param : fileName 파일이름
 * @param : extensions 허용할 확장자 리스트
 * @return : boolean
 **/
function checkExt(fileName, extensions) {
    var fileExt = getExt(fileName);
        
    return extensions.some(function(ext) {
        return fileExt === ext;
    });
}

/* 파일이름을 받아서 확장자 이름을 반환 
 *
 * @param : fileName 파일이름
 * @return : String 확장자이름
 **/
function getExt(fileName) {
    return fileName.split(".").pop();
}
```

## 2-2. 용량체크
```html
/* 
 * @param : file 업로드 할 File
 * @param : maxSize 최대 사이즈
 * @return boolean	: true면 maxSize보다 이하
 */
function checkSize(file, maxSize) {
    var size = file.size;

    if (size > maxSize) {
        return false;
    } else {
        return true;
    }
}
```

#### [돌아가기](../view.md)
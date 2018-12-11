# 화면에서 넘겨온 파일을 컨트롤러(서버)에서 받기 

화면에서 받아온 파일은 MultipartHttpServletRequest에 저장이 되어 있습니다. 그래서 파일 업로드 관련 된건 MultipartHttpServletRequest에서 기타 다른
텍스트는 HttpServletRequest에서 값을 가져올수 있습니다.

```java
@RequestMapping(value = "fileUpload.do")
public void fileUpload(MultipartHttpServletRequest mRequest,
        HttpServletRequest request) {
    
}
```

#### [README로 돌아가기](../README.md)
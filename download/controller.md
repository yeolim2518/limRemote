# 파일에 정보를 컨트롤러에서 받기

다운받고자 하는 파일 이름을 컨트롤러에서 받고 다운로드 처리를 할 view로 File을 넘겨줍니다.

```java
@RequestMapping(value = "fileDownload.do")
public String fileUpload(String fileName, ModelMap model) throws Exception {
    String path = "C:\\file\\";                 // 파일이 위치한 경로
    
    File file = new File(path + fileName);      // 실제 파일 경로로 File 생성
    
    if (!file.canRead()) {
        throw new Exception("파일을 찾을수 없습니다.");
    }
    
    model.addAttribute("file", file);           // model에 File 추가

    return "fileDownView";                      // 다운로드를 처리할 view의 이름을 반환
}
```

#### [README로 돌아가기](../README.md)
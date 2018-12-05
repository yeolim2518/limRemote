# pom.xml에 엑셀 dependency 추가하기

### 엑셀
```
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>3.11</version>
</dependency>
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>3.11</version>
</dependency>
```

### 파일업로드
엑셀의 데이터를 가져와서 사용할때는 파일업로드가 필요하기 때문에 아래의 dependency 추가
```
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.0.1</version>
</dependency>

<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.2.2</version>
</dependency>
```

#### 파일업로드를 처음 추가한다면 아래의 링크를 참조하여 dispatcher-servlet.xml 수정하기
[dispatcher-servlet.xml](dispatcher-servlet.xml.md)

#### [readme로 돌아가기](../README.md)
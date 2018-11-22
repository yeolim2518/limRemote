```xml
<!-- boardTest 프로젝트. -->

<!-- pom.xml  서버또는 로컬에 저장되어있는 엑셀파일을 가져오거나, 엑셀파일에 데이터 등을 저장할때.. -->
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

<!-- 엑셀파일 업로드 및 다운로드할때 필요 파일들.. 폴더째 복사붙여넣기 하기. -->
<!-- main>java>egov>example>cmmn>excel 폴더쨰 복사해서 경로에 맞춰 cmmn폴더안에 붙여넣기~
      참고: excel 폴더안에 3개의 폴더 있음
           > option
               - ReadOption.java
               - WriteOption.java
           > read
               - ExcelRead.java
               > util 폴더
                  - CellRef.java
                  - FileType.java
           > write
               - ExcelWritejava
-->
```

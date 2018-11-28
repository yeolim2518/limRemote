# pom.xml에 오라클 추가하기
### 아래 코드 추가하기

- repositories가 **없으면** 아래 코드 전체를 복사해서 붙여넣기
- repositories가 **존재하면** `<repository>` 태그만 복사해서 붙여넣기
	
```
<repositories>
	<repository>
	    <id>codelds</id>
	    <url>https://code.lds.org/nexus/content/groups/main-repo</url>
	</repository>
</repositories>	
```
### denpendencies 하위에 추가하기
```
<dependency>
    <groupId>com.oracle</groupId>
    <artifactId>ojdbc6</artifactId>
    <version>11.2.0.3</version>
        <!-- <scope>system</scope>
        <systemPath>${basedir}/src/main/webapp/WEB-INF/lib/ojdbc-11.2.0.3.jar</systemPath> -->
</dependency>
```
### 위의 코드가 먹히지 않고 오류가 발생한다면 아래 ojdbc6를 다운받자
[ojdbc6.zip](https://github.com/yeolim2518/limRemote/files/2623006/ojdbc6.zip)

#### [pom.xml로 돌아가기](../pom.xml.md)

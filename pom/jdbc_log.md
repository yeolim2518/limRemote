# pom.xml JSTL 
### denpendencies 하위에 추가하기
log 설정을 하지 않으면 DB 실행 결과나 오류 상황을 알기가 힘들기 때문에 아래 코드를 추가하여 사용하면 좋습니다.
```
<dependency>
    <groupId>org.lazyluke</groupId>
    <artifactId>log4jdbc-remix</artifactId>
    <version>0.2.7</version>
</dependency>
```
#### [pom.xml로 돌아가기](../pom.xml.md)

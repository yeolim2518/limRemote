# pom.xml에 타일즈 추가하기
### properties 하위에 붙여넣기
```
<org.apache.tiles-version>3.0.8</org.apache.tiles-version>
```
### dependencies 하위에 붙여넣기
```
<dependency>
    <groupId>org.apache.tiles</groupId>
    <artifactId>tiles-jsp</artifactId>
    <version>${org.apache.tiles-version}</version>
</dependency>
<dependency>
    <groupId>org.apache.tiles</groupId>
    <artifactId>tiles-core</artifactId>
    <version>${org.apache.tiles-version}</version>
</dependency>
```
#### [pom.xml로 돌아가기](../pom.xml.md)

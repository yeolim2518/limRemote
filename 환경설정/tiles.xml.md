# tiles.xml파일 작성하기
### tiles.xml 파일 생성
먼저 dispatcher-servlet.xml에서 설정했었던 경로를 참고하여 tiles.xml을 생성합니다.

![image](https://user-images.githubusercontent.com/42727909/49426230-545fc700-f7e3-11e8-92ac-186c4bd38d1d.png)
![image](https://user-images.githubusercontent.com/42727909/49426307-8b35dd00-f7e3-11e8-99c1-205fc38f4b82.png)

### 아래코드 삽입
```html
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE tiles-definitions PUBLIC
       "-//Apache Software Foundation//DTD Tiles Configuration 2.1//EN"
       "http://tiles.apache.org/dtds/tiles-config_2_1.dtd">
 
<tiles-definitions>
	<definition name="*/*.cmmn-tiles"       template="/WEB-INF/views/cmmn/default-layouts.jsp">
	  	<put-attribute name="header"    	value="/WEB-INF/views/cmmn/default-header.jsp" />
	  	<put-attribute name="content"		value="/WEB-INF/views/{1}/{2}.jsp"/>
	</definition>
</tiles-definitions>
```
### 태그 설명
1. tiles-definitions : 가장 바깥에 위치한 태그로 해당 태그 안에 타일즈를 정의 합니다.

1. definition : 사용자에게 제공되기 위하여 랜더링되는 Template과 Attribute들을 연결해주는 역할을 합니다.
    - name : 뷰와 매핑할 때 참조할 값
    - template : 한 페이지의 레이아웃을 구성하기 위한 페이지로 definition의 하위태그로 작성하는 attribute태그들을 가지고 레이아웃을 구성하게 됩니다.
    
1. put-attribute
    - name : template에서 사용할 attribute의 name
    - value : 레이아웃을 구성할 실제 파일 경로

#### [README로 돌아가기](../README.md)
#### [상세설명 보러가기](../확장/tiles.xml.md)    

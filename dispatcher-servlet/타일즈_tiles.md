# dispatcher-servlet.xml에 타일즈 추가하기
### 아래의 코드를 적절한 곳에 복사 후 붙여넣기 
```
<!-- 타일즈 뷰 설정 -->    
<beans:bean class="org.springframework.web.servlet.view.UrlBasedViewResolver">  		
    <beans:property name="viewClass" value="org.springframework.web.servlet.view.tiles3.TilesView" />  		
    <beans:property name="order" value="1" /> 	
</beans:bean> 	
	
<!-- 타일즈 레이아웃 설정  --> 	
<beans:bean class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
    <beans:property name="definitions">
        <beans:list>
            <beans:value>/WEB-INF/tiles/default-layout.xml</beans:value>
        </beans:list>
    </beans:property>
</beans:bean>
```

### 아래코드 찾아 order의 value를 2로 수정
![image](https://user-images.githubusercontent.com/42727909/49123039-6da3d780-f2fa-11e8-8b38-019ae130b703.png)

### 아래의 네모 부분의 위치에 해당 파일 작성하기(만들지 않으면 에러 발생)
![image](https://user-images.githubusercontent.com/42727909/49123075-988e2b80-f2fa-11e8-9e32-92b1e24b9336.png)
- [소스코드 가지러가기](default-layout.xml.md)
#### [dispatcher-servlet.xml로 돌아가기](../servlet-context.xml(=dispatcher-servlet.xml).md)

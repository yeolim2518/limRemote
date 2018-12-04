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

### 기존의 ViewResolver를 찾아 order의 value를 2로 수정
order는 우선순위를 결정하는 것으로 숫자가 빠른 ViewResolver에서 처리를 먼저 하고 해결이 안된다면 다음 우선순위의 ViewResolver에 처리를 넘겨줍니다.


![image](https://user-images.githubusercontent.com/42727909/49123039-6da3d780-f2fa-11e8-8b38-019ae130b703.png)

#### [README로 돌아가기](../README.md)

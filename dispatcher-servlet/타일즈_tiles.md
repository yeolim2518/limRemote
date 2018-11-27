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

아래코드 찾아 order의 value를 2로 수정
```
<beans:bean class="org.springframework.web.servlet.view.UrlBasedViewResolver">
    <beans:property name="prefix" value="/WEB-INF/views/" />
    <beans:property name="suffix" value=".jsp" />
    <beans:property name="order" value="2"/>
    <beans:property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
</beans:bean>
```
```
타일즈 폴더째 복붙하기(그래야 오류안남)
WEB-INF우클릭후 붙여넣기~
```

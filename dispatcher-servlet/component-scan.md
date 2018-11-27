아래 코드에서 base-package 부분을 본인의 패키지로 변경하기
```
<context:component-scan base-package="com.test.spring">
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Service"/>
    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
</context:component-scan>
```
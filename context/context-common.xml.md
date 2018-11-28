# context-common.xml 작성하기
### 1. 아래의 코드를 삽입
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.test.spring">
       <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller" />
    </context:component-scan>

	<bean id="messageSource" class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
		<property name="basenames">
			<list>
				<value>classpath:/spring/message/message-common</value>
			</list>
		</property>
		<property name="cacheSeconds">
			<value>60</value>
		</property>
	</bean>
</beans>
```

### 2. 아래의 그림을 참조하여 본인의 패키지로 변경
![image](https://user-images.githubusercontent.com/42727909/49121055-71336080-f2f2-11e8-8d6b-ad8c60d0a324.png)

#### [context_create로 돌아가기](context_create.md)

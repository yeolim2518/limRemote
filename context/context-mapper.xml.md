# context-mapper.xml 작성하기
### 1. 아래의 코드를 삽입
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:mybatis-spring="http://mybatis.org/schema/mybatis-spring"
	xsi:schemaLocation="http://mybatis.org/schema/mybatis-spring http://mybatis.org/schema/mybatis-spring-1.2.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- 마이바티스 설정 파일
			1. datasource : 마이바티스와 dhcp 연결
			2. configLocation : 마이바티스 설정..(alias 등록 및 각종 설정 등록)
			3. mapperLocations : 실제 query문이 들어가는 xml
	 -->	
	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="configLocation" value="classpath:/spring/sqlmap/sql-mapper-config.xml" />
		<property name="mapperLocations" value="classpath:/spring/sqlmap/mappers/*.xml" />
	</bean>

    	
	<!-- 이걸 등록 해줌으로써 mapper를 인터페이스로만 구성하여 사용가능 한듯.. 패키지 주소에 맞게 설정-->
	<mybatis-spring:scan base-package="com.test.spring.**.service.impl"/>
</beans>
```

### 2. 아래 부분은 Mapper.class가 위치한 패키지를 설정하는 소스코드로 본인의 패키지로 변경
![image](https://user-images.githubusercontent.com/42727909/49121424-b6a45d80-f2f3-11e8-8684-e208302d2527.png)

#### [context_create로 돌아가기](context_create.md)

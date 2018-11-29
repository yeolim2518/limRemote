# context-datasource.xml 작성하기
### 1. 아래의 코드를 삽입
- 오라클을 사용시 주석을 풀고 아래의 myaridb용 datasource는 주석
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- oracle
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
        <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
        <property name="url" value="jdbc:oracle:thin:@127.0.0.1:1521:example" />
        <property name="validationQuery" value="SELECT 1 FROM dual"/>
        <property name="username" value="user"/>
        <property name="password" value="password"/>
    </bean>
    -->
    
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
	    <property name="driverClassName" value="org.mariadb.jdbc.Driver"/>
	    <property name="url" value="jdbc:mariadb://localhost/test" />
	    <property name="validationQuery" value="SELECT 1"/>
	    <property name="username" value="root"/>
	    <property name="password" value="root"/>
	</bean>
</beans>
```
### 2. **<오라클>** 아래의 네모 부분을 본인의 정보에 맞추어 수정
![image](https://user-images.githubusercontent.com/42727909/49121237-19e1c000-f2f3-11e8-9553-1c41f0120ee6.png)
### 3. **<마리아DB>** 아래의 네모 부분을 본인의 정보에 맞추어 수정
![image](https://user-images.githubusercontent.com/42727909/49121313-5dd4c500-f2f3-11e8-99a2-c1e22812723e.png)

## 주의 : 로그를 추가하려면 아래 코드로 수정
```
<bean id="dataSourceSpied" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
    <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
    <property name="url" value="jdbc:oracle:thin:@52.79.235.41:1521:xe" />
    <property name="validationQuery" value="SELECT 1 FROM dual"/>
    <property name="username" value="ource"/>
    <property name="password" value="ourvoice"/>
</bean>

<!-- 아래가 로그를 삽입하는 코드 -->
<bean id="dataSource" class="net.sf.log4jdbc.Log4jdbcProxyDataSource">
    <constructor-arg ref="dataSourceSpied" />
    <property name="logFormatter">
        <bean class="net.sf.log4jdbc.tools.Log4JdbcCustomFormatter">
            <property name="loggingType" value="MULTI_LINE" />
            <property name="sqlPrefix" value="SQL         :  "/>
        </bean>
    </property>
</bean>
```
그리고 src > main > resources > log4j.xml 수정하기
[log4j.xml](log4j.xml.md)


#### [context_create로 돌아가기](context_create.md)

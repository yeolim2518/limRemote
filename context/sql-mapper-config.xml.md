# sql-mapper-config.xml 작성하기
### 아래의 코드를 복사 후 붙여넣기
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>

	<!-- VO만 카멜케이스로 반환하여 저장 해주는 듯 -->
	<settings>
		<setting name="mapUnderscoreToCamelCase" value="true"/>
	</settings>
	
    <typeAliases>
    </typeAliases>
</configuration>
```
#### [context_create로 돌아가기](context_create.md)

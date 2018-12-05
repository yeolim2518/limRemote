# MYBATIS에러
#### 에러 내용 : org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.reflection.ReflectionException: Error instantiating class com.spring.sns.myInfo.service.UserVO with invalid types () or values (). Cause: java.lang.NoSuchMethodException: com.spring.sns.myInfo.service.UserVO.<init>()

#### 원인
- SQL에서 SELECT를 할때 매개변수를 받는 생성자를 만들어 놓고 기본생성자가(**매개변수가 없는**) 없을 때 발생

#### 해결방법
- 기본생성자 만들기(매개변수 안받는 생성자) 
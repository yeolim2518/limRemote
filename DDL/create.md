# CREATE문

## 1. 데이터 타입

## 1-1. 데이터 타입의 종류
    1. 문자형 데이터
        1. char(바이트) : 고정길이(2000까지 가능)
        1. varchar2(바이트) : 가변길이(4000까지 가능)
        1. nchar(바이트) : unicode형 고정길이(2000까지 가능)
        1. nvarchar2(바이트) : unicode형 가변길이(4000까지 가능)
        1. long(바이트) : 가변길이 2GB까지 가능 
    2. 날짜형 데이터
        1. date
    3. 숫자형 데이터
        1. number(숫자1, 숫자2) : 숫자1은 최대자리수, 숫자2는 소수점 자릿수 표현
        ```
            number(10, 2)   => 숫자 10자리 중에서 2자리수까지는 소수로 표현가능
        ```
## 2. create 생성방법

## 2-1. 직접생성
```
CREATE TABLE 테이블이름
(
    컬럼명 타입,
    컬럼명 타입
);
```

### 코드 실습 예제
```
CREATE TABLE TABLE_TEST
(
    NO number(10),
    NAME varchar2(20),
    NOW_DATE date
);
```

위의코드를 실행하면 아래처럼 테이블이 생성된것을 확인 할수있습니다.

![image](https://user-images.githubusercontent.com/42727909/49848539-d1f58980-fe18-11e8-9a4a-62523455f83e.png)

![image](https://user-images.githubusercontent.com/42727909/49848552-ef2a5800-fe18-11e8-8199-2d4c86f01301.png)

## 2-2. select를 이용한 생성(레코드까지 복사)

select를 이용한 생성시에 primary키와 unique 등과 제약조건은 복사되지 않습니다.

```
CREATE TABLE 테이블이름
AS
SELECT * FROM 테이블이름
```

### 코드 실습 예제
```
CREATE TABLE TABLE_TEST_COPY
AS
SELECT * FROM TABLE_TEST;
```

위의코드를 실행하면 TABLE_TEST와 동일한 컬럼이 존재하는 테이블이 생성되는 것을 확인할수 있습니다.

![image](https://user-images.githubusercontent.com/42727909/49848587-15e88e80-fe19-11e8-8b01-48e39b2ca5ef.png)

![image](https://user-images.githubusercontent.com/42727909/49848617-4a5c4a80-fe19-11e8-8222-f98e62e9babb.png)

## 2-3. select를 이용한 생성(구조만 생성)
```
CREATE TABLE TABLE_TEST_COPY2
AS
SELECT * FROM TABLE_TEST
WHERE 1 = 2;
```

WHERE 1 = 2와 같이 조건절에서 true가 되지 않는 조건을 작성하여 줍니다.

![image](https://user-images.githubusercontent.com/42727909/49848693-b179ff00-fe19-11e8-80fb-cf7e1e589b30.png)

![image](https://user-images.githubusercontent.com/42727909/49848726-cf476400-fe19-11e8-8011-39f48ce33b13.png)


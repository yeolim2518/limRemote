# alter문

### 실습용 테이블 생성

```
CREATE TABLE ALTER_TEST
(
    no number(10)
);
```

![image](https://user-images.githubusercontent.com/42727909/49848972-f3f00b80-fe1a-11e8-8587-dccc0e379cc6.png)


## 1. 컬럼추가

### 사용문법

```
ALTER TALBE 테이블명 add (컬럼명 타입)
```

### 사용예제
```
ALTER TABLE ALTER_TEST add (name varchar(20));
```

name 컬럼이 추가 된것을 확인할수 있습니다.

![image](https://user-images.githubusercontent.com/42727909/49849023-2863c780-fe1b-11e8-967d-5fdbad0e8852.png)


## 2. 컬럼수정

### 사용문법

```
ALTER TABLE 테이블명 modify (컬럼명 타입)
```

### 사용예제
```
ALTER TABLE ALTER_TEST modify (name varchar(100));
```

name 컬럼의 바이트가 20에서 100으로 변경되었습니다.

![image](https://user-images.githubusercontent.com/42727909/49849451-f6536500-fe1c-11e8-8f36-d376be0ac916.png)

## 3. 컬럼삭제

### 사용문법

```
ALTER TALBE 테이블명 drop column 컬럼명
```

### 사용예제
```
ALTER TABLE ALTER_TEST drop column name;
```
name 컬럼이 삭제 되었습니다.

![image](https://user-images.githubusercontent.com/42727909/49849473-200c8c00-fe1d-11e8-9afe-dc3a4f6f4750.png)

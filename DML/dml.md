# DML 4가지 작성하기

## 1. SELECT

### 1-1. SELECT란

SELECT는 테이블에서 데이터를 추출해주는 역할을 합니다.

### 1-2. 구문
```
SELECT [ALL | DISTINCT] 속성이름
FROM 테이블명
[WHERE 조건]
[GROUP BY 속성이름]
[HAVING 조건]
[ORDER BY 속성이름 [ASC | DESC]]
```

## 2. INSERT

### 2-1. INSERT란

테이블에 데이터를 삽입하는 역할을 합니다.

### 2-2. 구문

```
INSERT INTO 테이블명
[(컬럼이름...)]
VALUES (값...)
```

## 3. UPDATE

### 3-1. UPDATE란

기존에 테이블에 저장되어 있는 데이터의 값을 수정하는 역할을 합니다.

### 3-2. 구문

```
UPDATE 테이블명 SET
컬럼명 = 값
[WHERE 조건]
```

## 4. DELETE

### 4-1. DELETE란

기존에 테이블에 저장되어 있는 로우를 삭제하는 역할을 합니다.

```
DELETE [FROM] 테이블명
[WHERE 조건]
```

-----

## 5. ROLLBACK

가장 최근에 커밋한 시점으로 되돌리는 것입니다.

### 사용방법

```
ROLLBACK;
```

## 6. COMMIT

변경된 내용 업데이트를 영구적으로 확정하는 것입니다.

### 사용방법

```
COMMIT;
```
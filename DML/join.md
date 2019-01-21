# 조인

### [예제에서 사용할 테이블 생성](예제테이블생성.md)

조인이란 두개 이상의 테이블을 특정 조건을 걸어서 해당하는 값들을 하나의 로우로 가져오는 것을 말합니다.

## 1. 내부조인(INNER JOIN)

## 1-1. 내부조인이란

1. 두 테이블 사이에서 조건에 맞는 로우만 가져오는 것을 말합니다.

## 1-2. 사용방법

```
SELECT 컬럼명
FROM 테이블명 별칭1
[INNER] JOIN 테이블명 별칭2
ON 별칭1.컬럼명 = 별칭2.컬럼명
```

## 1-3. 사용예제

### 사원별 부서이름 출력

```
SELECT e.name, d.name, e.salary
FROM employees e
JOIN department d
on e.department_id = d.id;
```

## 2. 외부조인(OUTER JOIN)

## 2-1. 외부조인이란

1. 내부조인은 두 테이블의 조건에 맞는 ROW만 출력하지만 OUTER 조인은 조건에 맞지 않는 ROW도 출력합니다.
1. 조건에 맞지 않는 ROW를 출력하는 기준은 LEFT, RIGHT, FULL 중 어느것을 쓰느냐에 따라 달라집니다.

## 2-2. 사용방법

```
-- LEFT OUTER JOIN
SELECT 컬럼명
FROM 테이블명 별칭1
LEFT JOIN 테이블명 별칭2
ON 별칭1.컬럼명 = 별칭2.컬럼명

-- RIGHT OUTER JOIN
SELECT 컬럼명
FROM 테이블명 별칭1
RIGHT JOIN 테이블명 별칭2
ON 별칭1.컬럼명 = 별칭2.컬럼명

-- FULL OUTER JOIN
SELECT 컬럼명
FROM 테이블명 별칭1
FULL JOIN 테이블명 별칭2
ON 별칭1.컬럼명 = 별칭2.컬럼명
```

## 2-3. 사용예제

### 사원별 부서이름 출력

INNER JOIN에서의 ROW의 수는 7개 였으나 LEFT OUTER JOIN의 ROW의 수는 8개입니다. `e.department_id = d.id`의 조건에 맞지 않는 ROW도 한줄이 더 출력되었기 때문입니다.

즉 LEFT OUTER JOIN은 우측 테이블에서 JOIN시킬 데이터가 존재 하지 않아도 좌측 테이블의 모든 ROW를 출력합니다. RIGHT OUTER JOIN은 그 반대이고, FULL OUTER JOIN은 양 테이블의 모든 ROW를 출력하게 됩니다(RIGHT OUTER JOIN은 LEFT OUTER JOIN을 사용해서도 동일한 결과를 얻을 수 있기 때문에 잘 사용되지 않습니다).

```
-- LEFT OUTER JOIN
SELECT e.name, d.name
FROM employees e
LEFT OUTER JOIN department d
ON e.department_id = d.id;

-- FULL OUTER JOIN
SELECT e.name, d.name
FROM employees e
FULL OUTER JOIN department d
ON e.department_id = d.id;
```

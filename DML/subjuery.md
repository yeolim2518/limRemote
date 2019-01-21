# 서브쿼리

### [예제에서 사용할 테이블 생성](예제테이블생성.md)

메인쿼리를 구성하는 소단위 쿼리입니다. - 쿼리문 안에 쿼리문

## 1. 활용

## 1-1. 서브쿼리를 '='와 함께 사용

이땐 서브쿼리의 결과가 하나이어야 합니다.

### 사용방법

```
WHERE 컬럼명 = (서브쿼리)
```    

### 사용예제 - 부서번호가 1인 사원

```
SELECT name
FROM employees
WHERE department_id = (
        SELECT id
        FROM department
        WHERE id = 1
);
```

## 1-2. 서브쿼리를 in과 함께 사용

이땐 서브쿼리의 결과가 하나이상이어도 상관없습니다.

### 사용방법

```
WHERE 컬럼명 IN(서브쿼리)
```    

### 사용예제 - 부서번호가 1 또는 2인 사원

```
SELECT name
FROM employees
WHERE department_id in(
        SELECT id
        FROM department
        WHERE id = 1 or id = 2
);
```

## 1-3. 서브쿼리를 any와 함께 사용

해당 서브쿼리의 결과를 하나라도 만족하는 모든 결과를 출력하게 됩니다(여러 조건을 OR로 구성하는 것이라 생각하면 됩니다). any는 등호뿐 아니라 부등호와도 같이 사용 할수있습니다.

### 사용방법

```
WHERE 컬럼명 IN(서브쿼리)
```    

### 사용예제 - 그룹별로 salary를 가장 적게 받는 사람들 중, 해당 salary보다 많이 받는 사람 출력(그룹 별 salary들 중에 하나라도 더 많이 받으면 출력됨)

```
-- any 사용
SELECT name, salary
FROM employees
WHERE salary > any(
        SELECT MIN(salary)
        FROM employees
        GROUP BY department_id
);
```

## 1-4. 서브쿼리를 all와 함께 사용

해당 서브쿼리의 결과를 모두 만족하는 결과만 출력하게 됩니다(여러 조건은 AND로 구성하는 것이라 생각하면 됩니다). all은 등호뿐 아니라 부등호와도 같이 사용 할수있습니다.

### 사용방법

```
WHERE 컬럼명 IN(서브쿼리)
```    

### 사용예제 - 그룹별로 salary를 가장 적게 받는 사람들 모두 보다 더 많은 salary를 받는 사람 출력(그룹 별 모든 salary 보다 더 많이 받아야 출력됨)

any와 all의 결과를 비교하면 이해하기 쉽습니다.

```
-- all 사용
SELECT name, salary
FROM employees
WHERE salary > all(
        SELECT MIN(salary)
        FROM employees
        GROUP BY department_id
);
```

## 2. 기타 활용

## 2-1. 컬럼으로 사용 가능

이땐 결과값이 하나이어야만 합니다.

```
SELECT name, salary, (SELECT MIN(salary)
        FROM employees
        WHERE department_id = 1) a
FROM employees;
```

## 2-2. 테이블로 사용가능

```
SELECT name
FROM (
    SELECT name 
    FROM employees
    WHERE department_id = 1
);
```
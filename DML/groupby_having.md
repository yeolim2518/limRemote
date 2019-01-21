# GROUP BY

### [예제에서 사용할 테이블 생성](예제테이블생성.md)

### GROUP BY란

- group by를 사용하면 distinct처럼 중복되지 않은 값을 추출가능
- distinct와의 차이는 집계함수를 사용할 때 알수있음
- 집계함수와 컬럼명을 함계 표현하려고 할때 gropu by를 쓰지 않으면 오류 발생
- 집계함수는 그룹으로 지정되어야 사용가능
- 그룹화한 컬럼을 하나라도 SELECT 하지않으면 오류 발생

## 1. DISTINCT와 GROUP BY 차이

## 1-1. 집계합수 없이 사용

### 기본

```
SELECT department_id
FROM employees;
```

![image](https://user-images.githubusercontent.com/42727909/49918310-ea7fa580-fee5-11e8-9ed1-6826b6c1a71c.png)


### DISTINCT

```
SELECT DISTINCT department_id
FROM employees;
```

![image](https://user-images.githubusercontent.com/42727909/49918260-bdcb8e00-fee5-11e8-875c-6bc6d970fa72.png)

### GROUP BY

```
SELECT department_id 
FROM employees
GROUP BY department_id;
```

![image](https://user-images.githubusercontent.com/42727909/49918366-40ece400-fee6-11e8-8a19-f54d1250623b.png)

## 1-2. 집계함수를 이용

DISTINCT와 GROUP BY의 결과값의 차이가 전혀 없음을 확인 할 수 있습니다. 둘다 중복되는 내용없이 출력해주는 역할입니다. 하지만 집계함수를 이용하면 차이를 확인 할수있습니다.

### DISTINCT

집계함수를 사용 할 때 DISTINCT만을 사용 할경우 오류가 나는 것을 확인 할 수 있습니다.

```
SELECT DISTINCT department_id, SUM(salary) 
FROM employees;
```

### GORUP BY

집계함수를 사용 할 때는 GROUP BY를 사용하여야 합니다.

```
SELECT department_id, SUM(salary) 
FROM employees
GROUP BY department_id;
```

## 2. 사용예시

## 2-1. 부서별 사원수와 평균 급여를 구해보자

```
SELECT department_id, COUNT(department_id), ROUND(AVG(salary), 2)     -- COUNT(department_id) : 그룹별 로우의 수, AVG(salary) : 그룹별 salary의 평균
FROM employees
GROUP BY department_id;     -- department_id별로 그룹을 지정
```


## 2-2. 부서별 직급별 사원수와 평균 급여를 구해보자

```
SELECT department_id, job_id, COUNT(salary) "사원수", ROUND(AVG(salary), 2) "평균급여"
FROM employees
GROUP BY department_id, job_id
ORDER BY department_id, job_id;
```

## 3. HAVING 사용하기

- HAVING에서의 조건에는 집계함수를 사용할수 있습니다.
- WHERE에서는 집계함수를 조건으로 사용할수 없습니다.
- GROUP BY 위에서도 정상작동하나 보통은 GROUP BY 밑에 위치 시킵니다. 

### HAVING

```
SELECT 컬럼명
FROM 테이블명
[WHERE 조건]
GROUP BY
[HAVING 조건]
```

## 2. 사용예시

## 2-1. 현재 부서별 사원수가 4명이상인 부서

```
SELECT DEPARTMENT_ID, COUNT(DEPARTMENT_ID) "사원수"
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING COUNT(DEPARTMENT_ID) >= 4;
```


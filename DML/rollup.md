# ROLLUP

### [예제에서 사용할 테이블 생성](예제테이블생성.md)

### ROLLUP란

- 그룹별 합계 정보를 추가해서 보여주는 함수
- GROUP BY 만 쓸 경우 그룹으로 묶인 모든 조건에 해당하는 결과값만 나옵니다. 하지만 ROLLUP 함수를 쓸 경우 각각의 그룹별로 정보를 추가해서 보여줍니다.
- 예1) GROUP BY 나라, 지역
    1. GROUP BY만 사용
        - 각 나라별 그룹에서 각 지역별로 결과가 나옵니다.
    1. ROLLUP() 쓸경우
        - 각 나라별 그룹에서 각 지역별로 결과가 나옵니다.
        - 각 나라별 결과도 나옵니다.
        - 각 지역별 결과는 나오지 않습니다(오른쪽에 위치한 그룹 조건이 하나씩 없어진다고 생각).
- 예2) GROUP 나라, 지역
    1. GROUP만 사용
        - 미국-캘리포니아
        - 미국-뉴욕
        - 한국-서울
    1. ROLLUP() 쓸경우
        - 미국-캘리포니아
        - 미국-뉴욕
        - 한국-서울
        - 미국
        - 한국

## 1. 사용방법

```
SELECT 컬럼명
FROM 테이블
GROUP BY ROLLUP(컬럼명..)
```

## 2. 사용예시

## 2-1. 부서별 직무별 그룹

```
-- GROUP BY만 사용
SELECT DEPARTMENT_ID, JOB_ID, COUNT(DEPARTMENT_ID) "사원수"
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID, JOB_ID
ORDER BY DEPARTMENT_ID, JOB_ID;

-- ROLLUP
SELECT DEPARTMENT_ID, JOB_ID, COUNT(DEPARTMENT_ID) "사원수"
FROM EMPLOYEES
GROUP BY ROLLUP(DEPARTMENT_ID, JOB_ID)
ORDER BY DEPARTMENT_ID, JOB_ID;
```
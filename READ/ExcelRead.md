# 2. ExcelRead

ExcelRead는 실제 엑셀에서 데이터를 추출하는 역할을 합니다.

## 2-1. read 메서드

### 파라미터

- ReadOption

### 반환값

- `List<Object>` 
    + 기본은 Map
    + VO 설정가능

## 2-2. excelObjectToMap 메서드

Excel.read의 기본 반환값은 List<Object> 입니다.
이를 List<Map<String, Object>>으로 바꿔주는 메서드입니다.

#### [README로 돌아가기](README.md)


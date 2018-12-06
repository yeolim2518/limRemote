# 1. WriteOption

WriteOption은 데이터를 엑셀에 저장할 때 설정정보를 담고 있는 객체 입니다. 데이터를 저장할 때 WriteOption를 매개변수로 받기 때문에 필수적으로 생성해야하는 객체입니다.

## 필수 입력 사항

1. **String filePath**

    - 설명 : 엑셀파일이 저장 될 경로입니다(**파일 이름 제외**).
    - setMethod : 
        1. **setFilePath(String filePath)**
1. **String fileName**
    - 설명 : 엑셀파일이 저장 될 파일이름입니다.
    - setMethod : 
        1. **ssetFileName(String fileName)**
        
-----

## 1-1. 인스턴스 변수 (참조사항)

- **String filePath - 필수**

엑셀파일이 저장 될 경로입니다(**파일 이름 제외**).

- **String fileName - 필수**

엑셀파일이 저장 될 파일이름입니다.

- **List<Map<String, Object>> contents - 필수**

엑셀파일에 저장 될 데이터를 저장합니다.

- String sheetName - 선택

엑셀파일에서 저장될 시트 이름입니다.
기본값은 sheet 입니다.

- List<String> titles - 선택

아래그림처럼 첫 row에 타이틀을 넣고 싶을 때 사용합니다.

![image](https://user-images.githubusercontent.com/42727909/49501844-2cda2e80-f8b7-11e8-83d3-6cfe89e1e650.png)

- ExcelCalculable excelCalculable - 선택

    - 기본값은 Map에 저장된 순서대로 공백없이 출력 하는 것

![image](https://user-images.githubusercontent.com/42727909/49502421-68292d00-f8b8-11e8-8900-b106c641c43c.png)

    - ExcelWriteColumnCal은 타이틀에 맞춰서 Map에 해당 타이틀 값이 존재하지 않으면 공백으로 저장
      ExcelWriteColumnCal을 사용하려면 setColumn메서드를 호출하면 됩니다.

![image](https://user-images.githubusercontent.com/42727909/49502594-b9392100-f8b8-11e8-92aa-fc645368e9b1.png)


## 1-2. 생성자

- WriteOption(List<Map<String, Object>> list)

엑셀에 저장할 데이터를 지정할수 있습니다.

## 1-3. set 메서드

- String filePath
    - setFilePath(String filePath)

- String fileName
    - setFileName(String fileName)

- String sheetName
    - setSheetName(String sheetName)

- ExcelCalculable excelCalculable
    - setExcelCalculable(ExcelCalculable excelCalculable)
      데이터를 저장하는 방법을 사용자가 직접 지정 할수 있습니다.
    - setColumn()
      데이터를 저장하는 Class를 ExcelWriteColumnCal로 변경합니다.

- List<String> titles
    - setTitles(List<String> titles)
    - setTitles(String ... titles)    
 
- List<Map<String, Object>> contents
    - setContents(List<String[]> contents)
    - setContents(String ... contents)
      ==> 기본적으로 contents를 저장하는 방법은 생성자를 통해서 제공하는 방법입니다. 위의 2가지 타입의 값만 파라미터로 받을 때 사용합니다.

#### [README로 돌아가기](README.md)

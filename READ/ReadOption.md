# 1. ReadOption

ReadOption은 엑셀에서 데이터를 가져올 때 설정정보를 담고 있는 객체 입니다. 데이터를 가져올 때 ReadOption를 매개변수로 받기 때문에 필수적으로 생성해야하는 객체입니다.

## 필수 입력 사항

1. **String filePath**

    - 설명 : 엑셀파일이 저장된 위치를 저장하는 변수입니다(파일 업로드를 통해서 진행하더라도 파일을 저장한 후에 해당 경로를 변수에 저장해야 합니다).
    - setMethod : 
        1. **setFilePath(String filePath)**
1. **File file**
    - 설명 : 엑셀파일이 저장된 위치를 담고 있는 File 객체 입니다. 삭제시에 해당 객체를 사용합니다.
    - setMethod : 
        1. **setFilePath(MultipartHttpServletRequest mRequest, String path, String uploadName)**
        
            : path는 실제 저장경로, uploadName는 파일업로드한 input의 name값
        1. **setFilePath(File file)**
        
            : 저장경로가 담긴 File로 받기
        1. **setFile(File file)**
        
            : 사용불가(X)
        
-----

## 1-1. 인스턴스 변수 (참조사항)

- **String filePath - 필수**

엑셀파일이 저장된 위치를 저장하는 변수입니다(파일 업로드를 통해서 진행하더라도 파일을 저장한 후에 해당 경로를 변수에 저장해야 합니다).

- **File file - 필수**

엑셀파일이 저장된 위치를 담고 있는 File 객체 입니다. 삭제시에 해당 객체를 사용합니다.

- List<String> outputColumns - 선택
    
특정컬럼에 해당하는 값만 추출하고 싶을 때 사용합니다. 
아래그림처럼 상단에 A B C ..로 시작하는 컬럼명을 저장합니다.
![image](https://user-images.githubusercontent.com/42727909/49498544-bb967d80-f8ae-11e8-89ea-4ae704ef2327.png)

- int startRow - 선택

데이터를 가져올 시작 row를 지정합니다. 지정하지 않으면 첫번째 row부터 데이터를 가져옵니다. 첫번째 row는 0입니다.

- int selectSheet - 선택

데이터를 가져올 시트를 지정합니다. 지정하지 않으면 첫번째 시트에서 데이터를 가져옵니다. 첫번째 시트는 0입니다.

- boolean deleteCheck - 선택

엑셀파일로부터 데이터를 모두 가져온 후에 해당 파일을 삭제할지 여부를 지정합니다.
기본값은 **true** 입니다.

- boolean titleCheck - 선택

첫 row를 타이틀로 설정할지 여부를 선택합니다. 이 옵션은 엑셀로부터 데이터를 가져올 때 VO에 저장할 때 필수적으로 사용해야 합니다.
기본값은 **false** 입니다.

- Class<?> excelVO - 선택

엑셀에서 데이터를 가져올 때 기본값은 List<Map>에 저장하여 반환합니다. 하지만 Map이 아니라 VO에 저장하고 싶을 때 사용하는 옵션입니다.

## 1-2. 생성자

- ReadOption(int startRow)

엑셀로부터 가져올 시작 row를 지정할수 있습니다.

- ReadOption(List<String> outputColumns)
    
엑셀로부터 가져올 컬럼명을 지정할수 있습니다.

- ReadOption(String ... outputColumns)

엑셀로부터 가져올 컬럼명을 지정할 때 List가 아니라 위와 같인 저장할수 있습니다.
파라미터 개수를 지정하는게 아닌 개수를 동적으로 가져올수 있습니다.

- ReadOption(List<String> outputColumns, int startRow)
    
컬럼명 및 시작 row를 한번에 지정할수 있습니다.

- ReadOption(List<String> outputColumns, int startRow, int selectSheet)
    
컬럼명, 시작 row, 시작 시트를 한번에 지정할수 있습니다.

## 1-3. set 메서드

- String filePath
    - setFilePath(String filePath)

- List<String> outputColumns
    - setOutputColumns(List<String> outputColumns)
    - setOutputColumns(String ... outputColumns)

- int startRow
    - setStartRow(int startRow) 

- int selectSheet
    - setSelectSheet(int selectSheet)

- File file
    - setFilePath(MultipartHttpServletRequest mRequest, String path, String uploadName)
        : 해당 메서드는 파일의 저장 및 변수 file, filePath에 자동으로 저장해줍니다.
        uploadName은 파일업로드시에 사용했었던 input의 name을 가리킵니다.
    - setFilePath(File file)
        : 해당 메서드를 실행하면 변수 filePath와 file를 자동으로 저장합니다.
    - setFile(File file)
        : 해당 메서드는 사용하지 않습니다.

- boolean deleteCheck
    - setDeleteCheck(boolean deleteCheck)

- boolean titleCheck
    - setTitleCheck(boolean titleCheck) 

- Class<?> excelVO
    - setExcelVO(Class<?> excelVO)

#### [README로 돌아가기](README.md)

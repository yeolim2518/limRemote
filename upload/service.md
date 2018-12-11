# 서비스에서 파일 저장하기

컨트롤러에서는 뷰에서 넘겨온 파일을 받아서 서비스로 넘겨주고, 서비스는 직접 저장하는 역할을 수행하게 됩니다.

## 1. 컨트롤러에서 서비스로 전달
```java
@Resource
private FileService fileService;

@RequestMapping(value = "fileUpload.do")
public void fileUpload(MultipartHttpServletRequest mRequest,
        HttpServletRequest request) {
    fileService.saveFile(mRequest);
}
```

## 2. 서비스에서 파일 저장

## 2-1. 단인 파일 저장

MultipartHttpServletRequest의 getFile메서드에 파라미터로 file의 name을 넘겨주면 업로드한 파일의 정보가 담긴 MultipartFile를 반환해줍니다.

```java
private final String path = "C:\\file\\";               // 실제 저장할 경로
	
@Override
public void saveFile(MultipartHttpServletRequest mRequest) {
    MultipartFile mFile = mRequest.getFile("file");     // input의 name값(file)을 통해서 MultipartFile을 반환
    
    String fileName = mFile.getOriginalFilename();      // getOriginalFilename메서드는 파일의 원본 이름을 반환
    
    File file = new File(path + fileName);
    
    try {
        mFile.transferTo(file);                         // transferTo메서드를 통해서 해당 위치에 저장
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

## 2-2. 다중파일 저장

MultipartHttpServletRequest의 getFileNames메서드는 모든 file들의 name을 Iterator로 반환해줍니다. 이를 이용하면 파일 업로드의 수가 동적이라도 파일업로드가 가능합니다.

```java
private final String path = "C:\\file\\";
	
@Override
public void saveFile(MultipartHttpServletRequest mRequest) {
    Iterator<String> it = mRequest.getFileNames();      // getFileNames메서드를 이용하면 file들의 name을 Iterator로 반환해줍니다.
    
    while (it.hasNext()) {
        String key = (String) it.next();                // next메서드를 통해서 file의 name을 하나씩 가져옵니다.
        
        MultipartFile mFile = mRequest.getFile(key);    // 해당 key를 이용해서 MultipartFile를 반환합니다.
        
        File file = new File(path + mFile.getOriginalFilename());
        
        try {
            mFile.transferTo(file);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```


## 2-3. multiple 속성을 사용한 경우

multiple속성을 이용하면 하나의 name으로 여러 파일들이 저장되어 있습니다. multiple속성을 사용한다면 MultipartHttpServletRequest의 getFiles메서드를 이용하면 모든 파일들을 가져올수 있습니다(multiple을 사용하지 않아도 getFiles사용가능).

```java
private final String path = "C:\\file\\";
	
@Override
public void saveFile(MultipartHttpServletRequest mRequest) {
    List<MultipartFile> mFiles = mRequest.getFiles("files");     // input의 name값(files)을 통해서 MultipartFile을 리스트로 반환
                                                                 // multiple을 사용하면 하나의 input에 여러개의 file을 저장할수 있기 때문에 List
    
    String fileName = "";
    
    File file = null;
    
    for (MultipartFile mFile : mFiles) {                        // List의 길이만큼 for문을 돌리기만 하면 단일이랑 비슷
        fileName = mFile.getOriginalFilename();
        
        file = new File(path + fileName);
        
        try {
            mFile.transferTo(file);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 2-4. multiple속성을 사용한 다중파일 저장

```java
private final String path = "C:\\file\\";
	
@Override
public void saveFile(MultipartHttpServletRequest mRequest) {
    Iterator<String> it = mRequest.getFileNames();
    
    while (it.hasNext()) {
        String key = (String) it.next();
        
        List<MultipartFile> Files = mRequest.getFiles(key);
        
        for (MultipartFile mFile : Files) {
            File file = new File(path + mFile.getOriginalFilename());
            
            try {
                mFile.transferTo(file);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

#### [README로 돌아가기](../README.md)
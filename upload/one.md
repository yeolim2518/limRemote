# 화면(뷰)부터 서비스까지 파일업로드

## 1. 화면

```html
<form id="form" method="post" enctype="multipart/form-data" action="fileUpload.do">
    <input type="file" id="file" name="file1" multiple>
    <input type="submit" value="전송하기">
</form>
```

```js
$(function() {
    $("#file").change(function(e) {
        var files 		= e.target.files,
            extensions 	= ["jpg", "png", "jpeg"],
            maxSize		= 50 * 1024,
            check		= Array.prototype.every.call(files, function(file) {
                var fileName = file.name;
                
                return checkExt(fileName, extensions);
            }),
            sizeCheck	= Array.prototype.every.call(files, function(file) {
                var fileSize = file.size;
                
                return fileSize < maxSize;
            });
        
        if (check) {
            
            if (sizeCheck) {
                preview(e);
            } else {
                alert("파일 사이즈는 50MB만 가능합니다.");
                this.value = "";
            }
        } else {
            alert("확장자는 " + extensions.join(", ") + "만 업로드가능합니다.");
            this.value = "";
        }
    });
});

function preview(e) {
    var files 		= e.target.files,
        length		= files.length,
        preview		= document.querySelector("#preview"),
        reader 		= null; 
    
    preview.innerHTML = "";
    
    for (var i = 0; i < length; i++) {
        reader = new FileReader();
        
        reader.onload = function(e) {
            var url = e.target.result,
                img = document.createElement("img");
            
            img.src = url;
            
            preview.appendChild(img);
        }
        
        reader.readAsDataURL(files[i]);
    } 
}

/* @param : fileName 파일이름
    * @param : extensions 허용할 확장자 리스트
    * @return : boolean
    **/
function checkExt(fileName, extensions) {
    var fileExt = getExt(fileName);
        
    return extensions.some(function(ext) {
        return fileExt === ext;
    });
}

function getExt(fileName) {
    return fileName.split(".").pop();
}

/* 
    * @param : file 업로드 할 File
    * @param : maxSize 최대 사이즈
    * @return boolean	: true면 maxSize보다 이하
    */
function checkSize(file, maxSize) {
    var size = file.size;
    
    if (size > maxSize) {
        return false;
    } else {
        return true;
    }
}  
```

## 2. 컨트롤러
```java
@Controller
public class FileController {

	@Resource
	private FileService fileService;
	
	@RequestMapping(value = "file.do")
	public String file() {
		return "file";
	}
	
	@RequestMapping(value = "fileUpload.do")
	public void fileUpload(MultipartHttpServletRequest mRequest) {
		fileService.saveFile(mRequest);
	}
}
```

## 3. 서비스
```java
@Service
public class FileServiceImpl implements FileService {

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

}
```

#### [README로 돌아가기](../README.md)
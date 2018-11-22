package egovframework.example.excel.util;

import java.io.File;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUtil {

	public static File saveFile(String path, String name, MultipartHttpServletRequest mRequest) {
		
		// 서버에 엑셀 파일을 저장한 경로를 담고 있는 file
		File file = null;
		
		// 업로된 엑셀파일을 저장하는 mFile
		MultipartFile mFile = mRequest.getFile(name);
		
		// 엑셀파일이 제대로 업로드 되었을 경우만 if문 실행
		if (!mFile.isEmpty()) {
			
			// 파일을 저장하고자 하는 경로 설정(컨트롤러에서 path변수에 경로 정해줌 + 실제 뷰에서 올린파일이름 더하기.
			file = new File(path + mFile.getOriginalFilename()); // "C:\\excel\\" + 원본이름
			
			if (!file.exists()) {	// exists(): 경로에 폴더까지 포함시켜서 그 경로가 존재하는지 여부: 존재하면 ture, 아니면 false반환
				file.mkdirs();		// if(경로가 존재하지 않으면) { 경로상에 존재하지 않는 모든 디렉토리를 생성해줌 }
			}
			
			try {
				mFile.transferTo(file);	// 위 file에 "C:\\excel\\" + 원본이름 => 경로가 존재하면 위에 if문안타고 바로 transferTo(file)해줌.
			} catch (Exception e) {
				
			}
		}
		
		return file;
	}
	
	public static void deleteFile(File file) {
		
		if (file.exists()) {
			file.delete();
		}
	}
}

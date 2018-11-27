package excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUtil {

	public static File uploadOne(MultipartHttpServletRequest mRequest,
			String path, String uploadName) {
		File file = null;
		
		MultipartFile mFile = mRequest.getFile(uploadName);
		
		FileOutputStream fos = null;
		
		String absoultePath = "";
		
		// 업로드된 파일이 존재할 때만 실행
		if (!mFile.isEmpty()) {
			file = new File(path);
			
			// 경로상에 디렉토리가 존재하지 않는다면
			if (!file.exists()) {
				
				// 경로상의 모든 디렉토리 생성
				file.mkdirs();
			}
			
			try {
				absoultePath = file.getAbsolutePath() + "\\" + mFile.getOriginalFilename();
				
				fos = new FileOutputStream(absoultePath);
				
				fos.write(mFile.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException(e.getMessage());
			} finally {
				
				try {
					fos.close();
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
		
		File dest = new File(absoultePath);
		
		return dest;
	}
	
	public static void deleteOne(File file) {
		
		// 파일이 존재할 때만 삭제
		if (file != null && file.exists()) {
			file.delete();
		}
	}
}
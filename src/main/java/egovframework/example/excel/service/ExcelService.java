package egovframework.example.excel.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ExcelService {

	void excelUpload(MultipartHttpServletRequest mRequest, String uploadPath, String uploadName);

	void excelUploadRows(MultipartHttpServletRequest mRequest, String uploadPath, String uploadName, int startRow);

	void excelUploadColumns(MultipartHttpServletRequest mRequest, String uploadPath, String uploadName);

	void excelUploadSheet(MultipartHttpServletRequest mRequest, String uploadPath, String uploadName);

	void excelUploadVO(MultipartHttpServletRequest mRequest, String uploadPath, String uploadName);

	void excelDownload(String downloadPath, String string);

}

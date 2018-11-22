package egovframework.example.excel.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ExcelService {

	File saveExcelFile(MultipartHttpServletRequest mRequest, String name, String uploadPath) throws Exception;

	List<Map<String, String>> getExcelData(File file) throws Exception;

	void downloadExcelFile(Map<String, Object> paramMap, String downloadPath, String sheet, String string) throws Exception;

	void insertExcelList(List<Map<String, String>> excelList) throws Exception;

	void downloadDB(String downloadPath, String sheetName, String string) throws Exception;

}

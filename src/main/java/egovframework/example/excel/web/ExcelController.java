package egovframework.example.excel.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.example.cmmn.JsonUtil;
import egovframework.example.excel.service.ExcelService;
import excel.write.util.DateUtil;

@Controller
public class ExcelController {

	@Resource
	private ExcelService excelService;
	
	private final String uploadPath 	= "C:\\excel\\";
	private final String downloadPath 	= "C:\\excel\\download";
	
	@RequestMapping(value = "excel.do")
	public String excel() {
		return "excel/excel";
	}
	
	@RequestMapping(value = "excelUpload.do")
	public void excelUpload(MultipartHttpServletRequest mRequest, String uploadName) {
		
		// 파일 경로만 저장하는 경우
		excelService.excelUpload(mRequest, uploadPath, uploadName);
		
		// 2번째 로우부터 저장하는 경우(index는 0부터)
		excelService.excelUploadRows(mRequest, uploadPath, uploadName, 1);
		
		// 특정 컬럼명만 추출
		excelService.excelUploadColumns(mRequest, uploadPath, uploadName);
		
		// 특정 시트 추출(index는 0부터)
		excelService.excelUploadSheet(mRequest, uploadPath, uploadName);
		
		// VO로 받기
		excelService.excelUploadVO(mRequest, uploadPath, uploadName);
	}
	
	@RequestMapping(value = "excelDownload.do", method = RequestMethod.POST)
	public void excelDownload(HttpServletResponse response) throws Exception {
		String fileName = "test.xlsx";
		
		Map<String, Object> resultMap = new HashMap<>();
		
		excelService.excelDownload(downloadPath, DateUtil.getTodayDate() + fileName);
		
		resultMap.put("result", "SUCCESS");
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(JsonUtil.MapToJson(resultMap));
	}
		
	
}

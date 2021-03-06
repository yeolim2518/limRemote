package egovframework.example.excel.web;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.example.cmmn.DateUtil;
import egovframework.example.cmmn.JsonUtil;
import egovframework.example.excel.service.ExcelService;
import egovframework.example.excel.util.FileUtil;

@Controller
public class ExcelController {

	private static Logger log = LoggerFactory.getLogger(ExcelController.class);
	
	private final String uploadPath 	= "C:\\excel\\";
	private final String downloadPath 	= "C:\\excel\\download\\";
	private final String sheetName		= "test";		// 엑셀에서 sheet이름.
	
	@Resource 
	private ExcelService excelService;
	
	// 엑셀 업로드 페이지 호출
	@RequestMapping(value = "excelUploadPage.do")
	public String excelUploadPage() {
		
		return "excel/excelPage.tiles";
	}
	
	 /* 기능 : 엑셀 파일을 업로드 하여 해당 파일에 있는 데이터를 JSON으로 뷰페이지로 전송
	 * [param]
	 * 	 1. MultipartHttpServletRequest mRequest - 뷰페이지에서 업로드한 엑셀 파일
	 * 	 2. HttpServletResponse response - 엑셀 데이터(JSON)으로 전송 하기 위한 객체 */	
	  											// 뷰에서 post로 보낸것만 받음. get로 보내면 오류남.
	@RequestMapping(value = "excelUploadAjax.do", method = RequestMethod.POST)
	public void excelUploadAjax(MultipartHttpServletRequest mRequest,
			String name, HttpServletResponse response) {
		File file = null;
		
		List<Map<String, String>> excelList = null;
		
		try {
			
			// 1. 엑셀파일의 데이터를 가져오기 위해서는 먼저 서버에 저장 할 필요가 있기 때문에 저장기능 호출 ==> saveExcelFile
			file = excelService.saveExcelFile(mRequest, name, uploadPath); // 뷰에서 올린 엑셀파일, 인풋네임(값:excel), 위쪽 변수(=경로)
			
			// 2. 서버에 저장한 엑셀파일로부터(임플까지 갓다온) 데이터를 추출하여 List<Map<String, String>> 형식으로 저장
			if (file != null) {
				excelList = excelService.getExcelData(file);
				
				// 2-1. 임플에서 받아온 excelList를 디비에 저장하기.
				excelService.insertExcelList(excelList);
				
				// 3. 서버에 저장한 엑셀 파일 삭제 ==> 삭제하는 이유는 서버에 저장하려는게 아닌 엑셀에 담긴 데이터만 가져 오는 용도 이기 때문(서버에도 저장하고 싶다면 아래 코드는 주석처리)
				FileUtil.deleteFile(file);
			}
		} catch (Exception e) {
			log.debug("엑셀 데이터를 가져오는 중에 문제가 발생하였습니다." + e.getMessage());
		}
		
		System.out.println(excelList);
		
		// 엑셀의 데이터를 JSON으로 변경하여 뷰페이지로 전달
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JsonUtil.ListToJson(excelList));
		} catch (Exception e) {
			log.debug("뷰로 데이터를 전송 중에 문제가 발생하였습니다." + e.getMessage());
		}
	}
	
	
	/* 기능 : HTML로 작성 된 데이터를 엑셀로 저장하는 기능
	 * [param]
	 * 		1. String param - HTML 데이터를 담기위한 string
	 * 		2. HttpServletResponse response - 전송결과를 전송 하기 위한 객체 	*/
	@RequestMapping(value = "excelDownloadAjax.do", method = RequestMethod.POST)
	public void excelDownloadAjax(@RequestBody String param,		// param{"titles":["이름","성별","직무","등급 "]...
			HttpServletResponse response) {
		
		Map<String, Object> paramMap = JsonUtil.JsonToMap(param);	// HTML에서 보내온 데이터를 저장 할 map
		System.out.println("paramMap" + paramMap);					// paramMap{titles=[이름, 성별, 직무, 등급 ]...}
		
		Map<String, Object> resultMap = new HashMap<>();			// 결과를 저장할 map
		
		String fileName = "test.xlsx";								// 저장할때 파일 이름 (변경 가능)
		
		try {
			excelService.downloadExcelFile(paramMap, downloadPath, sheetName,
										DateUtil.getTodayDate() + fileName);
			
			resultMap.put("result", "SUCCESS");		// 임플에서 다운로드 해준게 문제(오류)가 없으면 SUCCESS 반환.
		} catch (Exception e) {
			resultMap.put("result", "FAIL");
		}
		
		// 엑셀 다운로드가 정상적으로 완료 되었는지 여부를 뷰페이지로 전달
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JsonUtil.MapToJson(resultMap));
		} catch (Exception e) {
			System.out.println("오류 발생");
		}
	}
	
	@RequestMapping(value = "DBdownloadAjax.do", method = RequestMethod.POST)
	public void excelDownloadAjax(HttpServletResponse response) {
		
		Map<String, Object> resultMap = new HashMap<>();			// 결과를 저장할 map
		
		String fileName = "test.xlsx";								// 저장할때 파일 이름 (변경 가능)
		
		try {
			excelService.downloadDB(downloadPath, sheetName,
										DateUtil.getTodayDate() + fileName);
			
			resultMap.put("result", "SUCCESS");		// 임플에서 다운로드 해준게 문제(오류)가 없으면 SUCCESS 반환.
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "FAIL");
		}
		
		// 엑셀 다운로드가 정상적으로 완료 되었는지 여부를 뷰페이지로 전달
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JsonUtil.MapToJson(resultMap));
		} catch (Exception e) {
			System.out.println("오류 발생");
		}
	}
}

package egovframework.example.excel.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.example.cmmn.DateUtil;
import egovframework.example.cmmn.excel.option.ReadOption;
import egovframework.example.cmmn.excel.option.WriteOption;
import egovframework.example.cmmn.excel.read.ExcelRead;
import egovframework.example.cmmn.excel.write.ExcelWrite;
import egovframework.example.excel.service.ExcelService;
import egovframework.example.excel.util.FileUtil;

@Service
public class ExcelServiceImpl implements ExcelService {
	
	@Resource
	private ExcelMapper excelMapper;

	// ##1. 화면 업로드(디비에 인서트해주는것과 같이 사용됨)
	@Override
	public File saveExcelFile(MultipartHttpServletRequest mRequest, String name, 
			String uploadPath) throws Exception {
		
									// 패스에 고유이름 더해서 경로저장, 인풋네임의 값, 뷰에서 올린 파일을 파라미터로 보냄.
		File file = FileUtil.saveFile(uploadPath + DateUtil.getTodayDate(), name, mRequest);
		
		return file;
	}
	
	// ##2. 화면 업로드(디비에 인서트해주는것과 같이 사용됨)
	@Override
	public List<Map<String, String>> getExcelData(File file) throws Exception {
		
		// 엑셀 데이터를 가져올 때 설정, cmmn에 넣어놓은 excel폴더를 사용하려면 아래처럼 쓰기.(공식)
		ReadOption readOption = new ReadOption();
		
		readOption.setFilePath(file.getAbsolutePath()); // 엑셀이 저장 된 파일 경로 설정
		readOption.setOutputColumns("A","B","C","D","E","F","G","H","I","J","K","L","M");// 데이터를 가져올 컬럼 이름(열 이름), 사용시마다 엑셀파일에 맞게 변경.
		readOption.setStartRow(1);						// 데이터를 가져올 시작 로우(몇번째 행부터 가져올건지)
		
		List<Map<String, String>> result = ExcelRead.read(readOption); // 엑셀의 데이터를 저장
		
		return result;
	}

	// ##1.디비 업로드: 화면 업로드한 엑셀파일 데이타 디비에 저장하기.
	@Override
	public void insertExcelList(List<Map<String, String>> excelList) throws Exception {
		
		// excelList 에서 컬럼명 추출하기. 리스트안에 맵으로 되어있어서 이걸 리스트로 만든다음에 포문 돌려야함.
		List<String> thCol =  excelMapToList(excelList.get(0));  // excelList에서 첫번째 줄(=컬럼명)만 파라미터로 보냄.
		
		// 위에서 excelMapToList()메서드 호출해서 return값으로 arrayList 받음(각 컬럼이름이랑 그 값)
		for (int i = 1; i < excelList.size(); i++) {	// 컬럼은 빼고 데이터부분부터 뺴와야해서 i=1 부터 시작.
			List<String> tdData =  excelMapToList(excelList.get(i));	// 포문 현재 돌고있는 한줄을 파라미터로 넣어서 메서드 호출.
			
			Map<String, Object> excelListToMap = new HashMap<String, Object>();
			
			excelListToMap.put("thCol",  thCol);	// 컬럼명 들어가잇음
			excelListToMap.put("tdData", tdData);	// 내용 들어가있음.
			
			excelMapper.insertExcelList(excelListToMap);
		} 
	}
	
	// ##2. 디비 업로드 : 화면 업로드한 엑셀파일 데이타 디비에 저장하기.
	private List<String> excelMapToList(Map<String, String> map) {
		List<String> arrayList = new ArrayList<>();
		
		Set<String> mapKey = map.keySet();		 // map에 들은 키네임을 다 가져옴.
		
		Iterator<String> it = mapKey.iterator(); // Set은 while문 못돌려서 iterator()메서드 이용해서 Iterator타입으로 바꿔줘야함.
		
		while (it.hasNext()) {
			String key = (String) it.next();
			
			arrayList.add(map.get(key));	// 	arrayList에  map에서 키를 가져와서 그 값을 하나씩 add해주기.
		}
		
		return arrayList;
	}
	
	// ##1.화면 다운로드(디비내용 다운로드X)
		@SuppressWarnings("unchecked")
		@Override
		public void downloadExcelFile(Map<String, Object> paramMap, String downloadPath,
				String sheet, String fileName) throws Exception {
			
			// JSON데이터를 엑셀로 저장하기 위한 설정
			WriteOption wo = new WriteOption();
	        wo.setSheetName(sheet);					// 시트 이름
	        wo.setFilePath(downloadPath);			// 다운로드 할 경로
	        wo.setFileName(fileName);				// 다운로드 할 파일이름
	        
	        List<String> titles = (List<String>) paramMap.get("titles");  // JSON데이터 중 타이틀에 해당하는 데이터를 저장(th태그 한줄)
	        wo.setTitles(titles);
	        
	     // JSON데이터 중 내용에 해당하는 데이터를 저장, listToArray(); 메서드 호출!!! =>리턴값인 resultList 에 tbody 내용이 다 들어가 있음.
	        List<String[]> contents = listToArray((List<List<String>>) paramMap.get("contents")); 
	        wo.setContents(contents);
	         
	        ExcelWrite.write(wo);		// 여기서 다운로드 시켜줌. 
		}
	
	/* ##2.화면 다운로드(디비내용 다운로드X)
	 * 기능 : List<List<String>>를 List<String[]>로 변환   =>화면의 내용을 엑셀파일로 만들려면 List<String[]>변환해야함.
	 * [파라미터] 1. List<List<String>> list
	 * [반환값] 1. List<String[]> */
	private List<String[]> listToArray(List<List<String>> tdlist) { // private 반환값(String 대신 List<String[]>) 메서드() {
		List<String[]> resultList = new ArrayList<>();
		
		for (List<String> strings : tdlist) {		// tdlist(=tbody에 들어있는 전부. row들) 각각 strings로 들어감.
			String[] stringArray = new String[strings.size()];	// 현재 돌고있는 한줄! 그 한줄안에 있는 칸의 갯수만큼의 배열 크기를 만듬(내용은없음,껍데기만 만듬)
			
			for (int i = 0, length = stringArray.length; i < length; i++) {		// 한줄을 다시 한칸 한칸으로 쪼갬.
				stringArray[i] = strings.get(i);	// 내용 집어넣기.
			}
			
			resultList.add(stringArray);	// 한칸 한칸 내용이 들어가 있는 한줄을 계속 add해줌.
		}
		
		return resultList;
	}
	
	// ##1.디비 다운로드
		@SuppressWarnings("unchecked")
		@Override
		public void downloadDB(String downloadPath,
				String sheet, String fileName) throws Exception {
			
			// JSON데이터를 엑셀로 저장하기 위한 설정
			WriteOption wo = new WriteOption();
	        wo.setSheetName(sheet);					// 시트 이름
	        wo.setFilePath(downloadPath);			// 다운로드 할 경로
	        wo.setFileName(fileName);				// 다운로드 할 파일이름
	        
	        // 엑셀 첫번째줄(컬럼명 직접 넣기)
	        List<String> titles = new ArrayList<String>();
	        titles.add("NO");
	        titles.add("KOR_NAME");
	        titles.add("JUMIN_NOF");
	        titles.add("JUMIN_NOB");
	        titles.add("SEX");
	        titles.add("TECH_LEV");
	        titles.add("JOP_TYPE");
	        titles.add("DESIRE_DEPT");
	        wo.setTitles(titles);
	        
	        // JSON데이터 중 내용에 해당하는 데이터를 저장, listToArray(); 메서드 호출!!! =>리턴값인 resultList 에 tbody 내용이 다 들어가 있음.
	        List<String[]> contents = excelArrayToList(excelMapper.downloadDB());
	        wo.setContents(contents);
	         
	        ExcelWrite.write(wo);		// 여기서 다운로드 시켜줌. 
		}
	
	// ##2.디비 다운로드, 3번에서 받아온 배열을 for문 돌려서 다시 리스트에 담기.
	private List<String[]> excelArrayToList(List<Map<String, Object>> map) {
		List<String[]> list = new ArrayList<>();
		
		for (int i = 0; i < map.size(); i++) {
			
			// excelMapToArray(map.get(i))의 반환값이 배열이다. list에 계속 배열을 add 해줌.
			list.add(excelMapToArray(map.get(i)));
		}
		
		return list;
	}
	
	// ##3.디비 다운로드
		private String[] excelMapToArray(Map<String, Object> map) {
			String[] arrayList = new String[map.size()];	// 맵의 사이즈만큼 배열의 크기 정해줌.
			
			Set<String> mapKey = map.keySet();		 // map에 들은 키네임을 다 가져옴.
			
			Iterator<String> it = mapKey.iterator(); // Set은 while문 못돌려서 iterator()메서드 이용해서 Iterator타입으로 바꿔줘야함.
			
			int count = 0;
			
			while (it.hasNext()) {
				String key = (String) it.next();
				
				arrayList[count++] = map.get(key).toString();	// 	arrayList에 map에서 키를 가져와서 그 값을 하나씩 add해주기.
			}
			
			return arrayList;
		}
}

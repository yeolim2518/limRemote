package excel.read;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import excel.FileUtil;
import excel.option.ReadOption;
import excel.read.util.CellRef;
import excel.read.util.ExcelFactory;
import excel.read.util.FileType;

public class ExcelRead {

	public static List<Object> read(ReadOption readOption) {
		
		/*
		 * 엑셀의 각 row를 하나의 Map에 저장 한후
		 * List에 추가
		 * ==> 하나의 엑셀 시트가 List
		 * */
		List<Object> resultList = new ArrayList<>();
		
		/*
		 * 타이틀을 사용 하는 경우에 타이틀을 저장하기 위한 용도
		 * */
		Map<String, String> titles = null;
		
		/*
		 * readOption에 저장된 파일 경로의 엑셀파일을 불러옴
		 * */
		Workbook workbook = FileType.getWorkbook(readOption.getFilePath());
		
		if (readOption.isTitleCheck()) {
			titles = new HashMap<>();
		}
		
		/*
		 * readOption에 저장된 sheet의 인덱스 번호에 
		 * 해당하는 sheet를 호출
		 *  - 입력하지 않을 시 첫번째 시트 호출
		 * */
		try {
			Sheet sheet = workbook.getSheetAt(readOption.getSelectSheet());
			
			int numOfRows = sheet.getPhysicalNumberOfRows();	// 해당 시트에서 유효한 데이터가 존재하는 row의 수를 가져온다.
	        int numOfCells = 0;									// 해당 row에서 유효한 데이터가 존재하는 cell의 수를 가져온다.
			
	        
	        Row row = null;		// 시트의 각 row를 저장할 객체
	        Cell cell = null;	// row의 각 cell을 저장할 객체
	        
	        String cellName = "";
	        
	        /*
	         * 각 row의 값을 저장하는데 사용 할 map
	         * put(컬럼명, 값);
	         */
	        
	        for(int rowIndex = readOption.getStartRow(); rowIndex < numOfRows; rowIndex++) {
	        	
	        	// 하나의 row를 저장 하기 위한 객체 생성(map or VO)
	        	ExcelFactory.createInstance(readOption.getExcelVO());
	        	
	        	// row를 하나 가져옴
	        	row = sheet.getRow(rowIndex);
	        	
	        	// row가 비어있지 않을 경우에
	        	if (row != null) {
	        		numOfCells = row.getPhysicalNumberOfCells();
	        		
	        		for(int cellIndex = 0; cellIndex < numOfCells; cellIndex++) {
	        			
	        			// cell 하나 가져옴
	        			cell = row.getCell(cellIndex);
	        			
	        			cellName = CellRef.getName(cell, cellIndex);
	        			
	        			/*
	        			 * ouputColumns가 null이거나
	        			 * null이 아닌 경우에는 cellName이 ouputColumns에 존재 할경우
	        			 * map에 하나의 cell을 저장
	        			 * */
	        			if (readOption.getOutputColumns() == null ||
	        					isColumns(readOption, cellName)) {
	        				
	        				if (readOption.isTitleCheck() && rowIndex == 0) {
	        					titles.put(cellName, CellRef.getValue(cell));
	        				} else {
	        					ExcelFactory.inputValue(cellName, CellRef.getValue(cell), titles);
	        				}
	        			}
	        		}
	        		
	        		// titleCheck가 false이거나 rowIndex가 0이 아닐 때만 실행
	        		if (!(readOption.isTitleCheck() && rowIndex == 0)) {
	        			resultList.add(ExcelFactory.getObject());
	        		}
	        	}
	        }
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		if (readOption.isDeleteCheck()) {
			
			// 파일 삭제
			FileUtil.deleteOne(readOption.getFile());
		}
        
		return resultList;
	}

	private static boolean isColumns(ReadOption readOption, String cellName) {
		List<String> outputColumns = readOption.getOutputColumns();
		
		boolean columnCheck = false;
		
		/*
		 * readOption에 추출할 특정컬럼을 입력 한경우
		 * cellName이 추출하고자 하는 컬럼명 중에 존재하는지 여부 확인
		 * */
		if (outputColumns.contains(cellName)) {
			columnCheck = true;
		}
		
		return columnCheck;
	}
	
	/*
	 * List<Object>를 List<Map<String, Object>>로 변경 하고 싶을 떄 사용
	 * */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> excelObjectToMap(List<Object> list) {
		List<Map<String, Object>> temp = new ArrayList<>();
		
		for (int i = 0, length = list.size(); i < length; i++) {
			temp.add((Map<String, Object>) list.get(i));
		}
		
		return temp;
	}
}

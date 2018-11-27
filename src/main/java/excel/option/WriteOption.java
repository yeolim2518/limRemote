package excel.option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import excel.write.util.ExcelCalculable;
import excel.write.util.ExcelWriteColumnCal;
import excel.write.util.ExcelWriteDefaultCal;

public class WriteOption {
    
   private String filePath;						// 엑셀 파일이 저장 될 경로
   private String fileName;						// 엑셀 파일 이름
   private String sheetName;					// 엑셀 파일이 저장 될 시트 이름
   private List<String> titles;					// 엑셀 파일 타이틀
   private List<Map<String, Object>> contents;	// 엑셀 저장 될 내용
   private ExcelCalculable excelCalculable;		// 엑셀의 cotents를 workbook에 저장 하기 위한 것
   
   public WriteOption() {
	   this.sheetName = "sheet";
	   this.excelCalculable = new ExcelWriteDefaultCal();
   }
   
   public WriteOption(List<Map<String, Object>> list) {
	   this();
	   
	   List<Map<String, Object>> temp = new ArrayList<>();
	   
	   temp.addAll(list);
	   
	   this.contents = temp;
   }
   
   public String getFilePath() {
       return filePath;
   }

   public void setFilePath(String filePath) {
       this.filePath = filePath;
   }

   public String getFileName() {
       return fileName;
   }

   public void setFileName(String fileName) {
       this.fileName = fileName;
   }

   public String getSheetName() {
       return sheetName;
   }

   public void setSheetName(String sheetName) {
       this.sheetName = sheetName;
   }

   
   public ExcelCalculable getExcelCalculable() {
	   return excelCalculable;
   }
	
   public void setExcelCalculable(ExcelCalculable excelCalculable) {
	   this.excelCalculable = excelCalculable;
   }

   public void setColumn() {
	   this.excelCalculable = new ExcelWriteColumnCal();
   }
   
   public List<String> getTitles() {
       List<String> temp = new ArrayList<String>();
       
       if (this.titles != null) {
    	   temp.addAll(this.titles);
       }
        
       return temp;
   }

   public void setTitles(List<String> titles) {
       List<String> temp = new ArrayList<String>();
       
       temp.addAll(titles);
        
       this.titles = temp;
   }

   public void setTitles(String ... titles) {
       List<String> temp = Arrays.asList(titles);
       
       this.titles = temp;
   }

   public List<Map<String, Object>> getContents() {
       List<Map<String, Object>> temp = new ArrayList<>();
       
       temp.addAll(this.contents);
        
       return temp;
   }

   public void setContents(List<String[]> contents) {
       List<Map<String, Object>> temp = new ArrayList<>();
       
       Map<String, Object> map = null;
       
       for (int i = 0, length = contents.size(); i < length; i++) {
    	   map = new LinkedHashMap<>();
    	   
    	   for (int j = 0, cLength = contents.get(i).length; i < cLength; i++) {
    		   map.put(String.valueOf(j), contents.get(i)[j]);
    	   }
       }
       
       this.contents = temp;
   }

   public void setContents(String ... contents) {
       List<String[]> temp = new ArrayList<String[]>();
       
       temp.add(contents);
       
       setContents(temp);
   }
}

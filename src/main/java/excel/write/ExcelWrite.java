package excel.write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import excel.option.WriteOption;
import excel.read.util.FileType;
import excel.write.util.ExcelCalculable;


public class ExcelWrite {
	 
    private static String downloadPath = null;	// 엑셀 파일이 저장 될 경로
    private static Sheet sheet;					// 엑셀 파일이 저장 될 시트
    private static int rowIndex;				// 몇번째 row에 저장 될지를 저장하기 위한 변수
     
    /**
     * 엑셀 파일을 작성한다.
     * @param WriteOption
     * @return Excel 파일의 File 객체
     */
    public static File write(WriteOption writeOption) {
        
    	// 엑셀 파일 경로 확인 용 file
    	File file = new File(writeOption.getFilePath());
    	
    	
    	// 엑셜이 저장 될 경우의 디렉토리가 존재하는지 여부 확인 후에 생성
        if (!file.exists()) {
        	file.mkdirs();
        }
    	
        // 확장자에 따라 Workbook 생성
        Workbook wb = FileType.createWorkbook(writeOption.getFileName());
        
        // 엑셀 workbook에 content를 저장 하기 위한 것
        ExcelCalculable excelCalculable = writeOption.getExcelCalculable();
        
        // sheet 네임으로 생성
        sheet = wb.createSheet(writeOption.getSheetName());
        
        setTitle(writeOption.getTitles());
        setContents(writeOption.getContents(), excelCalculable, writeOption.getTitles());
        
        FileOutputStream fos = null;
        
        
        // 실제 파일 저장
        try {
             
            downloadPath = writeOption.getFilePath();
            if ( downloadPath == null ) {
                throw new RuntimeException("Excel 파일이 만들어질 경로가 누락되었습니다. WriteOption 의 filePath를 셋팅하세요. 예 > D:\\uploadFiles\\");
            }
             
            fos = new FileOutputStream(downloadPath + "\\" + writeOption.getFileName());
            wb.write(fos);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        finally {
            if(fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {}
            }
             
            rowIndex = 0;
        }
         
        return getFile(writeOption.getFileName());
    }
     
    private static void setTitle(List<String> values) {
         
        Row row = null;
        Cell cell = null;
         
        int cellIndex = 0;
         
        if(values != null && values.size() > 0) {
            row = sheet.createRow(rowIndex++);
            
            for (String value : values) {
                cell = row.createCell(cellIndex++);
                cell.setCellValue(value);
            }
        }
         
    }
     
    private static void setContents(List<Map<String, Object>> values, ExcelCalculable excelCalculable, List<String> titles) {
        Row row = null;
        Cell cell = null;
         
        if( values != null && values.size() > 0 ) {
        	
            for (Map<String, Object> map : values) {
            	row = sheet.createRow(rowIndex++);
            	
            	excelCalculable.calculator(map, cell, row, titles);
            }
        }
         
    }
     
    private static File getFile(String fileName) {
        return new File(downloadPath + fileName);
    }
}


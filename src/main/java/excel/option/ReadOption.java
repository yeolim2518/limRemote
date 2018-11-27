package excel.option;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import excel.FileUtil;

public class ReadOption {
	 
    private String filePath;						// 엑셀 파일 경로
    private List<String> outputColumns; 			// 추출할 컬럼 명
    private int startRow; 							// 추출 시작할 행, 0이 첫번째 행
    private int selectSheet;						// 추출할 시트, 0이 첫번째 시트
    private File file;								// 저장한 파일이 담긱 객체
    private boolean deleteCheck;					// 엑셀에서 데이터 추출 후 파일 삭제 여부
    private boolean titleCheck;						// 첫행을 타이틀로 설정할지 여부 ==> read 결과를 VO에 담을 때만 사용
    private Class<?> excelVO;						// 결과를 VO에 담고 싶을 때 해당 Class<?>에 저장
    
    // 기본값으로 사용 하고 싶은 경우
    public ReadOption() {
    	this.startRow 		= 0;
    	this.selectSheet 	= 0;
    	this.deleteCheck	= true;
    	this.titleCheck		= false;
    }
    
    // 시작 row를 설정하고 싶은 경우
    public ReadOption(int startRow) {
    	this();
    	
    	this.startRow = startRow;
    }
    
    // 추출할 컬럼명을 설정하고 싶은 경우1
    public ReadOption(List<String> outputColumns) {
    	this();
    	
    	this.outputColumns = outputColumns;
    }
 
    // 추출할 컬럼명을 설정하고 싶은 경우2
    public ReadOption(String ... outputColumns) {
    	this();
    	
    	if (outputColumns != null) {
    		List<String> list = new ArrayList<>();
    		
    		for (String string : outputColumns) {
				list.add(string);
			}
    		
    		this.outputColumns = list;
    	}
    }
    
    // 추출할 컬럼과 시작 row를 설정하고 싶은 경우
    public ReadOption(List<String> outputColumns, int startRow) {
    	this(startRow);
    	
    	this.outputColumns = outputColumns;
    }
    
    // 추출할 컬럼과 시작 row, 시작 시트를를 설정하고 싶은 경우
    public ReadOption(List<String> outputColumns, int startRow, int selectSheet) {
    	this(startRow);
    	
    	this.outputColumns 	= outputColumns;
    	this.selectSheet 	= selectSheet;
    }      
    
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public List<String> getOutputColumns() {
        
        if (outputColumns != null) {
        	List<String> temp = new ArrayList<String>();
        	
        	temp.addAll(outputColumns);
        	
        	return temp;
        } else {
        	return outputColumns;
        }
        
    }
    public void setOutputColumns(List<String> outputColumns) {
        
        List<String> temp = new ArrayList<String>();
        temp.addAll(outputColumns);
        
        this.outputColumns = temp;
    }
    
    public void setOutputColumns(String ... outputColumns) {
        this.outputColumns = Arrays.asList(outputColumns);
    }
    
    public int getStartRow() {
        return startRow;
    }
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

	public int getSelectSheet() {
		return selectSheet;
	}

	public void setSelectSheet(int selectSheet) {
		this.selectSheet = selectSheet;
	}
    
	public void setFilePath(MultipartHttpServletRequest mRequest,
			String path, String uploadName) {
		File file = FileUtil.uploadOne(mRequest, path, uploadName);
		
		setFilePath(file);
	}
	
	public void setFilePath(File file) {
		this.filePath 	= file.getAbsolutePath();
		this.file		= file;
	}

	public File getFile() {
		return file;
	}

	public boolean isDeleteCheck() {
		return deleteCheck;
	}

	public void setDeleteCheck(boolean deleteCheck) {
		this.deleteCheck = deleteCheck;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public boolean isTitleCheck() {
		return titleCheck;
	}

	public void setTitleCheck(boolean titleCheck) {
		this.titleCheck = titleCheck;
	}

	public Class<?> getExcelVO() {
		return excelVO;
	}

	public void setExcelVO(Class<?> excelVO) {
		this.excelVO = excelVO;
	}
	
}

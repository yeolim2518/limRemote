package egovframework.example.excel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.example.excel.service.ExcelService;
import egovframework.example.excel.service.ExcelVO;
import excel.option.ReadOption;
import excel.option.WriteOption;
import excel.read.ExcelRead;
import excel.write.ExcelWrite;

@Service
public class ExcelServiceImpl implements ExcelService {

	@Resource
	private ExcelMapper excelMapper;
	
	@Override
	public void excelUpload(MultipartHttpServletRequest mRequest, String uploadPath, String uploadName) {
		ReadOption readOption = new ReadOption();
		
		readOption.setFilePath(mRequest, uploadPath, uploadName);	// setFilePath은 가장 기본적인 옵션
		
		List<Object> list = ExcelRead.read(readOption);
		
		System.out.println(list);
		
		System.out.println("map으로 변환한것" + ExcelRead.excelObjectToMap(list));
	}

	@Override
	public void excelUploadRows(MultipartHttpServletRequest mRequest, String uploadPath, String uploadName, int startRow) {
		
		// 시작 row를 선택하고 싶을 때(set메서드를 활용 가능)
		ReadOption readOption = new ReadOption(startRow);
		
		readOption.setFilePath(mRequest, uploadPath, uploadName);
		
		List<Object> list = ExcelRead.read(readOption);
		
		System.out.println(list);
		
		excelMapper.insertExcelMap(list.get(0));
	}

	@Override
	public void excelUploadColumns(MultipartHttpServletRequest mRequest, String uploadPath, String uploadName) {
		
		// 특정 컬럼만 추출 하고 싶을 때(set메서드를 활용해도 가능)
		ReadOption readOption = new ReadOption("A", "C");
		
		readOption.setFilePath(mRequest, uploadPath, uploadName);
		
		List<Object> list = ExcelRead.read(readOption);
		
		System.out.println(list);
	}

	@Override
	public void excelUploadSheet(MultipartHttpServletRequest mRequest, String uploadPath, String uploadName) {
		ReadOption readOption = new ReadOption();
		
		readOption.setFilePath(mRequest, uploadPath, uploadName);
		readOption.setSelectSheet(1);								// 시트를 선택 하고 싶을 때
		
		List<Object> list = ExcelRead.read(readOption);
		
		System.out.println(list);
	}

	@Override
	public void excelUploadVO(MultipartHttpServletRequest mRequest, String uploadPath, String uploadName) {
		ReadOption readOption = new ReadOption();
		
		readOption.setFilePath(mRequest, uploadPath, uploadName);
		readOption.setTitleCheck(true);								// VO를 사용 할 때는 필수 옵션
		readOption.setExcelVO(ExcelVO.class);						// VO를 사용 할 때 해당하는 VO.class 입력
		readOption.setSelectSheet(2);
		
		List<Object> list = ExcelRead.read(readOption);
		
		System.out.println(list);
		
		excelMapper.insertExcelVO(list.get(0));
		
		System.out.println("vo로 변환한것" + getExcelVOList(list));
	}
	
	/*
	 * List<Object>를 List<VO>로 변환하기 위한 예시
	 * */
	private List<ExcelVO> getExcelVOList(List<Object> list) {
		List<ExcelVO> excelList = new ArrayList<>();
		
		for (int i = 0, length = list.size(); i < length; i++) {
			excelList.add((ExcelVO) list.get(i));
		}
		
		return excelList;
	}

	@Override
	public void excelDownload(String downloadPath, String fileName) {
		List<Map<String, Object>> list = excelMapper.selectExcel();
		
		// List<Map<String, Object>>을 사용 하려면 생성자를 통해서만 가능
		WriteOption writeOption = new WriteOption(list);
		
		writeOption.setFilePath(downloadPath);
		writeOption.setFileName(fileName);
		
		writeOption.setTitles("name", "age", "avg", "school", "class_num", "family");
		writeOption.setColumn();
		
		ExcelWrite.write(writeOption);
	}
}

package egovframework.example.excel.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface ExcelMapper {

	void insertExcelMap(Object object);

	void insertExcelVO(Object object);

	List<Map<String, Object>> selectExcel();

}

package egovframework.example.excel.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface ExcelMapper {

	void insertExcelList(Map<String, Object> excelListToMap) throws Exception;

	List<Map<String, Object>> downloadDB() throws Exception;


}

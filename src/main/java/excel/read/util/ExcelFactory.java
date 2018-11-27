package excel.read.util;

import java.util.HashMap;
import java.util.Map;

public class ExcelFactory {

	private static Map<String, String> map;
	private static Object excelVO;
	
	
	/*
	 * 엑셀에서 하나의 row를 저장하기 위한 객체 생성
	 * VO를 사용하는 경우 VO를 
	 * map을 사용하는 경우는 map을 생성
	 * */
	public static void createInstance(Class<?> clazz) {
		
		try {
			
			if (clazz != null) {
				excelVO = clazz.newInstance();
				map = null;
			} else {
				map = new HashMap<>();
				excelVO = null;
			}
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/*
	 * map이나 VO에 컬럼에 해당하는 값을 저장
	 * */
	public static void inputValue(String key, String value, Map<String, String> titles) {
		
		if (map != null) {
			map.put(key, value);
		} else if (excelVO != null) {
			
			// VO는 동적으로 받기 때문에 Method를 활용하여 값 저장
			ReflectExcel.methodInvoke(excelVO, titles.get(key).toString(), value);
		}
	}
	
	/*
	 * 모든 컬럼 값을 저장한 row를 list에 저장하기 위해서 반환 하는 것
	 * */
	public static Object getObject() {
		
		if (map != null) {
			return map;
		} else {
			return excelVO;
		}
	}
}

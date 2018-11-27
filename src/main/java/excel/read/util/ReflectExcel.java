package excel.read.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectExcel {

	@SuppressWarnings("rawtypes")
	public static void methodInvoke(Object excelVO, String methodName, String value) {
		
		Class targetClass = excelVO.getClass();		// 인터페이스를 구현하고 있는 class를 가져옴
		
		Method method[] = targetClass.getDeclaredMethods();		// 해당 class에서 정의하고 있는 모든 메서드를 배열로 반환
		
		for (int i = 0, length = method.length; i < length; i++) {
			
			if (getMethodName(methodName).equals(method[i].getName())) {	// method[i].getName은 해당 메서드의 이름을 반환해줌 => methodName과 일치여부 확인
				
				try {
					Class<?> argtypes[] = method[i].getParameterTypes(); // method[i].getParameterTypes은 모든 매개변수를 반환해줌
					
					// method[i].invoke(메서드가 존재하는 인스턴스, 매개변수들..)을 통하여 실행가능
					method[i].invoke(excelVO, getParameter(value, argtypes[0].getName())); // argtypes[0].getName()은 매개변수 타입의 이름을 반환해줌
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static Object getParameter(String value, String type) {

		if (type.contains("String")) {
			return value;
		} else if (type.contains("int")) {
			return (int) Double.parseDouble(value);
		} else if (type.contains("byte")) {
			return (byte) Double.parseDouble(value);
		} else if (type.contains("short")) {
			return (short) Double.parseDouble(value);
		} else if (type.contains("float")) {
			return (float) Double.parseDouble(value);
		} else if (type.contains("double")) {
			return Double.parseDouble(value);
		} else if (type.contains("long")) {
			return (long) Double.parseDouble(value);
		} else if (type.contains("char")) {
			return value.charAt(0);
		} else {
			return null;
		}
	}
	
	private static String getMethodName(String methodName) {
		StringBuilder builder = new StringBuilder(methodName);
		
		builder.setCharAt(0, Character.toUpperCase(methodName.charAt(0)));
		
		return "set" + builder.toString();
	}
}

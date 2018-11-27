package excel.write.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	public static String getTodayDate() {
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		
		return sdf.format(cal.getTime());
	}
}

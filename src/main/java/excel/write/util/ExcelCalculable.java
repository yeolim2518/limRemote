package excel.write.util;

import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public interface ExcelCalculable {

	public void calculator(Map<String, Object> map, Cell cell, Row row, List<String> titles);
}

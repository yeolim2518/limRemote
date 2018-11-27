package excel.write.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelWriteDefaultCal implements ExcelCalculable {

	@Override
	public void calculator(Map<String, Object> map, Cell cell, Row row, List<String> titles) {
		int cellIndex = 0;
		
		for (Iterator<Object> it = map.values().iterator(); it.hasNext();) {
			cell = row.createCell(cellIndex++);
			cell.setCellValue(it.next().toString());
		}
	}

}

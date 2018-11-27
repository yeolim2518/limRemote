package excel.write.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelWriteColumnCal implements ExcelCalculable {

	@Override
	public void calculator(Map<String, Object> map, Cell cell, Row row, List<String> titles) {
		
		if (titles == null) {
			ExcelWriteDefaultCal cal = new ExcelWriteDefaultCal();
			
			cal.calculator(map, cell, row, titles);
		} else {
			cal(map, cell, row, titles);
		}
	}

	private void cal(Map<String, Object> map, Cell cell, Row row, List<String> titles) {
		int cellIndex = 0;
		
		String 	value 	= "",
				key		= "";
		
		for (int i = 0, length = titles.size(); i < length; i++) {
			value 	= "";
			
			for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
				key 	= it.next();
				
				if (titles.get(i).equals(key)) {
					value = map.get(key).toString();
				}
			}
			
			cell = row.createCell(cellIndex++);
			cell.setCellValue(value);
		}
	}

}

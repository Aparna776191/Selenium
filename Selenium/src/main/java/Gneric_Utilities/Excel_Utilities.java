package Gneric_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utilities {
	
	public List<List<String>> getMultipleColumns(String path, String sheetName) throws IOException {
	    List<List<String>> dataList = new ArrayList<>();

	    FileInputStream file = new FileInputStream(path);
	    Workbook wb = WorkbookFactory.create(file);
	    Sheet sheet = wb.getSheet(sheetName);

	    for (int i = 0; i <= sheet.getLastRowNum(); i++) {
	        Row row = sheet.getRow(i);
	        List<String> rowData = new ArrayList<>();

	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            Cell cell = row.getCell(j);
	            if (cell != null) {
	                rowData.add(cell.toString());
	            } else {
	                rowData.add(""); // Empty cell
	            }
	        }

	        dataList.add(rowData);
	    }

	    wb.close();
	    file.close();

	    return dataList;
	}

	
	

}

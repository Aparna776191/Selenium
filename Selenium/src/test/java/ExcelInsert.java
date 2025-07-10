import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelInsert {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		  
		String path = "C:\\Users\\USER\\Documents\\Book1.xlsx";
		FileInputStream fb = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fb);
	     Sheet s = wb.getSheet("Sheet1");
	     Row r = s.getRow(2);
	     Cell c = r.getCell(2);
	    System.out.println(c.getStringCellValue());
	     
	     
	     
	     
		
		

	}

}

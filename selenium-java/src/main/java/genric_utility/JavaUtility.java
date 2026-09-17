package genric_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class JavaUtility {
	public static String GetDataExcellFile(String Sheet, int r, int c ) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(Sheet);
		Row row = sheet.getRow(r);
		Cell cell = row.getCell(c);
		String data = cell.getStringCellValue();
		System.out.println(data);
		wb.close();
		
		return data;
	}
}


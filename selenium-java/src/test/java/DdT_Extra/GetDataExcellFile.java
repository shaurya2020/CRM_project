package DdT_Extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataExcellFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./src/test/resources/Data.xlsx");
		
//		step 2> get the access of workbook
		Workbook wb = WorkbookFactory.create(fis);
		
// step 3> get the access of sheet
		Sheet sheet = wb.getSheet("ORGname");

// step 4> get the access of row
		Row row = sheet.getRow(7);
		
// step 5> get the access of cell
		Cell cell = row.getCell(0);
		
//step 6> get the data
		
		String data = cell.getStringCellValue();
// cell.getNumericCellValue();
// cell.getBooleanCellValue();
		System.out.println(data);
// don’t forget to close the workbook
		wb.close();
	}

}

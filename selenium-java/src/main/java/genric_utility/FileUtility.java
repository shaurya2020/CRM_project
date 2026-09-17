package genric_utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {

	public static String GetDataFJsonFile(String Key) throws IOException, ParseException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("./src/test/resources/cd.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		JSONObject jobj = (JSONObject) obj;
		String value = jobj.get(Key).toString();
		return value;
	}

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
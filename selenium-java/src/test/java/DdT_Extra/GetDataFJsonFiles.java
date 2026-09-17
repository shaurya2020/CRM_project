package DdT_Extra;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetDataFJsonFiles {

	public static void main(String[] args) throws IOException, ParseException {
//		Step > 1 Create a Java  repo object of physical file 
		FileReader FR = new FileReader("./src/test/resources/cd.json"); 

//		Step > 2 press the jro non static method first parse path to convert 
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(FR);
		
//		Step>3 downcast object to jason object to get the value 
		  
		JSONObject jobj = (JSONObject) obj;
		
//		Step > 4 By using GET method and passing the key get the value.
		String username = jobj.get("un").toString();
		String password = jobj.get("pwd").toString();
		
		System.out.println(username);
		System.out.println(password);
	}

}

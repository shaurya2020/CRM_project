package DdT_Extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataproperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//	Step 1>  create the java representation object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties"); 
	
//		Step 2> load all the keys by using non ststic 
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String brow = pObj.getProperty("bro");
		System.out.println(brow);
		
		String un = pObj.getProperty("user");
		System.out.println(un);
		
		fis.close();
		
	}

}

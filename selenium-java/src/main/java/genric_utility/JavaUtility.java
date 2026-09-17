package genric_utility;

import java.util.Random;

public class JavaUtility  {

		public static  int generateRandomNumber(int limit) {		
					Random zc = new Random();
					return zc.nextInt(limit);
				}

public static void main(String[] args) {

	int num = generateRandomNumber(1000);

	System.out.println(num);
}
}
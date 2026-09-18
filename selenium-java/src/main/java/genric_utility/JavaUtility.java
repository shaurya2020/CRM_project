package genric_utility;

import java.util.Random;

public class JavaUtility {

	public int generateRandomNumber(int limit) {
		Random zc = new Random();
		return zc.nextInt(limit);
	}
}
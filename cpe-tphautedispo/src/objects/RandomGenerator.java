package objects;

import java.math.BigInteger;
import java.security.SecureRandom;

public abstract class RandomGenerator {

	public static String generateRandomPassword(Integer size)
	{
		Integer bits = 5*size;
		String password = new BigInteger(bits, new SecureRandom()).toString();
		return password;
	}
}

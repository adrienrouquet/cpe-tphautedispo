package objects;

public abstract class RandomGenerator {

	public static String generateRandomPassword(Integer size)
	{
		int bits = 5*size;
		  BigInteger.
		    new(bits, SecureRandom.new). # generate a random number 
		    setBit(bits-1). #make sure the random number is always <length> chars long
		    toString(32) # convert to alphanumeric password like i3ue2mr4
	}
}

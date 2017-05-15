package securerandom.basic;
import java.io.ByteArrayInputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureRandomTest {
	public static String byteArrayToHex(byte[] a) {
		StringBuilder sb = new StringBuilder();
		for(final byte b: a)
			sb.append(String.format("%02x", b&0xff));
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			for(int i=0; i<100; i++){
				byte[] temp = random.getSeed(4);
				System.out.println(byteArrayToHex(temp));
			}

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

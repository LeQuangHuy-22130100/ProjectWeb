package utils;

import java.util.Random;

public class OTPGenerator {
	public static String generateOTP() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(999999));
    }

}

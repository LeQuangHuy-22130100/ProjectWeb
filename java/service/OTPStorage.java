package service;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

public class OTPStorage {
	private static final ConcurrentHashMap<String, OTPInfo> otpMap = new ConcurrentHashMap<>();
	
	static class OTPInfo {
		String otp;
		LocalDateTime expiryTime;
		
		OTPInfo(String otp) {
			this.otp = otp;
			this.expiryTime = LocalDateTime.now().plusMinutes(5);
		}
	}
	
	public void saveOTP(String email, String otp) {
		otpMap.put(email, new OTPInfo(otp));
	}
	
	public boolean verifyOTP(String email, String otp) {
		OTPInfo otpInfo = otpMap.get(email);
		if (otpInfo != null && otpInfo.otp.equals(otp) && LocalDateTime.now().isBefore(otpInfo.expiryTime)) {
			otpMap.remove(email);
			return true;
		}
		return false;
	}

}

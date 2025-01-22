package service;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	private final String HOST = "sandbox.smtp.mailtrap.io";
	private final String PORT = "2525";
	private final String USERNAME = "f2a5e34bfd350f";
	private final String PASSWORD = "c4b355ca541d61";
	
	public String generateOTP() {
		Random random = new Random();
		int otp = random.nextInt(999999);//Tạo mã OTP ngẫu nhiên gồm 6 chữ số
		return String.valueOf(otp);
	}
	
	public boolean sendOTPEmail(String toEmail, String otp) throws MessagingException {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", HOST);
		properties.put("mail.smtp.port", PORT);
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});
		
		Message mess = new MimeMessage(session);
		mess.setFrom(new InternetAddress("alexander@bimbambum.com"));
		mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
		mess.setSubject("Mã OTP Đặt Lại Mật Khẩu");
		
		String emailContent = "Xin chào,\n\n"
                + "Đây là mã OTP để đặt lại mật khẩu của bạn: " + otp + "\n"
                + "Mã này sẽ hết hạn sau 5 phút.\n\n"
                + "Nếu bạn không yêu cầu đặt lại mật khẩu, vui lòng bỏ qua email này.\n\n"
                + "Trân trọng,\nHệ thống";
		
		mess.setText(emailContent);
		
		Transport.send(mess);
		return true;
	}

}

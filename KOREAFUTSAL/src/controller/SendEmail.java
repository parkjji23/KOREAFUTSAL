package controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class SendEmail implements Cominterface {
	static SendEmail impl = new SendEmail();
	public static SendEmail instance() {
		return impl;

	}
	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 String q_b_email=request.getParameter("q_b_email");
		 String q_b_title=request.getParameter("q_b_title");
		 String q_b_contents=request.getParameter("q_b_contents");
		 String q_b_name=request.getParameter("q_b_name");
		 String q_b_reply=request.getParameter("q_b_reply");
		 ////////////////////////////////////////////
		 String host = "smtp.naver.com";  

		 final String username = "koreafutsalpark"; //���̹� ���̵� �Է����ּ���. @nave.com�� �Է����� ���ñ���.  

		 final String password = "korea34811005"; //���̹� �̸��� ��й�ȣ�� �Է����ּ���.  

		 int port=587; //��Ʈ��ȣ  

		  

		 // ���� ����  

		 String recipient = "parkjji23@naver.com"; //�޴� ����� �����ּҸ� �Է����ּ���.  

		 String subject = "�����׽�Ʈ"; //���� ���� �Է����ּ���.  

		 String body = username+"������ ���� ������ �޾ҽ��ϴ�."; //���� ���� �Է����ּ���.  

		  

		 Properties props = System.getProperties();  

		  

		 // ������ ��� ���� ��ü ����  

		 // SMTP ���� ���� ����  

		 props.put("mail.smtp.host", host);  

		 props.put("mail.smtp.port", port);  

		 props.put("mail.smtp.auth", "true");  

		 props.put("mail.smtp.ssl.enable", "true");  
		 
		 props.put("mail.smtp.starttls.enable", "true");

		 props.put("mail.smtp.ssl.trust", host);  

		 //Session ����  

		 Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {  

		 String un=username;  

		 String pw=password;  

		 protected javax.mail.PasswordAuthentication getPasswordAuthentication() {  

		 return new javax.mail.PasswordAuthentication(un, pw);  

		 }  

		 });  

		 session.setDebug(true); //for debug  

		 Message mimeMessage = new MimeMessage(session); //MimeMessage ���� 

		 mimeMessage.setFrom(new InternetAddress("koreafutsalpark@naver.com")); //�߽��� ���� , ������ ����� �̸����ּҸ� �ѹ� �� �Է��մϴ�. �̶��� �̸��� Ǯ �ּҸ� �� �ۼ����ּ���.  

		 mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //�����ڼ���  

		  

		 mimeMessage.setSubject(subject); //�������  

		 mimeMessage.setText(body); //������� 

		 Transport.send(mimeMessage); //javax.mail.Transport.send() �̿� 
		 ////////////////////////////////////////////////////////////
		 
		return "";
	}
 

}

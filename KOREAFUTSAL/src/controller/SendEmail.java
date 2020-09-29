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

		 final String username = "koreafutsalpark"; //네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요.  

		 final String password = "korea34811005"; //네이버 이메일 비밀번호를 입력해주세요.  

		 int port=587; //포트번호  

		  

		 // 메일 내용  

		 String recipient = "parkjji23@naver.com"; //받는 사람의 메일주소를 입력해주세요.  

		 String subject = "메일테스트"; //메일 제목 입력해주세요.  

		 String body = username+"님으로 부터 메일을 받았습니다."; //메일 내용 입력해주세요.  

		  

		 Properties props = System.getProperties();  

		  

		 // 정보를 담기 위한 객체 생성  

		 // SMTP 서버 정보 설정  

		 props.put("mail.smtp.host", host);  

		 props.put("mail.smtp.port", port);  

		 props.put("mail.smtp.auth", "true");  

		 props.put("mail.smtp.ssl.enable", "true");  
		 
		 props.put("mail.smtp.starttls.enable", "true");

		 props.put("mail.smtp.ssl.trust", host);  

		 //Session 생성  

		 Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {  

		 String un=username;  

		 String pw=password;  

		 protected javax.mail.PasswordAuthentication getPasswordAuthentication() {  

		 return new javax.mail.PasswordAuthentication(un, pw);  

		 }  

		 });  

		 session.setDebug(true); //for debug  

		 Message mimeMessage = new MimeMessage(session); //MimeMessage 생성 

		 mimeMessage.setFrom(new InternetAddress("koreafutsalpark@naver.com")); //발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.  

		 mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅  

		  

		 mimeMessage.setSubject(subject); //제목셋팅  

		 mimeMessage.setText(body); //내용셋팅 

		 Transport.send(mimeMessage); //javax.mail.Transport.send() 이용 
		 ////////////////////////////////////////////////////////////
		 
		return "";
	}
 

}

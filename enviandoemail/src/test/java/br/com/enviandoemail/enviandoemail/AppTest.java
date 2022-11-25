package br.com.enviandoemail.enviandoemail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class AppTest {

	/*Usuário e senha de APP para login*/
	private String userName = "gabriel.feitosa.java@gmail.com";
	private String senha = "rrxjmozksuzivjas";
	
	@Test
	public void testeEmail() {
		try {
			Properties properties = new Properties();

			
			/*Parametros de autenticação do Gmail*/
			properties.put("mail.smtp.ssl.trust", "*");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
			/*Criando sessão*/
			Session session = Session.getInstance(properties, new Authenticator() {
			
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, senha);
				}
				
			});
		
			/*Inicializando array com os destinatários*/
			Address[] destinatario = InternetAddress.parse("tadeupalermoti@gmail.com, alex.fernando.egidio@gmail.com");
			
			/*Inicializando mensagem a ser enviada com título e corpo*/
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO, destinatario);
			message.setSubject("E-mail enviado com API JavaMail");
			message.setText("Teste de envio de e-mail com API JavaMail rodando em Java!");
			
			/*Método de envio de e-mail*/
			Transport.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

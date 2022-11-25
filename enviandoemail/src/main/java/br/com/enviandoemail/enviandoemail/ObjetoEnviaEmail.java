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

public class ObjetoEnviaEmail {
	
    	/*Usuário e senha de APP para login*/
	private String userName = "gabriel.feitosa.java@gmail.com";
	private String senha = "rrxjmozksuzivjas";
	private String listaDestinatario = "";
	private String nomeRemetente = "";
	private String tituloEmail = "";
	private String corpoEmail = "";
	
	public ObjetoEnviaEmail(String listaDestinatario, String nomeRemetente, String tituloEmail, String corpoEmail) {
		this.listaDestinatario = listaDestinatario;
		this.nomeRemetente = nomeRemetente;
		this.tituloEmail = tituloEmail;
		this.corpoEmail = corpoEmail;
	}
	
	public void enviarEmail() {
		try {
			Properties properties = new Properties();

			/* Parametros de autenticação do Gmail */
			properties.put("mail.smtp.ssl.trust", "*");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			/* Criando sessão */
			Session session = Session.getInstance(properties, new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, senha);
				}

			});

			/* Inicializando array com os destinatários */
			Address[] destinatario = InternetAddress.parse(listaDestinatario);

			/* Inicializando mensagem a ser enviada com título e corpo */
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName, nomeRemetente));
			message.setRecipients(Message.RecipientType.TO, destinatario);
			message.setSubject(nomeRemetente);
			message.setText(corpoEmail);

			/* Método de envio de e-mail */
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

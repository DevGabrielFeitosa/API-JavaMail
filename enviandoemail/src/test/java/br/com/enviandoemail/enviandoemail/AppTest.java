package br.com.enviandoemail.enviandoemail;

import org.junit.Test;

public class AppTest {

	public static void main(String[] args) {
		
		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("cabeceirasmax@gmail.com", "Gabriel Feitosa", "Teste de POO", "Testando envio de e-mails com JavaMail e POO");

		enviaEmail.enviarEmail();
	}
	
	
	
	}

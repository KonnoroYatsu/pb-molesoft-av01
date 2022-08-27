package exercicio_09;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LoginEMenssagemPerssonalizada {
	
	public static void main(String[] args) {
		
		String usuario = "AdminJoao"; //Usuario para Login
		String senha = "Joao123"; //Senha para Login
		boolean validacaoDoLogin = false;
		
		String[] menssagem = {
				"Bom dia, você se logou ao nosso sistema.",
				"Boa tarde, você se logou ao nosso sistema.",
				"Boa noite, você se logou ao nosso sistema.",
				"Boa madrugada, você se logou ao nosso sistema.",
			};
		
		int hora = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.print("Insira o usuário: ");
			String usuarioDigitado = teclado.next();
			
			System.out.print("Insira a senha: ");
			String senhaDigitadda = teclado.next();
			
			if(usuario.equals(usuarioDigitado) && senha.equals(senhaDigitadda)) {
				validacaoDoLogin = true;
			}
			else {
				System.out.println("Usuário e/ou senha incorretos.\n");
			}
			
		}while(validacaoDoLogin == false);
		teclado.close();
		
		//Capturando somente a hora atual no padrão 24h 
		hora = Integer.parseInt(LocalDateTime.now().atZone(ZoneId.of("America/Sao_Paulo")).format(DateTimeFormatter.ofPattern("HH")));
		if(hora >= 6 && hora < 12) {
			System.out.println(menssagem[0]);
		}else if(hora >= 12 && hora < 18) {
			System.out.println(menssagem[1]);
		}else if(hora >= 18 && hora < 24) {
			System.out.println(menssagem[2]);
		}else {
			System.out.println(menssagem[3]);
		}
	}
}

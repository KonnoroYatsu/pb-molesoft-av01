package exercicio_08;

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		String nomeJogador = "";
		int acertos = 0, erros = 0;
		String respostasDoJogador = "";
		String[] perguntas = 
			{
				"01 - Geralmente quantos pneus tem um carro?",
				"02 - A cidade São Paulo fica localizada em que país?",
				"03 - Em que país acontecerá a copa do mundo de 2022?",
				"04 - Em que ano os portugueses chegaram ao Brasil?",
				"05 - Albert Ainsten morreu com quantos anos?"
			};
		
		String[] respostas = 
			{
				"5",
				"brasil",
				"catar",
				"1500",
				"76"
			};
		
		Scanner teclado = new Scanner(System.in);
		
		while(nomeJogador.length() == 0) {
			System.out.print("Insira seu nome: ");;
			nomeJogador = teclado.nextLine();
			if(nomeJogador.length() == 0) {
				System.out.println("Por favor insira um nome!");
			}
		}
		
		for(int contador = 0; contador < perguntas.length; contador++) {
			System.out.println(perguntas[contador]);
			System.out.print("Escreva suas resposta: ");
			
			respostasDoJogador = teclado.next().toString();
			
			if(respostasDoJogador.toLowerCase().equals(respostas[contador])) {
				System.out.println("Parabéns, voçê acertou! :) ");
				acertos++;
			}else {
				System.out.println("Que pena, parece que voçê errou! :( ");
				
				if(contador == 0) {
					System.out.println("Sim, era pegadinha. Contando com o estepe são 5 pneus");
				}
				
				erros++;
			}
			
			try {
				Thread.sleep(1700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println();
		}
		teclado.close();
		
		System.out.println("Voçê respondeu todas as perguntas, aqui esta seu resultado: ");
		System.out.println("Jogador: " + nomeJogador);
		System.out.println("Acertos: " + acertos);
		System.out.println("Erros: " + erros);
	}
}

package exercicio_10;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculaBonificacao {
	public static void main(String[] args) {
		int quantidadeDeFuncionarios = 0;
		DecimalFormat formatacaoParaOsValores = new DecimalFormat("0.00");
		List<String> nomeDosFuncionarios = new ArrayList<String>();
		List<Double> salarioDosFuncionarios = new ArrayList<Double>();
		List<Double> bonificacaoDosFuncionarios = new ArrayList<Double>();
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Insira a quantidade de funcionários: ");
		quantidadeDeFuncionarios = teclado.nextInt();
		
		for(int contador = 0; contador < quantidadeDeFuncionarios; contador++) {
			System.out.print(contador+1 + ". Insira o nome do funcionário: ");
			nomeDosFuncionarios.add(teclado.next());
			
			System.out.print(contador+1 + ". Insira o salário do funcionário: ");
			Double salarioDigitado = teclado.nextDouble();
			salarioDosFuncionarios.add(salarioDigitado);
			
			bonificacaoDosFuncionarios.add(verificaBonificacao(salarioDigitado));
			
			System.out.println(); //Só para pular uma linha
		}
		teclado.close();
		
		System.out.println("Resultado do calculo de bonus:\n");
		
		for(int contador = 0; contador < quantidadeDeFuncionarios; contador++) {
			System.out.println("Funcionário " + nomeDosFuncionarios.get(contador));
			System.out.println("Salário: " + formatacaoParaOsValores.format(salarioDosFuncionarios.get(contador)));
			
			//Só para alterar o inicio da mensagem caso seja um desconto um bónus
			if(bonificacaoDosFuncionarios.get(contador) < 0) {
				System.out.print("Desconto: ");
			}else {
				System.out.print("Bónus: ");
			}
			System.out.println(formatacaoParaOsValores.format(bonificacaoDosFuncionarios.get(contador)));
			
			System.out.println("Salário Liquido: " + 
					(formatacaoParaOsValores.format(
							salarioDosFuncionarios.get(contador) + bonificacaoDosFuncionarios.get(contador)))
					);
			System.out.println(); //Só para pular uma linha
		}
	}
	
	public static double verificaBonificacao(double salario) {
		if(salario < 1000) {
			return salario * 0.2;
		}
		else if (salario > 1000 && salario < 2000) {
			return salario * 0.1;
		}
		//Retorna um valor de bonificação negativo para ser armazenado no ArrayList
		return (salario * 0.1) - ((salario * 0.1) * 2);
	}
}

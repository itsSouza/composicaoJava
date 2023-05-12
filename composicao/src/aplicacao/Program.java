package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Empregado;
import entidades.enums.Senioridade;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		 
		System.out.print("Digite o nome do departamento: ");
		String dep = sc.nextLine();
		System.out.println("Digite os dados do empregado: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Senioridade: ");
		String nivel = sc.nextLine();
		System.out.print("Salario Base: ");
		Double salario = sc.nextDouble();
		
		Empregado empregado = new Empregado(nome, Senioridade.valueOf(nivel), salario, new Departamento(dep));
		
		System.out.print("Quantos contratos o empregado tem? ");
		int n = sc.nextInt();
		 
		for(int i = 1; i <= n; i++) {
			System.out.printf("Digite os dados do %d# contrato%n", i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date datacontrato = sfd.parse(sc.next());
			System.out.print("Valor por hora: ");
			Double valorPorHora = sc.nextDouble();
			System.out.print("Horas trabalhadas: ");
			int hora = sc.nextInt();
			ContratoHora contrato = new ContratoHora(datacontrato, valorPorHora, hora);
			empregado.addContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Digite o mes e ano para calcular a renda (MM/YYYY): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: " + empregado.getNome());
		System.out.println("Departamento " + empregado.getDepartamento().getNome());
		System.out.println("A receita de " + mesEAno + ": " + String.format("%.2f", empregado.receita(ano, mes)));
		
		
		
		sc.close();
	}

}

package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Contract number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date: ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Value: ");
		double totalValue = sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
		
		System.out.print("Number os installments: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		ContractService contractService = new ContractService(null);
		
		contractService.processContract(obj, n);
		
		System.out.println("Parcelas:");
		for(Installment i : obj.getInstallments()) {
			System.out.println(i);
		}
		
		sc.close();
		
	}
	
}

package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		try {
			System.out.println("Entre com os dados da conta");
			System.out.print("Número: ");
			int accNumber = input.nextInt();
			System.out.print("Titular: ");
			input.nextLine();
			String holder = input.nextLine();
			System.out.print("Saldo inicial: R$ ");
			double initialBalance = input.nextDouble();
			System.out.print("Limite de saque: R$ ");
			double withdrawLimit = input.nextDouble();

			Account acc = new Account(accNumber, holder, initialBalance, withdrawLimit);

			System.out.print("\nDigite a quantia de saque: R$ ");
			double withdraw = input.nextDouble();

			acc.withdraw(withdraw);
			System.out.println("Saldo atual: R$ " + String.format("%.2f", acc.getBalance()));
		} catch (DomainException e) {
			System.out.println("\nErro ao efetuar operação: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println(
					"\nValor inválido. Não foi possível efetuar operação pois foi inserido um valor inadequado.");
		} catch (RuntimeException e) {
			System.out.println("\nErro inesperado.");
		} finally {
			input.close();
		}
	}
}

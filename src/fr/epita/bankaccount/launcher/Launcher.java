package fr.epita.bankaccount.launcher;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

import fr.epita.bankaccount.datamodel.Accounts;
import fr.epita.bankaccount.datamodel.Customer;
import fr.epita.bankaccount.datamodel.InvestmentAccount;
import fr.epita.bankaccount.datamodel.SavingAccounts;

/**
 * @author Zick
 *
 */
public class Launcher {
	static Customer c1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean using = true;
		boolean validChoice;
		while(using){
			validChoice = false;
			System.out.println("Hello! Welcome to the bank account system!");
			System.out.println("What would you like to do?\n1. Create a customer\n2. Create an account\n"
					+ "3. Perform an operation\n4. Print customer's details\n5. Saving data\n6. Exit");
			
			Scanner scan = new Scanner(System.in);
			String choice = "";
			while(validChoice == false){
				System.out.print("Your "
						+ "choice is: ");
				choice = scan.nextLine().trim();
	
				switch(choice){
					case "1":
						executeOption1(scan);
						validChoice = true;
						break;
					case "2":
						executeOption2(scan);
						validChoice = true;
						break;
					case "3":
						executeOption3(scan);
						validChoice = true;
						break;
					case "4":
						System.out.println(c1.printCustomerDetails());
						validChoice = true;
						break;
					case "5":
						savingCustomerDetails();
						validChoice = true;
						break;
					case "6":
						validChoice = true;
						using = false;
						break;
					default:
						System.out.println("Invalid choice! Please try again!\n");
						break;
							
				}
			}
		}
		//System.out.println("You have chosen: " + choice);
		
		
	}
	
	public static void executeOption1(Scanner scan){
		System.out.println("Please enter your full name: ");
		String name = scan.nextLine();
		System.out.println("Please enter your address: ");
		String address = scan.nextLine();
		c1 = new Customer(name,address);
	}
	
	public static void executeOption2(Scanner scan){
		System.out.println("Which type of accounts do you want to open? \n1. Saving account\n2.Investment account");
		boolean validChoice = false;
		Accounts a = null;
		while(!validChoice){
			System.out.print("Your choice is: ");
			String choice = scan.nextLine().trim();
			switch(choice){
				case "1": 
					a = new SavingAccounts();
					c1.createAccount(a);
					validChoice = true;
					break;
				case "2":
					a = new InvestmentAccount();
					c1.createAccount(a);
					validChoice = true;
					break;
				default:
					System.out.println("Invalid choice! Please try again!");
					break;
			}
			
		}
		System.out.println("Your account id: " + a.getAccount_id());
	}
	
	public static void executeOption3(Scanner scan){
		ArrayList<Accounts> temps = c1.getAccountsList();
		if(temps.size() == 0){
			System.out.println("You don't have any account!");
			return;
		}
		System.out.println("Choose an account you want to do an operation: ");
		for(int i = 0; i<temps.size();i++){
			if(temps.get(i) instanceof SavingAccounts){
				System.out.println(Integer.toString(i + 1) + ". " + temps.get(i).getAccount_id() + " - Saving Account");
			}
			else{
				System.out.println(Integer.toString(i + 1) + ". " + temps.get(i).getAccount_id() + " - Investment Account");
			}
			
		}
		
		String input = "";
		int index = -1;
		while (index < 0){
			System.out.println("Your chosen account is: ");
			input = scan.nextLine().trim();
			try{
				index = Integer.parseInt(input) - 1;
				if (index >= temps.size()){
					System.out.println("Invalid choice! Please try again!");
					index = -1;
				}
			}
			catch(Exception e){
				System.out.println("Invalid choice! Please try again!" + index);
			}
			
		}
		
		System.out.println("Which operation do you want to execute?\n1. Withdrawn\n2. Deposite");
		while(true){
			System.out.println("Your choice is: ");
			input = scan.nextLine().trim();
			if(input.equals("1")){
				temps.get(index).widthdrawn(scan);
				break;
			}
			else if(input.equals("2")){
				temps.get(index).deposite(scan);
				break;
			}
			else{
				System.out.println("Invalid Choice! Please try again!");
			}
		}
	}
	

	public static void savingCustomerDetails(){
		try{
			OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("customerDetails.txt"), "UTF-8");
		    writer.write("\n dsadasdas \n dsadsadsadsa ");//c1.printCustomerDetails());
		    writer.close();
		} catch (IOException e) {
		   // do something
			System.out.println("Error");
		}
	}

}

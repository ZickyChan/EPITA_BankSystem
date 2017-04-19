package fr.epita.bankaccount.datamodel;

import java.util.Scanner;

public abstract class Accounts {
	private static int current_account_id = 0;
	double balance;
	
	public Accounts(){
		balance = 0;
		current_account_id++;
	}
	
	public abstract int getAccount_id();
	
	public int getCurrentID(){
		return current_account_id;
	}
	
	public double getBalance(){
		return balance;
	}
	public boolean widthdrawn(double ammount){
		if(ammount < balance){
			balance -= ammount;
			return true;
		}
		return false;
	}
	public void deposit(double ammount){
		balance += ammount;
	}
	public void widthdrawn(Scanner scan){
		while(true){
			System.out.println("Enter the ammount of money you want to widthdraw: ");
			try{
				double ammount = Double.parseDouble(scan.nextLine().trim());
				if(widthdrawn(ammount)){
					break;
				}
				else{
					System.out.println("The ammount exceeds your balance! Please try again!");
				}
			}
			catch(Exception e){
				System.out.println("Invalid ammount! Please try again!");
			}
		}
	}
	public void deposite(Scanner scan){
		while(true){
			System.out.println("Enter the ammount of money you want to deposit: ");
			try{
				double ammount = Double.parseDouble(scan.nextLine().trim());
				deposit(ammount);
				break;
			}
			catch(Exception e){
				System.out.println("Invalid ammount! Please try again!");
			}
		}
	}

}

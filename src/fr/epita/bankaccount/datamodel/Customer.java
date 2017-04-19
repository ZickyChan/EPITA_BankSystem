package fr.epita.bankaccount.datamodel;

import java.util.ArrayList;


public class Customer {
	private static int current_id_value = 0;
	private int id;
	private String name;
	private String address;
	
	private ArrayList<Accounts> accounts;
	
	public Customer(String n, String a){
		current_id_value++;
		id = current_id_value;
		setName(n);
		setAddress(a);
		accounts = new ArrayList<Accounts>();
	}
	
	public void createAccount(Accounts a){
		accounts.add(a);
	}
	public void deleteAccount(Accounts a){}
	public void modifyAccount(Accounts a){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null){
			this.name = name;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(address != null){
			this.address = address;
		}
	}

	public int getId() {
		return id;
	}
	
	public ArrayList<Accounts> getAccountsList(){
		return accounts;
	}
	
	public String printCustomerDetails(){
		String temp = "";
		temp += "Your account id is: " + getId() + "\n";
		temp += "Your full name is: " + name + "\n";
		temp += "Your address is: " + address + "\n";
		//System.out.println("Your account id is: " + getId());
		//System.out.println("Your full name is: " + name);
		//System.out.println("Your address is: " + address);
		if(accounts.size() == 0){
			temp += "You don't have any accounts!";
			return temp;
		}
		
		
		//System.out.println("Your accounts are: ");
		
		temp += "Your accounts are: \n";
		
		for(int i = 0; i<accounts.size();i++){
			Accounts a = accounts.get(i);
			if(a instanceof SavingAccounts){
				temp += Integer.toString(i + 1) + ". " + a.getAccount_id() + " - Saving Account\n- Balance: $" + a.getBalance() + "\n";
			}
			else{
				temp += Integer.toString(i + 1) + ". "  + accounts.get(i).getAccount_id() + " - Investment Account\n- Balance: $" + a.getBalance() + "\n";
			}
			
		}
		return temp;
	}
}

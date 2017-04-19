package fr.epita.bankaccount.datamodel;

public class SavingAccounts extends Accounts {
	private double interestRate;
	private int account_id;
	public SavingAccounts(){
		super();
		account_id = super.getCurrentID();
	}
	
	public double calculateInterest(){
		double money = 0;
		return money;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getAccount_id(){
		return this.account_id;
	}
}

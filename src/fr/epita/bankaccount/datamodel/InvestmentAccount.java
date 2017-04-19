package fr.epita.bankaccount.datamodel;

import java.util.List;

public class InvestmentAccount extends Accounts{
	List<StockOrders> orderedList;
	private int account_id;
	
	public InvestmentAccount(){
		super();
		account_id = super.getCurrentID();
	}
	
	public void orderStock(){}
	
	public int getAccount_id(){
		return this.account_id;
	}
}

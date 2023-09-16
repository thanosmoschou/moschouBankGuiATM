/*
 * Author: Thanos Moschou
 * Last Modification Date: 09/2023
 * Description: This is a very simple GUI ATM built with Java.
 */

package moschouBankGuiATM;

public class User 
{
	private int totalBalance;
	private int cardNumber;
	private int pin; //unusual for now because I use database and I will not use this pin in my app. Maybe is useful when I will implement change pin process.
	private boolean lockedAccount; //also unusual. It will be usual when I will implement an account lock process
	
	
	public User(int someInitialBalance, int aCardNumber)
	{
		this.totalBalance = someInitialBalance;
		this.cardNumber = aCardNumber;
		this.pin = 0;
		this.lockedAccount = false;
	}
	
	public User(int someInitialBalance, int aCardNumber, int initialPin)
	{
		this.totalBalance = someInitialBalance;
		this.cardNumber = aCardNumber;
		this.pin = initialPin;
		this.lockedAccount = false;
	}
	
	
	public String deposit(int money)
	{
		if(money > 0 && Bank.updateDatabase(this, money, 0))
		{
			this.totalBalance += money;
			return "Success! Press clear to enter amount or go back to the menu.";
		}
		
		return "Deposit Failed";
	}
	
	
	public String withdraw(int money)
	{
		if(money <= 0)
		{
			return "Invalid amount. Press clear or go back to the menu.";
		}
		
		if(this.totalBalance - money >= 0 && Bank.updateDatabase(this, money, 1))
		{
			this.totalBalance -= money;
			return "Success! Press clear to enter amount or go back to the menu.";
		}
		
		return "Withdraw Failed";
	}
	
	
	public int getTotalBalance()
	{
		return this.totalBalance;
	}
	
	
	public int getCardNumber()
	{
		return this.cardNumber;
	}
	
	
	public int getPin()
	{
		return this.pin;
	}
}

/*
 * Author: Thanos Moschou
 * Last Modification Date: 09/2023
 * Description: This is a very simple GUI ATM built with Java.
 */


package moschouBankGuiATM;

import java.sql.*;

public class Bank 
{
	public static final int CARDNUMBERLENGTH = 5;
	public static final int PINLENGTH = 4;
	
	
	public Bank()
	{
		
	}
	
	
	//mode 0 is for deposit and mode 1 is for withdraw
	public static boolean updateDatabase(User aUser, int amount, int mode)
	{
		String url = "jdbc:mysql://localhost:3306/moschoubank"; //only for localhost databases.
		String username = "simple"; 
		String password = "!@#$%^&*()";
		int newAmount = (mode == 0) ? (aUser.getTotalBalance() + amount) : (aUser.getTotalBalance() - amount);
		String query = "update users set balance = " + newAmount + " where cardNumber = " + aUser.getCardNumber();
		
		try 
		{
			Connection con = DriverManager.getConnection(url, username, password);
			Statement statement = con.createStatement();
			int rowsAffected = statement.executeUpdate(query);
						
			if(rowsAffected != 0)
				return true;
			
			statement.close();
			con.close();	
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public static User validateUser(String cardNumber, String pin)
	{
		//connect to the database
		//in real life applications you do not connect as root. You should create
		//a simple user with the minimum amount of privileges to your database. Please take security measures.
		//Here I created a user with the name of 'simple' and the privileges that he has is select and update only on users table
		//in moschoubank database. He does not have privileges anywhere else in the database nor in the entire mysql server.
		
		String url = "jdbc:mysql://localhost:3306/moschoubank"; //only for localhost databases.
		String username = "simple"; 
		String password = "!@#$%^&*()";
		String query = "select cardNumber, balance from users where cardNumber = " + cardNumber + " and pin = " + pin;
		
		try 
		{
			Connection con = DriverManager.getConnection(url, username, password);
			Statement statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);
			int cardNum = 0, balance = 0;
						
			if(results.next())//move the cursor to the first record of the result set (if records exist)
			{
				cardNum = results.getInt("cardNumber");
				balance = results.getInt("balance");				
			}
			
			statement.close();
			con.close();
			
			if(cardNum != 0 && balance != 0)
				return new User(balance, cardNum);
			else
				return new User(0, 0); //user not found in the database
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new User(-1, -1); //error with the database
	}
}

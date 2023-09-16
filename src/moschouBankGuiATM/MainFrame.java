/*
 * Author: Thanos Moschou
 * Last Modification Date: 09/2023
 * Description: This is a very simple GUI ATM built with Java.
 */

package moschouBankGuiATM;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class MainFrame extends JFrame
{

	private User myUser = null;
	
	private JPanel startingPanel = new JPanel();
	
	private CardLayout changeScreens = new CardLayout();
	private JPanel outputScreen = new JPanel(changeScreens);
	private String currentShowingScreen;
	
	private JPanel menuPanel = new JPanel();
	private JPanel depositPanel = new JPanel();
	private JPanel withdrawPanel = new JPanel();
	private JPanel showTotalBalancePanel = new JPanel();
	private JPanel loginPanel = new JPanel();

	
	//This arraylist is just for enable/disable selection buttons. I pass to these methods
	//some arguments that show which buttons I want to enable/disable
	private ArrayList<JButton> selectionButtons = new ArrayList<>();
	
	private JButton firstSelectionButton = new JButton("");
	private JButton secondSelectionButton = new JButton("");
	private JButton thirdSelectionButton = new JButton("");
	private JButton fourthSelectionButton = new JButton("");
	private JButton fifthSelectionButton = new JButton("");
	private JButton sixthSelectionButton = new JButton("");
	
	
	//Also I add digitButtons to an arrayList just for making my life easier
	private ArrayList<JButton> digitButtons = new ArrayList<>();
	
	private JButton digitButton1 = new JButton("1");
	private JButton digitButton2 = new JButton("2");
	private JButton digitButton3 = new JButton("3");
	private JButton digitButton4 = new JButton("4");
	private JButton digitButton5 = new JButton("5");
	private JButton digitButton6 = new JButton("6");
	private JButton digitButton7 = new JButton("7");
	private JButton digitButton8 = new JButton("8");
	private JButton digitButton9 = new JButton("9");
	private JButton digitButton0 = new JButton("0");
	
	private JButton clearButton = new JButton("Clear");
	private JButton backButton = new JButton("Back");
	private JButton okButton = new JButton("OK");
	
	
	//menu panel
	private JLabel chooseTitleLabel = new JLabel("Please choose");
	private JLabel depositLabel = new JLabel("Deposit");
	private JLabel withdrawLabel = new JLabel("Withdraw");
	private JLabel balanceLabel = new JLabel("Total Balance");
	private JLabel comingSoon1Label = new JLabel("Coming Soon");
	private JLabel comingSoon2Label = new JLabel("Coming Soon");
	private JLabel comingSoon3Label = new JLabel("Coming Soon");
	
	//deposit panel
	private JLabel depositTitleLabel = new JLabel("Deposit");
	private JLabel depositExplanationLabel = new JLabel("Please enter the amount");
	private JTextField inputForDeposit = new JTextField();
	
	
	//withdraw panel
	private JLabel withdrawTitleLabel = new JLabel("Withdraw");
	private JLabel withdrawExplanationLabel = new JLabel("Please enter the amout you want to withdraw");
	private JTextField inputForWithdraw = new JTextField();
	
	
	//total balance panel
	private JLabel totalBalanceTitleLabel = new JLabel("Total Balance");
	private JLabel totalBalanceLabel = new JLabel();
	
	
	//login panel
	private JLabel loginTitleLabel = new JLabel("Login to your account.");
	private JTextField cardNumberInputField = new JTextField(5); //5 digit card number
	private JPasswordField pinInputField = new JPasswordField(4); //4 digits allowed
	private JLabel cardInputExplanationLabel = new JLabel("Please enter your 5-digit card number.");
	private JLabel pinInputExplanationLabel = new JLabel("Please enter your 4-digit pin.");
	private JLabel loginInfoLabel = new JLabel("NOTE: You can enter your pin only after you enter your card number.");
	private JLabel failLoginLabel = new JLabel("");
	
	
	/**
	 * Create the application.
	 */
	
	public MainFrame() 
	{
		//add selection and digit buttons to their arraylist
		this.addSelectionButtonsToTheArraylist();
		this.addDigitButtonsToTheArraylist();
		
		
		outputScreen.add("menu", menuPanel);
		outputScreen.add("deposit", depositPanel);
		outputScreen.add("withdraw", withdrawPanel);
		outputScreen.add("balance", showTotalBalancePanel);
		outputScreen.add("login", loginPanel);
		
		changeTheShowingScreen("login", false);
		
		//Login page
		loginPanel.setLayout(null);
		
		loginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginTitleLabel.setBounds(78, 10, 310, 30);
		loginPanel.add(loginTitleLabel);
		
		cardNumberInputField.setBounds(156, 89, 130, 19);
		loginPanel.add(cardNumberInputField);
		
		pinInputField.setBounds(156, 159, 130, 19);
		loginPanel.add(pinInputField);
		
		cardInputExplanationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardInputExplanationLabel.setBounds(105, 66, 283, 13);
		loginPanel.add(cardInputExplanationLabel);
		
		pinInputExplanationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pinInputExplanationLabel.setBounds(126, 135, 189, 13);
		loginPanel.add(pinInputExplanationLabel);
		
		loginInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		loginInfoLabel.setBounds(22, 188, 422, 13);
		loginPanel.add(loginInfoLabel);
		
		failLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		failLoginLabel.setBounds(66, 211, 296, 20);
		loginPanel.add(failLoginLabel);
		
		
		//Menu page
		menuPanel.setLayout(null);
		
		chooseTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chooseTitleLabel.setBounds(89, 10, 263, 44);
		menuPanel.add(chooseTitleLabel);
		
		depositLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositLabel.setBounds(10, 78, 107, 21);
		menuPanel.add(depositLabel);
		
		withdrawLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawLabel.setBounds(10, 139, 86, 21);
		menuPanel.add(withdrawLabel);
		
		balanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		balanceLabel.setBounds(10, 191, 86, 29);
		menuPanel.add(balanceLabel);
		
		comingSoon1Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comingSoon1Label.setBounds(344, 74, 100, 29);
		menuPanel.add(comingSoon1Label);
		
		comingSoon2Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comingSoon2Label.setBounds(344, 135, 100, 29);
		menuPanel.add(comingSoon2Label);
		
		comingSoon3Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comingSoon3Label.setBounds(344, 191, 100, 29);
		menuPanel.add(comingSoon3Label);
		
		
		//Deposit screen
		depositPanel.setLayout(null);
		
		depositTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		depositTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		depositTitleLabel.setBounds(47, 10, 362, 22);
		depositPanel.add(depositTitleLabel);
		
		inputForDeposit = new JTextField();
		inputForDeposit.setBounds(47, 110, 362, 35);
		inputForDeposit.setColumns(10);
		depositPanel.add(inputForDeposit);
		
		depositExplanationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		depositExplanationLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		depositExplanationLabel.setBounds(58, 65, 351, 35);
		depositPanel.add(depositExplanationLabel);
		
		
		//Withdraw screen
		withdrawPanel.setLayout(null);
		
		withdrawTitleLabel.setBounds(155, 10, 146, 22);
		withdrawTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		withdrawTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		withdrawPanel.add(withdrawTitleLabel);
		
		inputForWithdraw.setBounds(45, 101, 367, 30);
		inputForWithdraw.setColumns(10);
		withdrawPanel.add(inputForWithdraw);
		
		withdrawExplanationLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		withdrawExplanationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		withdrawExplanationLabel.setBounds(80, 42, 297, 30);
		withdrawPanel.add(withdrawExplanationLabel);
		
		
		//Total balance screen
		showTotalBalancePanel.setLayout(null);
		
		totalBalanceTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		totalBalanceTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalBalanceTitleLabel.setBounds(77, 22, 293, 32);
		showTotalBalancePanel.add(totalBalanceTitleLabel);
		
		totalBalanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalBalanceLabel.setBounds(10, 81, 293, 32);
		showTotalBalancePanel.add(totalBalanceLabel);
		
		
		//Initial frame
		outputScreen.setBackground(new Color(204, 255, 255));
		outputScreen.setBounds(167, 34, 454, 241);
		startingPanel.add(outputScreen);
		
		
		firstSelectionButton.setBackground(new Color(204, 255, 255));
		firstSelectionButton.setBounds(38, 114, 85, 21);
		startingPanel.add(firstSelectionButton);
		
		secondSelectionButton.setBackground(new Color(204, 255, 255));
		secondSelectionButton.setBounds(38, 172, 85, 21);		
		startingPanel.add(secondSelectionButton);
		
		thirdSelectionButton.setBackground(new Color(204, 255, 255));
		thirdSelectionButton.setBounds(38, 233, 85, 21);
		startingPanel.add(thirdSelectionButton);
		
		fourthSelectionButton.setBackground(new Color(204, 255, 255));
		fourthSelectionButton.setBounds(675, 114, 85, 21);
		fourthSelectionButton.setEnabled(false);
		startingPanel.add(fourthSelectionButton);
		
		fifthSelectionButton.setBackground(new Color(204, 255, 255));
		fifthSelectionButton.setBounds(675, 172, 85, 21);
		fifthSelectionButton.setEnabled(false);
		startingPanel.add(fifthSelectionButton);
		
		sixthSelectionButton.setBackground(new Color(204, 255, 255));
		sixthSelectionButton.setBounds(675, 233, 85, 21);
		sixthSelectionButton.setEnabled(false);
		startingPanel.add(sixthSelectionButton);
		
		digitButton1.setBackground(new Color(204, 255, 255));
		digitButton1.setBounds(167, 300, 85, 21);
		startingPanel.add(digitButton1);
		
		digitButton2.setBackground(new Color(204, 255, 255));
		digitButton2.setBounds(262, 300, 85, 21);
		startingPanel.add(digitButton2);
		
		digitButton3.setBackground(new Color(204, 255, 255));
		digitButton3.setBounds(357, 300, 85, 21);
		startingPanel.add(digitButton3);
		
		digitButton4.setBackground(new Color(204, 255, 255));
		digitButton4.setBounds(167, 328, 85, 21);
		startingPanel.add(digitButton4);
		
		digitButton5.setBackground(new Color(204, 255, 255));
		digitButton5.setBounds(262, 328, 85, 21);
		startingPanel.add(digitButton5);
		
		digitButton6.setBackground(new Color(204, 255, 255));
		digitButton6.setBounds(357, 328, 85, 21);
		startingPanel.add(digitButton6);
		
		digitButton7.setBackground(new Color(204, 255, 255));
		digitButton7.setBounds(167, 359, 85, 21);
		startingPanel.add(digitButton7);
		
		digitButton8.setBackground(new Color(204, 255, 255));
		digitButton8.setBounds(262, 359, 85, 21);
		startingPanel.add(digitButton8);
		
		digitButton9.setBackground(new Color(204, 255, 255));
		digitButton9.setBounds(357, 359, 85, 21);
		startingPanel.add(digitButton9);
		
		digitButton0.setBackground(new Color(204, 255, 255));
		digitButton0.setBounds(262, 390, 85, 21);
		startingPanel.add(digitButton0);
		
		clearButton.setForeground(new Color(0, 0, 0));
		clearButton.setBackground(new Color(255, 0, 0));
		clearButton.setBounds(536, 300, 85, 21);	
		startingPanel.add(clearButton);
		
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 0, 0));
		backButton.setBounds(536, 328, 85, 21);
		startingPanel.add(backButton);
		
		okButton.setBackground(new Color(0, 204, 0));
		okButton.setBounds(536, 359, 85, 21);
		startingPanel.add(okButton);
				
		
		//add action listeners to the buttons
		ButtonListener listener = new ButtonListener();
		
		this.firstSelectionButton.addActionListener(listener);
		this.secondSelectionButton.addActionListener(listener);
		this.thirdSelectionButton.addActionListener(listener);
		this.backButton.addActionListener(listener);
		this.okButton.addActionListener(listener);
		this.clearButton.addActionListener(listener);
		this.digitButton1.addActionListener(listener);
		this.digitButton2.addActionListener(listener);
		this.digitButton3.addActionListener(listener);
		this.digitButton4.addActionListener(listener);
		this.digitButton5.addActionListener(listener);
		this.digitButton6.addActionListener(listener);
		this.digitButton7.addActionListener(listener);
		this.digitButton8.addActionListener(listener);
		this.digitButton9.addActionListener(listener);
		this.digitButton0.addActionListener(listener);

		
		//settings for the main panel
		startingPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		startingPanel.setLayout(null);
		startingPanel.setBackground(new Color(0, 255, 204));

		this.setContentPane(startingPanel);
		
		this.setVisible(true);
		this.setSize(800, 500);
		this.setTitle("Moschou Bank");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	//disable all the available selection buttons
	private void disableSelectionButtons()
	{
		this.firstSelectionButton.setEnabled(false);
		this.secondSelectionButton.setEnabled(false);
		this.thirdSelectionButton.setEnabled(false);
	}
	
	
	//Only for a single button
	private void disableSelectionButton(JButton aButton)
	{
		aButton.setEnabled(false);
	}
	
	
	//Enable all the available selection buttons...I do not use the arraylist because at this time there are not all buttons available
	private void enableSelectionButtons()
	{
		this.firstSelectionButton.setEnabled(true);
		this.secondSelectionButton.setEnabled(true);
		this.thirdSelectionButton.setEnabled(true);
	}
	
	
	//Only for a single button
	private void enableSelectionButton(JButton aButton)
	{
		aButton.setEnabled(true);
	}
	
	
	//Disable the digit buttons because I do not want to be pressed at the main page of the atm
	private void disableDigitButtons()
	{
		for(JButton d : digitButtons)
			d.setEnabled(false);
	}
	
	
	//enable the digit buttons
	private void enableDigitButtons()
	{
		for(JButton d : digitButtons)
			d.setEnabled(true);
	}
	
	
	private void updateBalanceScreen()
	{
		totalBalanceLabel.setText("Your total balance is: " + Integer.toString(myUser.getTotalBalance()));
	}
	
	
	private void changeTheShowingScreen(String screenName, boolean enableSelectionButtons)
	{
		changeScreens.show(outputScreen, screenName);
		currentShowingScreen = screenName;
		
		if(enableSelectionButtons)
			enableSelectionButtons();
		else
			disableSelectionButtons();
	}
	
	
	private String getPinFromInputField()
	{
		String retPin = "";
		
		for(char c : pinInputField.getPassword())
			retPin += c;
		
		return retPin;
	}
	
	
	
	//call this only inside the constructor
	private void addSelectionButtonsToTheArraylist()
	{
		this.selectionButtons.add(firstSelectionButton);
		this.selectionButtons.add(secondSelectionButton);
		this.selectionButtons.add(thirdSelectionButton);
		this.selectionButtons.add(fourthSelectionButton);
		this.selectionButtons.add(fifthSelectionButton);
		this.selectionButtons.add(sixthSelectionButton);
	}
	
	
	//call this only inside the constructor
	private void addDigitButtonsToTheArraylist()
	{
		this.digitButtons.add(digitButton1);
		this.digitButtons.add(digitButton2);
		this.digitButtons.add(digitButton3);
		this.digitButtons.add(digitButton4);
		this.digitButtons.add(digitButton5);
		this.digitButtons.add(digitButton6);
		this.digitButtons.add(digitButton7);
		this.digitButtons.add(digitButton8);
		this.digitButtons.add(digitButton9);
		this.digitButtons.add(digitButton0);
	}
	
	
	
	//listener class
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			checkTheSourceOfEvent(e);
		}
		
		
		private void checkTheSourceOfEvent(ActionEvent e)
		{
			/* NOTE: When user is on menu page and he presses the back button
			 * he will not be directed to login page. In order to go 
			 * to the login page he must close the app and open it again.
			 */
			
			
			//this section can be implemented better
			if(e.getSource().equals(firstSelectionButton) && myUser != null)
			{
				changeTheShowingScreen("deposit", false);
				enableDigitButtons();
				inputForDeposit.setText(""); //clear the input from previous transactions
				return; //in order not to continue to check for events
			}
			
			
			if(e.getSource().equals(secondSelectionButton) && myUser != null)
			{
				changeTheShowingScreen("withdraw", false);
				enableDigitButtons();
				inputForWithdraw.setText("");
				return;
			}
			
			
			if(e.getSource().equals(thirdSelectionButton) && myUser != null)
			{
				updateBalanceScreen();
				changeTheShowingScreen("balance", false);
				disableDigitButtons();
				return;
			}
			
			
			if(e.getActionCommand().equals("Back") && myUser != null)
			{
				changeTheShowingScreen("menu", true);
				disableDigitButtons();
				return;
			}
			
			
			if(e.getActionCommand().equals("Clear") && currentShowingScreen.equals("login"))
			{
				//clear both card input and pin input fields
				cardNumberInputField.setText("");
				pinInputField.setText("");
				return;
			}
			
			
			if(e.getActionCommand().equals("Clear") && currentShowingScreen.equals("withdraw"))
			{
				inputForWithdraw.setText("");
				enableDigitButtons();
				return;
			}
			
			
			if(e.getActionCommand().equals("Clear") && currentShowingScreen.equals("deposit"))
			{
				inputForDeposit.setText("");
				enableDigitButtons();
				return;
			}
			
			
			//check if event came from number buttons
			boolean isADigitButton = false;
			JButton selecDigitButton = null;
			
			for(JButton digButton : digitButtons)
			{
				if(e.getSource().equals(digButton))
				{
					selecDigitButton = digButton;
					isADigitButton = true;
					break;
				}
			}
			
			
			if(isADigitButton && currentShowingScreen.equals("login"))
			{
				
				String inputCardAsAString = cardNumberInputField.getText();
				String inputPinAsAString = getPinFromInputField();
				
				//This means that user did not entered the card number and as a result he cannot enter the pin until he enters the card number
				//The password field will be filled after the successful input of the card number
				if(inputCardAsAString.length() == 0)
				{
					cardNumberInputField.setText(selecDigitButton.getText());
					return;
				}
				
				if(inputCardAsAString.length() < Bank.CARDNUMBERLENGTH)
				{
					cardNumberInputField.setText(inputCardAsAString + selecDigitButton.getText());
					return;
				}
				
				if(inputPinAsAString.length() == 0)
				{
					pinInputField.setText(selecDigitButton.getText());
					return;
				}
				else
				{
					pinInputField.setText(inputPinAsAString + selecDigitButton.getText());
					return;
				}
			}
			
			
			if(isADigitButton && currentShowingScreen.equals("deposit"))
			{
				//get the digit value and show it to the textfield of the screen
				String givenAmountForDeposit = inputForDeposit.getText();
				
				if(givenAmountForDeposit.length() == 0)
				{
					inputForDeposit.setText(selecDigitButton.getText());
					return;
				}
				else
				{
					inputForDeposit.setText(givenAmountForDeposit + selecDigitButton.getText());
					return;					
				}
			}
			
			
			if(isADigitButton && currentShowingScreen.equals("withdraw"))
			{
				String givenAmountForWithdraw = inputForWithdraw.getText();
				
				if(givenAmountForWithdraw.length() == 0)
				{
					inputForWithdraw.setText(selecDigitButton.getText());
					return;
				}
				else
				{
					inputForWithdraw.setText(givenAmountForWithdraw + selecDigitButton.getText());
					return;
				}
				
			}
			
			
			//If user presses ok and we are on withdraw then we withdraw the amount of the account
			//Otherwise if we are on deposit we add the amount to the account.Last but not
			//least if we are on login page and he presses ok we take the credentials and
			//if they implement some specifications then I check if there is a user with
			//those credentials otherwise if there is not a user nothing will happen on the screen
			
			
			if(e.getSource().equals(okButton) && currentShowingScreen.equals("login"))
			{
				User loggedUser = null;
				String enteredCardNumber = cardNumberInputField.getText();
				String enteredPin = getPinFromInputField();
				int loggedUserCardNumber;
				
				
				if(enteredCardNumber.length() == Bank.CARDNUMBERLENGTH && enteredPin.length() == Bank.PINLENGTH)
				{
					loggedUser = Bank.validateUser(enteredCardNumber, enteredPin);
				}
				
				if(loggedUser == null)
				{
					failLoginLabel.setText("Enter a 5 digit card number and a 4 digit pin");
					return;
				}
				
				//card number with value of 0 means user does not found in the database
				//and card number with the value of -1 means that there is an error with the database
				//or maybe the database server is turned off
				loggedUserCardNumber = loggedUser.getCardNumber();
				
				if(loggedUserCardNumber != 0 && loggedUserCardNumber != -1)
				{
					myUser = loggedUser;
					changeTheShowingScreen("menu", true);
				}
				else if(loggedUserCardNumber == 0)
					failLoginLabel.setText("Wrong Credentials");
				else
					failLoginLabel.setText("Error with the database. Contact the administrator");
				
			}
			else if(e.getSource().equals(okButton) && currentShowingScreen.equals("withdraw"))
			{
				int wantedAmount = Integer.parseInt(inputForWithdraw.getText());
				
				String msg = myUser.withdraw(wantedAmount);
				inputForWithdraw.setText(msg);
				disableDigitButtons();
				updateBalanceScreen();
							
			}
			else if(e.getSource().equals(okButton) && currentShowingScreen.equals("deposit"))
			{
				int givenAmount = Integer.parseInt(inputForDeposit.getText());
				
				String msg = myUser.deposit(givenAmount);
				inputForDeposit.setText(msg);
				disableDigitButtons();
				updateBalanceScreen();
					
			}	
		}
	}
}

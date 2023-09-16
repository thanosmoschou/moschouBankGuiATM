### Welcome to Moschou Bank

This is our atm. Feel free to use it! 

### 📷 Screenshots
#### Login process
![Login](screenshots/image1.png) <br>
![Interface](screenshots/image2.png) <br>

#### Main Window
![Interface](screenshots/image3.png)

### How to run it
Double click on the jar file just like you would do for an .exe file. <br>
Make sure you have Java installed on your computer. <br>
Also you need a mysql server installed on your pc (find a tutorial about how to set it up). <br>
Enable the server and run the code from the ```dbCreation.sql``` script (search online how to do it). <br> 
I used xampp package in my pc which has a mysql server pre-installed. <br>
App uses the following creadentials which are xampp's default user credentials: <br>


Username: ```root``` <br>
Password: ```(Here xampp does not contain any password. It is just an empty string)``` <br>

Those credentials are unsafe. In real life make sure you'll create a user with the least amount of privileges. <br>
If you use mysql server create a simple user with only the necessary privileges for your database. <br>
Then change the login credentials in the source code of the project. (Those will not be applied to the runnable jar. You will need to create it again). 
If you use xampp make sure you will run the code of the ```dbCreation.sql``` script on ```phpmyadmin``` page of xampp (On the xampp panel start both apache server
and mysql server and then press the admin button next to MySQL module. Go to the field where you can run your sql code and paste the code from the file. Then go down and press the execute button.) <br>
If you use xampp you will need to enable only the mysql server but if you want to track the database you will need to enable the apache server also.
The source code of the project is also provided if you want to import it to an IDE and run it from there (It is an Eclipse project). <br><br>

### How it works
User enters his card number and after that he enters the pin. <br>
Only deposit, withdraw and show balance operations are implemented. <br>
In every successful transaction, app will update the users table of the database. <br>

You can use my test account: <br><br>
Card Number: ```11111``` <br>
Pin: ```1234``` <br><br>

### Possible improvements
The following statements are some suggestions for improvement:

Create card activation and change pin processes. <br>
Enter more customers to the app. <br>
Make use of encryption algorithms in order to make the credentials more secure. <br>
With 3 failed attemps to login, system will lock user's account and administrator must unlock the account from the database. <br>

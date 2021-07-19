# ProjectManager-Database
A program used to add and store given architecture projects in a MySQL Database

This program will be exactly the same as my ProjectManagement program, which will contain the initial menu options below:

1. Add new Project
2. View non-finalized Projects
3. View Projects past due date
4. Edit or Finalise Project
5. Display all Projects

Each selection will have its own sub-menu.

The difference between this program and the ProjectManagement program, is that this program will make use of retreiving and storing data from a MySQL database instead of a text file.

Please feel free to read through the ProjectManagement's README file for more regarding this program's functionality.

## How to use the program

Download MySQL
Create your database
Create your tables:

- Customer, Contractor, Architect (replace user with these titles accordingly for each table): 
projectNumber, int, NOT NULL, UNIQUE
projectName, varchar(255)
userName, varchar(255)
userSurname, varchar(255)
userTelNumber, varchar(255)
userEmail, varchar(255)
userAddress, varchar(255)

- Project:
projectNumber, int, NOT NULL, UNIQUE
projectName, varchar(255)
buildingType, varchar(255)
address, varchar(255)
erfNumber, int
totalFee, float
paidToDate, float
dealine, varchar(255)
finalized, varchar(255)

Connect your local computer to the database (the comments in the program will guide accordingly):

Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:1234// /poisepms?useSSL=false", "username","password"
				);
        
Replace 1234, username and password accordingly        


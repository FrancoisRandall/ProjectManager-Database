import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DatabasePoised {

	public static void main(String[] args) {
		
		try {
			
			// Connect to the ebookstore database, via the jdbc:mysql: channel on localhost (this PC)
			// Use username "otheruser", password "swordfish".
									
			Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/poisepms?useSSL=false", "otheruser","swordfish"
				);
									
			// Create a direct line to the database for running our queries
									
			Statement statement = connection.createStatement();
			ResultSet results;
			int rowsAffected;
			
			// Display start menu to provide user actions
			// Request user input
			
			System.out.print("Welcome to your Project Manager\n\n");
			
			System.out.print("Choose an action below:\n\n"
					+ "1. Add new Project\n"
					+ "2. View non-finalized Projects\n"
					+ "3. View Projects past due date\n"
					+ "4. Edit or Finalise Project\n"
					+ "5. Display all Projects\n\n"
					+ "Selection: ");	
			Scanner menuScanner = new Scanner(System.in);
			int menuSelection = menuScanner.nextInt();
			
			// Add new Project
			
			if(menuSelection == 1) {
				
				// Request user input for Customer details
				
				System.out.print("\nCustomer Details: \n\n");
				
				Scanner input = new Scanner(System.in);
				
				System.out.print("Enter Name here: \n");	
		        input = new Scanner(System.in); 
				String customerName = input.nextLine();
				
				System.out.print("Enter Surname here: \n");	
		        input = new Scanner(System.in); 
				String customerSurname = input.nextLine();
								
				System.out.print("Enter Telephone Number here: \n");	
		        input = new Scanner(System.in); 
				String customerTelNumber = input.nextLine();

				System.out.print("Enter email here: \n");	
		        input = new Scanner(System.in); 
				String customerEmail = input.nextLine();
				
				System.out.print("Enter address here: \n");	
		        input = new Scanner(System.in); 
				String customerAddress = input.nextLine();

				// Create 'Customer' objects
				// User input will be stored in variables and will be stored in the below variable as follows
				
				DatabaseCustomer customer = new DatabaseCustomer(customerName, customerSurname, customerTelNumber, customerEmail, customerAddress);
				
				// Request user input for Contractor details
				
				System.out.print("\nContractor Details: \n\n");
				
				Scanner contractorInput = new Scanner(System.in);
				
				System.out.print("Enter Name here: \n");	
		        contractorInput = new Scanner(System.in); 
				String contractorName = contractorInput.nextLine();
				
				System.out.print("Enter Surname here: \n");	
		        contractorInput = new Scanner(System.in); 
				String contractorSurname = contractorInput.nextLine();
								
				System.out.print("Enter Telephone Number here: \n");	
		        contractorInput = new Scanner(System.in); 
				String contractorTelNumber = contractorInput.nextLine();

				System.out.print("Enter email here: \n");	
		        contractorInput = new Scanner(System.in); 
				String contractorEmail = contractorInput.nextLine();
				
				System.out.print("Enter address here: \n");	
		        contractorInput = new Scanner(System.in); 
				String contractorAddress = contractorInput.nextLine();

				// Create 'Contractor' objects
				
				DatabaseContractor contractor = new DatabaseContractor(contractorName, contractorSurname, contractorTelNumber, contractorEmail, contractorAddress);

				// Request user input for Architect details
				
				System.out.print("\nArchitect Details: \n\n");
				
				Scanner architectInput = new Scanner(System.in);
				
				System.out.print("Enter Name here: \n");	
		        architectInput = new Scanner(System.in); 
				String architectName = architectInput.nextLine();
				
				System.out.print("Enter Surname here: \n");	
		        architectInput = new Scanner(System.in); 
				String architectSurname = architectInput.nextLine();
								
				System.out.print("Enter Telephone Number here: \n");	
		        architectInput = new Scanner(System.in); 
				String architectTelNumber = architectInput.nextLine();

				System.out.print("Enter email here: \n");	
		        architectInput = new Scanner(System.in); 
				String architectEmail = architectInput.nextLine();
				
				System.out.print("Enter address here: \n");	
		        architectInput = new Scanner(System.in); 
				String architectAddress = architectInput.nextLine();

				// Create 'Customer' objects
				
				DatabaseArchitect architect = new DatabaseArchitect(architectName, architectSurname, architectTelNumber, architectEmail, architectAddress);
				
				// Declare project variable values
				// Request user input
				
				System.out.print("\nProject Details: \n\n");
				
				Scanner selection = new Scanner(System.in);

				System.out.print("Enter Project Number here: \n");	
				selection = new Scanner(System.in); 
				int projectNumber = selection.nextInt();
				
				System.out.print("Enter Project Name here: \n");	
				selection = new Scanner(System.in); 
				String projectName = selection.nextLine();
				
				System.out.print("Enter Building Type here: \n");	
				selection = new Scanner(System.in); 
				String projectBuildingType = selection.nextLine();
				
				System.out.print("Enter Project Address here: \n");	
				selection = new Scanner(System.in); 
				String projectAddress = selection.nextLine();
				
				System.out.print("Enter ERF Number here: \n");	
				selection = new Scanner(System.in); 
				int projectErfNumber = selection.nextInt();
				
				System.out.print("Enter Total Project fee here: \n");	
				selection = new Scanner(System.in); 
				double projectTotalFee = selection.nextDouble();
				
				System.out.print("Enter Paid to Date amount here: \n");	
				selection = new Scanner(System.in); 
				double projectPaidToDate = selection.nextDouble();
								
				System.out.print("Enter Deadline here(yyyy-mm-dd): \n");	
				selection = new Scanner(System.in); 
				String projectDeadline = selection.nextLine();
												
				String finalised = "No";
				
				// If project name  is not given, then it should be named after the building type and surname of the customer
				
				if(projectName == "") {
					projectName = projectBuildingType + " " + customerSurname;
				}
	
				// Create Project objects		
				// User input will be stored in variables and will be stored in the below variable as follows
				
				DatabaseProject house = new DatabaseProject(projectNumber, projectName, projectBuildingType, projectAddress, projectErfNumber, 
														projectTotalFee, projectPaidToDate, projectDeadline, finalised);
		
				// The objects are used to print to the user
				
				System.out.print("\nThe following details have successfully been recorded:\n\nProject Details:\n\n" + house);
				System.out.print("\n\nCustomer:\n\n" + customer);
				System.out.print("Contractor:\n\n" + contractor);
				System.out.print("Architect:\n\n" + architect);
					
					// Write project details to project file
					
					rowsAffected = statement.executeUpdate("INSERT INTO projectManager VALUES(" + projectNumber + ", '" + projectName + 
							"', '" + projectBuildingType + "', '" + projectAddress + "', " + projectErfNumber + ", " + projectTotalFee + 
							", " + projectPaidToDate + ", '" + projectDeadline + "', '" + finalised + "')");
					
					// Write data to the customers file
					// The Project Name and Number is included for when the user needs to select a project 
					
					rowsAffected = statement.executeUpdate("INSERT INTO customers VALUES(" + projectNumber + ", '" + projectName + 
							"', '" + customerName + "', '" + customerSurname + "', '" + customerTelNumber + "', '" + customerEmail + 
							"', '" + customerAddress + "')");
					
					// Write data to the contractors file
					
					rowsAffected = statement.executeUpdate("INSERT INTO contractor VALUES(" + projectNumber + ", '" + projectName + 
							"', '" + contractorName + "', '" + contractorSurname + "', '" + contractorTelNumber + "', '" + contractorEmail + 
							"', '" + contractorAddress + "')");
					
					// Write data to the architects file
					
					rowsAffected = statement.executeUpdate("INSERT INTO architect VALUES(" + projectNumber + ", '" + projectName + 
							"', '" + architectName + "', '" + architectSurname + "', '" + architectTelNumber + "', '" + architectEmail + 
							"', '" + architectAddress + "')");				
			}
			
			// View non-finalized projects
			
			else if(menuSelection == 2) {
				
				// Print data if finalized's value is No
				
				ResultSet nonFinalized = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, erfNumber, "
						+ "totalFee, paidToDate, deadline, finalized FROM projectManager"
						+ " WHERE finalized = 'No'");
				System.out.println("\nNon-finalized projects:");
				while (nonFinalized.next()) {
					System.out.println(
					"\nProject Number: " + nonFinalized.getInt("projectNumber") +
					"\nProject Name: " + nonFinalized.getString("projectName") +
					"\nBuilding Type: " + nonFinalized.getString("buildingType") +
					"\nAddress: " + nonFinalized.getString("address") +
					"\nERF Number: " + nonFinalized.getInt("erfNumber") +
					"\nTotal Fee: R" + nonFinalized.getDouble("totalFee") +
					"\nPaif To Date: R" + nonFinalized.getDouble("paidToDate") +
					"\nDeadline: " + nonFinalized.getString("deadline") +
					"\nFinalized: " + nonFinalized.getString("finalized")
					);
					}
			}
			
			// View all overdue projects
			
			else if(menuSelection == 3) {
				
				// Print data is current date is 'greater than' deadline

				ResultSet overdue = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, erfNumber, "
						+ "totalFee, paidToDate, deadline, finalized FROM projectManager WHERE CURDATE() > deadline");
				System.out.println("\nOverdue projects:");
				while (overdue.next()) {
					System.out.println(
					"\nProject Number: " + overdue.getInt("projectNumber") +
					"\nProject Name: " + overdue.getString("projectName") +
					"\nBuilding Type: " + overdue.getString("buildingType") +
					"\nAddress: " + overdue.getString("address") +
					"\nERF Number: " + overdue.getInt("erfNumber") +
					"\nTotal Fee: R" + overdue.getDouble("totalFee") +
					"\nPaif To Date: R" + overdue.getDouble("paidToDate") +
					"\nDeadline: " + overdue.getString("deadline") +
					"\nFinalized: " + overdue.getString("finalized")
					);
					}
				}
			
			// Edit or Finalize project
			
			else if(menuSelection == 4) {
				
					String editSelection = "";
					String setValue = "";
					
					// Request user input
					// nameNumberValue variable will be used when updating details later on
					
					System.out.print("\nEnter your Project Number or your Project Name.\n\n"
							+ "1. Project Number\n"
							+ "2. Project Name\n\n"
							+ "Selection: ");
					Scanner nameNumber = new Scanner(System.in);
					int nameNumberValue = nameNumber.nextInt();
					
					// Request user input for project name or project number
										
					if(nameNumberValue == 1) {
						setValue = "projectNumber";
						System.out.print("\nProject Number: ");	
						Scanner scnr = new Scanner(System.in);
						editSelection = scnr.nextLine();
					}
					else if(nameNumberValue == 2) {
						setValue = "projectName";
						System.out.print("\nPlease be sure to spell it exactly the way you entered it initially.\n\nProject Name: ");	
						Scanner scnr = new Scanner(System.in);
						editSelection = scnr.nextLine();
					}
					else {
						System.out.print("You did not select an appropriate option!");
					}
					
					// Print project associated with above user input
										
					ResultSet editData = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, erfNumber, "
							+ "totalFee, paidToDate, deadline, finalized FROM projectManager "
							+ "WHERE " + setValue + " = '" + editSelection + "'");
					while (editData.next()) {
						System.out.println(
								"\nProject Number: " + editData.getInt("projectNumber") +
								"\nProject Name: " + editData.getString("projectName") +
								"\nBuilding Type: " + editData.getString("buildingType") +
								"\nAddress: " + editData.getString("address") +
								"\nERF Number: " + editData.getInt("erfNumber") +
								"\nTotal Fee: R" + editData.getDouble("totalFee") +
								"\nPaif To Date: R" + editData.getDouble("paidToDate") +
								"\nDeadline: " + editData.getString("deadline") +
								"\nFinalized: " + editData.getString("finalized")
						);
						}
					
					// Request if user wishes to edit or finalize the selected project
					
					System.out.print("\nDo you wish to edit or finalize this project?"
							+ "\n1. Edit"
							+ "\n2. Finalize"
							+ "\n\nSelection: ");	
					Scanner scnr1 = new Scanner(System.in);
					int editChoice = scnr1.nextInt();
					
					// Edit
					
					if(editChoice == 1) {
						
						System.out.print("\nWhat would you like to edit?(select number)"
								+ "\n1. Project Number"
								+ "\n2. Project Name"
								+ "\n3. Building Type"
								+ "\n4. Project Address"
								+ "\n5. ERF number"
								+ "\n6. Total Amount"
								+ "\n7. Paid to Date Amount"
								+ "\n8. Due Date"
								+ "\n\nSelection: ");	
						Scanner scnr2 = new Scanner(System.in);
						int edit = scnr2.nextInt();
						
						// Request user input to update the option selected above
						// Updates variable value to the user's input
						
						// Project Number

						if(edit == 1) {
											
							System.out.print("\nEnter new Project Number: ");	
							Scanner scnr3 = new Scanner(System.in);
							int newProjectNumber = scnr3.nextInt();
							
							rowsAffected = statement.executeUpdate(
									"UPDATE projectManager "
									+ "SET projectNumber  = " +  newProjectNumber
									+ " WHERE " + setValue + " = '" + editSelection + "'");
							System.out.println("\nUpdate recorded, " + rowsAffected + " rows updated.\n");
							printAllFromProjectManager(statement);
							
							// Customer
							
							rowsAffected = statement.executeUpdate(
									"UPDATE customers "
									+ "SET projectNumber  = " +  newProjectNumber
									+ " WHERE " + setValue + " = '" + editSelection + "'");
							
							// Architect
							
							rowsAffected = statement.executeUpdate(
									"UPDATE architect "
									+ "SET projectNumber  = " +  newProjectNumber
									+ " WHERE " + setValue + " = '" + editSelection + "'");
							
							// Contractor
							
							rowsAffected = statement.executeUpdate(
									"UPDATE contractor "
									+ "SET projectNumber  = " +  newProjectNumber
									+ " WHERE " + setValue + " = '" + editSelection + "'");
						}
						
						// Project Name

						else if(edit == 2) {
														
							System.out.print("\nEnter new Project Name: ");	
							Scanner scnr4 = new Scanner(System.in);
							String newProjectName = scnr4.nextLine();

							rowsAffected = statement.executeUpdate(
									"UPDATE projectManager "
									+ "SET projectName  = '" +  newProjectName
									+ "' WHERE " + setValue + " = '" + editSelection + "'");
							System.out.println("\nUpdate recorded, " + rowsAffected + " rows updated.\n");
							printAllFromProjectManager(statement);
							
							// Customer
							
							rowsAffected = statement.executeUpdate(
									"UPDATE customers "
									+ "SET projectName  = '" +  newProjectName
									+ "' WHERE " + setValue + " = '" + editSelection + "'");
							
							// Architect
							
							rowsAffected = statement.executeUpdate(
									"UPDATE architect "
									+ "SET projectName  = '" +  newProjectName
									+ "' WHERE " + setValue + " = '" + editSelection + "'");
							
							// Contractor
							
							rowsAffected = statement.executeUpdate(
									"UPDATE contractor "
									+ "SET projectName  = '" +  newProjectName
									+ "' WHERE " + setValue + " = '" + editSelection + "'");
						}
						
						// Building type
						
						else if(edit == 3) {
							
							System.out.print("\nEnter new Building Type: ");	
							Scanner scnr5 = new Scanner(System.in);
							String newBuildingType = scnr5.nextLine();

							rowsAffected = statement.executeUpdate(
									"UPDATE projectManager "
									+ "SET buildingType  = '" +  newBuildingType
									+ "' WHERE " + setValue + " = '" + editSelection + "'");
							System.out.println("\nUpdate recorded, " + rowsAffected + " rows updated.\n");
							printAllFromProjectManager(statement);
						}
						
						// Project address
						
						else if(edit == 4) {
							System.out.print("\nEnter new Project Address: ");	
							Scanner scnr6 = new Scanner(System.in);
							String newProjectAddress = scnr6.nextLine();

							rowsAffected = statement.executeUpdate(
									"UPDATE projectManager "
									+ "SET address  = '" +  newProjectAddress
									+ "' WHERE " + setValue + " = '" + editSelection + "'");
							System.out.println("\nUpdate recorded, " + rowsAffected + " rows updated.\n");
							printAllFromProjectManager(statement);
						}
						
						// ERF Number
						
						else if(edit == 5) {
							System.out.print("\nEnter new ERF Number: ");	
							Scanner scnr7 = new Scanner(System.in);
							int newErfNumber = scnr7.nextInt();

							rowsAffected = statement.executeUpdate(
									"UPDATE projectManager "
									+ "SET erfNumber  = " +  newErfNumber
									+ " WHERE " + setValue + " = '" + editSelection + "'");
							System.out.println("\nUpdate recorded, " + rowsAffected + " rows updated.\n");
							printAllFromProjectManager(statement);
						}
						
						// Total Fee
						
						else if(edit == 6) {
							System.out.print("\nEnter new Total Amount: ");	
							Scanner scnr8 = new Scanner(System.in);
							double newTotalAmount = scnr8.nextDouble();

							rowsAffected = statement.executeUpdate(
									"UPDATE projectManager "
									+ "SET totalFee  = " +  newTotalAmount
									+ " WHERE " + setValue + " = '" + editSelection + "'");
							System.out.println("\nUpdate recorded, " + rowsAffected + " rows updated.\n");
							printAllFromProjectManager(statement);
						}
						
						// Paid to date
						
						else if(edit == 7) {
							System.out.print("\nEnter new Paid to Date: ");	
							Scanner scnr9 = new Scanner(System.in);
							double newPaidToDate = scnr9.nextDouble();

							rowsAffected = statement.executeUpdate(
									"UPDATE projectManager "
									+ "SET paidToDate  = " +  newPaidToDate
									+ " WHERE " + setValue + " = '" + editSelection + "'");
							System.out.println("\nUpdate recorded, " + rowsAffected + " rows updated.\n");
							printAllFromProjectManager(statement);
						}
						
						// Deadline
						
						else if(edit == 8) {
							System.out.print("\nEnter new Due Date(yyyy-mm-dd): ");	
							Scanner scnr10 = new Scanner(System.in);
							String newDueDate = scnr10.nextLine();

							rowsAffected = statement.executeUpdate(
									"UPDATE projectManager "
									+ "SET deadline  = '" +  newDueDate
									+ "' WHERE " + setValue + " = '" + editSelection + "'");
							System.out.println("\nUpdate recorded, " + rowsAffected + " rows updated.\n");
							printAllFromProjectManager(statement);
						}
						else {
							System.out.print("You did not enter a valid option!");		
						}
			}	
					
					// Finalize project
					
					else if(editChoice == 2) {
						
						SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
						Date currentDate = new Date();
						String curDate = formatDate.format(currentDate);
											
						rowsAffected = statement.executeUpdate(
								"UPDATE projectManager "
								+ "SET finalized = 'Yes'"
								+  " WHERE " + setValue + " = '" + editSelection + "'");
						System.out.print("\nProject successfully finalized: " + curDate + "\nCustomer Details:\n");
						
						// Print customer's details associated with project
						
						ResultSet invoicePrint = statement.executeQuery("SELECT projectNumber, projectName, customerName, customerSurname, customerTelNumber, "
								+ "customerEmail, customerAddress FROM customers WHERE " + setValue + " = '" + editSelection + "'");
						while (invoicePrint.next()) {
							System.out.println(
							"\nName: " + invoicePrint.getString("customerName") + 
							"\nSurname: " + invoicePrint.getString("customerSurname") + 
							"\nTel Number: " + invoicePrint.getString("customerTelNumber") + 
							"\nEmail: " + invoicePrint.getString("customerEmail") +
							"\nAddress: " + invoicePrint.getString("customerAddress")
							);
							}
						
						// Calculate and print invoice to user
						
						ResultSet invoiceCalculation = statement.executeQuery("SELECT totalFee, paidToDate, totalFee - paidToDate"
								+ " AS invoice FROM projectManager WHERE " + setValue + " = '" + editSelection + "'");
						while (invoiceCalculation.next()) {
							System.out.println(
							"\nTotal Fee: R" + invoiceCalculation.getString("totalFee") +
							"\nPaid To Date: R" + invoiceCalculation.getString("paidToDate") +
							"\n\nInvoice: R" + invoiceCalculation.getString("invoice")
							);
						}
					}
			else {
				System.out.print("\nYou did not enter a valid option!");
			}
		}
			
			// Display all projects
			
			else if(menuSelection == 5) {
				printAllFromProjectManager(statement);
			}
			else {
				System.out.print("\nYou did not select an appropriate option!");
			}
		}
		// Print relevant messages to user if incorrect data was entered
		
		catch(InputMismatchException i) {
			System.out.println("The input provided was not an integer");
		}
		catch(NoSuchElementException n) {
			System.out.println("No new line found");
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		} 	
	}
	
	/**
	* Method printing all values in all rows.
	* Takes a statement to try to avoid spreading DB access too far.
	*
	* @param a statement on an existing connection
	* @throws SQLException
	*/
	
	// Method to print all projects

	public static void printAllFromProjectManager(Statement statement) throws SQLException{
		ResultSet results = statement.executeQuery("SELECT projectNumber, projectName, buildingType, address, erfNumber, "
				+ "totalFee, paidToDate, deadline, finalized FROM projectManager");
		while (results.next()) {
			System.out.println(
					"\nProject Number: " + results.getInt("projectNumber") +
					"\nProject Name: " + results.getString("projectName") +
					"\nBuilding Type: " + results.getString("buildingType") +
					"\nAddress: " + results.getString("address") +
					"\nERF Number: " + results.getInt("erfNumber") +
					"\nTotal Fee: R" + results.getDouble("totalFee") +
					"\nPaid To Date: R" + results.getDouble("paidToDate") +
					"\nDeadline: " + results.getString("deadline") +
					"\nFinalized: " + results.getString("finalized")
			);
			}
		}
}

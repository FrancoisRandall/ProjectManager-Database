
public class DatabasePerson {
	
	// Attributes
	// Assign datatypes to variables
	// Made attributes private as per refactor guidelines
		
		private String name;
		private String surname;
		private String telNumber;
		private String email;
		private String address;
		
	// Constructor
	// Structure the order which the specific variables should be called
		
		public DatabasePerson(String name, String surname, String telNumber, String email, String address) {
			this.name = name;
			this.surname = surname;
			this.telNumber = telNumber;
			this.email = email;
			this.address = address;
		}

	// Methods
	// Created to complete a specific function in main class
		
		public void setTelNumber(String newTelNumber) {
			this.telNumber = newTelNumber;
		}
		
		public void setEmail(String newEmail) {
			this.email = newEmail;
		}
		
	// Create method to add all the variables in a readable manner	
		
		public String toString() {
			String output = "Name: " + name;
			output += "\nSurname: " + surname;
			output += "\nTelephone Number: " + telNumber;
			output += "\nEmail: "+ email;
			output += "\nAddress: " + address + "\n\n";
			
			return output;
		}
}


public class DatabaseProject {
	
	// Attributes
	// Assign datatypes to variables
	// Made attributes private as per refactor guidelines
		
	private int projectNumber;
	private String projectName;
	private String buildingType;
	private String address;
	private int erfNumber;
	private double totalFee;
	private double paidToDate;
	private String deadline;
	private String finalised;
	//private FinalCustomer customer;
	//private FinalContractor contractor;
	//private FinalArchitect architect;
		
	// Constructor
	// Structure the order which the specific variables should be called
		
		public DatabaseProject(int projectNumber, String projectName, String buildingType, String address, int erfNumber, double totalFee, 
						double paidToDate, String deadline, String finalised) //FinalCustomer customer, FinalContractor contractor, FinalArchitect architect) 
		{
			this.projectNumber = projectNumber;
			this.projectName = projectName;
			this.buildingType = buildingType;
			this.address = address;
			this.erfNumber = erfNumber;
			this.totalFee = totalFee;
			this.paidToDate = paidToDate;
			this.deadline = deadline;
			this.finalised = finalised;
		//	this.customer = customer;
		//	this.contractor = contractor;
		//	this.architect = architect;
		}
		
	// Methods
	// Created to complete a specific function in main class

		public void setDeadline(String newDeadLine) {
			this.deadline = newDeadLine;
		}
		
		public void setPaidToDate(double newPaidToDate) {
			this.paidToDate = newPaidToDate;
		}
		
		public void setFinalised(String newFinalised) {
			this.finalised = newFinalised;
		}
		
	// Create function to add all the variables in a readable manner		
		
		public String toString() {
			String output = "Project Number: "+ projectNumber;
			output += "\nProject Name: " + projectName;
			output += "\nBuilding Type: " + buildingType;
			output += "\nAddress: " + address; 
			output += "\nERF Number: " + erfNumber; 
			output += "\nTotal Fee: " + "R " + totalFee; 
			output += "\nPaid To Date: " + "R " + paidToDate; 
			output += "\nDeadline: " + deadline; 
			output += "\nFinalised: " + finalised;
		//	output += "\n\nCustomer: " + customer;
		//	output += "\nContractor:" + contractor;
		//	output += "\nArchitect: " + architect;
			
			return output;
		}
	}

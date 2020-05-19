package model;
import utility.UnamePwdValidation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import service.ExcelGenerator;

/*The Register class details are get and set here in AdminRegister and validations are done in 
UnamePwdValidation of utility package
*/

public class StakeHolderRegister
{
	static Register register;
	static UnamePwdValidation validate;
	public static void main(String[] args) throws IOException
	{
		register =new Register();
		validate = new UnamePwdValidation();
		try(Scanner scanner = new Scanner(System.in))
		{
			System.out.println("Hellooo..! Welcome to E-MANDI \nPlease tell us your mode of Registration.. \n");
			System.out.println("1. Producer \n2. Wholesaler \n3. Retailer \n4. Civilian" );
			System.out.println("Please Choose one option :\n");
			int choice = scanner.nextInt();
			String filename = "";
			String sheetname = "";
			switch(choice)
			{
				case 1: System.out.println("Hello Producer..! Please fill the formalities\n");
				        filename = "C:\\Users\\sahith chowdary\\eclipse-workspace\\E-MANDI\\SHEETS\\ProducerExcel.xls";
				        sheetname = "ProducerDetails";
						break;
				case 2: System.out.println("Hello Wholesaler..! Please fill the formalities\n");
		        		filename = "C:\\Users\\sahith chowdary\\eclipse-workspace\\E-MANDI\\SHEETS\\WholesalerExcel.xls";
		        		sheetname = "WholesalerDetails";
						break;
				case 3: System.out.println("Hello Retailer..! Please fill the formalities\n");
		        		filename = "C:\\Users\\sahith chowdary\\eclipse-workspace\\E-MANDI\\SHEETS\\RetailerExcel.xls";
		        		sheetname = "RetailerDetails";
						break;
				case 4: System.out.println("Hello Civilian..! Please fill the formalities\n");
		        		filename = "C:\\Users\\sahith chowdary\\eclipse-workspace\\E-MANDI\\SHEETS\\CivilianExcel.xls";
		        		sheetname = "CivilianDetails";
						break;	
				default: System.out.println("Invalid Entry!" );
			}
			excelwriter(filename,sheetname);
		}	
	}
	
// Producer details validation check
	
	public static void excelwriter(String filename,String sheetname) throws IOException
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your Name: \n");
		String userName = scanner.nextLine();
		
		System.out.println("Enter Your Email-Id: \n");
		String email = scanner.nextLine();
		
		System.out.println("Enter Your Password: \n");
		String password = scanner.nextLine();
		
		System.out.println("Re-enter Your Password: \n");
		String confirmPassword = scanner.nextLine();
		
		System.out.println("Enter Your Mobile Number: \n");
		String mobile = scanner.nextLine();
		
		if(validate.checkUserDetails(email, password, confirmPassword, mobile))
		{
			register.setUserName(userName);
			register.setEmail(email);
			register.setPassword(password);
			register.setConfirmPassword(confirmPassword);
			register.setMobile(mobile);
			printData(register);
			List<Register> list = new ArrayList<Register>();
			//ProducerExcelGenerator excel = new ProducerExcelGenerator();
			ExcelGenerator excel = new ExcelGenerator();
			list.add(register);
			excel.excelGenerate(register, list,filename,sheetname); 
			System.out.println("Details are stored in Excel..");
		}
		else
		{
			System.out.println("Please correct your details.!");
		}
	}
	


// Displaying the registered details if satisfied the necessary conditions else to recheck once.
	
	public static void printData(Register register)
	{
		System.out.println("CHECK YOUR DETAILS: \n ------------------");
		System.out.println("Your Name: " + register.getUserName());
		System.out.println("Your Email: " + register.getEmail());
		System.out.println("Your Password: " + register.getPassword());
		System.out.println("Check Your Password: " + register.getConfirmPassword());
		System.out.println("Your Mobile Number: " + register.getMobile());
		
		    
	}
}

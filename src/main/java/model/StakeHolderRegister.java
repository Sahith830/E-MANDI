package model;
import utility.UnamePwdValidation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import service.CivilianExcelGenerator;
import service.ProducerExcelGenerator;
import service.RetailerExcelGenerator;
import service.WholesalerExcelGenerator;

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
			
			switch(choice)
			{
				case 1: System.out.println("Hello Producer..! Please fill the formalities\n");
						producer();
						break;
				case 2: System.out.println("Hello Wholesaler..! Please fill the formalities\n");
						wholesaler();
						break;
				case 3: System.out.println("Hello Retailer..! Please fill the formalities\n");
						retailer();
						break;
				case 4: System.out.println("Hello Civilian..! Please fill the formalities\n");
						civilian();
						break;	
				default: System.out.println("Invalid Entry!" );
			}
		}	
	}
	
// Producer details validation check
	
	public static void producer() throws IOException
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
			ProducerExcelGenerator excel = new ProducerExcelGenerator();
			list.add(register);
			excel.excelGenerate(register, list); 
			System.out.println("Details are stored in Excel..");
		}
		else
		{
			System.out.println("Please correct your details.!");
		}
	}
	
// Wholesaler details validation check
	
	public static void wholesaler() throws IOException
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
			WholesalerExcelGenerator excel = new WholesalerExcelGenerator();
			list.add(register);
			excel.excelGenerate(register, list); 
			System.out.println("Details are stored in Excel..");
		}
		else
		{
			System.out.println("Please correct your details.!");
		}
	}
	
// Retailer details validation check
	
	public static void retailer() throws IOException
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
			RetailerExcelGenerator excel = new RetailerExcelGenerator();
			list.add(register);
			excel.excelGenerate(register, list); 
			System.out.println("Details are stored in Excel..");
		}
		else
		{
			System.out.println("Please correct your details.!");
		}
	}
	
// Civilian details validation check
	
	public static void civilian() throws IOException
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
			CivilianExcelGenerator excel = new CivilianExcelGenerator();
			list.add(register);
			excel.excelGenerate(register, list); 
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

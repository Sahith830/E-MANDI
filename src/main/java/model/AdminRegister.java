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
public class AdminRegister
{
	public static void main(String[] args) throws IOException
	{
		Register register =new Register();
		UnamePwdValidation validate = new UnamePwdValidation();
		try(Scanner scanner = new Scanner(System.in))
		{
			System.out.println("Hellooo..! Welcome to E-MANDI \n You are registering your details as an Adminstrator \n");
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
				//Register register1 = new Register(userName, email, password, confirmPassword, mobile);
				ExcelGenerator excel = new ExcelGenerator();
				list.add(register);
				excel.excelGenerate(register, list); 
				System.out.println("Details are stored in Excel..");
			}
			else
			{
				System.out.println("Please correct your details.!");
			}
			
		}	
	}
	public static void printData(Register register)
	{
		System.out.println("Your Name: " + register.getUserName());
		System.out.println("Your Email: " + register.getEmail());
		System.out.println("Your Password: " + register.getPassword());
		System.out.println("Check Your Password: " + register.getConfirmPassword());
		System.out.println("Your Mobile Number: " + register.getMobile());
		
		    
	}
}

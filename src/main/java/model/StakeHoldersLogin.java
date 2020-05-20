package model;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import service.ExcelReader;
import controller.AdminControl;
import controller.ProducerControl;
import controller.WholesalerControl;


public class StakeHoldersLogin 
{
	static ExcelReader vc;
	static String email, pass;
	static int prof;
	
	public static void main(String[] args) throws IOException 
	{
		HashMap<String ,String > h=new HashMap<String ,String>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Your Email : ");
		
		email = sc.nextLine();
		System.out.print("Enter Your Password : ");
		
		pass = sc.nextLine();
		h.put(email , pass);
		vc = new ExcelReader();
		System.out.println("\n0:Admin\n1:Farmer\n2.Wholesaler\n3.Retailer\n4.Civilian\nEnter your profession :");
		prof=sc.nextInt();
		switch(prof)
		{
			case 0:  adminOperations();
					 break;
			case 1:  producerOperations();
					 break;
			case 2:  wholesalerOperations();
					 break;
			case 3:  retailerOperations();
					 break;
			case 4:  civilianOperations();
					 break;
			default:  System.out.println("\nEnter Valid Profession");
			
			
		}
		sc.close();
	}
	public static void adminOperations() throws IOException
	{
		if(vc.validateCredentials(email,pass,prof)) 
		{
			System.out.println("Logged in Successfully");
			AdminControl admin = new AdminControl();
			admin.adminOptions();
		}
		else 
		{
			System.out.println("Please Check your Credentials");
		}
	}
	public static void producerOperations() throws IOException
	{
		if(vc.validateCredentials(email,pass,prof)) 
		{
			System.out.println("Logged in Successfully");
			ProducerControl producer = new ProducerControl();
			producer.producerOptions();
		}
		else 
		{
			System.out.println("Please Check your Credentials");
		}
	}
	public static void wholesalerOperations() throws IOException
	{
		if(vc.validateCredentials(email,pass,prof)) 
		{
			System.out.println("Logged in Successfully");
			WholesalerControl wholesaler = new WholesalerControl();
			wholesaler.wholesalerOptions();
		}
		else 
		{
			System.out.println("Please Check your Credentials");
		}
	}
	public static void retailerOperations() throws IOException
	{
		if(vc.validateCredentials(email,pass,prof)) 
			System.out.println("Logged in Successfully");
		else 
			System.out.println("Please Check your Credentials");
	}
	public static void civilianOperations() throws IOException
	{
		if(vc.validateCredentials(email,pass,prof)) 
			System.out.println("Logged in Successfully");
		else 
			System.out.println("Please Check your Credentials");
	}
	
}
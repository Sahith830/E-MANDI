package model;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import service.ExcelReader;

public class StakeHoldersLogin 
{
	public static void main(String[] args) throws IOException 
	{
		HashMap<String ,String > h=new HashMap<String ,String>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Your Email : ");
		
		String email = sc.nextLine();
		System.out.print("Enter Your Password : ");
		
		String pass = sc.nextLine();
		
		h.put(email , pass );
		ExcelReader vc = new ExcelReader();
		System.out.println("\n1:Farmer\n2.Wholesaler\n3.Retailer\n4.Civilian\nEnter your profession :");
		int prof=sc.nextInt();
		if(vc.validateCredentials(email,pass)) 
		{
			System.out.println("Logged in Successfully");
			switch(prof)
			{
			case 1: System.out.println("Congo!!! You are Logged in as a Farmer");
				break;
			case 2:System.out.println("Congo!!! You are Logged in as a Wholesaler");
				break;
			case 3:System.out.println("Congo!!! You are Logged in as a Retailer");
				break;
			case 4:System.out.println("Congo!!! You are Logged in as a Civilian");
				break;
			default:System.out.println("please try logging in again !");
			
			}
		}
		else 
		{
			System.out.println("Please Check your Credentials");
		}
		sc.close();
	}
}
 
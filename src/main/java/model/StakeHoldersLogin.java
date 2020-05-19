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
		if(vc.validateCredentials(email,pass,prof)) 
		{
			System.out.println("Logged in Successfully");
			//bidding code
		}
		else 
		{
			System.out.println("Please Check your Credentials");
		}
		sc.close();
	}
}
 
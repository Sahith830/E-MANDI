package model;
import java.io.IOException;
import java.util.Scanner;
import service.ExcelReader;

public class StakeHoldersLogin 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Your Email : ");
		
		String email = sc.nextLine();
		System.out.print("Enter Your Password : ");
		
		String pass = sc.nextLine();
		ExcelReader vc = new ExcelReader();
		
		if(vc.validateCredentials(email,pass)) 
		{
			System.out.println("Logged in Successfully");
		}
		else 
		{
			System.out.println("Please Check your Credentials");
		}
		sc.close();
	}
}
 
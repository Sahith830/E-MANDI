package controller;

import java.util.Scanner;

public class AdminControl 
{
	public AdminControl(){}
	public void adminOptions()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select an option you want to perform now ! \n");
		System.out.println("1.BIDDING \n2.UpdateUser \n3.RetrieveUser \n4.DeleteUser");
		int option = sc.nextInt();
		switch(option)
		{
			case 1: bidding();
					break;
			case 2: updateUser();
					break;
			case 3: retrieveUser();
					break;
			case 4: deleteUser();
					break;
			default: System.out.println("Enter Valid Option.");
			
		}
		sc.close();
	}
	public void bidding()
	{
		
	}
	public void updateUser()
	{
		
	}
	public void retrieveUser()
	{
		
	}
	public void deleteUser()
	{
		
	}

}

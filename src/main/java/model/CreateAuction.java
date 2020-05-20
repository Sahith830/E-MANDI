package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class CreateAuction{
	void createBid(String email) {
		//Calendar cal = Calendar.getInstance();
		//int hour = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println("Create your Bidding : ");
		System.out.print("Enter your  Crop : ");
		Scanner sc = new Scanner(System.in);
		String crop = sc.nextLine();
		System.out.print("Quality of your crop : ");
		String quality = sc.nextLine();
		System.out.print("Note : 1. your timings must be in between 7 to 9\n 2.Our Auctions are limited so we chose to allocate 1 hour for each Auction \nEnter time in 24 hour format : ");
		String time = sc.nextLine();
		//LocalTime lt = LocalTime.parse(time);
		FileOutputStream out;
		File check = new File("C:\\Users\\jithendra\\eclipse-workspace\\E-MANDI\\SHEETS\\AuctionSetters.xls");
		if(check.exists()) {
			try {
				FileInputStream inputobj = new FileInputStream(check);
				Workbook wb = new HSSFWorkbook(inputobj);
				HSSFSheet sheet = (HSSFSheet) wb.getSheet("Bidders");
				inputobj.close();
				
				int rowSize = sheet.getPhysicalNumberOfRows();
				
				Row nextrow = sheet.createRow(rowSize);
				nextrow.createCell(0).setCellValue(email);
				nextrow.createCell(1).setCellValue(crop);
				nextrow.createCell(2).setCellValue(quality);
				nextrow.createCell(3).setCellValue(time);
				
				out = new FileOutputStream("C:\\Users\\jithendra\\eclipse-workspace\\E-MANDI\\SHEETS\\AuctionSetters.xls");
				
				wb.write(out);
				wb.close();
				out.close();
				sc.close();
				System.out.print("Thank You , your Auction has been registered withh us !");
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
		Workbook wb = new HSSFWorkbook();
		HSSFSheet sheet = (HSSFSheet) wb.createSheet("Bidders");
		Row row=sheet.createRow(0);
		
		row.createCell(0).setCellValue("Email-Id");
		row.createCell(1).setCellValue("Crop");
		row.createCell(2).setCellValue("Quality");
		row.createCell(3).setCellValue("Time");
		
		Row nextrow = sheet.createRow(1);
		nextrow.createCell(0).setCellValue(email);
		nextrow.createCell(1).setCellValue(crop);
		nextrow.createCell(2).setCellValue(quality);
		nextrow.createCell(3).setCellValue(time);
		
		out = new FileOutputStream("C:\\Users\\jithendra\\eclipse-workspace\\E-MANDI\\SHEETS\\AuctionSetters.xls");
		wb.write(out);
		out.close();
		wb.close();
		sc.close();
		System.out.print("Thank You , your Auction has been registered withh us !");
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
		
	}

}

package service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import model.Register;

//import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  


public class RetailerExcelGenerator 
{
	String filename="C:\\Users\\YASHASREE\\eclipse-workspace\\mandi\\SHEETS\\RetailerExcel.xls";
	FileOutputStream out;
	public HSSFWorkbook  excelGenerate(Register register, List<Register> list) throws IOException 
	{
		try 
		{
			
			HSSFWorkbook  workbook = new HSSFWorkbook ();
			HSSFSheet  sheet=workbook.createSheet("RetailerDetails");
			Row row=sheet.createRow(0);
			
			row.createCell(0).setCellValue("Email-Id");
			row.createCell(1).setCellValue("Password");
			row.createCell(2).setCellValue("confirm Password");
			row.createCell(3).setCellValue("Mobile");
			row.createCell(4).setCellValue("UserName");
			
		 	
			for(Register fillSheet: list) 
			{ 
				int rowSize = sheet.getPhysicalNumberOfRows() + 1;
		      	Row nextRows = sheet.createRow(rowSize++);
		      	nextRows.createCell(0).setCellValue(fillSheet.getEmail());
		      	nextRows.createCell(1).setCellValue(fillSheet.getPassword());
		      	nextRows.createCell(2).setCellValue(fillSheet.getConfirmPassword());
		      	nextRows.createCell(3).setCellValue(fillSheet.getMobile());  
		      	nextRows.createCell(4).setCellValue(fillSheet.getUserName());
      	  	}

			out = new FileOutputStream(filename);
			workbook.write(out);
			return workbook;
		}
		catch (Exception e) 
		{
				e.printStackTrace();
		}
		return null;
	}
}

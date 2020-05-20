package controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UpdateData 
{
	String filename="C:\\Users\\YASHASREE\\eclipse-workspace\\mandi\\SHEETS\\ProducerExcel.xls";
	int i=1;
	File checkFile = new File(filename);
	Workbook  workbook = null;
	FileOutputStream out;
	public XSSFWorkbook excelDeletingUser(String sheetname,String dataCell,int roww,int col) throws IOException
	{
		if(checkFile.exists())
		{
			try
			{
				FileInputStream fis = new FileInputStream(checkFile);
				Workbook  workbook = new XSSFWorkbook(fis);
				Sheet sheet= workbook.getSheet(sheetname);
				
	 for(int rowNumber=0;rowNumber<sheet.getLastRowNum();rowNumber++)
	 {
					  Row  row = sheet.getRow(rowNumber);
					
					 
		  if(rowNumber==roww)
		  {
			 for(int j=0;j<row.getLastCellNum();j++)
			    {
						
					 if(j==col)
					 {
							
						 Cell cell=row.getCell(j);
						 if (cell == null)
						 {
					            cell = row.createCell(j);
						 }
						 cell.getStringCellValue();
						 cell.setCellValue(dataCell);
				
					 }
				}
			}
					
	}
	
				out = new FileOutputStream(filename);
				workbook.write(out);
				out.close();
				workbook.close();
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		}else
		{
			System.out.println("Incorrect row Details");
		}
		return null;
			
		
		}
}
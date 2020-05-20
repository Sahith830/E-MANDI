package controller;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DeleteData 
{	
	String filename="C:\\Users\\YASHASREE\\eclipse-workspace\\mandi\\SHEETS\\ProducerExcel.xls";
	int i=1;
	File checkFile = new File(filename);
	Workbook  workbook = null;
	FileOutputStream out;
	public XSSFWorkbook excelDeletingUser(int row,String sheetname) throws IOException
	{
		if(checkFile.exists())
		{
			try
			{
				FileInputStream fis = new FileInputStream(checkFile);
				Workbook  workbook = new XSSFWorkbook(fis);
				Sheet sheet= workbook.getSheet(sheetname);
				boolean removeRow = removeRoww((XSSFSheet) sheet, row);
				out = new FileOutputStream(filename);
				workbook.write(out);
				out.close();
				workbook.close();
				
				if(removeRow)
				{
					System.out.println("Succesfully Deleted");
				}else
				{
					System.out.println("fail to Deleted");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		}
		else
		{
			System.out.println("Incorrect row Details");
		}
		return null;
	}
	public  static boolean removeRoww(XSSFSheet sheet, int rowIndex) 
	{
	    int lastRowNum=sheet.getLastRowNum();
	    if(rowIndex>=0 && rowIndex<lastRowNum)
	    {
	    	XSSFRow  removingRow=sheet.getRow(rowIndex);
	   
	        if(removingRow!=null)
	        {
	            sheet.removeRow(removingRow);
	            return true;
	        }
	    }
		return false;
	 }
}

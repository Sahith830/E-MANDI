package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public boolean validateCredentials(String email, String pass) throws IOException {

		String[][] excelvalues = null;
		int i=0,j=0;
		//File xssfile = new File("C:\\Users\\YASHASREE\\eclipse-workspace\\mandi\\AdminExcel.xls");
		//FileInputStream streamobj = new FileInputStream(xssfile);
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\YASHASREE\\eclipse-workspace\\mandi\\AdminExcel.xls"));
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		while(itr.hasNext()) {
			Row row = itr.next();
			Iterator<Cell> itrcell = row.cellIterator();
			j = 0 ;
			while(itrcell.hasNext()) {
				Cell cell = itrcell.next();
				excelvalues[i][j] = cell.getStringCellValue();
				j++;
				if(j>1) {
					break;
				}
			}
			i++;
		}
		while(i>=0) {
			if(excelvalues[i][0].equals(email) && excelvalues[i][1].equals(pass))
			{
				return true;
			}
			i--;
		}
		
		workbook.close();
		return false;
	}

}

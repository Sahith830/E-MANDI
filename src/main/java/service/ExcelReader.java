package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReader {

	public boolean validateCredentials(String email, String pass) throws IOException {
		
		String temp = "";
		int i=0,j=0,count = 0;
		
		File file = new File("C:\\Users\\YASHASREE\\eclipse-workspace\\mandi\\SHEETS\\AdminExcel.xls");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new HSSFWorkbook(fis);
		System.out.println(workbook);
		HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		while(itr.hasNext()) {
			Row row = itr.next();
			Iterator<Cell> itrcell = row.cellIterator();
			j = 0 ;
			while(itrcell.hasNext()) {
				Cell cell = itrcell.next();
				temp = cell.getStringCellValue();
				if(temp.equals(email)) {
					count++;
				}
				if(temp.equals(pass)) {
					count++;
				}
				j++;
				if(j>1) {
					break;
				}
			}
			i++;
		}
		if(count == 2)
			return true;
		workbook.close();
		return false;
	}

}

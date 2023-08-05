package GenericUtilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	/**
	 * 
	 * @author Vishnu
	 *This method will read data from excell shheet, row no, cell no 
	 */
		
		public String getDataFromExcelFileUtility(String sheetname , int rowNum, int CellNum) throws Throwable {
			FileInputStream fis = new FileInputStream(IConstants.excelFile);
	        Workbook wb = WorkbookFactory.create(fis);
		    Sheet sh = wb.getSheet(sheetname);
		    Row rw = sh.getRow(rowNum);
		    Cell cl = rw.getCell(CellNum);
		   String value = cl.getStringCellValue();
		   return value;
		    
		
	}
		/**
		 * This method writes the data to excel file
		 * @param sheetname
		 * @param rowNumber
		 * @param CellNumber
		 * @param data
		 * @throws Throwable
		 * @throws IOException
		 */
		
		public void writeDataIntoExcel(String sheetname , int rowNumber , int CellNumber , String data) throws Throwable, IOException {
			FileInputStream fis = new FileInputStream(IConstants.excelFile);
			Workbook wb = WorkbookFactory.create(fis);
		    Sheet sh = wb.createSheet(sheetname);
		    Row rw = sh.createRow(rowNumber);
		    Cell cl = rw.createCell(2);
		    cl.setCellValue(data);
		    
		    FileOutputStream fos = new FileOutputStream(IConstants.excelFile);
		    wb.write(fos);
		    wb.close();
		
		
			
		}
		/**
		 * This method will read all the data inside a sheet to be used in data provider
		 * @param sheet
		 * @return
		 * @throws Throwable
		 */
		
		public Object[][] readMultipleData(String sheet ) throws Throwable {
			FileInputStream fis = new FileInputStream(IConstants.excelFile);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			int lastRow = sh.getLastRowNum();
			int lastCel = sh.getRow(0).getLastCellNum();
			
			Object [][] data = new Object [lastRow][lastRow];
			
			for(int i = 0; i<lastRow; i++) {
				for (int j=0; j<lastCel ; j++) {
					data[i][j] = sh.getRow(i+1).getCell(j+1).getStringCellValue();
				}
			}
			return data;
		}

		
	}






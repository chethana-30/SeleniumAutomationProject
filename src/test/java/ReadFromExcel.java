

	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ReadFromExcel {
		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			
			FileInputStream fis = new FileInputStream("C:\\Users\\S Vishnu\\OneDrive\\Documents\\Selenium\\data.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("contact");
			Row rw = sh.getRow(1);
			Cell cl = rw.getCell(2);
			String value = cl.getStringCellValue();
			System.out.println(value);
			
		}

	}




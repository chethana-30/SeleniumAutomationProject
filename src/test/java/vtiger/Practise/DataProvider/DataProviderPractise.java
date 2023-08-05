package vtiger.Practise.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise {
	
	@Test(dataProvider = "getData")
	public void addToCartTest(String name, int price, String model) {
		System.out.println("Phone name is = "+name+" Prize is ="+price+" Model is ="+model+" ");
	}
	
	@DataProvider
	public Object[][] getData(){    //row col
		Object[][] data = new Object[3][3];
		data[0][0] = "Iphone"; //1st set of data
		data[0][1] = 20000;
		data[0][2] = "513k";
		
		data[1][0] = "Samsung"; //2st set of data
		data[1][1] = 30000;
		data[1][2] = "513k";
		
		
		data[2][0] = "Oneplus"; //3rd set of data
		data[2][1] = 20000;
		data[2][2] = "A23k";
		
		return data;
		
   }
	

}

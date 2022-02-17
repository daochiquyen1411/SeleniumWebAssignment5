package Demo;

import Helper.ExcelHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDriven {

	
	@DataProvider(name = "credential")
	public static Object[][] credential() throws Exception{
		return ExcelHelper.getDataFromExcel("src/test/java/Test/AddHotelData.xlsx", "AddHotel");
	} 
	
	
}

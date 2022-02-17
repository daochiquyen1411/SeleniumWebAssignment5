package Demo;

import Helper.ExcelHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenDemo {
//	
//	@DataProvider(name = "testData")
//	public Object[][] number() {
//		return new Object[][] {
//			{1,2,3},
//			{2,5,7},
//			{5,5,9}
//		};
//	}
//	
//	@Test(dataProvider = "testData")
//	public void testSum(int a, int b , int c) {
//		Assert.assert(a+b,c);
//	}
	
	@DataProvider(name = "credential")
	public static Object[][] credential() throws Exception{
		return ExcelHelper.getDataFromExcel("src/test/java/Test/LoginUser.xlsx", "Account");
	} 
	
	
}

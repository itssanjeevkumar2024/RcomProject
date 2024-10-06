package SignIn_Flow_Automation;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import webPages.BaseClass;

public class DataDrivernFromExcel extends BaseClass {
	
	@BeforeMethod()
	public void setUp(ITestResult result) {
        //String className = result.getTestClass().getName(); // CLASS NAME WITH PACKAGE
        String className= result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName(); // Get the method name
        createTest(className, methodName); // Create the test with class and method names
    }
	
	@Test(dataProvider="getData")
	public void PrintExcelData(double SrNo, String Name, String Place) {
		System.out.println("Sr.No.:"+SrNo+"    "+"Name:"+Name+"    "+"Place:"+Place);
	}
	
	@DataProvider()
	public Object[][] getData() {
		
		Object[][] Data=new Object[excel.getRow()-1][excel.getCoulmn()];
		for(int i=1;i<excel.getRow();i++)
		{
			for(int k=0;k<excel.getCoulmn();k++)
			{
				if(k==0) 
					Data[i-1][k]=excel.getNumaricData(1, i, k);
				else if(k==1)
					Data[i-1][k]=excel.getStringData(1, i, k);
				else if(k==2)
					Data[i-1][k]=excel.getStringData(1, i, k);
			}
		}
		try {
			excel.WB.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Data;
		
	}

}

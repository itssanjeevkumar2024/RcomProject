package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	public XSSFWorkbook WB;
	
	public ExcelDataProvider() throws FileNotFoundException {
		String path=System.getProperty("user.dir")+"\\TestData\\TestingData.xlsx";
		
		File fl=new File(path);
		System.out.println(path);
		FileInputStream inputdata=new FileInputStream(fl);
		try {
			WB=new XSSFWorkbook(inputdata);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getStringData(int index,int rowNumber,int Coulmn) {
		
		
		return WB.getSheetAt(index).getRow(rowNumber).getCell(Coulmn).getStringCellValue();
		
		
		
	}
	public double getNumaricData(int index,int rowNumber,int Coulmn) {
	return WB.getSheetAt(index).getRow(rowNumber).getCell(Coulmn).getNumericCellValue();
		
	}
	
	public int getRow() {
		int rowNo = WB.getSheetAt(1).getPhysicalNumberOfRows();
		return rowNo;
		
	}
	public int getCoulmn() {
		
		int columnCount = WB.getSheetAt(1).getRow(0).getPhysicalNumberOfCells();
		return columnCount;
	}
}

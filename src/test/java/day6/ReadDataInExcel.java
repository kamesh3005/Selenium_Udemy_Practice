package day6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataInExcel {

	public static void main(String[] args) throws IOException {

		// FileInputStream input=new FileInputStream("/home/kamesh/eclipse-workspace/SeleniumUdemyPractices/testData/MyData.ods");
		FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/testData/MyData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(input);
		XSSFSheet sheet = workBook.getSheetAt(0);
		int totalRow = sheet.getLastRowNum();// capture the total number of rows
		int totalCell = sheet.getRow(1).getLastCellNum();// capture total number of column

		System.out.println("total Rows :" + totalRow);
		System.out.println("total column :" + totalCell);

		for (int r = 0; r <= totalRow; r++) {

			XSSFRow currentRow = sheet.getRow(r);

			for (int c = 0; c < totalCell; c++) {

				XSSFCell cell = currentRow.getCell(c);
				String value = cell.toString();
				System.out.print(value + "     ");

			}
			System.out.println();
		}
		workBook.close();
		input.close();

	}

}

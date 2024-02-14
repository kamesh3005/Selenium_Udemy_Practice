package day6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInExcelSheet {

	public static void main(String[] args) throws IOException {

		FileOutputStream output = new FileOutputStream(System.getProperty("user.dir") + "/testData/myfile.xlsx");

		XSSFWorkbook book = new XSSFWorkbook();// To create work book
		XSSFSheet sheet = book.createSheet();// to create sheet
		// Approch 1
		/*
		 * XSSFRow row = sheet.createRow(0);// create a row
		 * row.createCell(0).setCellValue("Welcome");
		 * row.createCell(1).setCellValue("12345");
		 * row.createCell(2).setCellValue("kamesh");
		 * 
		 * XSSFRow row1 = sheet.createRow(1); row1.createCell(0).setCellValue("Java");
		 * row1.createCell(1).setCellValue("selenium");
		 * row1.createCell(2).setCellValue("MySql");
		 */
		// Approch2
		Scanner sc = new Scanner(System.in);
		for (int r = 0; r <= 5; r++) {
			XSSFRow currentRow = sheet.createRow(r);

			for (int c = 0; c < 3; c++) {
				// currentRow.createCell(c).setCellValue("welcome");
				System.out.println("Enter a value");
				String value = sc.nextLine();
				currentRow.createCell(c).setCellValue(value);

			}
		}

		book.write(output);
		book.close();
		output.close();
		System.out.println("Writing is donn!!!!!");

	}

}

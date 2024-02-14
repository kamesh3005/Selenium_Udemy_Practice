package day7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExlUtility {

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	public static int getRowCount(String xlFile, String xlSheet) throws IOException {

		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);

		sheet = wb.getSheet(xlSheet);
		int rowCount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;

	}

	public static int getCellCount(String xlFile, String xlSheet, int rownum) throws IOException

	{

		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();		
		wb.close();
		fis.close();
		return cellcount;

	}

	public static String getCellData(String xlFile, String xlSheet, int rownum, int colnum) throws IOException {
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			DataFormatter formater = new DataFormatter();
			data = formater.formatCellValue(cell);
			return data;

		} catch (Exception e) {
			data = " ";

		}
		wb.close();
		fis.close();
		return data;

	}

	public static void setCellData(String xlFile, String xlSheet, int rownum, int colnum, String data)
			throws IOException {
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fos = new FileOutputStream(xlFile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();

	}

	public static void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fos = new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

	public static void fillRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fos = new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
}

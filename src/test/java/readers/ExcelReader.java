package readers;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.LoggerLoad;


public class ExcelReader
{

		public static int totalRow;
		ConfigReader configreader;

		public List<Map<String, String>> ReadExcelFile(String sheetName)
				throws InvalidFormatException, IOException {

			List<Map<String,String>>sheetData=null;
			try
			{
				//String excelPath=configreader.getExcelFilePath();
				String excelPath="C:\\Users\\niles\\eclipse-workspace\\MyDSAlgo\\src\\test\\resources\\InputData\\TestData.xlsx";
				FileInputStream fs= new FileInputStream(excelPath);		
				
				//FileInputStream fs= new FileInputStream("C:\\Users\\niles\\eclipse-workspace\\MyDSAlgo\\src\\test\\resources\\InputData\\TestData.xlsx");
				try (XSSFWorkbook wb=new XSSFWorkbook(fs))
				{
					XSSFSheet sheet=wb.getSheet(sheetName);
					sheetData=ReadSheet(sheet);
				}
			}
			catch(IOException ex)
			{
				LoggerLoad.error(ex.getMessage()); 
			}
			return sheetData;
		}	

		private List<Map<String, String>> ReadSheet(Sheet sheet) {

			Row row;
			Cell cell;

			totalRow = sheet.getLastRowNum();

			List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();

			for (int currentRow = 1; currentRow <= totalRow; currentRow++) {

				row = sheet.getRow(currentRow);
				System.out.println("Current row=" + row);

				int totalColumn = row.getLastCellNum();
				System.out.println("Total colunm=" + totalColumn);

				LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
				System.out.println("column map data" +columnMapdata);

				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {

					System.out.println("Current column=" + currentColumn);
					cell = row.getCell(currentColumn);

					System.out.println("Current cell="+cell);
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();

					columnMapdata.put(columnHeaderName, cell.getStringCellValue());
				}

				excelRows.add(columnMapdata);
			}

			return excelRows;
		}
	}
	/*	public int countRow() {

			return totalRow;
		}*/



//Workbook workbook = WorkbookFactory.create(new File("C:\\Users\\niles\\eclipse-workspace\\MyDSAlgo\\src\\test\\resources\\InputData"));
//Sheet sheet = workbook.getSheet(sheetName);
//workbook.close();
//return readSheet(sheet);


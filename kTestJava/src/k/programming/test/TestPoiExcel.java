package k.programming.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestPoiExcel {
	static String uploadFileXls="C:/kStock/data/sample_data.xls";
	static String uploadFileXlsx="C:/kStock/data/sample_data.xlsx";
	
	public static void main(String[] args) {
   		testXls();
   		testXlsx();
	}

	
	public static boolean testXls() {
		System.out.println("k>TestPoiExcel.testXls - :" );	//test+++

        try {
        	FileInputStream file = new FileInputStream(new File(uploadFileXls));
        	HSSFWorkbook workbook = new HSSFWorkbook(file);
        	HSSFSheet sheet = workbook.getSheetAt(0);
			Row row;
			Cell cell;
             
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                row = rowIterator.next();
                 
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                    cell = cellIterator.next();
                     
                    switch(cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                        	System.out.print(cell.getNumericCellValue() + "\t\t");
                        	break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                    }
                }
            }
            file.close();
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
		return true;
	}
	
	public static boolean testXlsx() {
		System.out.println("\nk>TestPoiExcel.Xlsx - :" );	//test+++
		
		try {
			FileInputStream file = new FileInputStream(new File(uploadFileXlsx));
			Row row;
			Cell cell;
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					
					cell = cellIterator.next();
					
					switch(cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t\t");
						break;
					}
				}
			}
			file.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}

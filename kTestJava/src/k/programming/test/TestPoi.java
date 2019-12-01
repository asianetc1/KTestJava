package k.programming.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TestPoi {

	public static void main(String[] args) {
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("시트명");
		HSSFRow row=null;
		HSSFCell cell=null;
		
		// 처리 로직 작성
		for (int i = 0; i < 5; i++) {
				row = sheet.createRow(i);
				for (int j = 0; j < 10; j++) {
					cell=row.createCell(j);
					cell.setCellValue("aaaa"+i+j);
				}
		}
		System.out.println("k>TestPoi.main - success:" );	//test+++

		try {
			FileOutputStream fos = new FileOutputStream("C:/kStock/result_file/aaa.xls");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}

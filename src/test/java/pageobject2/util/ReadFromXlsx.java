package pageobject2.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadFromXlsx {
        public Object[][] getDataFromExcel(String excelPath) throws Exception{
            Workbook workbook;
            try(FileInputStream excelInputStream = new FileInputStream(excelPath)){
                workbook = new XSSFWorkbook(excelInputStream);
            }
            Sheet sheet = workbook.getSheetAt(0);
            int rowInExcel = sheet.getPhysicalNumberOfRows();
            int colInExcel = sheet.getRow(0).getPhysicalNumberOfCells();
            Object[][] obj = new Object[rowInExcel-1][colInExcel];
            for(int row=1;row<rowInExcel;row++){
                for(int col=0;col<colInExcel;col++){
                    obj[row-1][col] = sheet.getRow(row).getCell(col).getStringCellValue();
                    System.out.println(obj[row-1][col]);
                    System.out.println(row);
                    System.out.println(col);
                }
            }
            return obj;
        }
}


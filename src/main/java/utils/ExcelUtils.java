package utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static Object[][] getExcelData(File file, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int columns = sheet.getRow(0).getPhysicalNumberOfCells();
            Object[][] data = new Object[rows - 1][columns];

            for(int i = 1 ; i < rows; i++) {
                XSSFRow row = sheet.getRow(i);
                for(int j = 0; j< columns; j++) {
                    data[i-1][j] = row.getCell(j).toString();
                }
            }
            return data;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

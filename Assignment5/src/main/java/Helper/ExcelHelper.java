package Helper;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHelper {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;

    public static Object[][] getDataFromExcel(String filePath, String sheetName) throws Exception {
        try{
            FileInputStream excelFile = new FileInputStream(filePath);

            workbook = new XSSFWorkbook(excelFile);
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0); //header

            int totalRows = sheet.getPhysicalNumberOfRows();
            int totalColumn = row.getLastCellNum();

            Object[][] tabArray = new Object[totalRows - 1][totalColumn];
            for(int i = 0; i < totalRows - 1; i++){
                row = sheet.getRow(i+1);
                for(int j = 0; j < totalColumn; j++){
                    if(row == null){
                        tabArray[i][j] = "";
                    }
                    else {
                        cell = row.getCell(j);
                        if(cell == null){
                            tabArray[i][j] = "";
                        }else{
                            tabArray[i][j] = cell.getStringCellValue();
                      }

                    }
                }
            }
            return tabArray;
        }catch (Exception e){
            throw(e);
        }
    }
}

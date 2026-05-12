package utils;

import org.apache.poi.xdgf.usermodel.XDGFStyleSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    public static Object[][] readExcel(String filePath) throws Exception {

        FileInputStream file = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (sheet.getRow(i) != null && sheet.getRow(i).getCell(j) != null) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                } else {
                    data[i - 1][j] = "";
                }
            }
        }

        workbook.close();
        return data;
    }
}

package excel_core;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {

    //metod za iscitvanje Excela red po red
    public Map<String, String> getRowData(String fileName, String sheetName, int row) throws IOException {

        FileInputStream fis = new FileInputStream(fileName);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sh = wb.getSheet(sheetName);

        //sad kad imamo sheet, uzimamo vrednosti do zadnje popunjene vrednosti, i trazimo poslednju kolonu koja je popunjena
        int lastColNum = sh.getRow(1).getLastCellNum(); //broj zadnje popunjene celija u ovom redu; 1. red je red gde su nazivi promenljiva; nema opcija za kolonu nego uzimam red i poslednju popunjenu celiju

        Map<String, String> data = new HashMap<>(); //prazna promenljiva gde smestamo vrednosti kao K,V parove

        for (int i = 0; i < lastColNum; i++) {
            String key;
            String value;

            key = sh.getRow(1).getCell(i).getStringCellValue().trim(); //Username -> 1. red, 1. celija; 1. red, 2. celija itd; trim() brise prazne space-ove na pocetku/kraju strina; KEY je uvek 1!
            value = sh.getRow(row + 1).getCell(i).getStringCellValue().trim(); //username1 -> 2. red, 1. celija; 1.red sa indeksom 2

            data.put(key, value);
        }
        return data;
    }
}

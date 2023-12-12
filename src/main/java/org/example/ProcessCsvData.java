package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProcessCsvData {
    public static void main(String[] args) {
        try {
            // Reading the CSV File
            String csvFilePath = "/home/hmc/Downloads/member_details.csv";
            Workbook workbook = processCSV(csvFilePath);

            // Saving the Excel File
            String excelFilePath = "/home/hmc/Downloads/output_data.xlsx";
            saveExcelFile(workbook, excelFilePath);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Workbook processCSV(String csvFilePath) throws IOException {
        // opening & reading csv file into a workbook obj
        FileInputStream fileInputStream = new FileInputStream(csvFilePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        return workbook;
    }

    private static void saveExcelFile(Workbook workbook, String excelFilePath) {
        // Saving the workbook - file path
        try (FileOutputStream fileOut = new FileOutputStream(excelFilePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
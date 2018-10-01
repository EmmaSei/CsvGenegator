/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.emm.generatorcsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class WriterCsvFile {

    public void writeCustomers(String fileName, int recordNum) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter("C:/input_csv/"+fileName));

        List<String[]> allLines = new ArrayList<>();
        allLines.add(new String[]{"accountName","traffic", "date","city", "street", "homeNumber"});
        for (int i = 0; i < recordNum; i++) {
            //Create record
            String[] record = {randomCustomer() + "", randomNum(100, 1000) + "", randomDate(), "City" + randomNum(1, 100), "Street" + randomNum(1, 100), randomNum(1, 100) + ""};
            allLines.add(record);
        }
        writer.writeAll(allLines);
        writer.close();
    }

    public void writeCustomers(int recordNum) throws Exception {
        for (int i = 0; i < recordNum; i++) {
            List<String[]> allLines = new ArrayList<>();
            allLines.add(new String[]{"traffic", "date","address"});
            String nameCustomer = randomCustomer() + "";
            try {
                FileReader filereader = new FileReader("C:/input_csv/"+nameCustomer+".csv");
                CSVReader csvReader = new CSVReader(filereader);
                String[] nextRecord;
                csvReader.readNext();
                while ((nextRecord = csvReader.readNext()) != null) {
                    allLines.add(nextRecord);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            CSVWriter writer = new CSVWriter(new FileWriter("C:/input_csv/"+nameCustomer + ".csv"));
            //Create record
            String[] record = {randomNum(100, 1000) + "", randomDate(), "City" + randomNum(1, 100) + " Street" + randomNum(1, 100) + " " + randomNum(1, 100)};
            //Write the record to file
            allLines.add(record);
            writer.writeAll(allLines);
            //writer.writeNext(record);
            //close the writer
            writer.close();
        }
    }

    private CustomerName randomCustomer() {
        int pick = new Random().nextInt(CustomerName.values().length);
        return CustomerName.values()[pick];
    }

    private int randomNum(int min, int max) {
        Random rnd = new Random();
        return min + rnd.nextInt(max - min + 1);
    }

    private String randomDate() {

        GregorianCalendar cal = new GregorianCalendar(2000, 12, 12);
        Date startDate = cal.getTime();
        Date endDate = new Date();
        long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date(random));
        return date;
    }
}

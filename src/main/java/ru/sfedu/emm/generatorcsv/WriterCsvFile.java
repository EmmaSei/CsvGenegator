/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.emm.generatorcsv;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WriterCsvFile {

    public void writeCustomers(String fileName, int recordNum) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter(fileName));
        for (int i = 0; i < recordNum; i++) {
            //Create record
            String[] record = {randomCustomer() + "", randomNum(100, 1000) + "", randomDate(), "City" + randomNum(1, 100), "Street" + randomNum(1, 100), randomNum(1, 100) + ""};
            //Write the record to file
            writer.writeNext(record);
        }
        //close the writer
        writer.close();
    }

    public void writeCustomers(int recordNum) throws Exception {
        for (int i = 0; i < recordNum; i++) {

            String nameCustomer = randomCustomer() + "";
            CSVWriter writer = new CSVWriter(new FileWriter(nameCustomer + ".csv"));
            //Create record
            String[] record = {randomNum(100, 1000) + "", randomDate(), "City" + randomNum(1, 100) + " Street" + randomNum(1, 100) + " " + randomNum(1, 100)};
            //Write the record to file
            writer.writeNext(record);
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

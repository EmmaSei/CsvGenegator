/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.emm.generatorcsv;

/**
 *
 * @author Эмма
 */
public class Application {
    
    public static void main(String[] args) throws Exception {
        WriterCsvFile csvFile = new WriterCsvFile();
        csvFile.writeCustomers("customer.csv", 10);
        csvFile.writeCustomers(2);
    }
}

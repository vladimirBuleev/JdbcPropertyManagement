package data;

import data.client.Client;
import data.client.ClientDB;
import data.flat.Flat;
import data.flat.FlatDB;
import data.rent.Rent;
import data.rent.RentDB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.text.ParseException;



public class Main {
    public static void main(String[] args) throws ParseException {
        ApplicationContext context = new AnnotationConfigApplicationContext("data");
        ClientDB clientDb = context.getBean("clientDB", ClientDB.class);
        Client client = new Client("Vladimir", "Gil", "Vladimirovich", "6100 127788", "89108671654");
       // clientDb.show();

        FlatDB flatDb = context.getBean("flatDB", FlatDB.class);
        Flat flat = new Flat("Tver","Sklizkova","10","9","194",48.4,12993.0,"free");
        RentDB rentDb = context.getBean("rentDB", RentDB.class);
        Rent rent = new Rent(7,1,"01-12-2022","01-01-2023","15-01-2023",15600.5);
        rentDb.update(1,rent);
        rentDb.show();

    }
}

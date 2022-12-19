package DAO;

import DAO.client.Client;
import DAO.client.ClientDao;
import DAO.flat.Flat;
import DAO.flat.FlatDao;
import DAO.rent.RentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.text.ParseException;


public class Main {
    public static void main(String[] args) throws ParseException {
        ApplicationContext context = new AnnotationConfigApplicationContext("DAO");
        ClientDao clientDao = context.getBean("clientDao", ClientDao.class);
        Client client = new Client("Vladimir", "Gil", "Vladimirovich", "6100 127788", "89108671654");

        FlatDao flatDao = context.getBean("flatDao", FlatDao.class);
        Flat flat = new Flat("Tver","Sklizkova","10","9","194",48.4,12993.0,"free");
        RentDao rentDao = context.getBean("rentDao", RentDao.class);
        //Rent rent = new Rent(7,1,"01122022","01-01-2023","15-01-2023",15600.5);

    }
}

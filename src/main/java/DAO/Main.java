package DAO;

import DAO.client.Client;
import DAO.client.ClientDao;
import DAO.flat.Flat;
import DAO.flat.FlatDao;
import DAO.rent.RentDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
}

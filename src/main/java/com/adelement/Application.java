package com.adelement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Meetansh on 06-09-2016.
 */
@SpringBootApplication
public class Application {

        public static void main(String[] args) {
            System.setProperty("DB_URL","jdbc:mysql://localhost:3306/test");
            System.setProperty("DB_DRIVER_CLASS","com.mysql.jdbc.Driver");
            System.setProperty("DB_USERNAME","root");
            System.setProperty("DB_PASSWORD","");
            System.setProperty("IMAGES_LOCATION","D:\\Wallpapers");
            SpringApplication.run(Application.class, args);
        }

}

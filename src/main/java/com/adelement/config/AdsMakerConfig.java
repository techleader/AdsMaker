package com.adelement.config;

import com.adelement.dao.DataService;
import com.adelement.dao.InMemoryDataServiceImpl;
import com.adelement.dao.MySqlDataServiceImpl;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Meetansh on 06-09-2016.
 */
@Configuration
public class AdsMakerConfig {

    @Value("${DB_URL}")
    String DB_URL;
    @Value("${DB_DRIVER_CLASS}")
    String DB_DRIVER_CLASS;
    @Value("${DB_USERNAME}")
    String DB_USERNAME;
    @Value("${DB_PASSWORD}")
    String DB_PASSWORD;
    String DATABASE;



    @Bean
    public DataSource dataSource(){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(DB_URL);
        mysqlDataSource.setUser(DB_USERNAME);
        mysqlDataSource.setPassword(DB_PASSWORD);
        return mysqlDataSource;
    }


    @Bean
    public DataService dataService(){
        //return new InMemoryDataServiceImpl();
        return new MySqlDataServiceImpl(dataSource());
    }
}

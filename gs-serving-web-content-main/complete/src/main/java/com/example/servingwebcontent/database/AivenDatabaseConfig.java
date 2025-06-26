package com.example.servingwebcontent.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

@Configuration
public class AivenDatabaseConfig {

    @Bean
    public DataSource dataSource() {
        String url = System.getenv("DB_URL");
        String username = System.getenv("DB_USER");
        String password = System.getenv("DB_PASS");

        if (url == null || username == null || password == null) {
            throw new RuntimeException("Thiếu biến môi trường DB_URL, DB_USER hoặc DB_PASS");
        }

        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}

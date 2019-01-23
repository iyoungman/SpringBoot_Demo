package com.youngman.h2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component//빈 등록
public class H2Runner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;//자동설정에 의해서 빈으로 등록

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Connection connection = dataSource.getConnection();
        //DB정보 확인
        connection.getMetaData().getURL();
        connection.getMetaData().getUserName();

        //DB에 명령-Statement
        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE USER (ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
        statement.executeUpdate(sql);

        String sql2 = "INSERT INTO USER VALUES (1,'youngman')";
        statement.executeUpdate(sql2);

        connection.close();
    }
}

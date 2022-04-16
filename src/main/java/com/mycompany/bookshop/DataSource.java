/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookshop;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *Creating object to connect with database 
 * @author nikita
 */
public class DataSource {
   
    /**
     * Configuration
     */
     private static HikariConfig config;
     /**
      * Datasource
      */
     private static HikariDataSource ds;

    private DataSource() {}

    /**
     * Configuring connection
     * @return
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        
        config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl( "jdbc:postgresql://localhost:5432/book_shop_base" );
        config.setUsername( "postgres" );
        config.setPassword( "postgres" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setMaximumPoolSize(5);
        config.setTransactionIsolation("TRANSACTION_SERIALIZABLE");
        
        ds=new HikariDataSource(config);
        return ds.getConnection();
        
    }
}

/*
SCRIPTS FOR TEST APPLICATION IN 2 SQL CONNECTIONS

SQL1
BEGIN TRANSACTION ISOLATION LEVEL SERIALIZABLE;
SELECT * FROM books;
COMMIT;
DELETE FROM books WHERE book_id=21;
SELECT * FROM books;


SQL2
BEGIN TRANSACTION ISOLATION LEVEL SERIALIZABLE;
SELECT * FROM books;

INSERT INTO books VALUES (21,'NewWitcher',900,2);
COMMIT;
*/
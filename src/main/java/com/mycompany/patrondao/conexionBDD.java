/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.patrondao;

import static com.mycompany.patrondao.Main.DATABASE_URL;
import static com.mycompany.patrondao.Main.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karen.Pena
 */
public class conexionBDD {

    private Connection connection;

    private Statement statement;
    
    
    

   public Statement establecerConexionBDD(String JDBC_DRIVER, String DATABASE_URL) {

        try {      
        
        // load database driver class 
        Class.forName(JDBC_DRIVER);

        // Se establece la conexión a la base de datos  
        connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "root");

        // crear una Sentencia (Statement) de SQL 
        statement = (Statement) connection.createStatement();

        return statement;
        
        } catch (SQLException sqlException) {

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                statement.close(); // Manipular exceptions cerrando statement y conexión (connection)
            } catch (SQLException ex) {
                Logger.getLogger(conexionBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(conexionBDD.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        return null;
    }

}

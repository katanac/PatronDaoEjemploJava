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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Karen.Pena
 */
public class UsuarioImplemDao implements IUsuarioDao {

    //sobre escritura da interface dao
    @Override
    public boolean insertarDatosModelo(Statement sentenciaSQL, String nombre, String correo) {

        try {
            return sentenciaSQL.execute("INSERT INTO clase9may.usuario (`IDU`, `tipoID`, `nroCC`, nombre, correo) \n"
                    + "	VALUES (9, 3, '9999', '" + nombre + "', '" + correo + "')");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioImplemDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public void listarUsuario(ResultSet resultadoConsulta) {

        try {
            StringBuffer results = new StringBuffer();

            ResultSetMetaData metaData = resultadoConsulta.getMetaData();

            int numberOfColumns = metaData.getColumnCount();

            for (int i = 1; i <= numberOfColumns; i++) {

                results.append(metaData.getColumnName(i) + "\t");

            }

            results.append("\n");

            while (resultadoConsulta.next()) {

                for (int i = 1; i <= numberOfColumns; i++) {

                    results.append(resultadoConsulta.getObject(i) + "\t");

                }

                results.append("\n");

            }

            // Se imprime por consola
            System.out.println(results.toString());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioImplemDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ResultSet consultarBaseDatos(Statement stament, String consulta) {
        try {
            return stament.executeQuery(consulta);

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);

            System.exit(1);
        }

        return null;
    }

    @Override
    public void consultarUsuarioXCedula() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

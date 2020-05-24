/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.patrondao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author Karen.Pena
 */
public interface IUsuarioDao {
    
    
    boolean insertarDatosModelo( Statement sentenciaSQL ,String nombre, String correo);
    
    void listarUsuario(ResultSet resultConsulta);

    ResultSet consultarBaseDatos(Statement stament , String consulta);
    
    void consultarUsuarioXCedula();
}

package com.mycompany.patrondao;

import java.sql.*;


public class Main {

    // Nombre del Driver de JDBC y URL de conexión 
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";

    // PC = localhost puerto de conexión 3306 y nombre de base de datos = inventario 
    static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/clase9may";  // [root on Default schema] 

    //Atributos de clase
    private UsuarioImplemDao usuarioImplementacion;
    private conexionBDD conBDD;
    private Statement sentenciaSQL;
    private String name = "camilo Loco";
    private String correo = "camilo@yahoo.com";
    
    

    // Constructor que se conecta a la base de datos , consulta, procesa resultados y los muestra  
    public Main() {

        //crea conexion a bdd y devuelve un stament para realizar sentencias sql
        conBDD = new conexionBDD();

        sentenciaSQL = conBDD.establecerConexionBDD(JDBC_DRIVER, DATABASE_URL);
        // Se consulta la base de datos
        ResultSet resultConsulta = usuarioImplementacion.consultarBaseDatos(sentenciaSQL, "select * from usuario");
        //lista usuarios consultados
        usuarioImplementacion.listarUsuario(resultConsulta);

    }

    public void adicionarDatos() throws ClassNotFoundException, SQLException {

        boolean usuarioInsertado = usuarioImplementacion.insertarDatosModelo(sentenciaSQL, name, correo);

        //crea conexion a bdd y devuelve un stament para realizar sentencias sql
        conBDD = new conexionBDD();
        System.out.println(" estado de insert = " + usuarioInsertado);

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Main solucion = new Main();

        solucion.adicionarDatos();

        Main solucion2 = new Main();

    }

}

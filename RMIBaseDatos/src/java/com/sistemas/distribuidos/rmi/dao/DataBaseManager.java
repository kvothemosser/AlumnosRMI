package com.sistemas.distribuidos.rmi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Moisés Tapia Téllez.
 */
public class DataBaseManager {

    private static DataBaseManager instancia = null;
    private Connection conexion = null;

    public DataBaseManager() {
        conexion = getMySQLConnection();
    }

    public static synchronized DataBaseManager getInstance() {
        if (instancia == null) {
            instancia = new DataBaseManager();
        }
        return instancia;
    }

    public Connection getConnection() {
        return conexion;
    }

    private static Connection getMySQLConnection() {
        Connection con = null;
        try {
            String strCon = "jdbc:mysql://127.0.0.1/distribuida?user=rtuser&password=123";
            con = DriverManager.getConnection(strCon);
        } catch (SQLException se) {
            System.out.println(se);
        }
        return con;
    }
}
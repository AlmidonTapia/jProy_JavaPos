/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author AlmidonTapia
 */
public class Conexion {
    
    Connection conexion = null;
    
    String user = "admin23";
    String password = "1234";
    String database = "BD_SisFacturacion";
    String server = "DESKTOP-D4EHLOM\\SQLDEVELOPER";
    String port = "1433";
    
    public Connection establecerConexion(){
        try {
            String cadena = "jdbc:sqlserver://"+server+":"+port+";databaseName="+database;
            conexion = DriverManager.getConnection(cadena, user, password);
                JOptionPane.showMessageDialog(null,"Se Realizo la conexion con la BD");
                
        } catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error en la conexion con la BD"+ e.toString());
        }
        
        return conexion;
    }
    
        public void cerrarConexion(){
        try {
            if(conexion!=null && !conexion.isClosed()){
            conexion.close();
                JOptionPane.showMessageDialog(null,"Se cerro la conexion con la BD");
            }
        } catch (HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null,"Error en el cierre de la conexion con la BD" + e.toString());
        }
    }
}

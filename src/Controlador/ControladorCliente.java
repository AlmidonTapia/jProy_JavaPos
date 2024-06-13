/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AlmidonTapia
 */
public class ControladorCliente {
     
    public void MostrarClientes(JTable tablaTotalClientes) {
         
    Controlador.Conexion objetoConexion = new Controlador.Conexion();
    
    Modelo.ModeloCliente objetoCliente = new Modelo.ModeloCliente();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    String sql;
    /*String sql = "";*/
    
      modelo.addColumn("Id");
      modelo.addColumn("Nombre");
      modelo.addColumn("Apellidos");
      modelo.addColumn("Telefono");
     
      tablaTotalClientes.setModel(modelo);
      
      sql = "select cliente.idcliente, cliente.nombre, cliente.apellidos, cliente.telefono from cliente";
      
        try {
            Statement st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                objetoCliente.setIdCliente(rs.getInt("idcliente"));
                objetoCliente.setNombres(rs.getString("nombre"));
                objetoCliente.setApellidos(rs.getString("apellidos"));
                objetoCliente.setTelefono(rs.getString("telefono"));

                  modelo.addRow(new Object[]{objetoCliente.getIdCliente(),objetoCliente.getNombres(),objetoCliente.getApellidos(),objetoCliente.getTelefono()});
                  
            }
            tablaTotalClientes.setModel(modelo);
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"error al mostrar usuarios"+ e.toString());
        }
        finally{
            objetoConexion.cerrarConexion();
        }
    }
    
    public void agregarCliente(JTextField nombres,JTextField apellidos,JTextField telefono){
    
        Controlador.Conexion objetoConexion = new Controlador.Conexion();
        Modelo.ModeloCliente objetoCliente = new Modelo.ModeloCliente();
        
    String consulta = "insert into cliente (nombre,apellidos,telefono) values (?,?,?);";
     
        try {
            objetoCliente.setNombres(nombres.getText());
            objetoCliente.setApellidos(apellidos.getText());
            objetoCliente.setTelefono(telefono.getText());
            
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, objetoCliente.getNombres());
            cs.setString(2, objetoCliente.getApellidos());
            cs.setString(3, objetoCliente.getTelefono());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"se guardo correctamente");

        } catch (HeadlessException | SQLException e) {
                        JOptionPane.showMessageDialog(null,"Error al guardar "+e.toString());

        }
        finally{
            objetoConexion.cerrarConexion();
        }
    }
    
    public void seleccionar (JTable totalcliente, JTextField id, JTextField nombres, JTextField apellidos, JTextField telefono){
    
        int fila = totalcliente.getSelectedRow();
        try {
            if (fila>=0) {
                
                id.setText(totalcliente.getValueAt(fila, 0).toString());
                nombres.setText(totalcliente.getValueAt(fila, 1).toString());
                apellidos.setText(totalcliente.getValueAt(fila, 2).toString());
                telefono.setText(totalcliente.getValueAt(fila, 3).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar cliente "+e.toString());
        }
    }
    
    public void ModificarCliente(JTextField id, JTextField nombres, JTextField apellidos, JTextField telefono){
        
        Controlador.Conexion objetoConexion = new Controlador.Conexion();
        
        Modelo.ModeloCliente objetoCliente = new Modelo.ModeloCliente();
        
    String consulta = "update cliente set cliente.nombre=?,cliente.apellidos=?,cliente.telefono=? where cliente.idcliente=?;";
        try {
            objetoCliente.setIdCliente(Integer.parseInt(id.getText()));
            objetoCliente.setNombres(nombres.getText());
            objetoCliente.setApellidos(apellidos.getText());
            objetoCliente.setTelefono(telefono.getText());
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);

            cs.setString(1, objetoCliente.getNombres());
            cs.setString(2, objetoCliente.getApellidos());
            cs.setString(3, objetoCliente.getTelefono());
            cs.setInt(4, objetoCliente.getIdCliente());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se Modifico Correctamente");
            
            
        } catch (NumberFormatException | SQLException e) {
           JOptionPane.showMessageDialog(null,"Error al Modificar cLiente "+ e.toString());
        }
        finally{
        objetoConexion.cerrarConexion();
        }
    }
    
    public void LimpiarCampos(JTextField id, JTextField nombres, JTextField apellidos, JTextField telefono){
        id.setText("");
        nombres.setText("");
        apellidos.setText("");
        telefono.setText("");
        
    }
    
    public void EliminarCliente (JTextField id){
        
    Controlador.Conexion objetoConexion = new Controlador.Conexion();
    
    Modelo.ModeloCliente objetoCliente = new Modelo.ModeloCliente();
    
    String consulta = "delete from cliente where cliente.idcliente=?;";
    
        try {
            objetoCliente.setIdCliente(Integer.parseInt(id.getText()));
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);

            cs.setInt(1,objetoCliente.getIdCliente());
            cs.executeQuery();
                       JOptionPane.showMessageDialog(null,"Se Elimino correctamente al cLiente");
            
        } catch (HeadlessException | NumberFormatException | SQLException e) {
                       JOptionPane.showMessageDialog(null,"Error al eliminar cLiente"+ e.toString());

        }finally{
            objetoConexion.cerrarConexion();
        }
    }       

}

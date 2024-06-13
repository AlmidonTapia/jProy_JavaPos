/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AlmidonTapia
 */
public class ContraladorProducto {
    
public void MostrarProductos(JTable tablaTotalProductos) {
    
   Controlador.Conexion objetoConexion = new Controlador.Conexion();
   
    Modelo.ModeloProducto objetoProducto = new Modelo.ModeloProducto();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    String sql;
    /*String sql = "";*/
    
      modelo.addColumn("id");
      modelo.addColumn("Nombre");
      modelo.addColumn("Precio");
      modelo.addColumn("Stock");
     
      tablaTotalProductos.setModel(modelo);
      
      sql = "select producto.idproducto,producto.nombre, producto.precioProducto, producto.stock from producto;";
      
        try {
            Statement st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                objetoProducto.setIdProducto(rs.getInt("idproducto"));
                objetoProducto.setNombreProducto(rs.getString("nombre"));
                objetoProducto.setPrecioProducto(rs.getDouble("PrecioProducto"));
                objetoProducto.setStockProducto(rs.getInt("stock"));

                  modelo.addRow(new Object[]{objetoProducto.getIdProducto(),objetoProducto.getNombreProducto(),objetoProducto.getPrecioProducto(),objetoProducto.getStockProducto()});
                  
            }
            tablaTotalProductos.setModel(modelo);
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"error al mostrar producto"+ e.toString());
        }
        finally{
            objetoConexion.cerrarConexion();
        }
}
    
}

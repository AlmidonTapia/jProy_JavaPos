/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ControladorProducto {
    
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

public void agregarProducto(String codigo, String nombre, String categoria, String proveedor, double precio, double stock) {
    try {
        Controlador.Conexion objetoConexion = new Conexion();

        // Verificar si el proveedor existe en la tabla Proveedores
        Connection conexion = objetoConexion.establecerConexion();
        String sqlProveedor = "SELECT id FROM Proveedores WHERE nombre = ?";
        PreparedStatement stProveedor = conexion.prepareStatement(sqlProveedor);
        stProveedor.setString(1, proveedor);
        ResultSet rsProveedor = stProveedor.executeQuery();

        int idProveedor;
        if (!rsProveedor.next()) {
            // Si el proveedor no existe, insertarlo en la tabla Proveedores
            String sqlInsertProveedor = "INSERT INTO Proveedores (nombre) VALUES (?)";
            PreparedStatement stInsertProveedor = conexion.prepareStatement(sqlInsertProveedor, Statement.RETURN_GENERATED_KEYS);
            stInsertProveedor.setString(1, proveedor);
            stInsertProveedor.executeUpdate();
            ResultSet rsInsertProveedor = stInsertProveedor.getGeneratedKeys();
            rsInsertProveedor.next();
            idProveedor = rsInsertProveedor.getInt(1);
        } else {
            idProveedor = rsProveedor.getInt("id");
        }

        // Verificar si el producto existe en la tabla Productos
        String sqlProducto = "SELECT id FROM Productos WHERE codigo = ?";
        PreparedStatement stProducto = conexion.prepareStatement(sqlProducto);
        stProducto.setString(1, codigo);
        ResultSet rsProducto = stProducto.executeQuery();

        if (rsProducto.next()) {
            // Si el producto existe, actualizar el stock
            int idProducto = rsProducto.getInt("id");
            double nuevoStock = obtenerStockProducto(idProducto) + stock;
            actualizarStockProducto(idProducto, nuevoStock);

            // Verificar si la relación entre el producto y el proveedor ya existe
            String sqlRelacion = "SELECT * FROM ProductosProveedores WHERE id_producto = ? AND id_proveedor = ?";
            PreparedStatement stRelacion = conexion.prepareStatement(sqlRelacion);
            stRelacion.setInt(1, idProducto);
            stRelacion.setInt(2, idProveedor);
            ResultSet rsRelacion = stRelacion.executeQuery();
            if (!rsRelacion.next()) {
                // Si la relación no existe, insertarla
                String sqlInsertRelacion = "INSERT INTO ProductosProveedores (id_producto, id_proveedor) VALUES (?, ?)";
                PreparedStatement stInsertRelacion = conexion.prepareStatement(sqlInsertRelacion);
                stInsertRelacion.setInt(1, idProducto);
                stInsertRelacion.setInt(2, idProveedor);
                stInsertRelacion.executeUpdate();
            }
        } else {
            // Si el producto no existe, insertarlo en la tabla Productos
            String sqlInsertProducto = "INSERT INTO Productos (codigo, nombre, categoria, precio, stock) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stInsertProducto = conexion.prepareStatement(sqlInsertProducto, Statement.RETURN_GENERATED_KEYS);
            stInsertProducto.setString(1, codigo);
            stInsertProducto.setString(2, nombre);
            stInsertProducto.setString(3, categoria);
            stInsertProducto.setDouble(4, precio);
            stInsertProducto.setDouble(5, stock);
            stInsertProducto.executeUpdate();
            ResultSet rsInsertProducto = stInsertProducto.getGeneratedKeys();
            rsInsertProducto.next();
            int idProducto = rsInsertProducto.getInt(1);

            // Insertar la relación entre el producto y el proveedor
            String sqlInsertRelacion = "INSERT INTO ProductosProveedores (id_producto, id_proveedor) VALUES (?, ?)";
            PreparedStatement stInsertRelacion = conexion.prepareStatement(sqlInsertRelacion);
            stInsertRelacion.setInt(1, idProducto);
            stInsertRelacion.setInt(2, idProveedor);
            stInsertRelacion.executeUpdate();
        }

        objetoConexion.cerrarConexion();
    } catch (SQLException e) {
        System.out.println("Error al agregar el producto: " + e.getMessage());
    }
}

private double obtenerStockProducto(int idProducto) {
    // Implementar método para obtener el stock de un producto
    return 0.0;
}

private void actualizarStockProducto(int idProducto, double nuevoStock) {
    // Implementar método para actualizar el stock de un producto
}
}

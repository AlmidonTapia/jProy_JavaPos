/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.ModeloUsuario;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AlmidonTapia
 */
public class ControladorUsuario {
    private static ModeloUsuario usuarioActual;
    private static boolean inicioSesionExitoso;
    //INICIAR SESION
    public static boolean iniciarSesion(String correo, String contraseña) {
        
        Controlador.Conexion objetoConexion = new Conexion();
        try {
            Connection conexion = objetoConexion.establecerConexion();
            String sql = "SELECT * FROM Usuarios WHERE correo = ? AND contraseña = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, correo);
            statement.setString(2, contraseña);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                usuarioActual = new ModeloUsuario(
                        resultSet.getInt("idUsuario"),
                        resultSet.getString("nombres"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("correo"),
                        resultSet.getString("contraseña"),
                        resultSet.getBoolean("admin_Principal")
                );
                inicioSesionExitoso = true;
                }
            else {
                inicioSesionExitoso = false;
                }
            objetoConexion.cerrarConexion();
            return inicioSesionExitoso;
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
            return false;
        }
    }
    //CERRR SESION
    public static void cerrarSesion() {
        usuarioActual = null;
    }
    //MOSTRAR USUARIOS
    public void MostrarUsuarios(JTable tablaTotalUsuarios) {
         
    Controlador.Conexion objetoConexion = new Controlador.Conexion();
    
    Modelo.ModeloUsuario objetoUsuario = new Modelo.ModeloUsuario();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    String sql;
    /*String sql = "";*/
    
      modelo.addColumn("Id");
      modelo.addColumn("Nombre");
      modelo.addColumn("Apellidos");
      modelo.addColumn("Correo");
      modelo.addColumn("Contraseña");
      modelo.addColumn("Admin principal");
     
      tablaTotalUsuarios.setModel(modelo);
      
      sql = "select Usuarios.id_usuario, Usuarios.nombre, Usuarios.apellidos, Usuarios.correo,Usuarios.contraseña, Usuarios.admin_Principal from Usuarios";
      
        try {
            Statement st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                objetoUsuario.setIdUsuario(rs.getInt("Id"));
                objetoUsuario.setNombre(rs.getString("Nombre"));
                objetoUsuario.setApellidos(rs.getString("Apellidos"));
                objetoUsuario.setCorreo(rs.getString("Correo"));
                objetoUsuario.setContraseña(rs.getString("Contraseña"));
                objetoUsuario.setAdminPrincipal(rs.getBoolean("Admin Principal"));

                  modelo.addRow(new Object[]{objetoUsuario.getIdUsuario(),objetoUsuario.getNombre(),objetoUsuario.getApellidos(),objetoUsuario.getCorreo(),objetoUsuario.getContraseña(),objetoUsuario.getAdminPrincipal()});
                  
            }
            tablaTotalUsuarios.setModel(modelo);
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"error al mostrar usuarios"+ e.toString());
        }
        finally{
            objetoConexion.cerrarConexion();
        }
    }
    //INGRESAR NUEVOS USUARIOS
    public void agregarUsuario(JTextField idField, JTextField nombresField, JTextField apellidosField, JTextField correoField, JTextField contraseñaField, JComboBox<String> adminPrincipalCombo) {
    
    Controlador.Conexion conexion = new Controlador.Conexion();
    Modelo.ModeloUsuario usuario = new Modelo.ModeloUsuario();
    
    String consulta = "INSERT INTO Usuarios (id_usuario, nombre, apellidos, correo, contrasenia, admin_principal) VALUES (?, ?, ?, ?, ?, ?)";
     
    try {
        int idUsuario = Integer.parseInt(idField.getText());
        boolean adminPrincipal;
        
        if (adminPrincipalCombo != null && adminPrincipalCombo.getSelectedIndex() == 0) {
            adminPrincipal = true;
        } else {
            adminPrincipal = false;
        }
        
        usuario.setIdUsuario(idUsuario);
        usuario.setNombre(nombresField.getText());
        usuario.setApellidos(apellidosField.getText());
        usuario.setCorreo(correoField.getText());
        usuario.setContraseña(contraseñaField.getText());
        usuario.setAdminPrincipal(adminPrincipal);
        
        CallableStatement cs = conexion.establecerConexion().prepareCall(consulta);
        cs.setInt(1, usuario.getIdUsuario());
        cs.setString(2, usuario.getNombre());
        cs.setString(3, usuario.getApellidos());
        cs.setString(4, usuario.getCorreo());
        cs.setString(5, usuario.getContraseña());
        cs.setBoolean(6, usuario.getAdminPrincipal());
        
        cs.execute();
        
        JOptionPane.showMessageDialog(null, "Se guardó correctamente");

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: El ID de usuario debe ser un número");
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al guardar: " + e.toString());
    } finally {
        conexion.cerrarConexion();
    }
    }
    //SELECCIONAR USUARIO
    public void seleccionar(JTable tablaUsuarios, JTextField id_usuario, JTextField nombre, JTextField apellidos, JTextField correo, JTextField contrasenia, JComboBox<String> admin_principal) {
    int filaSeleccionada = tablaUsuarios.getSelectedRow();
    try {
        if (filaSeleccionada >= 0) {
            id_usuario.setText(tablaUsuarios.getValueAt(filaSeleccionada, 0).toString());
            nombre.setText(tablaUsuarios.getValueAt(filaSeleccionada, 1).toString());
            apellidos.setText(tablaUsuarios.getValueAt(filaSeleccionada, 2).toString());
            correo.setText(tablaUsuarios.getValueAt(filaSeleccionada, 3).toString());
            contrasenia.setText(tablaUsuarios.getValueAt(filaSeleccionada, 4).toString());
            
            // Establecer el valor del JComboBox según el valor de la base de datos
            boolean esAdminPrincipal = Boolean.parseBoolean(tablaUsuarios.getValueAt(filaSeleccionada, 5).toString());
            if (esAdminPrincipal) {
                admin_principal.setSelectedItem("Admin Principal");
            } else {
                admin_principal.setSelectedItem("Admin Regular");
                }
            }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al seleccionar usuario: " + e.toString());
        }
    }
    // Método para eliminar un usuario
    public void eliminar(JTable tablaUsuarios, JTextField id_usuario) {
    int filaSeleccionada = tablaUsuarios.getSelectedRow();
    try {
        if (filaSeleccionada >= 0) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                // Aquí iría la lógica para eliminar el usuario de la base de datos
                String idUsuario = id_usuario.getText();
                // Eliminar el usuario de la base de datos usando el idUsuario
                
                // Después de eliminar el usuario, refrescar la tabla de usuarios
                ((DefaultTableModel) tablaUsuarios.getModel()).removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario de la tabla.");
        }
    } catch (HeadlessException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.toString());
    }
}
    // Método para modificar un usuario
    public void modificar(JTable tablaUsuarios, JTextField id_usuario, JTextField nombre, JTextField apellidos, JTextField correo, JTextField contrasenia, JComboBox<String> admin_principal) {
    int filaSeleccionada = tablaUsuarios.getSelectedRow();
    try {
        if (filaSeleccionada >= 0) {
            String idUsuario = id_usuario.getText();
            String nombreUsuario = nombre.getText();
            String apellidosUsuario = apellidos.getText();
            String correoUsuario = correo.getText();
            String contraseniaUsuario = contrasenia.getText();
            boolean esAdminPrincipal = admin_principal.getSelectedItem().equals("Sí");
            
            // Aquí iría la lógica para modificar el usuario en la base de datos
            // Actualizar los datos del usuario en la base de datos usando los valores obtenidos
            
            // Después de modificar el usuario, refrescar la tabla de usuarios
            tablaUsuarios.setValueAt(idUsuario, filaSeleccionada, 0);
            tablaUsuarios.setValueAt(nombreUsuario, filaSeleccionada, 1);
            tablaUsuarios.setValueAt(apellidosUsuario, filaSeleccionada, 2);
            tablaUsuarios.setValueAt(correoUsuario, filaSeleccionada, 3);
            tablaUsuarios.setValueAt(contraseniaUsuario, filaSeleccionada, 4);
            tablaUsuarios.setValueAt(esAdminPrincipal ? "Sí" : "No", filaSeleccionada, 5);
            
            JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario de la tabla.");
        }
    } catch (HeadlessException e) {
        JOptionPane.showMessageDialog(null, "Error al modificar usuario: " + e.toString());
    }
    }
    // Método para limpiar los campos de texto y el JComboBox
    public void limpiar_campos(JTextField id_usuario, JTextField nombre, JTextField apellidos, JTextField correo, JTextField contrasenia, JComboBox<String> admin_principal) {
    id_usuario.setText("");
    nombre.setText("");
    apellidos.setText("");
    correo.setText("");
    contrasenia.setText("");
    admin_principal.setSelectedIndex(0); // Seleccionar la primera opción del JComboBox
    }
    public static ModeloUsuario getUsuarioActual() {
        return usuarioActual;
    }  
}

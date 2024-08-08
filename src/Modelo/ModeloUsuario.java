/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author AlmidonTapia
 */
public class ModeloUsuario {
    int idUsuario;
    String nombre;
    String apellidos;
    String correo;
    String contraseña;
    Boolean adminPrincipal;

    public ModeloUsuario() {
    }

    public ModeloUsuario(int idUsuario, String nombre, String apellidos, String correo, String contraseña, Boolean adminPrincipal) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contraseña = contraseña;
        this.adminPrincipal = adminPrincipal;
    }
    
    
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Boolean getAdminPrincipal() {
        return adminPrincipal;
    }

    public void setAdminPrincipal(Boolean adminPrincipal) {
        this.adminPrincipal = adminPrincipal;
    }


}

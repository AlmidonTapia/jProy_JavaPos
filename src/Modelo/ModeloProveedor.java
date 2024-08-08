/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author AlmidonTapia
 */
public class ModeloProveedor {
    int idProveedor;
    String nombres;
    String telefono;
    String correo;

    public ModeloProveedor() {
    }

    public ModeloProveedor(int idProveedor, String nombres, String telefono, String correo) {
        this.idProveedor = idProveedor;
        this.nombres = nombres;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}

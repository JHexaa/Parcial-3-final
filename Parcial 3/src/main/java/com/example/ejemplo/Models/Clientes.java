package com.example.ejemplo.Models;

public class Clientes {
    private String Usuario;
    private String Nombre;
    private String Apellido;
    private String Telefono;

    public Clientes(String usuario, String nombre, String apellido, String telefono) {
        Usuario = usuario;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
    }

    public Clientes() {
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}

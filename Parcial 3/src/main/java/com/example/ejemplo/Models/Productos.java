package com.example.ejemplo.Models;

public class Productos {
  private int Id;
  private String Nombre;
  private Float Precio;
  private String Edition;
  private String Foto;
  private int Stock;
  private String FechaImpresion;
  private String FechaPublicacion;

  public Productos(int id, String edition, String nombre, String fechaImpresion, String fechaPublicacion, float precio, int stock, String foto) {
    Id = id;
    Nombre = nombre;
    Precio = precio;
    Edition = edition;
    Foto = foto;
    Stock = stock;
    FechaImpresion = fechaImpresion;
    FechaPublicacion = fechaPublicacion;
  }

  public Productos(int id, int stock){
    Id=id;
    Stock=stock;
  }

  public Productos() {
  }

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public String getNombre() {
    return Nombre;
  }

  public void setNombre(String nombre) {
    Nombre = nombre;
  }

  public Float getPrecio() {
    return Precio;
  }

  public void setPrecio(Float precio) {
    Precio = precio;
  }

  public String getEdition() {
    return Edition;
  }

  public void setEdition(String edition) {
    Edition = edition;
  }

  public String getFoto() {
    return Foto;
  }

  public void setFoto(String foto) {
    Foto = foto;
  }

  public int getStock() {
    return Stock;
  }

  public void setStock(int stock) {
    Stock = stock;
  }

  public String getFechaImpresion() {
    return FechaImpresion;
  }

  public void setFechaImpresion(String fechaImpresion) {
    FechaImpresion = fechaImpresion;
  }

  public String getFechaPublicacion() {
    return FechaPublicacion;
  }

  public void setFechaPublicacion(String fechaPublicacion) {
    FechaPublicacion = fechaPublicacion;
  }
}

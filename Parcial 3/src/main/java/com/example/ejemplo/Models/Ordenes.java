package com.example.ejemplo.Models;

public class Ordenes {
    private int OrderId,ProductoId,Cantidad;
    private String Cliente,FechaVenta,Direccion,Pais;

    public Ordenes(int orderid, String cliente, int producotoid, int cantidad,String fecha,String direccion,String pais){
        OrderId=orderid;
        Cliente=cliente;
        ProductoId=producotoid;
        Cantidad=cantidad;
        FechaVenta=fecha;
        Direccion=direccion;
        Pais=pais;
    }

    public Ordenes(){

    }

    public int getOrderId(){
        return OrderId;
    }
    public int getProductoId(){
        return ProductoId;
    }
    public int getCantidad(){
        return Cantidad;
    }
    public String getCliente(){
        return Cliente;
    }
    public String getFechaVenta(){
        return FechaVenta;
    }
    public String getDireccion(){
        return Direccion;
    }
    public String getPais(){
        return Pais;
    }

    public void setOrderId(int id){
        OrderId=id;
    }
    public void setProductoId(int productoid){
        ProductoId=productoid;
    }
    public void setCantidad(int cantidad){
        Cantidad=cantidad;
    }
    public void setCliente(String cliente){
        Cliente=cliente;
    }
    public void setFechaVenta(String fecha){
        FechaVenta=fecha;
    }
    public void setDireccion(String direccion){
        Direccion=direccion;
    }
    public void setPais(String pais){
        Pais=pais;
    }
    
}

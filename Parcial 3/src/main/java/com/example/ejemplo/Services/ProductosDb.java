package com.example.ejemplo.Services;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.ejemplo.Models.*;

public class ProductosDb {
  Connection _cn;
  int x;

  public ProductosDb() {
    _cn = new Conexion().openDb();
  }

  public List<Productos> ObtenerProductos() {
    try {
      Statement stmt = _cn.createStatement();
      String query = "SELECT * FROM productos";

      List<Productos> productos = new ArrayList<>();
      ResultSet result = stmt.executeQuery(query);
      while (result.next()) {
        Productos producto = new Productos(
            result.getInt("id"),
            result.getString("edition"),
            result.getString("nombre"),
            result.getString("fecha_Impresion"),
            result.getString("fecha_Publicacion"),
            result.getFloat("precio"),
            result.getInt("stock"),
            result.getString("ruta_img"));

        productos.add(producto);
      }

      result.close();
      stmt.close();
      return productos;

    } catch (Exception e) {
      x = 1;
    }
    return null;
  }

  public List<Ordenes> ObtenerOrdenes(String cliente) {
    try {
      Statement stmt = _cn.createStatement();
      String query = "SELECT * FROM ordenes where cliente='" + cliente + "'";

      List<Ordenes> ordenes = new ArrayList<>();
      ResultSet result = stmt.executeQuery(query);
      while (result.next()) {
        Ordenes orden = new Ordenes(
            result.getInt("order_id"),
            result.getString("cliente"),
            result.getInt("id_producto"),
            result.getInt("cantidad"),
            result.getString("fecha_venta"),
            result.getString("direccion"),
            result.getString("pais"));

        ordenes.add(orden);
      }

      result.close();
      stmt.close();
      return ordenes;

    } catch (Exception e) {
      x = 1;
    }
    return null;
  }

  public int RegistrarOrdenes(Ordenes orden) {
    int resultado = 0;
    try {
      Statement stm = _cn.createStatement();
      String query = "EXEC insertar_ordenes '"
          + orden.getCliente() + "','"
          + orden.getProductoId() + "','"
          + orden.getCantidad() + "','"
          + orden.getDireccion() + "','"
          + orden.getPais() + "'";

      resultado = stm.executeUpdate(query);
      return resultado;
    } catch (Exception e) {
      x = 1;
    }
    return resultado;
  }

  public int RegistrarCliente(Clientes cliente) {
    int resultado = 0;
    try {
      Statement stm = _cn.createStatement();
      String query = "EXEC insertar_clientes '"
          + cliente.getUsuario() + "','"
          + cliente.getNombre() + "','"
          + cliente.getApellido() + "','"
          + cliente.getTelefono() + " ' ";
      resultado = stm.executeUpdate(query);

      return resultado;
    } catch (Exception e) {
      x = 1;
    }
    return resultado;
  }

  public int ActualizarStock(Productos producto) {
    int resultado = 0;
    try {
      Statement stm = _cn.createStatement();
      String query = "EXEC Actualizar_Stock "
        + producto.getId() + ","
        + producto.getStock();
    
      resultado = stm.executeUpdate(query);
  
      return resultado;
    } catch (Exception e) {
    x = 1;
    }
    return resultado;
  }

  /*
   * public int GuardarProductos(Productos producto) {
   * int resultado = 0;
   * try {
   * Statement stm = _cn.createStatement();
   * String query = "EXEC InsertarProducto '"
   * + producto.getNombre() + "',"
   * + producto.getPrecio() + ","
   * + producto.getCategoriaId() + ",'"
   * + producto.getFoto() + "','"
   * + producto.getFechaProduccion() + "','"
   * + producto.getFechaCaducidad() + "'";
   * 
   * resultado = stm.executeUpdate(query);
   * 
   * return resultado;
   * } catch (Exception e) {
   * x = 1;
   * }
   * return resultado;
   * }
   * 
   * public int ActualizarProductos(Productos producto) {
   * int resultado = 0;
   * try {
   * Statement stm = _cn.createStatement();
   * String query = "EXEC ActualizarProducto "
   * + producto.getId() + ",'"
   * + producto.getNombre() + "',"
   * + producto.getPrecio() + ","
   * + producto.getCategoriaId() + ",'"
   * + producto.getFoto() + "','"
   * + producto.getFechaProduccion() + "','"
   * + producto.getFechaCaducidad() + "'";
   * 
   * resultado = stm.executeUpdate(query);
   * 
   * return resultado;
   * } catch (Exception e) {
   * x = 1;
   * }
   * return resultado;
   * }
   * 
   * public int EliminarProducto(int pid) {
   * int resultado = 0;
   * try {
   * Statement stmt = _cn.createStatement();
   * String query = "EXEC EliminarProducto " + pid;
   * 
   * return stmt.executeUpdate(query);
   * 
   * } catch (Exception e) {
   * x = 1;
   * }
   * return resultado;
   * }
   */
}

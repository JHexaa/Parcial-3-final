package com.example.ejemplo.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplo.Models.Productos;
import com.example.ejemplo.Models.Ordenes;
import com.example.ejemplo.Models.Clientes;
import com.example.ejemplo.Services.ProductosDb;

@RestController
public class ProductosController {

  @GetMapping("/productos/all")
  public List<Productos> ObtenerTodosProductos() {
    return new ProductosDb().ObtenerProductos();
  }

  @GetMapping("/ordenes/{cliente}")
  public List<Ordenes> ObtenerOrdenes(@PathVariable("cliente") String cliente) {
    return new ProductosDb().ObtenerOrdenes(cliente);
  }

  @PostMapping("/orden")
  public int InsertarOrdenes(@RequestBody Ordenes orden) {
    return new ProductosDb().RegistrarOrdenes(orden);
  }

  @PostMapping("/cliente")
  public int InsertarCliente(@RequestBody Clientes cliente) {
    return new ProductosDb().RegistrarCliente(cliente);
  }

  @PutMapping("/producto")
   public int ActualizarStock(@RequestBody Productos producto) {
   return new ProductosDb().ActualizarStock(producto);
   }
}

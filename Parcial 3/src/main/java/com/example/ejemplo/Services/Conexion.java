package com.example.ejemplo.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
  int x;

  public Connection openDb() {
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      return DriverManager.getConnection(
          "jdbc:sqlserver://Desktop-Juan;encrypt=true;trustServerCertificate=true;databaseName=berserk", "sa",
          "admin123");
    } catch (SQLException e) {
      x = 1;
    } catch (ClassNotFoundException cnfex) {
      x = 1;
    }
    return null;
  }
}

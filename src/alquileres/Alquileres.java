/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alquileres;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alex
 */
public class Alquileres {

  private static final String URL = "jdbc:mysql://localhost:3306/alquileres";
  private static final String USUARIO = "root";
  private static final String CONTRASEÑA = "";
  private DefaultTableModel modelo;

    public Alquileres(JTable modelo) {
        this.modelo=(DefaultTableModel)modelo.getModel();
    }
    
    public void Conexion(){
      try (
          Connection connection= DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
          Statement stmt= connection.createStatement();)
      {System.out.println("Conexion exitosa");
          String consulta="SELECT * FROM registros";
          ResultSet rS=stmt.executeQuery(consulta);
          modelo.setRowCount(0);
          while (rS.next()) {
                // Obtén los datos de la fila actual
                Object[] row = new Object[13]; 

                for (int i = 1; i <= 13; i++) {
                    // Agrega los valores de la base de datos a las columnas del array
                    row[i - 1] = rS.getObject(i);
                }

                // Agrega la fila al modelo
                modelo.addRow(row);
            }
           connection.close();
           stmt.close();
      } catch (SQLException ex) {
          System.out.println("Conexion fallida");
          Logger.getLogger(Alquileres.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    public void Busqueda(String fechaI, String fechaO){
        try(Connection connection= DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
          Statement stmt= connection.createStatement();)
          {System.out.println("Conexion exitosa");
           
            if(fechaI!=null||fechaO!=null){
                String consulta="SELECT * FROM registros WHERE Fecha_entrada BETWEEN '"+fechaI+"' AND '"+fechaO+"'";
                ResultSet rS=stmt.executeQuery(consulta);
                modelo.setRowCount(0);
                while (rS.next()) {
                // Obtén los datos de la fila actual
                    Object[] row = new Object[13]; 

                    for (int i = 1; i <= 13; i++) {
                    // Agrega los valores de la base de datos a las columnas del array
                    row[i - 1] = rS.getObject(i);
                }

                // Agrega la fila al modelo
                modelo.addRow(row);
            } 
      }else{
          JOptionPane.showMessageDialog(null, "Introduce fechas antes de buscar");
      }
           connection.close();
           stmt.close();
      }catch(SQLException ex){
            System.out.println("Conexion fallida");
            Logger.getLogger(Alquileres.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public static String getURL() {
        return URL;
    }

    public static String getUSUARIO() {
        return USUARIO;
    }

    public static String getCONTRASEÑA() {
        return CONTRASEÑA;
    }
  
  
    
}

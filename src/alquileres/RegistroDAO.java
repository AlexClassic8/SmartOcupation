/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alquileres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class RegistroDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/alquileres";
    private static final String USUARIO = "root";
    private static final String PASS = "";
    
    public static void guardarRegistro(Registro registro) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, PASS)) {
            // La consulta SQL para insertar un registro en la base de datos
            String sql = "INSERT INTO registros (ID,Fecha_entrada, Meses_contrato, Nombre, Apellidos, DNI, N_Telefono, Correo, ID_Vivienda, Ubicacion, Metros, N_Habitaciones, Mensualidad) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Establecer los valores en la consulta preparada
                preparedStatement.setString(1, registro.getId());
                preparedStatement.setString(2, registro.getDiaEntrada());
                preparedStatement.setString(3, registro.getMesesContrato());
                preparedStatement.setString(4, registro.getNombre());
                preparedStatement.setString(5, registro.getApellidos());
                preparedStatement.setString(6, registro.getDni());
                preparedStatement.setString(9, registro.getIdPropiedad());
                preparedStatement.setString(10, registro.getUbicacion());
                preparedStatement.setString(8, registro.getCorreo());
                preparedStatement.setInt(7, registro.getnTelefono());
                preparedStatement.setInt(11, registro.getMetros());
                preparedStatement.setInt(12, registro.getnHabitaciones());
                preparedStatement.setInt(13, registro.getMensualidad());

                // Ejecutar la consulta
                preparedStatement.executeUpdate();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

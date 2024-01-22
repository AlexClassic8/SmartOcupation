/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alquileres;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Informe {

    public static void generarInforme(JTable tabla) {
        // Crea un JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Establece un filtro para permitir solo archivos con extensión ".csv"
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV (*.csv)", "csv");
        fileChooser.setFileFilter(filter);

        // Muestra el cuadro de diálogo de guardar archivo
        int seleccion = fileChooser.showSaveDialog(null);

        // Verifica si el usuario seleccionó un archivo y presionó "Guardar"
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            // Obtiene el archivo seleccionado
            java.io.File archivo = fileChooser.getSelectedFile();

            // Agrega la extensión ".csv" si no está presente
            if (!archivo.getName().toLowerCase().endsWith(".csv")) {
                archivo = new java.io.File(archivo.getAbsolutePath() + ".csv");
            }

            // Guarda los datos de la tabla en el archivo CSV
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                guardarDatosCSV(writer, tabla);
                System.out.println("Datos guardados en el archivo: " + archivo.getAbsolutePath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void guardarDatosCSV(BufferedWriter writer, JTable tabla) throws IOException {
        // Obtiene el modelo de la tabla
        javax.swing.table.TableModel model = tabla.getModel();

        // Guarda los encabezados de columnas
        for (int col = 0; col < model.getColumnCount(); col++) {
            writer.write(model.getColumnName(col));
            if (col < model.getColumnCount() - 1) {
                writer.write(",");
            }
        }
        writer.write("\n");

        // Guarda los datos de cada fila
        for (int row = 0; row < model.getRowCount(); row++) {
            for (int col = 0; col < model.getColumnCount(); col++) {
                Object value = model.getValueAt(row, col);
                writer.write(value != null ? value.toString() : "");  // Verifica si el valor es nulo
                if (col < model.getColumnCount() - 1) {
                    writer.write(",");
                }
            }
            writer.write("\n");
        }
    }
}

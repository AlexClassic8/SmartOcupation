/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alquileres;

/**
 *
 * @author Alex
 */
public class Registro {
    private String id,nombre, apellidos, dni, idPropiedad, ubicacion, correo, diaEntrada, mesesContrato;
    private int  nTelefono,metros,nHabitaciones,mensualidad;

    public Registro() {
    }

    public Registro(String id, String fecha, String nombre, String apellidos, String dni, String idPropiedad, String ubicacion, String correo, String diaEntrada, int nTelefono, int metros, int nHabitaciones, int mensualidad) {
        this.id = id;
        this.mesesContrato = fecha;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.idPropiedad = idPropiedad;
        this.ubicacion = ubicacion;
        this.correo = correo;
        this.diaEntrada = diaEntrada;
        this.nTelefono = nTelefono;
        this.metros = metros;
        this.nHabitaciones = nHabitaciones;
        this.mensualidad = mensualidad;
    }

    

    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMesesContrato() {
        return mesesContrato;
    }

    public void setMesesContrato(String mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(String diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public int getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(int nTelefono) {
        this.nTelefono = nTelefono;
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }

    public int getnHabitaciones() {
        return nHabitaciones;
    }

    public void setnHabitaciones(int nHabitaciones) {
        this.nHabitaciones = nHabitaciones;
    }

    public int getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(int mensualidad) {
        this.mensualidad = mensualidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}

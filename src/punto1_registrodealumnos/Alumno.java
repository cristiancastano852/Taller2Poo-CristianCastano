package punto1_registrodealumnos;

import java.util.ArrayList;

public class Alumno {
  private String nombre;
  private int edad;
  private ArrayList<Double> calificaciones;

  public Alumno(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
    this.calificaciones = new ArrayList<Double>();
  }

  public String getNombre() {
    return nombre;
  }

  public int getEdad() {
    return edad;
  }

  public ArrayList<Double> getCalificaciones(){
    return calificaciones;
  }

  public void agregarCalificacion(double calificacion) {
    calificaciones.add(calificacion);
  }

  public void mostrarInformacion() {
    System.out.println("Nombre: " + nombre);
    System.out.println("Edad: " + edad);
    System.out.println("Calificaciones: " + calificaciones.toString());
  }
}

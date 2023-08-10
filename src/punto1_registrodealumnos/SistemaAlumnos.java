package punto1_registrodealumnos;

import java.util.ArrayList;

public class SistemaAlumnos {
  private ArrayList<Alumno> alumnos;

  public SistemaAlumnos() {
    this.alumnos = new ArrayList<Alumno>();
  }

  public void agregarAlumno(Alumno alumno) {
    alumnos.add(alumno);
  }

  public void asignarCalificacion(String nombreAlumno, double calificacion) {
    for (Alumno alumno : alumnos) {
      if (alumno.getNombre().equals(nombreAlumno)) {
        alumno.agregarCalificacion(calificacion);
        break;
      }
    }
  }

  public double calcularPromedio(String nombreAlumno) {
    double suma = 0;
    int contador = 0;
    for (Alumno alumno : alumnos) {
      if (alumno.getNombre().equals(nombreAlumno)) {
        for (double calificacion : alumno.getCalificaciones()) {
          suma += calificacion;
          contador++;
        }
        break;
      }
    }
    double promedio = suma / contador;
    return Math.round(promedio * 100.0) / 100.0;
  }

  public void mostrarInformacionAlumnos() {
    for (Alumno alumno : alumnos) {
      alumno.mostrarInformacion();
      System.out.println("Promedio: " + calcularPromedio(alumno.getNombre()));
      System.out.println();
    }
  }
}

package punto4_sistemadereservashotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
     private String nombre;
    private List<Habitacion> habitaciones;

    public Hotel(String nombre, int cantidadHabitaciones) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        for (int i = 1; i <= cantidadHabitaciones; i++) {
            habitaciones.add(new Habitacion(i));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<Habitacion> getHabitacionesDisponibles() {
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isDisponible()) {
                habitacionesDisponibles.add(habitacion);
            }
        }
        return habitacionesDisponibles;
    }
    
}

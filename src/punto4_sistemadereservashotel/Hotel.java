package punto4_sistemadereservashotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
     private String nombre;
     private List<Habitacion> habitaciones;
     private List<Reserva> reservas;

    public Hotel(String nombre, int cantidadHabitaciones) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        for (int i = 1; i <= cantidadHabitaciones; i++) {
            habitaciones.add(new Habitacion(i));
        }
        this.reservas = new ArrayList<>();
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

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void reservar(Cliente cliente, Habitacion habitacion) {
        Reserva reserva = new Reserva(cliente, habitacion);
        reservas.add(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        reserva.cancelar();
        reservas.remove(reserva);
    }
    
}

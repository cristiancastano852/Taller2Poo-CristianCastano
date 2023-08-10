package punto4_sistemadereservashotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaReservas {
    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("Hotel Las vegas", 10);
        Hotel hotel2 = new Hotel("Hotel Los Angeles", 15);
        Hotel hotel3 = new Hotel("Hotel Miami", 20);

        Cliente cliente1 = new Cliente("CRISTIAN","SOFLOND", "123456789");
        Cliente cliente2 = new Cliente("ALEXANDER", "IBM", "987654321");

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva(cliente1, hotel1.getHabitacionesDisponibles().get(0)));
        reservas.add(new Reserva(cliente2, hotel2.getHabitacionesDisponibles().get(0)));
        reservas.add(new Reserva(cliente1, hotel1.getHabitacionesDisponibles().get(1)));

        Map<Hotel, List<Reserva>> reservasPorHotel = new HashMap<>();
        // Iteramos sobre las reservas y las agrupamos por hotel
        for (Reserva reserva : reservas) {
            Hotel hotel = getHotelFromReserva(reserva);
            reservasPorHotel.computeIfAbsent(hotel, k -> new ArrayList<>()).add(reserva);
        }

        //
        // Imprimimos las reservas por hotel
        for (Map.Entry<Hotel, List<Reserva>> entry : reservasPorHotel.entrySet()) {
            Hotel hotel = entry.getKey();
            List<Reserva> reservasEnHotel = entry.getValue();

            System.out.println("Hotel: " + hotel.getNombre());
            for (Reserva reserva : reservasEnHotel) {
                Cliente cliente = reserva.getCliente();
                Habitacion habitacion = reserva.getHabitacion();
                System.out.println("Cliente: " + cliente.getNombre() + " (Cédula: " + cliente.getCedula() + ")");
                System.out.println("Habitación: " + habitacion.getNumero());
            }
            System.out.println();
        }
    }

    private static Hotel getHotelFromReserva(Reserva reserva) {
        return reserva.getHabitacion().getNumero() <= 10 ? new Hotel("Hotel A", 10) : new Hotel("Hotel B", 15);
    }
}

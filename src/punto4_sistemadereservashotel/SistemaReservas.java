package punto4_sistemadereservashotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaReservas {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Hotel> hoteles = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Crear hoteles
        hoteles.add(new Hotel("Hotel Miami", 10));
        hoteles.add(new Hotel("Hotel Las Vegas", 15));
        hoteles.add(new Hotel("Hotel New York", 12));

        while (true) {
            while (true) {
                mostrarMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada
    
                switch (opcion) {
                    case 1:
                        hacerReserva();
                        break;
                    case 2:
                        cancelarReserva();
                        break;
                    case 0:
                        System.out.println("¡Gracias por usar el sistema de reservas!");
                        return;
                    default:
                        System.out.println("Opción no válida. Seleccione una opción válida.");
                }
            }

    
        }
    }

    private static void mostrarMenu() {
            System.out.println("Bienvenido al sistema de reservas de hoteles");
            System.out.println("1. Reservar Habitacion");
            System.out.println("2. Cancelar reserva");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
        }

    public static void hacerReserva(){
            Hotel hotelElegido = ListaHotelesDisponibles();
            List<Habitacion> habitacionesDisponibles = hotelElegido.getHabitacionesDisponibles();
            System.out.println("Habitaciones disponibles:");
            for (Habitacion habitacion : habitacionesDisponibles) {
                System.out.println(habitacion.getNumero());
            }

            System.out.print("Seleccione el número de habitación: ");
            int numeroHabitacion = scanner.nextInt();
            Habitacion habitacionElegida = null;

            for (Habitacion habitacion : habitacionesDisponibles) {
                if (habitacion.getNumero() == numeroHabitacion) {
                    if (habitacion.isDisponible()) {
                        habitacionElegida = habitacion;
                        
                        break;
                    }
                }
            }
            Cliente cliente = PedirDatosUsuario();
            if (habitacionElegida != null) {
                hotelElegido.reservar(cliente, habitacionElegida);
                System.out.println("\nRESERVA realizada con éxito:");
                System.out.println("Cliente: " + cliente.getNombre() + " (Empresa: " + cliente.getEmpresa() + ", Cédula: " + cliente.getCedula() + ")");
                System.out.println("Habitación: " + habitacionElegida.getNumero());
                System.out.println("Hotel: " + hotelElegido.getNombre());
            } else {
                System.out.println("La habitación seleccionada no está disponible.");
            }
    }
    
    public static Cliente PedirDatosUsuario(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese la empresa del cliente: ");
        String empresaCliente = scanner.nextLine();
        System.out.print("Ingrese la cédula del cliente: ");
        String cedulaCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nombreCliente, empresaCliente, cedulaCliente);
        return cliente;
    }

    public static Hotel ListaHotelesDisponibles(){
            System.out.println("Hoteles disponibles:");
            System.out.println("1. " + hoteles.get(0).getNombre());
            System.out.println("2. " + hoteles.get(1).getNombre());
            System.out.println("3. " + hoteles.get(2).getNombre());
            System.out.print("Seleccione el número de hotel: ");
            int opcionHotel = scanner.nextInt();
            Hotel hotelElegido = null;
            switch (opcionHotel) {
            case 1:
                hotelElegido = hoteles.get(0);
                break;
            case 2:
                hotelElegido = hoteles.get(1);
                break;
            case 3:
                hotelElegido = hoteles.get(2);
                break;
            default:
                System.out.println("Opción no válida. Seleccione una opción válida.");
            }
            return hotelElegido;

    }

    public static void cancelarReserva(){
        Hotel hotelElegido = ListaHotelesDisponibles();
        scanner.nextLine();
        System.out.println("Ingrese la cédula del cliente: ");
        String cedulaCliente = scanner.nextLine();
        System.out.println("Ingrese el número de habitación: ");
        int numeroHabitacion = scanner.nextInt();
        Habitacion habitacionElegida = null;
        for (Reserva reserva : hotelElegido.getReservas()) {
            if (reserva.getCliente().getCedula().equals(cedulaCliente) && reserva.getHabitacion().getNumero() == numeroHabitacion) {
                habitacionElegida = reserva.getHabitacion();

                break;
            }
        }
        if (habitacionElegida == null) {
            System.out.println("No se encontró la reserva.");
            return;
        }else{
            habitacionElegida.liberar();
            System.out.println("Reserva cancelada con éxito.");

        }
    }

    public static void listarReservas(){
        Hotel hotelElegido = ListaHotelesDisponibles();
        System.out.println("Reservas del hotel " + hotelElegido.getNombre() + ":");
        for (Reserva reserva : hotelElegido.getReservas()) {
            System.out.println("Cliente: " + reserva.getCliente().getNombre() + " (Empresa: " + reserva.getCliente().getEmpresa() + ", Cédula: " + reserva.getCliente().getCedula() + ")");
            System.out.println("Habitación: " + reserva.getHabitacion().getNumero());
        }
    }
}



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
        System.out.println("Bienvenido al sistema de reservas de hoteles");

        // Menú principal
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
                    case 3:
                        Hotel hotelElegido = ElegirHotel();
                        listarReservas(hotelElegido);
                        break;
                    case 0:
                        System.out.println("¡Gracias por usar el sistema de reservas!");
                        return;
                    default:
                        System.out.println("Opción no válida. Seleccione una opción válida.");
                }
            }

    
        
    }

    // Mostrar el menú principal
    private static void mostrarMenu() {
        System.out.println("\n          MENU PRINCIPAL");
        System.out.println("1. Reservar Habitacion");
        System.out.println("2. Cancelar reserva");
        System.out.println("3. Mostrar reservas");
        System.out.println("0. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    // Hacer una reserva
    public static void hacerReserva(){
        // Mostrar hoteles disponibles
        Hotel hotelElegido = ElegirHotel();
        List<Habitacion> habitacionesDisponibles = hotelElegido.getHabitacionesDisponibles();
        System.out.println("Habitaciones disponibles:");
        for (Habitacion habitacion : habitacionesDisponibles) {
            System.out.println(habitacion.getNumero());
        }

        // Seleccionar habitación para la reserva
        System.out.print("Seleccione el número de habitación: ");
        int numeroHabitacion = scanner.nextInt();
        Habitacion habitacionElegida = null;

        // Buscar la habitación seleccionada en la lista de habitaciones disponibles
        for (Habitacion habitacion : habitacionesDisponibles) {
            // Si la habitación está disponible y el número coincide, se selecciona
            if (habitacion.getNumero() == numeroHabitacion && habitacion.isDisponible()) {
                habitacionElegida = habitacion;
                break;
            }
        }

        // Si la habitación está disponible, se pide los datos del cliente y se hace la reserva
        if (habitacionElegida != null) {
            Cliente cliente = PedirDatosUsuario();
            hotelElegido.reservar(cliente, habitacionElegida);
            System.out.println("\nRESERVA realizada con éxito:");
            System.out.println("Cliente: " + cliente.getNombre() + " - Empresa " + cliente.getEmpresa() + " - Cédula: " + cliente.getCedula());
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

    public static Hotel ElegirHotel(){
        // Mostrar hoteles disponibles
        System.out.println("      Hoteles:");
        System.out.println("1. " + hoteles.get(0).getNombre());
        System.out.println("2. " + hoteles.get(1).getNombre());
        System.out.println("3. " + hoteles.get(2).getNombre());
        System.out.print("Seleccione el número de hotel: ");
        int opcionHotel = scanner.nextInt();
        Hotel hotelElegido = null;
    
         //Se agrega el Hotel elegido a la variable hotelElegido
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
        // Mostrar hoteles disponibles 
        Hotel hotelElegido = ElegirHotel();
        listarReservas(hotelElegido);
        scanner.nextLine();
        System.out.println("Ingrese la cédula del cliente: ");
        String cedulaCliente = scanner.nextLine();
        Habitacion habitacionElegida = null;

        // Buscar la reserva seleccionada en la lista de reservas del hotel
        for (Reserva reserva : hotelElegido.getReservas()) {
            // Si la reserva coincide con los datos ingresados, se cancela
            if (reserva.getCliente().getCedula().equals(cedulaCliente)) {
                habitacionElegida = reserva.getHabitacion();
                hotelElegido.cancelarReserva(reserva);
                break;
            }
        }
        
        // Si no se encontró la reserva, se muestra un mensaje de error
        if (habitacionElegida == null) {
            System.out.println("No se encontró la reserva. Verifique los datos ingresados.");
            return;
        }else{
            habitacionElegida.liberar();
            System.out.println("Reserva cancelada con éxito.");

        }
    }

    //Mostrar las reservas de un hotel 
    public static void listarReservas(Hotel hotelElegido){
        if (hotelElegido.getReservas().isEmpty()) {
            System.out.println("\nNo hay reservas en el hotel " + hotelElegido.getNombre());
            return;
        }
        System.out.println("\n---- Reservas del " + hotelElegido.getNombre() + ":");
        for (Reserva reserva : hotelElegido.getReservas()) {

            System.out.print("Cliente: " + reserva.getCliente().getNombre() + ", Cédula " + reserva.getCliente().getCedula() +". Empresa que reservo: " + reserva.getCliente().getEmpresa()  );
            System.out.println(" - habitación: " + reserva.getHabitacion().getNumero());
        }
    }
}



import java.util.Scanner;

import punto1_registrodealumnos.Alumno;
import punto1_registrodealumnos.SistemaAlumnos;
import punto2_conversordemonedas.ConversorMonedas;
import punto4_sistemadereservashotel.SistemaReservas;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("       Menú Principal");
            System.out.println("1. punto 1: Registro de alumnos");
            System.out.println("2. punto 2: Conversor de monedas");
            System.out.println("3. punto 3: Calculadora");
            System.out.println("4. punto 4: Sistema de reservas de hotel");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int point = scanner.nextInt();

            switch (point) {
                case 1:
                    point1();
                    break;
                case 2:
                    point2();
                    break;
                case 3:
                    point3();
                    break;
                case 4:
                    point4();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
            
        }
        System.out.println("¡Hasta luego!");
        scanner.close();
    }

        public static void point1() {
            SistemaAlumnos sistema = new SistemaAlumnos();

            Alumno alumno1 = new Alumno("CRISTIAN CASTANO", 22);
            Alumno alumno2 = new Alumno("MANUELA PINEDA", 23);
            sistema.agregarAlumno(alumno1);
            sistema.agregarAlumno(alumno2);

            sistema.asignarCalificacion("CRISTIAN CASTANO", 8.5);
            sistema.asignarCalificacion("CRISTIAN CASTANO", 9.0);
            sistema.asignarCalificacion("CRISTIAN CASTANO", 7.5);
            sistema.asignarCalificacion("MANUELA PINEDA", 3.0);
            sistema.asignarCalificacion("MANUELA PINEDA", 6.0);

            sistema.mostrarInformacionAlumnos();
        }

        public static void point2() {
            Scanner scanner = new Scanner(System.in);
            //Mostramos las opciones de monedas con sus tasas
            System.out.println("          Monedas con sus tasas");
            System.out.println("1. \"USD\" tasa de: 1.0");
            System.out.println("2. \"EUR\" tasa de: 0.91");
            System.out.println("3. \"COP\" tasa de: 3998.0");
            System.out.println("4. \"MXN\" tasa de: 17.32");

            //Pedimos la opcion de la moneda de origen
            System.out.println("Ingresa la opcion de la modena de origen: ");
            int moneda1 = scanner.nextInt();
            //Pedimos la opcion de la moneda de destino
            System.out.println("Ingrese la moneda de destino: ");
            int moneda2 = scanner.nextInt();
            //Pedimos la cantidad a convertir
            System.out.println("Ingrese la cantidad a convertir: ");
            double cantidadAConvertir = scanner.nextDouble();

            //Obtenemos el tipo de moneda seleccionada
            String monedaOrigen = ConversorMonedas.tipoMonedaSeleccionada(moneda1);
            String monedaDestino = ConversorMonedas.tipoMonedaSeleccionada(moneda2);
            //Convertimos la moneda
            double cantidadConvertida = ConversorMonedas.convertirMoneda(monedaOrigen, monedaDestino, cantidadAConvertir);
            System.out.println("RESULTADO: "+cantidadAConvertir +" "+monedaOrigen+ " es igual a "+cantidadConvertida+" "+monedaDestino+"\n");
        }

        public static void point3() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("BIENVENIDO A LA CALCULADORA");
            System.out.println("Selecciona la opción que desea: \n1. Sumar\n2. Restar \n3. Multiplicar \n4. Dividir");
            int operacion = scanner.nextInt();

            System.out.println("Ingrese el primer numero: ");
            double numero1 = scanner.nextDouble();
            System.out.println("Ingrese el segundo numero: ");
            double numero2 = scanner.nextDouble();
        
            switch(operacion){
                case 1:   
                    double suma = numero1 + numero2;
                    System.out.println("El resultado de la suma es: "+suma);
                    break;
                case 2:
                    double resta = numero1 - numero2;
                    System.out.println("El resultado de la resta es: "+resta);
                    break;
                case 3:
                    double multiplicacion = numero1 * numero2;
                    System.out.println("El resultado de la multiplicacion es: "+multiplicacion);
                    break;
                case 4:
                    double division = numero1 / numero2;
                    System.out.println("El resultado de la division es: "+division);
                    break;
            }
            
        }

        public static void point4() {
            SistemaReservas.main(null);
        }
}

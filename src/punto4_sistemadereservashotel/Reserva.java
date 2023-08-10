package punto4_sistemadereservashotel;

public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;

    public Reserva(Cliente cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        habitacion.reservar();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void cancelar() {
        habitacion.liberar();
    }
}

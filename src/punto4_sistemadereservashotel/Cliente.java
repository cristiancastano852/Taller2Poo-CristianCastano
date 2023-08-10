package punto4_sistemadereservashotel;

public class Cliente {
    private String nombre;
    private String cedula;
    private String empresa;

    public Cliente(String nombre, String empresa, String cedula) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEmpresa() {
        return empresa;
    }
}

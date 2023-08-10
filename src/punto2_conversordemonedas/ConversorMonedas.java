package punto2_conversordemonedas;

import java.util.HashMap;
import java.util.Map;

public class ConversorMonedas {

    private static final Map<String, Double> tasas = new HashMap<>();

    //añadimos las tasas de diferentes monedas al HashMap tasas
    //Es static para garantizar el orden de ejecucion
    static {
        tasas.put("USD", 1.0);
        tasas.put("COP", 3991.0);
        tasas.put("EUR", 0.91);
        tasas.put("MXN", 17.1);
    }


    public static double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        double resultado=cantidad * tasas.get(monedaDestino) / tasas.get(monedaOrigen);
        return Math.round(resultado * 100.0) / 100.0;
    }

    public static String tipoMonedaSeleccionada(int opcionMoneda){
        String monedaSeleccionada="0";
        if(opcionMoneda==1){
            return monedaSeleccionada="USD";
        }else if(opcionMoneda==2){
            return monedaSeleccionada="EUR";
        }else if(opcionMoneda==3){
            return monedaSeleccionada="COP";
        }else if(opcionMoneda==4){
            return  monedaSeleccionada="MXN";
        }
        return monedaSeleccionada;
    }
}

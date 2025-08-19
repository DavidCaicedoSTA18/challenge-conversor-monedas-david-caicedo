package modelos;

import ConsumoAPI.ClienteAPI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConversorMoneda {
    private ClienteAPI clienteAPI;
    private Map<String, Moneda> monedas;

    public ConversorMoneda() {
        this.clienteAPI = new ClienteAPI();
        inicializarMonedas();
    }

    private void inicializarMonedas() {
        monedas = new HashMap<>();
        monedas.put("USD", new Moneda("USD", "Dólar estadounidense"));
        monedas.put("ARS", new Moneda("ARS", "Peso argentino"));
        monedas.put("BOB", new Moneda("BOB", "Boliviano boliviano"));
        monedas.put("BRL", new Moneda("BRL", "Real brasileño"));
        monedas.put("CLP", new Moneda("CLP", "Peso chileno"));
        monedas.put("COP", new Moneda("COP", "Peso colombiano"));
    }

    // Convirtiendo los valores
    public double convertirMoneda(String codigoOrigen, String codigoDestino, double cantidad)
            throws IOException, InterruptedException {

        // Validar que las monedas existan
        if (!monedas.containsKey(codigoOrigen) || !monedas.containsKey(codigoDestino)) {
            throw new IllegalArgumentException("Código de moneda no válido");
        }

        // Si es la misma moneda, retornar la misma cantidad
        if (codigoOrigen.equals(codigoDestino)) {
            return cantidad;
        }

        // Obtener la tasa de cambio desde la API
        double tasaCambio = clienteAPI.obtenerTasaEspecifica(codigoOrigen, codigoDestino);

        // Realizar la conversión
        return cantidad * tasaCambio;
    }

    public String obtenerNombreMoneda(String codigo) {
        Moneda moneda = monedas.get(codigo);
        return moneda != null ? moneda.getNombre() : codigo;
    }

    // Método para realizar conversión con formato de salida
    public String realizarConversion(String codigoOrigen, String codigoDestino, double cantidad) {
        try {
            double resultado = convertirMoneda(codigoOrigen, codigoDestino, cantidad);

            return String.format("El valor %.2f [%s] corresponde al valor final de --> %.2f [%s]",
                    cantidad, codigoOrigen, resultado, codigoDestino);
        } catch (IOException | InterruptedException e) {
            return "Error al conectar con la API: " + e.getMessage();
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
}
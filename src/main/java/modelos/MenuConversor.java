package modelos;

import java.util.Scanner;

public class MenuConversor {
    private ConversorMoneda conversor;
    private Scanner scanner;
    private boolean ejecutando;

    public MenuConversor() {
        this.conversor = new ConversorMoneda();
        this.scanner = new Scanner(System.in);
        this.ejecutando = true;
    }

    // Interactuando con el usuario
    public void iniciar() {
        mostrarMensajeBienvenida();

        while (ejecutando) {
            mostrarMenu();
            procesarOpcion();
        }

        scanner.close();
    }

    private void mostrarMensajeBienvenida() {
        System.out.println("**************************************************");
        System.out.println("Bienvenido/a al Conversor de Monedas del Walas ´u´");
        System.out.println("**************************************************");
    }

    private void mostrarMenu() {
        System.out.println("\n1) Dólar --> Peso argentino");
        System.out.println("2) Peso argentino --> Dólar");
        System.out.println("3) Dólar --> Real brasileño");
        System.out.println("4) Real brasileño --> Dólar");
        System.out.println("5) Dólar --> Peso colombiano");
        System.out.println("6) Peso colombiano --> Dólar");
        System.out.println("7) Salir");
        System.out.println("Elija una opción válida:");
        System.out.println("*******************************************");
    }

    private void procesarOpcion() {
        try {
            int opcion = scanner.nextInt();

            if (opcion == 7) {
                System.out.println("Programa finalizado. ¡Hasta luego!");
                ejecutando = false;
                return;
            }

            if (opcion < 1 || opcion > 7) {
                System.out.println("Opción no válida. Por favor, elija una opción del 1 al 7.");
                return;
            }

            // Solicitar el valor a convertir
            System.out.println("Ingrese el valor que deseas convertir:");
            double valor = scanner.nextDouble();

            if (valor < 0) {
                System.out.println("El valor debe ser positivo.");
                return;
            }

            // Realizar la conversión según la opción
            String resultado = realizarConversionSegunOpcion(opcion, valor);
            System.out.println(resultado);

        } catch (Exception e) {
            System.out.println("Error: Ingrese un valor válido.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    private String realizarConversionSegunOpcion(int opcion, double valor) {
        String codigoOrigen = "";
        String codigoDestino = "";

        switch (opcion) {
            case 1:
                codigoOrigen = "USD";
                codigoDestino = "ARS";
                break;
            case 2:
                codigoOrigen = "ARS";
                codigoDestino = "USD";
                break;
            case 3:
                codigoOrigen = "USD";
                codigoDestino = "BRL";
                break;
            case 4:
                codigoOrigen = "BRL";
                codigoDestino = "USD";
                break;
            case 5:
                codigoOrigen = "USD";
                codigoDestino = "COP";
                break;
            case 6:
                codigoOrigen = "COP";
                codigoDestino = "USD";
                break;
            default:
                return "Opción no válida";
        }

        return conversor.realizarConversion(codigoOrigen, codigoDestino, valor);
    }
}


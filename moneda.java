import java.util.Scanner;

public class moneda {

    // Tasas de cambio simuladas (puedes actualizarlas manualmente o conectarlas a una API)
    static final double COP_TO_USD = 0.00025;  // Peso colombiano a USD
    static final double MXN_TO_USD = 0.054;   // Peso mexicano a USD
    static final double PEN_TO_USD = 0.27;    // Sol peruano a USD
    static final double BOB_TO_USD = 0.14;    // Boliviano a USD
    static final double ARS_TO_USD = 0.0028;  // Peso argentino a USD

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al Conversor de Monedas!");
        System.out.println("Monedas disponibles:");
        System.out.println("1. Peso Colombiano (COP)");
        System.out.println("2. Peso Mexicano (MXN)");
        System.out.println("3. Sol Peruano (PEN)");
        System.out.println("4. Boliviano (BOB)");
        System.out.println("5. Peso Argentino (ARS)");

        // Seleccionar moneda de origen
        System.out.print("Selecciona la moneda de origen (1-5): ");
        int monedaOrigen = scanner.nextInt();

        System.out.print("Ingresa la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        // Seleccionar moneda de destino
        System.out.println("Selecciona la moneda de destino (1-5): ");
        int monedaDestino = scanner.nextInt();

        // Convertir
        double resultado = convertirMoneda(monedaOrigen, monedaDestino, cantidad);

        if (resultado == -1) {
            System.out.println("Selección de monedas inválida. Intenta de nuevo.");
        } else {
            System.out.printf("El resultado de la conversión es: %.2f\n", resultado);
        }

        scanner.close();
    }

    public static double convertirMoneda(int origen, int destino, double cantidad) {
        // Obtener tasa de cambio a USD
        double tasaOrigen = obtenerTasaCambio(origen);
        double tasaDestino = obtenerTasaCambio(destino);

        if (tasaOrigen == -1 || tasaDestino == -1) {
            return -1; // Error por selección inválida
        }

        // Convertir a USD y luego a la moneda destino
        double cantidadEnUSD = cantidad * tasaOrigen;
        return cantidadEnUSD / tasaDestino;
    }

    public static double obtenerTasaCambio(int moneda) {
        switch (moneda) {
            case 1: return COP_TO_USD; // Peso colombiano
            case 2: return MXN_TO_USD; // Peso mexicano
            case 3: return PEN_TO_USD; // Sol peruano
            case 4: return BOB_TO_USD; // Boliviano
            case 5: return ARS_TO_USD; // Peso argentino
            default: return -1;        // Error
        }
    }
}

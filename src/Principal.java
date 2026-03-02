import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultarDinero consulta = new ConsultarDinero();

        System.out.println("=== BIENVENIDO AL CONVERSOR PRO ===");

        System.out.println("¿Qué moneda tienes? (ej: dolares, pesos, eur): ");
        String origenInput = scanner.nextLine();

        System.out.println("¿Qué cantidad deseas convertir?: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("¿A qué moneda lo quieres convertir? (ej: reales, ars, usd): ");
        String destinoInput = scanner.nextLine();

        Dinero miDinero = new Dinero(origenInput, cantidad);

        String monedaDestino = Dinero.normalizar(destinoInput);

        try {
            DineroAPI datos = consulta.convertirDinero(miDinero.moneda());

            if (datos.conversion_rates().containsKey(monedaDestino)) {
                double tasaDeCambio = datos.conversion_rates().get(monedaDestino);
                double resultado = miDinero.cantidad() * tasaDeCambio;

                System.out.println("\n******************************************");
                System.out.printf("%.2f %s equivalen a %.2f %s%n",
                        miDinero.cantidad(), miDinero.moneda(),
                        resultado, monedaDestino);
                System.out.println("Tasa aplicada: " + tasaDeCambio);
                System.out.println("******************************************");
            } else {
                System.out.println("Lo siento, la moneda de destino '" + monedaDestino + "' no está disponible.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
public record Dinero(String moneda, double cantidad) {
    public Dinero {
        moneda = normalizar(moneda);
    }

    public static String normalizar(String entrada) {
        return switch (entrada.trim().toLowerCase()) {
            case "dolares", "dolar", "usd" -> "USD";
            case "pesos", "mexicanos", "mxn" -> "MXN";
            case "pesos argentinos", "ars" -> "ARS";
            case "reales", "real", "brl" -> "BRL";
            case "euros", "euro", "eur" -> "EUR";
            default -> entrada.toUpperCase();
        };
    }
}
import java.util.Map;

public record DineroAPI(String base_code, Map<String, Double> conversion_rates) {
}

package br.com.danilo.modelos;

public record Conversor(String base_code,
                        String target_code,
                        double conversion_result,
                        double conversion_rate,
                        double valor) {
}

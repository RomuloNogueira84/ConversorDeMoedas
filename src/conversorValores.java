public class conversorValores {
    public double converter(double valor, String moedaOrigem, String moedaDestino, Map<String, Double> taxasCambio) {
        if (!taxasCambio.containsKey(moedaOrigem) || !taxasCambio.containsKey(moedaDestino)) {
            throw new IllegalArgumentException("Moeda(s) inválida(s): " + moedaOrigem + ", " + moedaDestino);
        }

        double taxaOrigem = taxasCambio.get(moedaOrigem);
        double taxaDestino = taxasCambio.get(moedaDestino);
        return valor * taxaDestino / taxaOrigem;
    }
}

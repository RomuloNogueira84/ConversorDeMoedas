    public class ConversorMoedasApp {

        public static void main(String[] args) throws URISyntaxException, IOException {
            String apiKey = "0fc64b908ff079311c4bd706"; // Sua chave da API
            ConversorMoedas conversor = new ConversorMoedas(apiKey);

            Map<String, Double> taxasCambio = conversor.obterTaxasCambio();
        }
    }

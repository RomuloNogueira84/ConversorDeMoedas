public class taxaDeCambio {
    public Map<String, Double> obterTaxasCambio() throws URISyntaxException, IOException {
        // Construa a requisição à API
        String url = "https://api.exchangerate-api.com/v4/latest/BRL";
        HttpRequest request = Unirest.get(url)
                .header("X-RapidAPI-Key", apiKey)
                .asJson();

        // Processe a resposta
        HttpResponse<JsonNode> response = request.asJson();
        if (response.getStatus() != 200) {
            throw new IOException("Falha ao obter taxas de câmbio: " + response.getStatusText());
        }

        // Extraia as taxas do JSON
        JsonNode json = response.getBody();
        Map<String, Double> taxas = new HashMap<>();
        for (Map.Entry<String, JsonNode> entry : json.getFields()) {
            if (!entry.getKey().equals("rates")) {
                continue;
            }

            for (Map.Entry<String, JsonNode> taxaEntry : entry.getValue().getFields()) {
                String moeda = taxaEntry.getKey();
                double taxa = taxaEntry.getValue().asDouble();
                taxas.put(moeda, taxa);
            }
        }

        return taxas;
    }
}

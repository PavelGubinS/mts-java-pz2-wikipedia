public class Main {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        String query = consoleInput.readSearchQuery();

        System.out.println("Отправка запроса к Википедии...");
        WikipediaApiClient apiClient = new WikipediaApiClient();
        String jsonResponse = apiClient.search(query);

        if (jsonResponse != null) {
            System.out.println("Парсинг ответа...");
            WikipediaParser parser = new WikipediaParser();
            SearchResponse response = parser.parse(jsonResponse);

            if (response.getQuery() != null && response.getQuery().getSearch() != null
                    && !response.getQuery().getSearch().isEmpty()) {
                System.out.println("Найденные статьи:");
                for (SearchResult result : response.getQuery().getSearch()) {
                    System.out.println("- " + result.getTitle() + " (ID: " + result.getPageId() + ")");
                }
            } else {
                System.out.println("По вашему запросу ничего не найдено.");
            }
        }
    }
}
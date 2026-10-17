import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        String query = consoleInput.readSearchQuery();

        System.out.println("Отправка запроса к Википедии...");
        WikipediaApiClient apiClient = new WikipediaApiClient();
        String jsonResponse = apiClient.search(query);

        if (jsonResponse != null) {
            WikipediaParser parser = new WikipediaParser();
            SearchResponse response = parser.parse(jsonResponse);

            if (response.getQuery() != null && response.getQuery().getSearch() != null
                    && !response.getQuery().getSearch().isEmpty()) {
                List<SearchResult> results = response.getQuery().getSearch();

                // Выводим результаты через отдельный класс
                ConsoleOutput consoleOutput = new ConsoleOutput();
                consoleOutput.printResults(results);

                // Просим пользователя выбрать статью
                int choiceIndex = consoleInput.readChoice(results.size());
                SearchResult selectedArticle = results.get(choiceIndex);

                System.out.println(
                        "Вы выбрали: " + selectedArticle.getTitle() + " (ID: " + selectedArticle.getPageId() + ")");
                // На следующем этапе мы будем открывать её в браузере

            } else {
                System.out.println("По вашему запросу ничего не найдено.");
            }
        }
    }
}
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

            if (response.getQuery() != null && response.getQuery().getSearch() != null && !response.getQuery().getSearch().isEmpty()) {
                List<SearchResult> results = response.getQuery().getSearch();
                
                ConsoleOutput consoleOutput = new ConsoleOutput();
                consoleOutput.printResults(results);

                int choiceIndex = consoleInput.readChoice(results.size());
                SearchResult selectedArticle = results.get(choiceIndex);

                // Открываем статью в браузере
                BrowserOpener browserOpener = new BrowserOpener();
                browserOpener.openArticle(selectedArticle.getPageId());
                
            } else {
                System.out.println("По вашему запросу ничего не найдено.");
            }
        }
    }
}
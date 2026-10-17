public class Main {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        String query = consoleInput.readSearchQuery();

        System.out.println("Отправка запроса к Википедии...");
        WikipediaApiClient apiClient = new WikipediaApiClient();
        String jsonResponse = apiClient.search(query);

        if (jsonResponse != null) {
            System.out.println("\nОтвет сервера (сырой JSON):");
            System.out.println(jsonResponse);
        }
    }
}
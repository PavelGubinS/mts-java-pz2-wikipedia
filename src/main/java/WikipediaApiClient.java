import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WikipediaApiClient {
    private static final String API_URL = "https://ru.wikipedia.org/w/api.php";

    public String search(String query) {
        try {
            // 1. Кодируем запрос (Percent-encoding, как сказано в задании)
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
            
            // 2. Формируем URL
            String urlString = API_URL + "?action=query&list=search&utf8=&format=json&srsearch=" + encodedQuery;
            URL url = URI.create(urlString).toURL();

            // 3. Открываем соединение
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // Википедия блокирует запросы без User-Agent
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)"); 

            // 4. Читаем ответ от сервера
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }
        } catch (Exception e) {
            // Обработка сетевых ошибок без аварийного завершения
            System.err.println("Ошибка сети: не удалось получить данные от Википедии.");
            return null;
        }
    }
}
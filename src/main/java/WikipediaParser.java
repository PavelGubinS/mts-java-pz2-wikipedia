import com.google.gson.Gson;

public class WikipediaParser {
    public SearchResponse parse(String json) {
        Gson gson = new Gson();
        // Gson сам свяжет JSON-поля с нашими классами
        return gson.fromJson(json, SearchResponse.class);
    }
}
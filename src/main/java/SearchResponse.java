import java.util.List;

public class SearchResponse {
    private Query query;

    public Query getQuery() {
        return query;
    }

    public static class Query {
        private List<SearchResult> search;

        public List<SearchResult> getSearch() {
            return search;
        }
    }
}
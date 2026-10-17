import java.util.List;

public class ConsoleOutput {
    public void printResults(List<SearchResult> results) {
        System.out.println("\nРезультаты поиска:");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + results.get(i).getTitle());
        }
    }
}
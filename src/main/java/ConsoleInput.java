import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput() {
        // Принудительно указываем UTF-8
        this.scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    }

    public String readSearchQuery() {
        System.out.print("Введите поисковый запрос: ");
        String query = scanner.nextLine().trim();

        while (query.isEmpty()) {
            System.out.print("Запрос не может быть пустым. Введите поисковый запрос: ");
            query = scanner.nextLine().trim();
        }
        return query;
    }
}
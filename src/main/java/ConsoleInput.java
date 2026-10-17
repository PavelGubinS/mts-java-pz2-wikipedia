import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public String readSearchQuery() {
        System.out.print("Введите поисковый запрос: ");
        String query = scanner.nextLine().trim();
        
        // Цикл не даст программе упасть и переспросит, если строка пустая
        while (query.isEmpty()) {
            System.out.print("Запрос не может быть пустым. Введите поисковый запрос: ");
            query = scanner.nextLine().trim();
        }
        return query;
    }
}
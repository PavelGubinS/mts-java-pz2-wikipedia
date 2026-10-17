import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
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

    public int readChoice(int maxIndex) {
        while (true) {
            System.out.print("\nВыберите номер статьи для открытия (от 1 до " + maxIndex + "): ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= maxIndex) {
                    return choice - 1; // Возвращаем индекс для массива (от 0)
                } else {
                    System.out.println("Такого номера нет в списке. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число.");
            }
        }
    }
}
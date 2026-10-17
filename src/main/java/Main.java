public class Main {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        String query = consoleInput.readSearchQuery();
        
        // Временный вывод для проверки первого этапа
        System.out.println("Вы ввели: " + query);
    }
}
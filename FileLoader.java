import java.util.Scanner;

public class FileLoader {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nВыберите действие:\n1 - Сохранить файл\n2 - Прочитать файл\n0 - Выход");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> saveFile();
                case "2" -> readFile();
                case "0" -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
    }

    private static void saveFile() {
        System.out.print("Введите директорию: ");
        String directory = scanner.nextLine().trim();
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine().trim();
        System.out.print("Введите текст для сохранения: ");
        String content = scanner.nextLine();

        if (!FileManager.isValid(directory, fileName)) return;

        boolean success = fileManager.saveFile(directory, fileName, content);
        if (success) {
            System.out.println("Файл успешно сохранен.");
        } else {
            System.out.println("Ошибка при сохранении файла.");
        }
    }

    private static void readFile() {
        System.out.print("Введите директорию: ");
        String directory = scanner.nextLine().trim();
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine().trim();

        if (!FileManager.isValid(directory, fileName)) return;

        String content = fileManager.readFile(directory, fileName);
        if (content != null) {
            System.out.println("Содержимое файла:\n" + content);
        } else {
            System.out.println("Ошибка при чтении файла.");
        }
    }
}

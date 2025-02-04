import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileManager {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public boolean saveFile(String directory, String fileName, String content) {
        Path dirPath = Paths.get(directory);
        Path filePath = dirPath.resolve(fileName);

        try {
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            if (Files.exists(filePath)) {
                System.out.print("Файл уже существует. Перезаписать? (y/n): ");
                Scanner scanner = new Scanner(System.in);
                String overwrite = scanner.nextLine().trim();
                if (!overwrite.equalsIgnoreCase("y")) {
                    System.out.println("Запись отменена.");
                    return false;
                }
            }

            Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            long fileSize = Files.size(filePath);
            String timeStamp = LocalDateTime.now().format(formatter);
            System.out.println("Файл сохранен: " + filePath);
            System.out.println("Размер файла: " + fileSize + " байт");
            System.out.println("Время записи: " + timeStamp);
            return true;

        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
            return false;
        }
    }

    public String readFile(String directory, String fileName) {
        Path filePath = Paths.get(directory, fileName);
        if (!Files.exists(filePath)) {
            System.out.println("Файл не найден.");
            return null;
        }

        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return null;
        }
    }

    public static boolean isValid(String directory, String fileName) {
        if (directory.isEmpty() || fileName.isEmpty()) {
            System.out.println("Имя файла и директория не могут быть пустыми!");
            return false;
        }

        if (fileName.contains("/") || fileName.contains("\\")) {
            System.out.println("Имя файла не должно содержать слэши!");
            return false;
        }
        return true;
    }
}

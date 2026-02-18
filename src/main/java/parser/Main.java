import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static final String DEFAULT_INPUT_PATH = "test.txt";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: не указан путь к файлу");
            System.out.println("Использование: java Main <путь_к_файлу>");
            return;
        }

        String inputPath = getInputPath(args[0]);

        if (!fileExists(inputPath)) {
            System.out.println("Ошибка: файл '" + inputPath + "' не существует");
            return;
        }

        FreqApp.start(inputPath);
    }

    private static String getInputPath(String inputPath) {
        if (inputPath == null || inputPath.isEmpty()) {
            System.out.println("Используется файл по умолчанию: " + DEFAULT_INPUT_PATH);
            return DEFAULT_INPUT_PATH;
        }
        return inputPath;
    }

    private static boolean fileExists(String path) {
        Path filePath = Paths.get(path);
        return Files.exists(filePath) && Files.isRegularFile(filePath);
    }
}
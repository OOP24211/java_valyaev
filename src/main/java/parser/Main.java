package parser;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());
    private static final String DEFAULT_INPUT_PATH = "test.txt";

    public static void main(String[] args) {

        String inputPath = validateAndGetInputPath(args);

        FreqApp.start(inputPath);
    }

    private static String validateAndGetInputPath(String[] args) {
        if (args.length == 0) {
            log.info("Usage: java Main <input file> <output file>");
            throw new IllegalArgumentException("Usage: java Main <input file> <output file>");
        }

        String inputPath = getInputPath(args[0]);

        if (!fileExists(inputPath)) {
            log.warning("File not found: " + inputPath);
            throw new IllegalArgumentException("File not found: " + inputPath);
        }

        return inputPath;
    }

    private static String getInputPath(String inputPath) {
        if (inputPath == null || inputPath.isEmpty()) {
            log.info("Default input path: " + DEFAULT_INPUT_PATH);
            return DEFAULT_INPUT_PATH;
        }
        return inputPath;
    }


    private static boolean fileExists(String path) {
        Path filePath = Paths.get(path);
        return Files.exists(filePath) && Files.isRegularFile(filePath);
    }
}
package parser;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;

public class FreqApp {

    private static final Logger log = Logger.getLogger(FreqApp.class.getName());
    public static void start(String inputPath){
        String outputPath = inputPath.substring(0, inputPath.lastIndexOf(".")) + ".csv";

        try {
            TextAnalyzer analyzer = new TextAnalyzer(Path.of(inputPath));
            List<WordStat> stats = analyzer.analyze();

            if (stats.isEmpty()) {
                log.warning("File is empty.");
                return;
            }

            CsvReportWriter reportWriter = new CsvReportWriter();
            reportWriter.write(outputPath, stats);

            log.info("CSV file was created: " + outputPath);

        } catch (IOException e) {
           log.warning("Error during work with file: " + e.getMessage());
        } catch (Exception e) {
            log.warning("Error: " + e.getMessage());
        }
    }
}

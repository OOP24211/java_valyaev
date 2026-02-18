package parser;
import lombok.RequiredArgsConstructor;

import java.util.Locale;


@RequiredArgsConstructor
class WordStat {
    private final String word;
    private final int count;
    private final double percentage;

    public String toCsvRow() {
        return String.format(Locale.US, "%s,%d,%.4f", word, count, percentage);
    }
}
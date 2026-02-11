package ua.cryptograph.functional;

import java.util.HashMap;
import java.util.Map;

public class LanguageChecker {

    private static final int ANALYSIS_LIMIT = 500;
    private final Map<String, String> alphabets;

    public LanguageChecker(Map<String, String> alphabet) {
        this.alphabets = new HashMap<>(alphabet);
    }

    public String detectAlphabet(String text) {
        String defaultAlphabet = alphabets.get("English");
        int maxCount = 0;

        for (Map.Entry<String, String> entry : alphabets.entrySet()) {
            String currentAlphabet = entry.getValue();
            int count = 0;

            int limit = Math.min(text.length(), ANALYSIS_LIMIT);
            for (int i = 0; i < limit; i++) {
                char c = text.charAt(i);

                if (currentAlphabet.indexOf(c) != -1 && !isShared(c)) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                defaultAlphabet = currentAlphabet;
            }
        }
        return defaultAlphabet;
    }

    private boolean isShared(char c) {
        return ".,\"':!? ".indexOf(c) != -1;
    }
}

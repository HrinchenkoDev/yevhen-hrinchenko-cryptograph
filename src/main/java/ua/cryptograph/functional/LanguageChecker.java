package ua.cryptograph.functional;

import java.util.LinkedHashMap;
import java.util.Map;

public class LanguageChecker {

    private final Map<String, String> alphabets = new LinkedHashMap<>();

    public LanguageChecker() {
        alphabets.put("English", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.,\"':!? ");
        alphabets.put("Ukrainian", "абвгґдеєжзиіїйклмнопрстуфхцчшщьюяАБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ.,\"':!? ");
    }

    public String detectAlphabet(String text) {
        String bestAlphabet = alphabets.get("English");
        int maxCount = 0;

        for(Map.Entry<String, String> entry : alphabets.entrySet()) {
            String currentAlphabet = entry.getValue();
            int count = 0;

            int limit = Math.min(text.length(), 500);
            for(int i = 0; i < limit; i++) {
                char c = text.charAt(i);

                if(currentAlphabet.indexOf(c) != -1 && !isShared(c)) {
                    count++;
                }
            }

            if(count > maxCount) {
                maxCount = count;
                bestAlphabet = currentAlphabet;
            }
        }
        return bestAlphabet;
    }

    private boolean isShared(char c) {
        return ".,\"':!? ".indexOf(c) != -1;
    }
}

package ua.cryptograph.functional;

public class LanguageChecker {
    public String detectAlphabet(String text, String engAlphabet, String ukAlphabet) {
        for (char c : text.toCharArray()) {
            if (isLetter(c, ukAlphabet)) return ukAlphabet;
            if (isLetter(c, engAlphabet)) return engAlphabet;
        }
        return engAlphabet;
    }

    private boolean isLetter(char c, String alphabet) {
        return alphabet.indexOf(c) != -1 && ".,\"':!? ".indexOf(c) == -1;
    }
}

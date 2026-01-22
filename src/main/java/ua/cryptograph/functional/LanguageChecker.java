package ua.cryptograph.functional;

public class LanguageChecker {
    public String languageCode(String file) {
        String content = file;
        if(isUkrainian(content)) {
            return "Uk";
        }else {
            return "En";
        }
    }

    public static boolean isUkrainian(String text) {
        return text.matches(".*[іїєґІЇЄҐ].*");
    }
}

package ua.cryptograph;

import ua.cryptograph.filemanager.FileManager;
import ua.cryptograph.functional.CaesarCipher;
import ua.cryptograph.functional.LanguageChecker;
import ua.cryptograph.functional.CommanProcessor;

public class CryptographRunner {

    private static final String ALPHABET_ENG = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            ".,\"':!? ";
    private static final String ALPHABET_UKR = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя" +
            "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ" +
            ".,\"':!? ";

    public static void main(String[] args) {
        CommanProcessor runCryptograph = new CommanProcessor();
        FileManager fileManager = new FileManager();
        LanguageChecker langChecker = new LanguageChecker();
        String filePath = args[1];
        String content = fileManager.readFile(filePath);
        String alphabet = langChecker.detectAlphabet(content, ALPHABET_ENG, ALPHABET_UKR);
        CaesarCipher cipher = new CaesarCipher(alphabet);
        runCryptograph.session(args, cipher, fileManager);
    }
}

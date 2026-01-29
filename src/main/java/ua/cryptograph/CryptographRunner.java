package ua.cryptograph;

import ua.cryptograph.filemanager.FileManager;
import ua.cryptograph.functional.CaesarCipher;
import ua.cryptograph.functional.LanguageChecker;
import ua.cryptograph.functional.RunSession;

public class CryptographRunner {

    private static final String ALPHABET_ENG = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            ".,\"':!? ";
    private static final String ALPHABET_UKR = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя" +
            "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ" +
            ".,\"':!? ";

    public static void main(String[] args) {
        RunSession runCryptograph = new RunSession();
        FileManager fileManager = new FileManager();
        LanguageChecker langChecker = new LanguageChecker();
        String filePath = args[1];
        String content = fileManager.readFile(filePath);
        String alphabet = langChecker.detectAlphabet(content, ALPHABET_ENG, ALPHABET_UKR);
        CaesarCipher cipher = new CaesarCipher(alphabet);
        runCryptograph.session(args, cipher, fileManager);
    }
}

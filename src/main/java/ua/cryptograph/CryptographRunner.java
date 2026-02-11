package ua.cryptograph;

import ua.cryptograph.domain.Alphabet;
import ua.cryptograph.filemanager.FileManager;
import ua.cryptograph.functional.CommandProcessor;
import ua.cryptograph.functional.LanguageChecker;

public class CryptographRunner {

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        LanguageChecker languageChecker = new LanguageChecker(new Alphabet().nameToAlphabet());
        CommandProcessor runCryptograph = new CommandProcessor(fileManager, languageChecker);
        runCryptograph.startProcess(args);
    }
}

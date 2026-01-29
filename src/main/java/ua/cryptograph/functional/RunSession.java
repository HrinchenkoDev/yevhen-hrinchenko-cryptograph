package ua.cryptograph.functional;

import ua.cryptograph.Command;
import ua.cryptograph.filemanager.FileManager;

public class RunSession {

    private static final String ALPHABET_ENG = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            ".,\"':!? ";
    private static final String ALPHABET_UKR = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя" +
            "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ" +
            ".,\"':!? ";

    public void session(String[] args) {
        if(args.length < 2) {
            throw new IllegalArgumentException("Використання: command filePath key \n " +
                    "Команди: ENCRYPT, DECRYPT, BRUTE_FORCE");
        }

        Command command = Command.valueOf(args[0].toUpperCase());
        String filePath = args[1];
        FileManager fileManager = new FileManager();
        String content = fileManager.readFile(filePath);
        String alphabet = detectAlphabet(content);
        CaesarCipher cipher = new CaesarCipher(alphabet);

        try{
            switch(command) {
                case ENCRYPT:
                    int keyEnc = Integer.parseInt(args[2]);
                    fileManager.writeFile(filePath, cipher.encode(content, keyEnc), "[ENCRYPTED]");
                    break;
                case DECRYPT:
                    int keyDec = Integer.parseInt(args[2]);
                    fileManager.writeFile(filePath, cipher.encode(content, -keyDec), "[DECRYPTED]");
                    break;
                case BRUTE_FORCE:
                    cipher.bruteForce(content);
                    break;
                default:
                    System.out.println("Unknown command!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String detectAlphabet(String text) {
        for (char c : text.toCharArray()) {
            if (isLetter(c, ALPHABET_UKR)) return ALPHABET_UKR;
            if (isLetter(c, ALPHABET_ENG)) return ALPHABET_ENG;
        }
        return ALPHABET_ENG;
    }

    private boolean isLetter(char c, String alphabet) {
        // Перевіряємо, чи це літера (не розділовий знак і не пробіл)
        return alphabet.indexOf(c) != -1 && ".,\"':!? ".indexOf(c) == -1;
    }
}

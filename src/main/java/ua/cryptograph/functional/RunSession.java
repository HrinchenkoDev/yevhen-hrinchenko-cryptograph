package ua.cryptograph.functional;

import ua.cryptograph.Command;
import ua.cryptograph.filemanager.FileManager;

public class RunSession {

    private static final String ALPHABET_ENG = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            ".,\"':!? ";
    private static final String ALPHABET_UKR = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            ".,\"':!? ";

//    private final CaesarCipher encoder;
//
//    public RunSession(CaesarCipher encoder) {
//        this.encoder = encoder;
//    }

    public void session(String[] args) {
        if(args.length < 2) {
            throw new IllegalArgumentException("Використання: command filePath key \n " +
                    "Команди: ENCRYPT, DECRYPT, BRUTE_FORCE");
        }

        Command command = Command.valueOf(args[0].toUpperCase());
        String filePath = args[1];

        CaesarCipher cipher = new CaesarCipher(ALPHABET_ENG);
        FileManager fileManager = new FileManager();

        try{
            String content = fileManager.readFile(filePath);

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
}

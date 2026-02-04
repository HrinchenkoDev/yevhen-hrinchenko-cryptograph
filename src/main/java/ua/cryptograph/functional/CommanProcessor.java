package ua.cryptograph.functional;

import ua.cryptograph.Command;
import ua.cryptograph.filemanager.FileManager;

public class CommanProcessor {

    public void session(String[] args, CaesarCipher cipher, FileManager fileManager) {
        if(args.length < 2) {
            throw new IllegalArgumentException("Using: command filePath key \n " +
                    "Command: ENCRYPT, DECRYPT, BRUTE_FORCE");
        }

        Command command = Command.valueOf(args[0].toUpperCase());
        String filePath = args[1];

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

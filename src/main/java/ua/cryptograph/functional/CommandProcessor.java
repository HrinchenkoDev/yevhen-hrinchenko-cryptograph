package ua.cryptograph.functional;

import ua.cryptograph.domain.Command;
import ua.cryptograph.filemanager.FileManager;

public class CommandProcessor {
    private final FileManager fileManager;
    private final LanguageChecker langChecker;

    public CommandProcessor(FileManager fileManager, LanguageChecker langChecker) {
        this.fileManager = fileManager;
        this.langChecker = langChecker;
    }

    public void startProcess(String[] args) {
        try {
            if (args.length >= 2) {
                String argCommand = args[0].toUpperCase();
                String filePath = args[1];
                int key = (args.length > 2) ? Integer.parseInt(args[2]) : 0;
                execute(argCommand, filePath, key);
            } else {
                String[] arguments = new CLIService().runCLI();
                if (arguments.length < 3) {
                    execute(arguments[0], arguments[1], 0);
                } else {
                    execute(arguments[0], arguments[1], Integer.parseInt(arguments[2]));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void execute(String argCommand, String filePath, int key) {
        try {
            String content = fileManager.readFile(filePath);
            String alphabet = langChecker.detectAlphabet(content);
            CaesarCipher cipher = new CaesarCipher(alphabet);

            switch (Command.valueOf(argCommand)) {
                case Command.ENCRYPT:
                    System.out.println("--ENCRYPTED--");
                    fileManager.writeFile(filePath, cipher.encode(content, key), "[ENCRYPTED]");
                    break;
                case Command.DECRYPT:
                    System.out.println("--DECRYPTED--");
                    fileManager.writeFile(filePath, cipher.encode(content, -key), "[DECRYPTED]");
                    break;
                case Command.BRUTE_FORCE:
                    System.out.println("--BRUTE_FORCE--");
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

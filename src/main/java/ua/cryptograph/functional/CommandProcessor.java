package ua.cryptograph.functional;

import ua.cryptograph.Command;
import ua.cryptograph.filemanager.FileManager;
import java.util.Scanner;

public class CommandProcessor {
    private final FileManager fileManager = new FileManager();
    private final LanguageChecker langChecker = new LanguageChecker();

    public void session(String[] args) {
        try{
            if(args.length >= 2) {
                Command command = Command.valueOf(args[0].toUpperCase());
                String filePath = args[1];
                int key = (args.length > 2) ? Integer.parseInt(args[2]) : 0;
                execute(String.valueOf(command), filePath, key);
            }else {
                runInteractive();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void execute(String command, String filePath, int key) {
        try{
            String content = fileManager.readFile(filePath);
            String alphabet = langChecker.detectAlphabet(content);
            CaesarCipher cipher = new CaesarCipher(alphabet);

            switch(command) {
                case "ENCRYPT":
                    fileManager.writeFile(filePath, cipher.encode(content, key), "[ENCRYPTED]");
                    break;
                case "DECRYPT":
                    fileManager.writeFile(filePath, cipher.encode(content, -key), "[DECRYPTED]");
                    break;
                case "BRUTE_FORCE":
                    cipher.bruteForce(content);
                    break;
                default:
                    System.out.println("Unknown command!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void runInteractive() {
        Scanner scanConsole = new Scanner(System.in);
        System.out.println("--- CAESAR CRYPTOGRAPH ---");

        System.out.print("Select an action - (ENCRYPT/DECRYPT/BRUTE_FORCE): ");
        String command = scanConsole.nextLine().toUpperCase();

        System.out.print("Enter file path: ");
        String filePath = scanConsole.nextLine();

        int key = 0;
        if(!"BRUTE_FORCE".equals(command)) {
            System.out.print("Enter the key: ");
            key = Integer.parseInt(scanConsole.nextLine());
        }

        execute(command, filePath, key);
    }
}

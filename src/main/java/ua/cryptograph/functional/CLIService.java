package ua.cryptograph.functional;

import ua.cryptograph.domain.Command;

import java.util.Scanner;

public class CLIService {
    public String[] runCLI() {
        Scanner scanConsole = new Scanner(System.in);
        System.out.println("--- CAESAR CRYPTOGRAPH ---");

        System.out.print("Select an action - (ENCRYPT/DECRYPT/BRUTE_FORCE): ");
        String command = scanConsole.nextLine().toUpperCase();

        System.out.print("Enter file path: ");
        String filePath = scanConsole.nextLine();

        if (Command.BRUTE_FORCE.name().equals(command)) {
            return new String[]{command, filePath,};
        }
        System.out.print("Enter the key: ");
        String key = scanConsole.nextLine();

        return new String[]{command, filePath, key};
    }
}

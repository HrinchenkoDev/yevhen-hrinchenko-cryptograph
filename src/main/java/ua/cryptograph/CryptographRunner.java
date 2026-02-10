package ua.cryptograph;

import ua.cryptograph.functional.CommandProcessor;

public class CryptographRunner {

    public static void main(String[] args) {
        CommandProcessor runCryptograph = new CommandProcessor();
        runCryptograph.session(args);
    }
}

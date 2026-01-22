package ua.cryptograph;

import ua.cryptograph.functional.RunSession;

public class CryptographRunner {

    public static void main(String[] args) {
        RunSession runCryptograph = new RunSession();
        runCryptograph.session(args);
    }
}

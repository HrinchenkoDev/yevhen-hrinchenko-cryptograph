package ua.cryptograph.functional;

import ua.cryptograph.Command;

public class RunSession {
    private final Encoder encoder;

    public RunSession(Encoder encoder) {
        this.encoder = encoder;
    }

    public void session(String[] args) {
        if(args.length < 2) {
            throw new IllegalArgumentException("Використання: command filePath key \n " +
                    "Команди: ENCRYPT, DECRYPT, BRUTE_FORCE");
        }

        Command command = Command.valueOf(args[0].toUpperCase());

        switch(command) {
            case ENCRYPT:
        }
    }
}

package ua.cryptograph;

import ua.cryptograph.functional.Encoder;

public class CryptographRunner {

    private static final String ALPHABET_ENG = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            ".,\"':!? ";
    private static final String ALPHABET_UKR = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            ".,\"':!? ";

    public static void main(String[] args) {
        Encoder encoderEng = new Encoder(ALPHABET_ENG);
        Encoder encoderUkr = new Encoder(ALPHABET_UKR);
    }
}

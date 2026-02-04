package ua.cryptograph.functional;

public class CaesarCipher {

    public static final int SYMBOLS_IN_ALPHABET = 60;
    private final String alphabet;

    public CaesarCipher(String alphabet) {
        this.alphabet = alphabet;
    }

    public String encode(String text, int key) {
        StringBuilder result = new StringBuilder();
        for(char c : text.toCharArray()) {
            result.append(encodeChar(c, key));
        }
        return result.toString();
    }

    private char encodeChar(char symbol, int key) {
        int index = alphabet.indexOf(symbol);
        if(index == -1) {
            return symbol;
        }

        int alphabetSize = alphabet.length();
        int newIndex = (index + (key % alphabetSize) + alphabetSize) % alphabetSize;

        return alphabet.charAt(newIndex);
    }

    public void bruteForce(String encryptedText) {
        for (int key = 1; key < alphabet.length(); key++) {
            String decoded = encode(encryptedText, -key);
            String preview = decoded.length() > SYMBOLS_IN_ALPHABET ? decoded.substring(0, SYMBOLS_IN_ALPHABET) : decoded;
            System.out.println("Ключ " + key + ": [" + preview + "...]");
        }
    }
}

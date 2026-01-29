package ua.cryptograph.functional;

public class CaesarCipher {

    private final String alphabet;

    public CaesarCipher(String alphabet) {
        this.alphabet = alphabet;
    }

    public String encode(String text, int key) {
        String result = "";
        for(char c : text.toCharArray()) {
            result = result + encodeChar(c, key);
        }
        return result;
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
            String preview = decoded.length() > 60 ? decoded.substring(0, 60) : decoded;
            System.out.println("Ключ " + key + ": [" + preview + "...]");
        }
    }
}

package ua.cryptograph.functional;

public class CaesarCipher {

    private static final int SYMBOLS_IN_ALPHABET = 60;
    private final String alphabet;

    public CaesarCipher(String alphabet) {
        this.alphabet = alphabet;
    }

    public String encode(String text, int key) {
        StringBuilder result = new StringBuilder();
        int size = alphabet.length();

        for(char c : text.toCharArray()) {
            int index = alphabet.indexOf(c);
            if(index == -1) {
                result.append(c);
            }else {
                int newIndex = (index + (key % size) + size) % size;
                result.append(alphabet.charAt(newIndex));
            }
        }
        return result.toString();
    }

    public void bruteForce(String encryptedText) {
        for (int key = 1; key < alphabet.length(); key++) {
            String decoded = encode(encryptedText, -key);
            String preview = decoded.length() > SYMBOLS_IN_ALPHABET ? decoded.substring(0, SYMBOLS_IN_ALPHABET) : decoded;
            System.out.println("Key " + key + ": [" + preview + "...]");
        }
    }
}

package ua.cryptograph.functional;

public class Encoder {

    private final String alphabet;

    public Encoder(String alphabet) {
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

        int newIndex = (index + key) % alphabet.length();
        if(newIndex < 0) {
            newIndex += alphabet.length();
        }

        return alphabet.charAt(newIndex);
    }
}

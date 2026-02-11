package ua.cryptograph.functional;

public class CaesarCipher {

    private static final int PREVIEW_LENGTH = 60;
    private final String alphabet;

    public CaesarCipher(String alphabet) {
        this.alphabet = alphabet;
    }

    public String encode(String text, int key) {
        StringBuilder result = new StringBuilder();
        int size = alphabet.length();

        for (char c : text.toCharArray()) {
            int index = alphabet.indexOf(c);
            if (index == -1) {
                result.append(c);
            } else {
                int newIndex = (index + (key % size) + size) % size;
                result.append(alphabet.charAt(newIndex));
            }
        }
        return result.toString();
    }

    public void bruteForce(String encryptedText) {
        int correctKey = 0;
        double maxScore = -1.0;

        System.out.println("=== SELECTION OF OPTIONS ===");

        for (int i = 1; i < alphabet.length(); i++) {
            String decoded = encode(encryptedText, -i);
            double currentScore = calculateTextScore(decoded);

            if (currentScore > maxScore) {
                maxScore = currentScore;
                correctKey = i;
            }
            String preview = decoded.length() > PREVIEW_LENGTH ? decoded.substring(0, PREVIEW_LENGTH) : decoded;
            System.out.println("Key " + i + ": [" + preview + "...]");
        }
        System.out.println("\n" + "=".repeat(30));
        System.out.println("ANALYSIS COMPLETED ✅");
        System.out.println("MOST PROBABLE KEY: " + correctKey);
        System.out.println("=".repeat(30));
    }

    private double calculateTextScore(String text) {
        int spaceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') spaceCount++;
        }
        return (double) spaceCount / text.length();
    }
}

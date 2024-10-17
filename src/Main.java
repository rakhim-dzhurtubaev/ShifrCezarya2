public class Main {

    // Метод для шифрования текста
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        // Проходим по каждому символу в строке
        for (char character : text.toCharArray()) {
            // Проверяем, является ли символ буквой
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                // Сдвигаем символ и обрабатываем переполнение
                character = (char) ((character + shift - base + 26) % 26 + base);
            }
            result.append(character);
        }
        return result.toString();
    }

    // Метод для расшифрования текста
    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift); // Для расшифрования просто меняем знак сдвига
    }

    public static void main(String[] args) {
        String text = "Hello, World!";
        int shift = 3;

        String encrypted = encrypt(text, shift);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, shift);
        System.out.println("Decrypted: " + decrypted);
    }
}

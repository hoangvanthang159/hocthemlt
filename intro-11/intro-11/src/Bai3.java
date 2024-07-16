import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai3 {
    public static String normalizeString(String s) {
        s = s.trim().replaceAll("\\s+", " ");

        StringTokenizer tokenizer = new StringTokenizer(s, " ");
        StringBuilder normalizedString = new StringBuilder();

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            normalizedString.append(word).append(" ");
        }
        return normalizedString.toString().trim();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một xâu ký tự bất kỳ:");
        String s = scanner.nextLine();

        String normalizedString = normalizeString(s);
        System.out.println("Xâu ký tự sau khi chuẩn hóa: " + normalizedString);
    }
}

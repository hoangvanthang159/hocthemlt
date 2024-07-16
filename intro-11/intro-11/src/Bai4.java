import java.util.Scanner;
import java.util.StringTokenizer;


public class Bai4 {
    public static void findLongestWord(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s, " ");
        String longestWord = "";
        int maxLength = 0;
        int position = -1;
        int currentPos = 0;

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (word.length() > maxLength) {
                longestWord = word;
                maxLength = word.length();
                position = currentPos;
            }
            currentPos += word.length() + 1;
        }

        System.out.println("Từ dài nhất: " + longestWord);
        System.out.println("Độ dài: " + maxLength);
        System.out.println("Vị trí bắt đầu: " + position);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một xâu ký tự bất kỳ:");
        String s = scanner.nextLine();

        findLongestWord(s);
    }
}

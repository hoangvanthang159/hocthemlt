import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập một câu không quá 20 từ, mỗi từ không quá 10 ký tự:");
        String sentence = scanner.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(sentence);
        int tokenCount = tokenizer.countTokens();
        if (tokenCount > 20) {
            System.out.println("Câu nhập vào có nhiều hơn 20 từ. Vui lòng nhập lại.");
            return;
        }
        String[] words = new String[tokenCount];
        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (word.length() > 10) {
                System.out.println("Có từ dài hơn 10 ký tự: " + word + ". Vui lòng nhập lại.");
                return;
            }
            words[index++] = word;
        }
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Các từ trong câu sau khi sắp xếp theo thứ tự Alphabet:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}

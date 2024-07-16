import java.util.Scanner;
import java.util.StringTokenizer;
public class Bai5 {
    public static String reformatName(String name) {
        StringTokenizer tokenizer = new StringTokenizer(name, " ");
        int tokenCount = tokenizer.countTokens();
        String[] nameParts = new String[tokenCount];

        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            nameParts[index++] = tokenizer.nextToken();
        }

        StringBuilder reformattedName = new StringBuilder();
        reformattedName.append(nameParts[tokenCount - 1]);

        for (int i = 0; i < tokenCount - 1; i++) {
            reformattedName.append(" ").append(nameParts[i]);
        }

        return reformattedName.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một xâu họ tên theo cấu trúc họ...đệm...tên:");
        String name = scanner.nextLine();

        String reformattedName = reformatName(name);
        System.out.println("Xâu họ tên theo cấu trúc tên...họ...đệm là:");
        System.out.println(reformattedName);
    }
}

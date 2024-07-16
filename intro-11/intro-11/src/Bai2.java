import java.util.Scanner;
public class Bai2 {
    public static String toAlternatingCase(String s) {
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }

    // Hàm main để nhập xâu ký tự và hiển thị kết quả sau khi chuyển đổi
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một xâu ký tự bất kỳ:");
        String s = scanner.nextLine();

        String alternatingCaseString = toAlternatingCase(s);
        System.out.println("Xâu ký tự sau khi chuyển đổi: " + alternatingCaseString);
    }
}

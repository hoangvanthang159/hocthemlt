import java.util.Scanner;
public class Bai15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tự nhiên n: ");
        int n = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 0) {
                sum += i;
            }
        }

        System.out.println("Tổng các số tự nhiên không lớn hơn n và chia hết cho 7 là: " + sum);

        scanner.close();
    }

}

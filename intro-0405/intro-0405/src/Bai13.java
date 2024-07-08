import java.util.Scanner;
public class Bai13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m, n;
        do {
            System.out.print("Nhập vào số tự nhiên m: ");
            m = scanner.nextInt();
            System.out.print("Nhập vào số tự nhiên n (m < n): ");
            n = scanner.nextInt();
            if (m >= n) {
                System.out.println("Vui lòng nhập sao cho m < n.");
            }
        } while (m >= n);

        System.out.println("Các số chính phương trong đoạn [" + m + ", " + n + "] là:");

        int count = 0;
        for (int i = (int) Math.ceil(Math.sqrt(m)); i <= Math.floor(Math.sqrt(n)); i++) {
            int perfectSquare = i * i;
            if (perfectSquare >= m && perfectSquare <= n) {
                System.out.println(perfectSquare);
                count++;
            }
        }

        System.out.println("Tổng số các số chính phương trong đoạn [" + m + ", " + n + "] là: " + count);
        scanner.close();
    }
}

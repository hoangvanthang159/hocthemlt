import java.util.Scanner;

public class Bai17 {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tự nhiên m: ");
        int m = scanner.nextInt();
        System.out.print("Nhập số tự nhiên n: ");
        int n = scanner.nextInt();


        int ucln = gcd(m, n);

        if (ucln == 1) {
            System.out.println(m + " và " + n + " là hai số nguyên tố cùng nhau.");
        } else {
            System.out.println(m + " và " + n + " không phải là hai số nguyên tố cùng nhau.");
        }

        scanner.close();
    }
}

import java.util.Scanner;
public class Bai16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tự nhiên n: ");
        int n = scanner.nextInt();

        System.out.println("Các số chẵn nhỏ hơn n:");
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.println("Các số lẻ nhỏ hơn n:");
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        scanner.close();
    }
}

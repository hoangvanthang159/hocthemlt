import java.util.Scanner;
public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số n: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Nhập các phần tử của dãy số:");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "]: ");
            array[i] = scanner.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (array[i] == array[i + 1]) {
                count++;
            }
        }

        System.out.println("Số cặp phần tử liên tiếp bằng nhau: " + count);
    }
}

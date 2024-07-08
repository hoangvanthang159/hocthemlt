import java.util.Scanner;
import java.util.Arrays;

public class Bai3 {
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
        Arrays.sort(array);


        System.out.println("Dãy số sau khi sắp xếp theo thứ tự tăng dần:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }

}

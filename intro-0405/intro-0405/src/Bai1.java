import java.util.Scanner;
public class Bai1 {
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

        System.out.print("Nhập số b: ");
        int b = scanner.nextInt();
        System.out.print("Nhập số c: ");
        int c = scanner.nextInt();

        if (b >= c) {
            System.out.println("Giá trị của b phải nhỏ hơn c.");
            return;
        }

        double average = tinhTrungBinhCong(array, b, c);
        if (average == -1) {
            System.out.println("Không có phần tử nào trong khoảng [" + b + ", " + c + "].");
        } else {
            System.out.println("Trung bình cộng các phần tử trong khoảng [" + b + ", " + c + "] là: " + average);
        }
    }

    public static double tinhTrungBinhCong(int[] array, int b, int c) {
        int sum = 0;
        int count = 0;

        for (int i : array) {
            if (i >= b && i <= c) {
                sum += i;
                count++;
            }
        }

        if (count == 0) {
            return -1;
        }

        return (double) sum / count;
    }
}

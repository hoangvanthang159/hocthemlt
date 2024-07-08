import java.util.Scanner;
public class Bai5 {
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
        findSecondLargest(array);
    }

    public static void findSecondLargest(int[] array) {
        if (array.length < 2) {
            System.out.println("Dãy không đủ dài để tìm số lớn thứ hai.");
            return;
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max2Index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max1) {
                max2 = max1;
                max1 = array[i];
            } else if (array[i] > max2 && array[i] != max1) {
                max2 = array[i];
                max2Index = i;
            }
        }

        if (max2 == Integer.MIN_VALUE) {
            System.out.println("Không có số lớn thứ hai trong dãy.");
        } else {
            System.out.println("Số lớn thứ hai là: " + max2);
            System.out.println("Vị trí của số lớn thứ hai: " + max2Index);
        }
    }
}

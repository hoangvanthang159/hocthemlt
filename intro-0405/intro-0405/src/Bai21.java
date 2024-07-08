import java.util.Scanner;
public class Bai21 {
    public static void insertElement(int[] arr, int x, int k) {
        if (k < 0 || k > arr.length) {
            System.out.println("Vị trí k không hợp lệ.");
            return;
        }

        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < k; i++) {
            newArr[i] = arr[i];
        }

        newArr[k] = x;

        for (int i = k + 1; i < newArr.length; i++) {
            newArr[i] = arr[i - 1];
        }

        System.out.print("Mảng sau khi chèn phần tử " + x + " vào vị trí " + k + ": ");
        for (int num : newArr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int N = scanner.nextInt();

        int[] a = new int[N];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < N; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = scanner.nextInt();
        }

        System.out.print("Nhập số nguyên x cần chèn: ");
        int x = scanner.nextInt();
        System.out.print("Nhập vị trí k cần chèn: ");
        int k = scanner.nextInt();

        insertElement(a, x, k);

        scanner.close();
    }
}

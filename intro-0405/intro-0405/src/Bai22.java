import java.util.Scanner;
public class Bai22 {
    public static void deleteElement(int[] arr, int k) {
        if (k < 0 || k >= arr.length) {
            System.out.println("Vị trí k không hợp lệ.");
            return;
        }

        for (int i = k; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }

        System.out.print("Mảng sau khi xóa phần tử ở vị trí " + k + ": ");
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

        System.out.print("Nhập vị trí k cần xóa: ");
        int k = scanner.nextInt();

        deleteElement(a, k);

        scanner.close();
    }
}

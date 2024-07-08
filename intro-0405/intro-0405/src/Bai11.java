import java.util.Scanner;
public class Bai11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số hàng của ma trận (m): ");
        int m = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận (n): ");
        int n = scanner.nextInt();

        int[][] A = new int[m][n];

        System.out.println("Nhập các phần tử của ma trận A:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = scanner.nextInt();
            }
        }

        int[][] B = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[j][i] = A[i][j];
            }
        }

        System.out.println("Ma trận chuyển vị B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

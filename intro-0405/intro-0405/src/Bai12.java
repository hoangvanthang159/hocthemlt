import java.util.Scanner;
public class Bai12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số hàng của ma trận A (m): ");
        int m = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận A và số hàng của ma trận B (n): ");
        int n = scanner.nextInt();

        System.out.print("Nhập số cột của ma trận B (k): ");
        int k = scanner.nextInt();

        int[][] A = new int[m][n];

        int[][] B = new int[n][k];

        System.out.println("Nhập các phần tử của ma trận A:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Nhập các phần tử của ma trận B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print("B[" + i + "][" + j + "] = ");
                B[i][j] = scanner.nextInt();
            }
        }

        int[][] C = new int[m][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                C[i][j] = 0;
                for (int x = 0; x < n; x++) {
                    C[i][j] += A[i][x] * B[x][j];
                }
            }
        }

        System.out.println("Ma trận tích C:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

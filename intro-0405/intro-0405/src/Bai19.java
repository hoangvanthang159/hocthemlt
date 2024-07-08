public class Bai19 {
    public static boolean isPalindrome(int num) {
        int originalNum = num;
        int reverseNum = 0;
        while (num > 0) {
            int remainder = num % 10;
            reverseNum = reverseNum * 10 + remainder;
            num /= 10;
        }
        return originalNum == reverseNum;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int minNumber = 100000;
        int maxNumber = 999999;

        System.out.println("Các số thuận nghịch có 6 chữ số và tổng chữ số chia hết cho 10:");
        for (int num = minNumber; num <= maxNumber; num++) {
            if (isPalindrome(num)) {
                int sum = sumOfDigits(num);
                if (sum % 10 == 0) {
                    System.out.println(num);
                }
            }
        }
    }
}

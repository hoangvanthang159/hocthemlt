public class Bai18 {
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= num) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

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

    public static boolean containsNoFour(int num) {
        while (num > 0) {
            int digit = num % 10;
            if (digit == 4) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int minDigits = 10000;
        int maxDigits = 9999999;

        System.out.println("Các số nguyên có từ 5 đến 7 chữ số thoả mãn các điều kiện:");
        for (int num = minDigits; num <= maxDigits; num++) {
            if (isPrime(num) && isPalindrome(num) && containsNoFour(num)) {
                System.out.println(num);
            }
        }
    }
}

public class Bai2 {
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public static boolean allDigitsArePrime(int num) {
        String strNum = Integer.toString(num);
        for (char c : strNum.toCharArray()) {
            if (!isPrime(Character.getNumericValue(c))) return false;
        }
        return true;
    }
    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println("Các số nguyên có 7 chữ số thoả mãn các điều kiện là:");
        int start = 1000000;
        int end = 10000000;
        for (int num = start; num < end; num++) {
            if (isPrime(num) && allDigitsArePrime(num) && isPrime(reverseNumber(num))) {
                System.out.println(num);
            }
        }
    }
}

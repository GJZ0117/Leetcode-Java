package medium;

/**
 * 866. Prime Palindrome
 */

public class Prime_Palindrome {
    public int primePalindrome(int N) {
        while (true) {
            N = getNextPalindrome(N);
            if (isPrime(N)) {
                return N;
            }
            N++;
        }
    }

    private int getNextPalindrome(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int mid = s.length / 2;
        while (true) {
            for (int i = 0; i < mid; i++) {
                s[s.length - 1 - i] = s[i];
            }
            int tmp = Integer.parseInt(String.valueOf(s));
            if (tmp >= n) {
                return tmp;
            }
            int j = s.length % 2 == 1 ? mid : mid - 1;
            while (s[j] == '9') {
                s[j--] = '0';
            }
            s[j]++;
        }
    }

    private boolean isPrime(int num) {
        if (num <= 5) {
            return num == 2 || num == 3 || num == 5;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

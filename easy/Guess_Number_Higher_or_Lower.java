package easy;

/**
 * 374. Guess Number Higher or Lower
 */

public class Guess_Number_Higher_or_Lower {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid;
        int flag;
        while (true) {
            mid = left + (right - left) / 2;
            flag = guess(mid);
            if (flag == 0) {
                return mid;
            } else if (flag == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    public int guess(int num) {
        return 0;
    }
}

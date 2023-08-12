package easy;

/**
 * 1013. Partition Array Into Three Parts With Equal Sum
 */

public class Partition_Array_Into_Three_Parts_With_Equal_Sum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        sum = 0;
        int count = 3;
        for (int n : arr) {
            if (sum + n == target) {
                if (count > 0) {
                    count--;
                    sum = 0;
                } else {
                    sum += n;
                }
            } else {
                sum += n;
            }
        }
        return count == 0 && sum == 0;
    }
}

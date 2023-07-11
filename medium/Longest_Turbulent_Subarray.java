package medium;

/**
 * 978. Longest Turbulent Subarray
 */

public class Longest_Turbulent_Subarray {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }

        int i = 1;
        int res = 1;
        int cur = 1;
        boolean flag = false;
        while (i < arr.length && arr[i] == arr[i - 1]) {
            i++;
        }
        if (i < arr.length) {
            res = arr[i] == arr[i - 1] ? 1 : 2;
            cur = arr[i] == arr[i - 1] ? 1 : 2;
            flag = arr[i] > arr[i - 1];
            i++;
        }

        for (; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                res = Math.max(res, cur);
                while (i < arr.length && arr[i] == arr[i - 1]) {
                    i++;
                }
                if (i == arr.length) {
                    break;
                } else {
                    cur = 2;
                    flag = (arr[i] > arr[i - 1]);
                }
            } else if ((!flag && arr[i] > arr[i - 1]) || (flag && arr[i] < arr[i - 1])) {
                cur++;
                flag = !flag;
            } else {
                res = Math.max(res, cur);
                cur = 2;
                flag = (arr[i] > arr[i - 1]);
            }
        }
        res = Math.max(res, cur);
        return res;
    }
}
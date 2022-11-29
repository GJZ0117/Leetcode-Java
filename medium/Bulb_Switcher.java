package medium;

/**
 * 319. Bulb Switcher
 */

public class Bulb_Switcher {

    public static void main(String[] args) {
        for (int i = 0; i <= 10000; i++) {
            System.out.println(i + " : " + _bulbSwitch(i) + " " + _bulbSwitch(i));
        }
    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static int _bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        boolean[] flag = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            flag[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            int j = i;
            while (j <= n) {
                flag[j] = !flag[j];
                j += i;
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (flag[i]) {
                ans++;
            }
        }
        return ans;
    }

}

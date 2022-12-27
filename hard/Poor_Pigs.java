package hard;

/**
 * 458. Poor Pigs
 */

public class Poor_Pigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        int pigs = (int) Math.ceil(Math.log(buckets) / Math.log(states) - 1e-5);
        return pigs;
    }
}

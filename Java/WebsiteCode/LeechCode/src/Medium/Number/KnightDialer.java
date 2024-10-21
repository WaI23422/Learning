package Medium.Number;

import java.util.Arrays;

public class KnightDialer {
    public static void main(String[] args) {
        int[] tests = {
            1,
            2,
            3,
            4,
            3131
        };

        for (int n : tests) {
            System.out.println(new KnightDialer_Solution().knightDialer(n));
        }
    }
}

class KnightDialer_Solution {
    // 61 ms 43.3 MB
    public int knightDialer(int n) {
        if (n == 1) { return 10; }

        int mod = 1000000007;
        double[] 
            store = new double[9],
            pathCount = new double[9] // Path to [0,1,2,3,4,6,7,8,9] when at 5 knight can't move.
        ;

        Arrays.fill(store, 1); // Start counting path at each point.

        for (int i = 1; i < n; i++) {
            pathCount[0] = (store[4] + store[5])% mod;
            pathCount[1] = (store[5] + store[7])% mod;
            pathCount[2] = (store[6] + store[8])% mod;
            pathCount[3] = (store[4] + store[7])% mod; 
            pathCount[4] = (store[0] + store[3] + store[8])%mod;
            pathCount[5] = (store[0] + store[1] + store[6])%mod;
            pathCount[6] = (store[2] + store[5])% mod;
            pathCount[7] = (store[1] + store[3])% mod;
            pathCount[8] = (store[2] + store[4])% mod;

            store = pathCount.clone();
        }

        System.gc(); // 79 ms 40.8 MB
        return (int) (Arrays.stream(pathCount).sum()%mod);
    }
}

package BetterCodeAnswer.Medium.Number;

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

/**
 * <h1 id="approach">Approach</h1>
 * <ul>
<li>Create a 2D array <code>MOVES</code> to represent the possible moves for each digit on the phone pad.</li>
<li>Use a recursive function <code>knightDialer</code> to calculate the count of distinct phone numbers.</li>
<li>Use a cache (<code>cache</code> array) to store previously computed results for optimization.</li>
<li>If <code>remaining</code> is 1, return the length of <code>nextNumbers</code>, indicating that the knight can be placed on any of the available numbers.</li>
<li>Otherwise, iterate through each number in <code>nextNumbers</code> and recursively calculate the count for the remaining moves (<code>remaining - 1</code>) using the possible moves for the current number.</li>
<li>Update the cache with the calculated result and return the total count.</li>
</ul>
 */
class KnightDialer_Solution {
    // 2 ms 40.2 MB
    static final int mod = (int) 1e9 + 7;
    static final int[][] MOVES = {
            /*0*/ {4, 6},
            /*1*/ {6, 8},
            /*2*/ {7, 9},
            /*3*/ {4, 8},
            /*4*/ {0, 3, 9},
            /*5*/ {},
            /*6*/ {0, 1, 7},
            /*7*/ {2, 6},
            /*8*/ {1, 3},
            /*9*/ {2, 4}
    };
    static final int[][] cache = new int[5001][10];
     
    public int knightDialer(int n) {
        return knightDialer(n, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    int knightDialer(int remaining, int[] nextNumbers) {
        if (remaining == 1) return nextNumbers.length;
        int count = 0;

        for (int nextNumber : nextNumbers) {
            int cur = cache[remaining][nextNumber];
            if (cur == 0) {
                cur = knightDialer(remaining - 1, MOVES[nextNumber]);
                cache[remaining][nextNumber] = cur;
            }
            count += cur;
            count %= mod;
        }
        return count;
    }
} 
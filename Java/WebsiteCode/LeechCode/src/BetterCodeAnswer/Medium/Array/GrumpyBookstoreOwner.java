package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/grumpy-bookstore-owner/">1052. Grumpy Bookstore Owner</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There is a bookstore owner that has a store open for <code>n</code> minutes. Every minute, some number of customers enter the store. You are given an integer array <code>customers</code> of length <code>n</code> where <code>customers[i]</code> is the number of the customer that enters the store at the start of the <code>i<sup>th</sup></code> minute and all those customers leave after the end of that minute.</p>
 * 
 * <p>On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where <code>grumpy[i]</code> is <code>1</code> if the bookstore owner is grumpy during the <code>i<sup>th</sup></code> minute, and is <code>0</code> otherwise.</p>
 * 
 * <p>When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.</p>
 * 
 * <p>The bookstore owner knows a secret technique to keep themselves not grumpy for <code>minutes</code> consecutive minutes, but can only use it once.</p>
 * 
 * <p>Return <em>the maximum number of customers that can be satisfied throughout the day</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * <strong>Output:</strong> 16
 * <strong>Explanation:</strong> The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
 * The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> customers = [1], grumpy = [0], minutes = 1
 * <strong>Output:</strong> 1
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == customers.length == grumpy.length</code></li>
 * 	<li><code>1 &lt;= minutes &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= customers[i] &lt;= 1000</code></li>
 * 	<li><code>grumpy[i]</code> is either <code>0</code> or <code>1</code>.</li>
 * </ul>
 * </div>
 */
public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,0,1,2,1,1,7,5},
                {0,1,0,1,0,1,0,1},
                {3},
            },
        };

        for (int[][] test : tests) {
            int customer[] =test[0],
                grumpy[] = test[1],
                minute = test[2][0];

            System.out.println(new GrumpyBookstoreOwner_Solution().maxSatisfied(customer, grumpy, minute));
        }
    }
}

// 4 ms 47.1 MB
class GrumpyBookstoreOwner_Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int j = 0;
        int curWin = 0;
        int maxWin = 0;

        for(int i=0;j<n;j++) {
            if(grumpy[j] == 1) {
                curWin+=customers[j];
            }
            maxWin = Math.max(curWin, maxWin);
            if(j >= minutes - 1 ) {
                if(grumpy[i] == 1) {
                curWin -= customers[i];
                }
                i++;
            }
        }
        int res = maxWin;
        for(int i=0;i<grumpy.length;i++) {
            if(grumpy[i] == 0) {
                res+=customers[i];
            }
        }
        return res;

    }
}


// 3 ms 47.1 MB
class GrumpyBookstoreOwner_Solution2 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int i = 0;
        int curWin = 0;
        int maxWin = 0;

        for(int j=0;j<n;j++) {
            curWin+=customers[j] * grumpy[j];
            maxWin = Math.max(curWin, maxWin);
            if(j >= minutes - 1 ) {
                curWin -= customers[i] * grumpy[i++];
            }
        }
        int res = maxWin;
        for(i=0;i<grumpy.length;i++) {
            res+=customers[i] * (1 - grumpy[i]);
        }
        return res;

    }
}

// 3 ms 47.46 MB
class GrumpyBookstoreOwner_Solution3 {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unrealizedCustomers = 0;

        // Calculate initial number of unrealized customers in first 'minutes' window
        for (int i = 0; i < minutes; i++) {
            unrealizedCustomers += customers[i] * grumpy[i];
        }

        int maxUnrealizedCustomers = unrealizedCustomers;

        // Slide the 'minutes' window across the rest of the customers array
        for (int i = minutes; i < n; i++) {
            // Add the current minute's unsatisfied customers if the owner is grumpy
            // and remove the customers that are out of the current window
            unrealizedCustomers += customers[i] * grumpy[i];
            unrealizedCustomers -= customers[i - minutes] * grumpy[i - minutes];

            // Update the maximum unrealized customers
            maxUnrealizedCustomers = Math.max(
                maxUnrealizedCustomers,
                unrealizedCustomers
            );
        }

        // Start with maximum possible satisfied customers due to secret technique
        int totalCustomers = maxUnrealizedCustomers;

        // Add the satisfied customers during non-grumpy minutes
        for (int i = 0; i < customers.length; i++) {
            totalCustomers += customers[i] * (1 - grumpy[i]);
        }

        // Return the maximum number of satisfied customers
        return totalCustomers;
    }
}
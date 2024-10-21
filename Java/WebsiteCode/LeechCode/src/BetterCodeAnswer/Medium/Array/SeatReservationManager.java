package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/seat-reservation-manager/">1845.Seat Reservation Manager</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Design a system that manages the reservation state of <code>n</code> seats that are numbered from <code>1</code> to <code>n</code>.</p>

<p>Implement the <code>SeatManager</code> class:</p>

<ul>
	<li><code>SeatManager(int n)</code> Initializes a <code>SeatManager</code> object that will manage <code>n</code> seats numbered from <code>1</code> to <code>n</code>. All seats are initially available.</li>
	<li><code>int reserve()</code> Fetches the <strong>smallest-numbered</strong> unreserved seat, reserves it, and returns its number.</li>
	<li><code>void unreserve(int seatNumber)</code> Unreserves the seat with the given <code>seatNumber</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
[[5], [], [], [2], [], [], [], [], [5]]
<strong>Output</strong>
[null, 1, 2, null, 2, 3, 4, 5, null]

<strong>Explanation</strong>
SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
seatManager.reserve();    // The only available seat is seat 5, so return 5.
seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= seatNumber &lt;= n</code></li>
	<li>For each call to <code>reserve</code>, it is guaranteed that there will be at least one unreserved seat.</li>
	<li>For each call to <code>unreserve</code>, it is guaranteed that <code>seatNumber</code> will be reserved.</li>
	<li>At most <code>10<sup>5</sup></code> calls <strong>in total</strong> will be made to <code>reserve</code> and <code>unreserve</code>.</li>
</ul>
</div></div>
 */
public class SeatReservationManager {
    public static void main(String[] args) {
        String[][] Actions = {
            {"SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"},  
        };

        int[][][] Sizes = {
            {{5}, {}, {}, {2}, {}, {}, {}, {}, {5}}
        };

        for (int i = 0; i < Actions.length; i++) {
            Integer[] ans = new Integer[Actions[0].length];
            SeatManager2 seatManager = new SeatManager2(Sizes[i][0][0]);

            for (int j = 1; j < Actions[0].length; j++) {
                switch (Actions[i][j]) {
                    case "reserve":
                        ans[j] = seatManager.reserve();
                        break;

                    default:
                        seatManager.unreserve(Sizes[i][j][0]);
                        break;
                }
            }

            System.out.println(Arrays.toString(ans));
        }
    
    }    
}

class SeatManager2 {

    boolean[] res;
    int min = 1;
    int unreserved=0;
    public SeatManager2(int n) {
        res=new boolean[n+1];
    }
    
    public int reserve() {
        if (unreserved == 0){
            res[min] = true;
            return min++;
        }

        for (int i = 1; i<res.length;i++){
            if (!res[i]){
                res[i] = true;
                unreserved--;
                return i;
            }
        }
        return -1;
    }
    
    public void unreserve(int seatNumber) {
        unreserved++;
        res[seatNumber]=false;
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
class SeatManager1 {
    private int last;
    private PriorityQueue<Integer> pq;

    public SeatManager1(int n) {
        this.last = 0;
        this.pq = new PriorityQueue<>();
    }

    public int reserve() {
        if (pq.isEmpty()) {
            return ++last;
        } else {
            return pq.poll();
        }
    }

    public void unreserve(int seatNumber) {
        if (seatNumber == last) {
            --last;
        } else {
            pq.offer(seatNumber);
        }
    }
}
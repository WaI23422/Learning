package BetterCodeAnswer.Easy.Class;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/kth-largest-element-in-a-stream/">703. Kth Largest Element in a Stream</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Design a class to find the <code>k<sup>th</sup></code> largest element in a stream. Note that it is the <code>k<sup>th</sup></code> largest element in the sorted order, not the <code>k<sup>th</sup></code> distinct element.</p>
 * 
 * <p>Implement <code>KthLargest</code> class:</p>
 * 
 * <ul>
 * 	<li><code>KthLargest(int k, int[] nums)</code> Initializes the object with the integer <code>k</code> and the stream of integers <code>nums</code>.</li>
 * 	<li><code>int add(int val)</code> Appends the integer <code>val</code> to the stream and returns the element representing the <code>k<sup>th</sup></code> largest element in the stream.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input</strong>
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * <strong>Output</strong>
 * [null, 4, 5, 5, 8, 8]
 * 
 * <strong>Explanation</strong>
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= val &lt;= 10<sup>4</sup></code></li>
 * 	<li>At most <code>10<sup>4</sup></code> calls will be made to <code>add</code>.</li>
 * 	<li>It is guaranteed that there will be at least <code>k</code> elements in the array when you search for the <code>k<sup>th</sup></code> element.</li>
 * </ul>
 * </div>
 */
public class KthLargestElementInAStream {
    public static void main(String[] args) {
        Object[][][][] tests = {
            {
                {{"KthLargest", "add", "add", "add", "add", "add"}},
                {{2}, {0}, {-1}, {1}, {1}, {1}, {4}}
            },
            {
                {{"KthLargest", "add", "add", "add", "add", "add"}},
                {{3}, {4, 5, 8, 2}, {3}, {5}, {10}, {9}, {4}}
            }
        };

        for (Object[][][] test : tests) {
            String[] actions = Arrays.copyOf(test[0][0], test[0][0].length,String[].class);
            int[][] numbers = transfromObjectArrays(test[1]) ; 
            // Arrays.copyOf(test[1], test[1].length,Integer[].class);   

            Object[] ans = new Object[actions.length];
            KthLargest temp = new KthLargest(numbers[0][0], numbers[1]);
            
            int i = 2;
            for (String action : actions) {
                switch (action) {
                    case "KthLargest":
                        break;
                
                    default:
                        ans[i-1] = temp.add(numbers[i++][0]);
                        break;
                }
            }

            System.out.println(Arrays.toString(ans));
        }
    }

    private static int[][] transfromObjectArrays(Object[][] arr) {
        int[][] temp = new int[arr.length][];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = Arrays.stream(arr[i])
                            .mapToInt(x -> (int) x)
                            .toArray();
        }

        return temp;
    }
}

// 9ms 47MB
class KthLargest {

    private int size = 0;
    final int k = 0;
    private final int[] heap;

    public KthLargest(int k, int[] nums) {
        this.heap = new int[k + 1];
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        
        if (size == k) {
            if (val < heap[1]) {
                return heap[1];
            }
            pop();
        }

        heap[++size] = val;

        int index = size;
        int parent = size / 2;

        while (heap[parent] > heap[index] && index > 1) {

            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;

            index = parent;
            parent = parent / 2;
        }

        return heap[1];
    }

    public void pop() {
        heap[1] = heap[size--];

        int index = 1;
        while (index <= size / 2) {
            int left = index * 2;
            int right = (index * 2) + 1;

            if (heap[index] > heap[left] || heap[index] > heap[right]) {
                if (heap[left] < heap[right]) {
                    int temp = heap[left];
                    heap[left] = heap[index];
                    heap[index] = temp;
                    index = left;
                } else {
                    int temp = heap[right];
                    heap[right] = heap[index];
                    heap[index] = temp;
                    index = right;
                }
            } else {
                break;
            }
        }
    }

}

// 11ms 46.87MB
class KthLargest2 {
    final PriorityQueue<Integer> q;
        final int k;

        public KthLargest2(int k, int[] a) {
            this.k = k;
            q = new PriorityQueue<>(k);
            for (int n : a)
                add(n);
        }

        public int add(int n) {
            if (q.size() < k)
                q.offer(n);
            else if (q.peek() < n) {
                q.poll();
                q.offer(n);
            }
            return q.peek();
        }
}

package BetterCodeAnswer.Medium.Class;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/design-a-stack-with-increment-operation/">1381. Design a Stack With Increment Operation</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Design a stack that supports increment operations on its elements.</p>
 * 
 * <p>Implement the <code>CustomStack</code> class:</p>
 * 
 * <ul>
 * 	<li><code>CustomStack(int maxSize)</code> Initializes the object with <code>maxSize</code> which is the maximum number of elements in the stack.</li>
 * 	<li><code>void push(int x)</code> Adds <code>x</code> to the top of the stack if the stack has not reached the <code>maxSize</code>.</li>
 * 	<li><code>int pop()</code> Pops and returns the top of the stack or <code>-1</code> if the stack is empty.</li>
 * 	<li><code>void inc(int k, int val)</code> Increments the bottom <code>k</code> elements of the stack by <code>val</code>. If there are less than <code>k</code> elements in the stack, increment all the elements in the stack.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input</strong>
 * ["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
 * [[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
 * <strong>Output</strong>
 * [null,null,null,2,null,null,null,null,null,103,202,201,-1]
 * <strong>Explanation</strong>
 * CustomStack stk = new CustomStack(3); // Stack is Empty []
 * stk.push(1);                          // stack becomes [1]
 * stk.push(2);                          // stack becomes [1, 2]
 * stk.pop();                            // return 2 --&gt; Return top of the stack 2, stack becomes [1]
 * stk.push(2);                          // stack becomes [1, 2]
 * stk.push(3);                          // stack becomes [1, 2, 3]
 * stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
 * stk.increment(5, 100);                // stack becomes [101, 102, 103]
 * stk.increment(2, 100);                // stack becomes [201, 202, 103]
 * stk.pop();                            // return 103 --&gt; Return top of the stack 103, stack becomes [201, 202]
 * stk.pop();                            // return 202 --&gt; Return top of the stack 202, stack becomes [201]
 * stk.pop();                            // return 201 --&gt; Return top of the stack 201, stack becomes []
 * stk.pop();                            // return -1 --&gt; Stack is empty return -1.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= maxSize, x, k &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= val &lt;= 100</code></li>
 * 	<li>At most <code>1000</code> calls will be made to each method of <code>increment</code>, <code>push</code> and <code>pop</code> each separately.</li>
 * </ul>
 * </div>
 */
public class DesignAStackWithIncrementOperation {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {"CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"},
                {3},{1},{2},{},{2},{3},{4},{5,100},{2,100},{},{},{},{}
            },
        };

        for (Object[][] test : tests) {
            String[] actions = Arrays.copyOf(test[0], test[0].length, String[].class);
            CustomStack stack = new CustomStack((int) test[1][0]);
            Object[] res = new Object[test[0].length]; 

            for (int i = 0; i < test[0].length; i++) {
                switch (actions[i]) {
                    case "push":
                        stack.push((int) test[i+1][0]);
                        res[i] = null;
                        break;
                    case "pop":
                        res[i] = stack.pop();
                        break;
                    case "increment":
                        stack.increment((int) test[i+1][0],(int) test[i+1][1]);
                        res[i] = null;
                    default:
                        res[i] = null;
                        break;
                }
            }

            System.out.println(Arrays.toString(res));
        }
    }
}

// 5ms 44.94MB
class CustomStack {

    // Array to store stack elements
    private int[] stackArray;

    // Array to store increments for lazy propagation
    private int[] incrementArray;

    // Current top index of the stack
    private int topIndex;

    public CustomStack(int maxSize) {
        stackArray = new int[maxSize];
        incrementArray = new int[maxSize];
        topIndex = -1;
    }

    public void push(int x) {
        if (topIndex < stackArray.length - 1) {
            stackArray[++topIndex] = x;
        }
    }

    public int pop() {
        if (topIndex < 0) {
            return -1;
        }

        // Calculate the actual value with increment
        int result = stackArray[topIndex] + incrementArray[topIndex];

        // Propagate the increment to the element below
        if (topIndex > 0) {
            incrementArray[topIndex - 1] += incrementArray[topIndex];
        }

        // Reset the increment for this position
        incrementArray[topIndex] = 0;

        topIndex--;
        return result;
    }

    public void increment(int k, int val) {
        if (topIndex >= 0) {
            // Apply increment to the topmost element of the range
            int incrementIndex = Math.min(topIndex, k - 1);
            incrementArray[incrementIndex] += val;
        }
    }
}
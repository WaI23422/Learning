package BetterCodeAnswer.Medium.Class;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/design-circular-deque/">641. Design Circular Deque</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Design your implementation of the circular double-ended queue (deque).</p>
 * 
 * <p>Implement the <code>MyCircularDeque</code> class:</p>
 * 
 * <ul>
 * 	<li><code>MyCircularDeque(int k)</code> Initializes the deque with a maximum size of <code>k</code>.</li>
 * 	<li><code>boolean insertFront()</code> Adds an item at the front of Deque. Returns <code>true</code> if the operation is successful, or <code>false</code> otherwise.</li>
 * 	<li><code>boolean insertLast()</code> Adds an item at the rear of Deque. Returns <code>true</code> if the operation is successful, or <code>false</code> otherwise.</li>
 * 	<li><code>boolean deleteFront()</code> Deletes an item from the front of Deque. Returns <code>true</code> if the operation is successful, or <code>false</code> otherwise.</li>
 * 	<li><code>boolean deleteLast()</code> Deletes an item from the rear of Deque. Returns <code>true</code> if the operation is successful, or <code>false</code> otherwise.</li>
 * 	<li><code>int getFront()</code> Returns the front item from the Deque. Returns <code>-1</code> if the deque is empty.</li>
 * 	<li><code>int getRear()</code> Returns the last item from Deque. Returns <code>-1</code> if the deque is empty.</li>
 * 	<li><code>boolean isEmpty()</code> Returns <code>true</code> if the deque is empty, or <code>false</code> otherwise.</li>
 * 	<li><code>boolean isFull()</code> Returns <code>true</code> if the deque is full, or <code>false</code> otherwise.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input</strong>
 * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * <strong>Output</strong>
 * [null, true, true, true, false, 2, true, true, true, 4]
 * 
 * <strong>Explanation</strong>
 * MyCircularDeque myCircularDeque = new MyCircularDeque(3);
 * myCircularDeque.insertLast(1);  // return True
 * myCircularDeque.insertLast(2);  // return True
 * myCircularDeque.insertFront(3); // return True
 * myCircularDeque.insertFront(4); // return False, the queue is full.
 * myCircularDeque.getRear();      // return 2
 * myCircularDeque.isFull();       // return True
 * myCircularDeque.deleteLast();   // return True
 * myCircularDeque.insertFront(4); // return True
 * myCircularDeque.getFront();     // return 4
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= k &lt;= 1000</code></li>
 * 	<li><code>0 &lt;= value &lt;= 1000</code></li>
 * 	<li>At most <code>2000</code> calls will be made to <code>insertFront</code>, <code>insertLast</code>, <code>deleteFront</code>, <code>deleteLast</code>, <code>getFront</code>, <code>getRear</code>, <code>isEmpty</code>, <code>isFull</code>.</li>
 * </ul>
 * </div>
 */
public class DesignCircularDeque {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {"MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"},
                {3}, {1}, {2}, {3}, {4}, {}, {}, {}, {4}, {}
            },
        };

        for (Object[][] test : tests) {
            String[] actions = Arrays.copyOf(test[0], test[0].length, String[].class);
            MyCircularDeque deque = new MyCircularDeque((int) test[1][0]);
            Object[] res = new Object[test[0].length]; 

            for (int i = 0; i < test[0].length; i++) {
                switch (actions[i]) {
                    case "insertLast":
                        res[i] = deque.insertLast((int) test[i+1][0]);
                        break;
                    case "insertFront":
                        res[i] = deque.insertFront((int) test[i+1][0]);
                        break;
                    case "deleteFront":
                        res[i] = deque.deleteFront();
                        break;
                    case "deleteLast":
                        res[i] = deque.deleteLast();
                        break;
                    case "getFront":
                        res[i] = deque.getFront();
                        break;
                    case "getRear":
                        res[i] = deque.getRear();
                        break;
                    case "isEmpty":
                        res[i] = deque.isEmpty();
                        break;
                    case "isFull":
                        res[i] = deque.isFull();
                        break;
                    default:
                        res[i] = null;
                        break;
                }
            }

            System.out.println(Arrays.toString(res));
        }
    }
}

// 4ms 45.06MB
class MyCircularDeque {
    private int head, tail, size, n;
    private final int[] a;
    public MyCircularDeque(int k) {
        a = new int[k];
        n = a.length;
        tail = 1;
    }
    
    public boolean insertFront(int x) {
        if (size == n) return false;
        a[head = ++head % n] = x;
        size++;
        return true;
    }
    
    public boolean insertLast(int x) {
        if (size == n) return false;
        a[tail = (--tail + n) % n] = x;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (size == 0) return false;
        head = (--head + n) % n;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (size == 0) return false;
        tail = ++tail % n;
        size--;
        return true;
    }
    
    public int getFront() {
        return size == 0 ? -1 : a[head];
    }
    
    public int getRear() {
        return size == 0 ? -1 : a[tail];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == a.length;
    }
}

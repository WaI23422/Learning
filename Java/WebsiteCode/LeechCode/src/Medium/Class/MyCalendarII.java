package Medium.Class;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/my-calendar-ii/">731. My Calendar II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a <strong>triple booking</strong>.</p>
 * 
 * <p>A <strong>triple booking</strong> happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).</p>
 * 
 * <p>The event can be represented as a pair of integers <code>start</code> and <code>end</code> that represents a booking on the half-open interval <code>[start, end)</code>, the range of real numbers <code>x</code> such that <code>start &lt;= x &lt; end</code>.</p>
 * 
 * <p>Implement the <code>MyCalendarTwo</code> class:</p>
 * 
 * <ul>
 * 	<li><code>MyCalendarTwo()</code> Initializes the calendar object.</li>
 * 	<li><code>boolean book(int start, int end)</code> Returns <code>true</code> if the event can be added to the calendar successfully without causing a <strong>triple booking</strong>. Otherwise, return <code>false</code> and do not add the event to the calendar.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input</strong>
 * ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * <strong>Output</strong>
 * [null, true, true, true, false, true, true]
 * 
 * <strong>Explanation</strong>
 * MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
 * myCalendarTwo.book(10, 20); // return True, The event can be booked. 
 * myCalendarTwo.book(50, 60); // return True, The event can be booked. 
 * myCalendarTwo.book(10, 40); // return True, The event can be double booked. 
 * myCalendarTwo.book(5, 15);  // return False, The event cannot be booked, because it would result in a triple booking.
 * myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already double booked.
 * myCalendarTwo.book(25, 55); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= start &lt; end &lt;= 10<sup>9</sup></code></li>
 * 	<li>At most <code>1000</code> calls will be made to <code>book</code>.</li>
 * </ul>
 * </div>
 */
public class MyCalendarII {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {"MyCalendarTwo", "book", "book", "book", "book", "book", "book"},
                {}, {10,20},{50,60},{10,40},{5,15},{5,10},{25,55}
            },
        };

        for (Object[][] test : tests) {
            String[] actions = Arrays.copyOf(test[0], test[0].length, String[].class);
            MyCalendarTwo calendar = new MyCalendarTwo();
            Object[] res = new Object[test[0].length]; 

            for (int i = 0; i < test[0].length; i++) {
                switch (actions[i]) {
                    case "book":
                        res[i] = calendar.book((int) test[i+1][0], (int) test[i+1][1]);        
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

// 13ms 45.4MB
class MyCalendarTwo {
    Tree root;

    private static class Tree {
        int beg;
        int end;
        int times;
        Tree left;
        Tree right;

        public Tree(int beg, int end) {
            this.beg = beg;
            this.end = end;
            this.times = 1;
        }

        public static boolean query(Tree node, int b, int e) {
            if (node == null) {
                return true;
            }
            if (node.beg >= e) {
                return query(node.left, b, e);
            }
            if (node.end <= b) {
                return query(node.right, b, e);
            }
            if (node.times == 2) {
                return false;
            }
            int l1 = Math.min(b, node.beg);
            int l2 = Math.max(b, node.beg);
            int r1 = Math.min(e, node.end);
            int r2 = Math.max(e, node.end);
            boolean re1 = true;
            if (l1 != l2) {
                re1 = query(node.left, l1, l2);
            }
            boolean re2 = true;
            if (r1 != r2) {
                re2 = query(node.right, r1, r2);
            }

            return re1 && re2;

        }

        public static Tree insert(Tree node, int b, int e) {
            if (node == null) {
                return new Tree(b, e);
            }
            if (node.beg >= e) {
                node.left = insert(node.left, b, e);
                return node;
            }
            if (node.end <= b) {
                node.right = insert(node.right, b, e);
                return node;
            }
            int l1 = Math.min(b, node.beg);
            int l2 = Math.max(b, node.beg);
            int r1 = Math.min(e, node.end);
            int r2 = Math.max(e, node.end);
            node.beg = l2;
            node.end = r1;
            if (l1 != l2) {
                node.left = insert(node.left, l1, l2);
            }
            if (r1 != r2) {
                node.right = insert(node.right, r1, r2);
            }
            node.times++;
            return node;
        }
    }

    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new Tree(start, end);
            return true;
        }
        if (!Tree.query(root, start, end)) {
            return false;
        }
        Tree.insert(root, start, end);
        return true;
    }
}
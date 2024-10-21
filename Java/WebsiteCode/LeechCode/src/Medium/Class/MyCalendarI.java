package Medium.Class;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/my-calendar-i/">729. My Calendar I</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a <strong>double booking</strong>.</p>
 * 
 * <p>A <strong>double booking</strong> happens when two events have some non-empty intersection (i.e., some moment is common to both events.).</p>
 * 
 * <p>The event can be represented as a pair of integers <code>start</code> and <code>end</code> that represents a booking on the half-open interval <code>[start, end)</code>, the range of real numbers <code>x</code> such that <code>start &lt;= x &lt; end</code>.</p>
 * 
 * <p>Implement the <code>MyCalendar</code> class:</p>
 * 
 * <ul>
 * 	<li><code>MyCalendar()</code> Initializes the calendar object.</li>
 * 	<li><code>boolean book(int start, int end)</code> Returns <code>true</code> if the event can be added to the calendar successfully without causing a <strong>double booking</strong>. Otherwise, return <code>false</code> and do not add the event to the calendar.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input</strong>
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * <strong>Output</strong>
 * [null, true, false, true]
 * 
 * <strong>Explanation</strong>
 * MyCalendar myCalendar = new MyCalendar();
 * myCalendar.book(10, 20); // return True
 * myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
 * myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.</pre>
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
public class MyCalendarI {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {"MyCalendar", "book", "book", "book"},
                {}, {10, 20}, {15, 25}, {20, 30}
            },
        };

        for (Object[][] test : tests) {
            String[] actions = Arrays.copyOf(test[0], test[0].length, String[].class);
            MyCalendar calendar = new MyCalendar();
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

class MyCalendar {
    // boolean[] days = new boolean[1_000_000_000];
    SortedMap<Integer,Integer> days = new TreeMap<>();

    public MyCalendar() {}
    
    // Memory Limit Exceeded:
    // public boolean book(int start, int end) {
    //     for (int i = start; i < end; i++) {
    //         if (days[i] == true) {return false;}
    //     }
        
    //     Arrays.fill(days, start, end, true);

    //     return true;
    // }

    // 348ms 45.71MB
    public boolean book(int start, int end) {
        if (days.containsKey(start)) {return false;}

        for (Integer day : days.keySet()) {
            if (
                day < start && days.get(day) > start ||
                day > start && end > day
            ) {return false;}
        }

        days.put(start, end);

        return true;
    }
}
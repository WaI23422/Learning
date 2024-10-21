package BetterCodeAnswer.Medium.Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

// 47ms 45.9MB
class MyCalendarTwo {

    private List<int[]> bookings;
    private List<int[]> overlapBookings;

    // Return true if the booking [start1, end1) & [start2, end2) overlaps.
    private boolean doesOverlap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    // Return overlapping booking between [start1, end1) & [start2, end2).
    private int[] getOverlapped(int start1, int end1, int start2, int end2) {
        return new int[] { Math.max(start1, start2), Math.min(end1, end2) };
    }

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlapBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Returns false if the new booking has an overlap
        // with the existing double-booked bookings.
        for (int[] booking : overlapBookings) {
            if (doesOverlap(booking[0], booking[1], start, end)) {
                return false;
            }
        }

        // Add the double overlapping bookings if any with the new booking.
        for (int[] booking : bookings) {
            if (doesOverlap(booking[0], booking[1], start, end)) {
                overlapBookings.add(
                    getOverlapped(booking[0], booking[1], start, end)
                );
            }
        }

        // Add the new booking to the list of bookings.
        bookings.add(new int[] { start, end });
        return true;
    }
}
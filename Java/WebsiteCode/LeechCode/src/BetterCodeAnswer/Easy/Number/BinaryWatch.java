package BetterCodeAnswer.Easy.Number;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/binary-watch/">401. Binary Watch</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent&nbsp;the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.</p>

<ul>
	<li>For example, the below binary watch reads <code>"4:51"</code>.</li>
</ul>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/04/08/binarywatch.jpg" style="width: 500px; height: 500px;"></p>

<p>Given an integer <code>turnedOn</code> which represents the number of LEDs that are currently on (ignoring the PM), return <em>all possible times the watch could represent</em>. You may return the answer in <strong>any order</strong>.</p>

<p>The hour must not contain a leading zero.</p>

<ul>
	<li>For example, <code>"01:00"</code> is not valid. It should be <code>"1:00"</code>.</li>
</ul>

<p>The minute must&nbsp;consist of two digits and may contain a leading zero.</p>

<ul>
	<li>For example, <code>"10:2"</code> is not valid. It should be <code>"10:02"</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> turnedOn = 1
<strong>Output:</strong> ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> turnedOn = 9
<strong>Output:</strong> []
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= turnedOn &lt;= 10</code></li>
</ul>
</div>
 */
public class BinaryWatch {
    public static void main(String[] args) {
        int[] tests = {

        };

        for (int turnedOn : tests) {
            System.out.println(new BinaryWatch_Solution().readBinaryWatch(turnedOn).toString());
        }
    }
}

// 0 ms 42 MB
class BinaryWatch_Solution {
    List<String> res;
    int[] clock;
    public List<String> readBinaryWatch(int turnedOn) {
         res = new ArrayList<>();
         clock = new int[2];
         backtrack(turnedOn, 0);
         return res;
    }

    private void backtrack(int on, int p){
        //the stop condition for backtracking
        if(on == 0){
            String time = getString(clock);
            res.add(time);
            return;
        }
        for(int i = p; i < 10; i++){
            int num = 1 << (i % 6);
            if(i < 6){
                clock[1] += num;
                if(isValid()){
                    backtrack(on - 1, i + 1);
                }
                clock[1] -= num;
            }else{
                clock[0] += num;
                if(isValid()){
                    backtrack(on - 1, i + 1);
                }
                clock[0] -= num;
            }
        }
    }

    //check if the clock has a valid time
    private boolean isValid(){
        if(clock[1] < 60 && clock[0] < 12){
            return true;
        }
        return false;
    }

    private String getString(int[] mark){
        StringBuilder sb = new StringBuilder();
        sb.append(mark[0]);
        sb.append(":");
        if(mark[1] < 10){
            sb.append(0);
        }
        sb.append(mark[1]);
        return sb.toString();
    }
}

// 1 ms 41.7 MB
class BinaryWatch_Solution2 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> output = new ArrayList<>();

        if (turnedOn >= 9) {
            return new ArrayList<String>();
        } else if (turnedOn == 0) {
            output.add("0:00");
            return output;
        }

        StringBuilder sb = new StringBuilder();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                // Count the number of LEDs that are on in the hour and minute
                int count = Integer.bitCount(hour) + Integer.bitCount(minute);
                
                // If the count matches the given turnedOn value, add the time to the output list
                if (count == turnedOn) {
                    sb.setLength(0); // Clear StringBuilder
                    sb.append(hour);
                    sb.append(":");
                    if (minute < 10) {
                        sb.append("0"); // Add leading zero for single-digit minute
                    }
                    sb.append(minute);
                    output.add(sb.toString());
                }
            }
        }

        return output;
    
    }
}
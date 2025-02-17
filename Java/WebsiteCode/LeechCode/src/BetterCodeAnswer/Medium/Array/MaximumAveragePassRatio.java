
package BetterCodeAnswer.Medium.Array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-average-pass-ratio/">1792. Maximum Average Pass Ratio</a>
 * <div><div class="elfjS" data-track-load="description_content"><p>There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array <code>classes</code>, where <code>classes[i] = [pass<sub>i</sub>, total<sub>i</sub>]</code>. You know beforehand that in the <code>i<sup>th</sup></code> class, there are <code>total<sub>i</sub></code> total students, but only <code>pass<sub>i</sub></code> number of students will pass the exam.</p>
 * 
 * <p>You are also given an integer <code>extraStudents</code>. There are another <code>extraStudents</code> brilliant students that are <strong>guaranteed</strong> to pass the exam of any class they are assigned to. You want to assign each of the <code>extraStudents</code> students to a class in a way that <strong>maximizes</strong> the <strong>average</strong> pass ratio across <strong>all</strong> the classes.</p>
 * 
 * <p>The <strong>pass ratio</strong> of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The <strong>average pass ratio</strong> is the sum of pass ratios of all the classes divided by the number of the classes.</p>
 * 
 * <p>Return <em>the <strong>maximum</strong> possible average pass ratio after assigning the </em><code>extraStudents</code><em> students. </em>Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> classes = [[1,2],[3,5],[2,2]], <code>extraStudents</code> = 2
 * <strong>Output:</strong> 0.78333
 * <strong>Explanation:</strong> You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> classes = [[2,4],[3,9],[4,5],[2,10]], <code>extraStudents</code> = 4
 * <strong>Output:</strong> 0.53485
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= classes.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>classes[i].length == 2</code></li>
 * 	<li><code>1 &lt;= pass<sub>i</sub> &lt;= total<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= extraStudents &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div></div>
 */
public class MaximumAveragePassRatio {
    public static void main(String[] args) {

    }
}

// 294ms 95.02MB
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassRecord> pq = new PriorityQueue<>(new Compare());
        for(int[] cl : classes){
            pq.add(new ClassRecord(cl));
        }

        ClassRecord cl;
        while(extraStudents-- > 0){
            pq.add(pq.remove().addOneStudent());
        }
        double sum = 0;
        while(!pq.isEmpty()){
            cl = pq.remove();
            sum += (double)cl.pass/cl.total;
        }
        return sum / classes.length;
    }
}

class ClassRecord{
    int pass;
    int total;
    double inc;
    public ClassRecord(int[] array){
        pass = array[0];
        total = array[1];
        inc = getIncrement();
    }

    public ClassRecord addOneStudent(){
        pass++;
        total++;
        inc = getIncrement();
        return this;
    }

    private double getIncrement(){
        return (pass + 1.0)/(total + 1) - (double)pass/total;
    }
}

class Compare implements Comparator<ClassRecord>{
    public int compare(ClassRecord a, ClassRecord b){
        if(a.inc < b.inc){
            return 1;
        }
        else if(a.inc > b.inc){
            return -1;
        }
        else{
            return 0;
        }
    }
}
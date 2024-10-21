package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/lemonade-change/">860.Lemonade Change</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>At a lemonade stand, each lemonade costs <code>$5</code>. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a <code>$5</code>, <code>$10</code>, or <code>$20</code> bill. You must provide the correct change to each customer so that the net transaction is that the customer pays <code>$5</code>.</p>

<p>Note that you do not have any change in hand at first.</p>

<p>Given an integer array <code>bills</code> where <code>bills[i]</code> is the bill the <code>i<sup>th</sup></code> customer pays, return <code>true</code> <em>if you can provide every customer with the correct change, or</em> <code>false</code> <em>otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> bills = [5,5,5,10,20]
<strong>Output:</strong> true
<strong>Explanation:</strong> 
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> bills = [5,5,10,10,20]
<strong>Output:</strong> false
<strong>Explanation:</strong> 
From the first two customers in order, we collect two $5 bills.
For the next two customers in order, we collect a $10 bill and give back a $5 bill.
For the last customer, we can not give the change of $15 back because we only have two $10 bills.
Since not every customer received the correct change, the answer is false.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= bills.length &lt;= 10<sup>5</sup></code></li>
	<li><code>bills[i]</code> is either <code>5</code>, <code>10</code>, or <code>20</code>.</li>
</ul>
</div>
 */
public class LemonadeChange {
    public static void main(String[] args) {
        int[][] tests = {
            {5,5,5,10,20},
            {5,5,10,10,20}
        };

        for (int[] bills : tests) {
            System.out.println(new LemonadeChange_Solution().lemonadeChange(bills));
        }
    }
}

// 2 ms 55.9 MB
class LemonadeChange_Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int tens=0;
        for(int i:bills){
            if(i==5){
                five++;
                continue;
            }else if(i==10 && five>0){
                tens++;
                five--;
            }else if(i==20 && tens>0 && five>0){
                tens--;
                five--;
            }else if(five>=3){
                five-=3;
            }else{
                return false;
            }
        }
        return true;
    }
}
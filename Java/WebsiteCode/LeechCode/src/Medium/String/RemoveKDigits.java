package Medium.String;

import java.util.Stack;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/remove-k-digits/">402. Remove K Digits</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given string num representing a non-negative integer <code>num</code>, and an integer <code>k</code>, return <em>the smallest possible integer after removing</em> <code>k</code> <em>digits from</em> <code>num</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> num = "1432219", k = 3
<strong>Output:</strong> "1219"
<strong>Explanation:</strong> Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> num = "10200", k = 1
<strong>Output:</strong> "200"
<strong>Explanation:</strong> Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> num = "10", k = 2
<strong>Output:</strong> "0"
<strong>Explanation:</strong> Remove all the digits from the number and it is left with nothing which is 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= num.length &lt;= 10<sup>5</sup></code></li>
	<li><code>num</code> consists of only digits.</li>
	<li><code>num</code> does not have any leading zeros except for the zero itself.</li>
</ul>
</div>
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        String[][] tests = {
            {"10","1"},
            {"12","1"},
            {"112","1"},
            {"10200","1"},
            {"1432219","3"},
            {"10","2"},
            {"100","1"},
        }; 

        for (String[] test : tests) {
            String num = test[0];
            int k = Integer.parseInt(test[1]);

            System.out.println(new RemoveKDigits_Solution().removeKdigits(num, k));
        }
    }
}

// Time Limit Exceeded
class RemoveKDigits_Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {return "0";}

        StringBuffer numAns = new StringBuffer(num);

        int loop = 0;
        while (loop < k) {
            int start = 0;
            int len = numAns.length();
            for (int i = 0; i < len; i++) {
                if (numAns.charAt(start) - numAns.charAt(i) > 0) {
                    numAns.deleteCharAt(start);
                    break;
                } else {
                    start = i;
                }

                if (i == len - 2) {
                    if (numAns.charAt(i) - numAns.charAt(i+1) > 0) {
                        numAns.deleteCharAt(i);
                    } else {
                        numAns.deleteCharAt(i+1);
                    }
                    break;                
                }
            }

            loop++;
        }

        while (numAns.length() > 1) {
            if (numAns.charAt(0) == '0') {numAns.deleteCharAt(0);}
            else {break;}
        }

        return numAns.toString();
    }
}

// 23 ms 45.9 MB
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk=new Stack<>();
        int n=num.length();
        if(k>=n){ return "0";}

        for(int i=0;i<n;i++){
            while(!stk.isEmpty()&&stk.peek()>num.charAt(i) && k!=0){
                stk.pop();
                k--;
            }
            
            if(!stk.isEmpty() || num.charAt(i)!='0'){ stk.push(num.charAt(i)); }
        }

        StringBuffer str=new StringBuffer("");
        
        while(!stk.isEmpty() && k>0){
            stk.pop();
            k--;
        }
        
        if(stk.isEmpty()){return "0";}

        while(!stk.isEmpty()){
            str.append(stk.pop());
        }

        return str.reverse().toString();
    }
}
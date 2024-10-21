package BetterCodeAnswer.Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/reverse-bits/">190.Reverse Bits</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Reverse bits of a given 32 bits unsigned integer.</p>

<p><strong>Note:</strong></p>

<ul>
	<li>Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.</li>
	<li>In Java, the compiler represents the signed integers using <a href="https://en.wikipedia.org/wiki/Two%27s_complement" target="_blank">2's complement notation</a>. Therefore, in <strong class="example">Example 2</strong> above, the input represents the signed integer <code>-3</code> and the output represents the signed integer <code>-1073741825</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 00000010100101000001111010011100
<strong>Output:</strong>    964176192 (00111001011110000010100101000000)
<strong>Explanation: </strong>The input binary string <strong>00000010100101000001111010011100</strong> represents the unsigned integer 43261596, so return 964176192 which its binary representation is <strong>00111001011110000010100101000000</strong>.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 11111111111111111111111111111101
<strong>Output:</strong>   3221225471 (10111111111111111111111111111111)
<strong>Explanation: </strong>The input binary string <strong>11111111111111111111111111111101</strong> represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is <strong>10111111111111111111111111111111</strong>.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The input must be a <strong>binary string</strong> of length <code>32</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> If this function is called many times, how would you optimize it?</p>
</div>
 */
public class ReverseBits {
    public static void main(String[] args) {
        String[] tests = {
            "00000010100101000001111010011100",
            "11111111111111111111111111111101"
        };

        for (String string : tests) {
            int n = Integer.parseUnsignedInt(string,2);

            System.out.println(new ReverseBits_Solution().reverseBits(n));
        }
    }
}

// 0 ms 42 MB
/**
 * In this implementation we have followed "Divide and Conquer" strategy where Original problem is divided into sub problems
 * 
 * <p>Let's understand in terms of decimal number to understand how the code is implemented<br>
Suppose we have a number <code>12345678</code> and we have to reverse it to get <code>87654321</code> as desired output<br>
The process will be as follows:<br>
<code>12345678</code> --&gt; original number</p>

<ol>
<li><code>56781234</code></li>
<li><code>78563412</code></li>
<li><code>87654321</code> --&gt; desired number(reversed number)</li>
</ol>

<p>Explanation of above process is as follows:</p>
<ul>
<li>
<p>Divide original number<code>(12345678)</code> into 2 parts(<strong>4 - 4 each</strong>)<br>
<code>1234|5678</code> and swap with each other i.e.<br>
|_____|</p>
<p><code>5678|1234</code>(it can also be said that we are <strong>right shifting</strong> the 1st part<code>(1234)</code> <strong>to 4 places</strong> from its original position and <strong>left shifting</strong> the 2nd part<code>(5678)</code> <strong>to 4 places</strong> from its original position)</p>
</li>
<li>
<p>Divide this obtained number<code>(56781234)</code> into 4 parts(<strong>2 - 2 each</strong>)<br>
<code>56|78|12|34</code> and swap with each other i.e.<br>
|__|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|__|</p>
<p><code>78|56|34|12</code>(it can also be said that we are <strong>right shifting</strong> the 1st part<code>(56)</code> and 3rd part<code>(12)</code> <strong>to 2 places</strong> from their original positions and <strong>left shifting</strong> the 2nd part<code>(78)</code> and 4th part<code>(34)</code> <strong>to 2 places</strong> from their original positions)</p>
</li>
<li>
<p>Divide the obtained number<code>(78563412)</code> into 8 parts(<strong>1 - 1 each</strong>)<br>
<code>7|8|5|6|3|4|1|2</code> and swap with each other i.e.<br>
|_|&nbsp;&nbsp;&nbsp;&nbsp;|_|&nbsp;&nbsp;&nbsp;&nbsp;|_|&nbsp;&nbsp;&nbsp;&nbsp;|_|</p>
<p><code>8|7|6|5|4|3|2|1</code>(it can also be said that we are <strong>right shifting</strong> the 1st part<code>(7)</code>, 3rd part<code>(5)</code>, 5th part<code>(3)</code> and 7th part<code>(1)</code>  <strong>to 1 place</strong> from their original positions and <strong>left shifting</strong> the 2nd part<code>(8)</code>, 4th part<code>(6)</code>, 6th part<code>(4)</code> and 8th part<code>(2)</code>  <strong>to 1 place</strong> from their original positions)</p>
<p>We got the desired output as <code>87654321</code></p>
  <hr>
<p><strong>Time to play with bits!!!!!!</strong></p>
<p>To get better understanding of how the 32 bits are reversed in binary, we will take 8 bits instead of 32.<br>
<strong>If the number is of 8 bits</strong>, <strong>the bits will be reversed in 3 steps</strong> as we are using <strong>Divide and Conquer</strong> approach which is nothing <strong>dividing the original problem into sub problems</strong> i.e. log(O(Number_Of_Bits)) i.e. log(O(8)) --&gt; 3 and the same Idea applies <strong>for 32 bits</strong> where <strong>the bits will be reversed in 5 steps</strong> as log(O(32)) --&gt; 5</p>
<p>First let's understand with 8 bits<br>
Suppose we have bits as 00010111 and we have to reverse it to get 11101000 as desired output<br>
The Process will be as follows:<br>
00010111(8 bits)  --&gt; Original Number</p>
</li>
</ul>
<ol>
<li>01110001</li>
<li>11010100</li>
<li>11101000  --&gt; Reversed Numer</li>
</ol>
<p>Explanation of above process is as follows:</p>
<ol>
<li>Divide original bits into 4 - 4 each (4 * 2 = 8 bits)<br>
<code>0001|0111</code> and swap with each other i.e.<br>
|_____|<br>
<code>0111|0001</code> (It can also be said that we are <strong>right shifting</strong> 1st part(first 4 bits) <strong>to 4 places</strong> from their original positions and <strong>left shifting</strong> the 2nd part(last 4 bits) <strong>to 4 places</strong> from their original positions)<br><br>
Following is the process of doing it:<br>
a) <strong>Preserve 1st part(first 4 bits)</strong> and we know the property of bitwise and(&amp;) opertor i.e. 0, 1 -&gt; 0 and 1, 1 -&gt; 1<br>
For this, we will take a mask in <strong>hexadecimal form</strong> and <strong>apply bitwise and(&amp;) to preserve the first 4 bits</strong><br>
<strong>mask = 0xf0</strong> (which is nothing but <code>1111 0000</code> i.e. <code>1111</code>(15 == f) and 0000(0))<br>
<code>0001 0111</code> --&gt; num<br>
&amp;&nbsp;<code>1111 0000</code> --&gt; 0xf0<br>
<code>0001 0000</code><br><br>
b) <strong>Right shift</strong> the obtained number from its original position <strong>by 4 places</strong> i.e. (num &amp; 0xf0) &gt;&gt;&gt; 4<br>
<code>00000001</code><br><br>
c) <strong>Preserve the 2nd part(last 4 bits)</strong><br>
For this, will take a mask in <strong>hexadecimal form</strong> and <strong>apply bitwise and(&amp;) to preserve the last 4 bits</strong><br>
<strong>mask = 0x0f</strong> (which is nothing but <code>0000 1111</code> i.e. <code>0000</code>(0) and <code>1111</code>(15 == f))<br>
<code>0001 0111</code> --&gt; num<br>
&amp;&nbsp;<code>0000 1111</code> --&gt; 0x0f<br>
<code>0000 0111</code><br><br>
d) <strong>Left shift</strong> the obtained number from its original position <strong>by 4 places</strong> i.e. (num &amp; 0x0f) &lt;&lt; 4<br>
<code>01110000</code><br><br>
e) <strong>Do the bitwise OR(|)</strong> operation on both shifted numbers to <strong>merge intermediate results</strong> into a single number which is used as an input for the next step.<br>
<code>0000 0001</code> --&gt; number obtained by right shift at step b)<br>
|&nbsp;&nbsp;<code>0111 0000</code> --&gt; number obtained by left shift at step d)<br>
<code>0111 0001</code><br><br>
f) <strong>Assign the result into num</strong> after apply bitwise or into num again to proceed furthur<br>
num = <code>01110001</code></li>
</ol>
<p><strong>Till here, 1 of 3 steps of process has been completed. 2 More remaining!!!</strong></p>
<ol start="2">
<li>Divide obtained bits(<code>01110001</code>) into 2 - 2 each (2 * 4 = 8 bits)<br>
<code>01|11|00|01</code> and swap with each other i.e.<br>
|__|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|__|<br>
<code>11|01|01|00</code> (It can also be said that we are <strong>right shifting</strong> 1st part(01) and 3rd part(00) <strong>to 2 places</strong> from their original positions and <strong>left shifting</strong> the 2nd part(11) and 4th part(01) <strong>to 2 places</strong> from their original positions)<br><br>
Following is the process of doing it:<br>
a) <strong>Preserve 1st part(01) and 3rd part(00)</strong> and we know the property of bitwise and(&amp;) opertor i.e. 0, 1 -&gt; 0 and 1, 1 -&gt; 1<br>
For this, we will take a mask in <strong>hexadecimal form</strong> and <strong>apply bitwise and(&amp;) to preserve 1st part(01) and 3rd part(00)</strong><br>
<strong>mask = 0xcc</strong> (which is nothing but 1100 1100 i.e. (12 == c) and (12 == c))<br>
<code>01 11 00 01</code> --&gt; num<br>
&amp;&nbsp;<code>11 00 11 00</code> --&gt; 0xcc<br>
<code>01 00 00 00</code><br><br>
b) <strong>Right shift</strong> the obtained number(<code>01 00 00 00</code>) from its original position <strong>by 2 places</strong> i.e. (num &amp; 0xcc) &gt;&gt;&gt; 2<br>
<code>00 01 00 00</code><br><br>
c) <strong>Preserve the 2nd part(11) and 4th part(01)</strong><br>
For this, we will take a mask in <strong>hexadecimal form</strong> and <strong>apply bitwise and(&amp;) to preserve 2nd part(11) and 4th part(01)</strong><br>
<strong>mask = 0x33</strong> (which is nothing but 0011 0011 i.e. 0011(3) and 0011(3))<br>
<code>01 11 00 01</code> --&gt; num<br>
&amp;&nbsp;<code>00 11 00 11</code> --&gt; 0x33<br>
<code>00 11 00 01</code><br><br>
d) <strong>Left shift</strong> the obtained number(00 11 00 01) from its original position <strong>by 2 places</strong> i.e. (num &amp; 0x33) &lt;&lt; 2<br>
<code>11 00 01 00</code><br><br>
e) <strong>Do the bitwise OR(|)</strong> operation on both shifted numbers to <strong>merge intermediate results</strong> into a single number which is used as an input for the next step.<br>
<code>00 01 00 00</code> --&gt; number obtained by right shift at step b)<br>
|&nbsp;&nbsp;<code>11 00 01 00</code> --&gt; number obtained by left shift at step d)<br>
<code>11 01 01 00</code><br><br>
f) <strong>Assign the result into num</strong> after apply bitwise or into num again to proceed furthur<br>
num = <code>11010100</code></li>
</ol>
<p><strong>Till here, 2 of 3 steps of process has been completed. Only 1 more to go!!!!!!!!!</strong></p>
<ol start="3">
<li>Divide obtained bits(<code>11010100</code>) into 1 - 1 each (1 * 8 = 8 bits)<br>
1|1|0|1|0|1|0|0 and swap with each other i.e.<br>
|_|&nbsp;&nbsp;|_|&nbsp;&nbsp;|_|&nbsp;&nbsp;|_|<br>
1|1|1|0|1|0|0|0 (It can also be said that we are <strong>right shifting</strong> 1st(1), 3rd(0), 5th(0) and 7th(0) parts <strong>to 1 place</strong> from their original positions and <strong>left shifting</strong> the 2nd(1), 4th(1), 6th(1) and 8th(0) parts <strong>to 1 place</strong> from their original positions)<br><br>
Following is the process of doing it<br>
a) <strong>Preserve 1st(1), 3rd(0), 5th(0) and 7th(0) parts</strong><br>
We know the property of bitwise and(&amp;) opertor i.e. 0, 1 -&gt; 0 and 1, 1 -&gt; 1<br>
For this, we will take a mask in <strong>hexadecimal form</strong> and <strong>apply bitwise and(&amp;) to preserve 1st(1), 3rd(0), 5th(0) and 7th(0) parts</strong><br>
<strong>mask = 0xaa</strong> (which is nothing but <code>1010 1010</code> i.e. (10 == a) and (10 == a))<br>
<code>1 1 0 1 0 1 0 0</code> --&gt; num<br>
&amp;&nbsp;<code>1 0 1 0 1 0 1 0</code> --&gt; 0xaa<br>
<code>1 0 0 0 0 0 0 0</code><br><br>
b) <strong>Right shift</strong> the obtained number(<code>1 0 0 0 0 0 0 0</code>) from its original position <strong>by 1 place</strong> i.e. (num &amp; 0xaa) &gt;&gt;&gt; 1<br>
<code>0 1 0 0 0 0 0 0</code><br><br>
c) <strong>Preserve the 2nd(1), 4th(1), 6th(1) and 8th(0) parts</strong><br>
For this, we will take a mask in <strong>hexadecimal form</strong> and <strong>apply bitwise and(&amp;) to preserve 2nd(1), 4th(1), 6th(1) and 8th(0) parts</strong><br>
<strong>mask = 0x55</strong> (which is nothing but 0101 0101 i.e. 0101(5) and 0101(5))<br>
<code>1 1 0 1 0 1 0 0</code> --&gt; num<br>
&amp;&nbsp;<code>0 1 0 1 0 1 0 1</code> --&gt; 0x55<br>
<code>0 1 0 1 0 1 0 0</code><br><br>
d) <strong>Left shift</strong> the obtained number(0 1 0 1 0 1 0 0) from its original position <strong>by 1 place</strong> i.e. (num &amp; 0x55) &lt;&lt; 1<br>
<code>1 0 1 0 1 0 0 0</code><br><br>
e) <strong>Do the bitwise OR(|)</strong> operation on both shifted numbers<br>
<code>0 1 0 0 0 0 0 0</code> --&gt; number obtained by right shift at step b)<br>
|&nbsp;&nbsp;<code>1 0 1 0 1 0 0 0</code> --&gt; number obtained by left shift at step d)<br>
<code>1 1 1 0 1 0 0 0</code><br><br>
f) <strong>Assign the result into num</strong> after apply bitwise or into num again<br>
num = <code>11101000</code></li>
</ol>
<p>Now, <strong>return the num</strong>.</p>
<p><strong>We have finally reversed the original number i.e. <code>00010111</code> -&gt; <code>11101000</code></strong><br>
<br><br>
Same idea goes for 32 bits<br>
eg:<br>
break the 32 bits into half(16 - 16 each) and right shift 1st half part to 16 positions and left shift the 2nd half to 16 positions<br>
break the 16 bits into half(8 - 8 each) and right shift to 8 positions and left shift to 8 positions<br>
break the 8 bits into half(4 - 4 each) and right shift to 4 positions and left shift to 4 positions<br>
break the 4 bits into half(2 - 2 each) and right shift to 2 positions and left shift to 2 positions<br>
break the 2 bits into half(1 - 1 each) and right shift to 1 positions and left shift to 1 positions</p>
 */
class ReverseBits_Solution {
    
    public int reverseBits(int num) {
        
        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
        
        return num;
        
    }
}

// 0 ms 41.5 MB
/**
 * <p>We start with an answer variable set to 0. Write a for loop that will run 32 times (once for each bit). In the loop we will:</p>
 * <ul>
<li>Move the answer's bits to the left.<br>
<code>ans &lt;&lt;= 1;</code></li>
<li>Check if the current bit is 1 and add it to the answer if it is.<br>
<code>ans |= (n &amp; 1);</code></li>
<li>Move to the next bit in the given number.<br>
<code>n &gt;&gt;= 1;</code></li>
</ul>
<p>After this process, the answer will have the reversed bits.</p>
 */
class ReverseBits_Solution2 {
    public int reverseBits(int num) {
       int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (num & 1); 
            result = (result << 1) | bit; 
            num = num >> 1;
        }

        return result;
    }
}

// 2 ms 41.9 MB
class ReverseBits_Solution3 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String s  = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(s).reverse();
        while(sb.length() < 32) {
            sb.append("0"); // Padding with zeros to ensure 32 bits
        }
        return Integer.parseUnsignedInt(sb.toString(), 2);
        
    }
}
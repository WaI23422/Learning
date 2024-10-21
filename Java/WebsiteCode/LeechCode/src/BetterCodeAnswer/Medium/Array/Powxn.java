package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/powx-n/">50. Pow(x, n)</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Implement <a href="http://www.cplusplus.com/reference/valarray/pow/" target="_blank">pow(x, n)</a>, which calculates <code>x</code> raised to the power <code>n</code> (i.e., <code>x<sup>n</sup></code>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> x = 2.00000, n = 10
<strong>Output:</strong> 1024.00000
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> x = 2.10000, n = 3
<strong>Output:</strong> 9.26100
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> x = 2.00000, n = -2
<strong>Output:</strong> 0.25000
<strong>Explanation:</strong> 2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-100.0 &lt; x &lt; 100.0</code></li>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup>-1</code></li>
	<li><code>n</code> is an integer.</li>
	<li>Either <code>x</code> is not zero or <code>n &gt; 0</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= x<sup>n</sup> &lt;= 10<sup>4</sup></code></li>
</ul>
</div>
 */
public class Powxn {
    public static void main(String[] args) {
        double[][] tests = {
            {2,-2147483648},
            {2,10},
            {2.1,3},
            {2,-2},
        };

        for (double[] test : tests) {
            double x = test[0];
            int n = (int) test[1];

            System.out.println(new Powxn_Solution().myPow(x, n));
        }
    }
}

// 0 ms 42.8 mm
/**
 * <div class="FN9Jv WRmCx"><ul>
<li>
<p><strong>FIRST APPROACH</strong></p>
<p>We can solve this problem by multiplying x by n times<br>
eg:<br>
<code>x = 7 and n = 11</code><br>
<strong>7 * 7 * 7 * 7 * 7 * 7 * 7 * 7 * 7 * 7 * 7 = 1977326743</strong><br>
Here we have <strong>multiplied 7 for 11 times</strong>, which will result in <strong>O(n)</strong><br>
But, Suppose <code>x = 1 and n = 2147483647</code><br>
If we follow this approach then, <strong>1 will be multiplied 2147483647 times</strong> which is not efficient at all.</p>
</li>
<li>
<p><strong>COMPLEXITY</strong></p>
<ul>
<li><strong>Time: O(n)</strong>, where <code>n</code> is the given power</li>
<li><strong>Space: O(1)</strong>, in-place</li>
</ul>
</li>
</ul>
<hr>
<ul>
<li>
<p><strong>SECOND  APPROACH</strong></p>
<p>In order to improve efficiency we will opt for <strong>Binary Exponentiation using which we can calculate x<sup>n</sup> using O log<sub>2</sub>(N) multiplications.</strong></p>
<p><strong>Basic Idea is to divide the work using binary representation of exponents</strong><br>
i.e. is to keep multiplying pow with x, if the bit is odd, and multiplying x with itself until we get 0<br>
We will use very <strong>1st example of 1st Approach</strong> i.e.<br>
<code>x = 7, n = 11 and pow = 1</code><br>
Here, we have to calculate 7<sup>11</sup><br>
<strong>Binary of n i.e. (11)<sub>10</sub> is (1011)<sub>2</sub></strong><br>
<strong>1 &nbsp; 0 &nbsp; 1 &nbsp; 1</strong><br>
2<sup>3 &nbsp;</sup>2<sup>2</sup>&nbsp; 2<sup>1</sup> &nbsp;2<sup>0</sup>&nbsp;&nbsp;  &lt;-- Corresponding <strong>place values</strong> of each bit</p>
<p>OR we can also write this as<br>
<strong>1  0  1  1</strong><br>
8 4 2 1  &lt;-- Corresponding <strong>place values</strong> of each bit</p>
<p>Now, <strong>7<sup>8</sup> × 7<sup>2</sup> × 7<sup>1</sup></strong> == <strong>7<sup>11</sup></strong> as <strong>7<sup>(8 + 2 + 1)</sup></strong> == <strong>7<sup>11</sup></strong><br>
<strong>NOTE:</strong>  We have not considered <strong>7<sup>4</sup></strong> in this case as the <strong>4th place bit is OFF</strong></p>
<p>So, <strong>7<sup>8</sup> × 7<sup>2</sup> × 7<sup>1</sup></strong> == <strong>5764801 × 49 × 7</strong> == <strong>1977326743</strong> <strong>&lt;-- Desired Output</strong><br>
Now, applying logic keeping this concept in mind</p>
<div class="mb-6 rounded-lg px-3 py-2.5 font-menlo text-sm bg-fill-3 dark:bg-dark-fill-3"><div class="group relative" translate="no"><pre style="color: black; font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none; padding: 0px; margin: 0px; overflow: auto; background: transparent; overflow-wrap: normal;"><code class="language-cpp" style="text-shadow: none; white-space: pre;"><span><span class="token" style="color: rgb(0, 119, 170);">double</span><span> pow </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">=</span><span> </span><span class="token" style="color: rgb(153, 0, 85);">1</span><span class="token" style="color: rgb(153, 153, 153);">;</span><span>
</span></span><span><span></span><span class="token" style="color: rgb(0, 119, 170);">while</span><span class="token" style="color: rgb(153, 153, 153);">(</span><span>n </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">!=</span><span> </span><span class="token" style="color: rgb(153, 0, 85);">0</span><span class="token" style="color: rgb(153, 153, 153);">)</span><span class="token" style="color: rgb(153, 153, 153);">{</span><span>
</span></span><span><span>	</span><span class="token" style="color: rgb(0, 119, 170);">if</span><span class="token" style="color: rgb(153, 153, 153);">(</span><span class="token" style="color: rgb(153, 153, 153);">(</span><span>n </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">&amp;</span><span> </span><span class="token" style="color: rgb(153, 0, 85);">1</span><span class="token" style="color: rgb(153, 153, 153);">)</span><span> </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">!=</span><span> </span><span class="token" style="color: rgb(153, 0, 85);">0</span><span class="token" style="color: rgb(153, 153, 153);">)</span><span> </span><span class="token" style="color: slategray;">// equivalent to if((n % 2) != 0) i.e. multiply only when the number is odd  </span><span>
</span></span><span><span>	pow </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">*=</span><span> x</span><span class="token" style="color: rgb(153, 153, 153);">;</span><span>
</span></span><span>
</span><span><span>	x </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">*=</span><span> x</span><span class="token" style="color: rgb(153, 153, 153);">;</span><span>
</span></span><span><span>	n </span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">&gt;&gt;</span><span class="token" style="color: rgb(154, 110, 58); background: rgba(255, 255, 255, 0.5);">&gt;=</span><span> </span><span class="token" style="color: rgb(153, 0, 85);">1</span><span class="token" style="color: rgb(153, 153, 153);">;</span><span> </span><span class="token" style="color: slategray;">// equivalent to n = n / 2; i.e. keep dividing the number by 2</span><span>
</span></span><span>
</span><span><span></span><span class="token" style="color: rgb(153, 153, 153);">}</span></span></code></pre><div class="absolute -right-1.5 -top-0.5 flex gap-2"><div class="z-base-1 hidden rounded border group-hover:block border-border-quaternary dark:border-border-quaternary bg-layer-02 dark:bg-layer-02"><div class="relative cursor-pointer flex h-[22px] w-[22px] items-center justify-center bg-layer-02 dark:bg-layer-02 hover:bg-fill-tertiary dark:hover:bg-fill-tertiary rounded-[4px]" data-state="closed"><div><div data-state="closed"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3 h-3.5 w-3.5 text-text-primary dark:text-text-primary"><svg aria-hidden="true" focusable="false" data-prefix="far" data-icon="clone" class="svg-inline--fa fa-clone absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M64 464H288c8.8 0 16-7.2 16-16V384h48v64c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V224c0-35.3 28.7-64 64-64h64v48H64c-8.8 0-16 7.2-16 16V448c0 8.8 7.2 16 16 16zM224 304H448c8.8 0 16-7.2 16-16V64c0-8.8-7.2-16-16-16H224c-8.8 0-16 7.2-16 16V288c0 8.8 7.2 16 16 16zm-64-16V64c0-35.3 28.7-64 64-64H448c35.3 0 64 28.7 64 64V288c0 35.3-28.7 64-64 64H224c-35.3 0-64-28.7-64-64z"></path></svg></div></div></div></div></div></div></div></div>
</li>
<li>
<p><strong>PROCESS</strong></p>
<ul>
<li>
<p><strong>Iteration 1</strong><br>
pow = 1 × 7 = 7<br>
x = 7 × 7 = 49<br>
n = 11 &gt;&gt;&gt; 1 = 5</p>
</li>
<li>
<p><strong>Iteration 2</strong><br>
pow = 7 × 49 = 343<br>
x = 49 × 49 = 2401<br>
n = 5 &gt;&gt;&gt; 1 = 2</p>
</li>
<li>
<p><strong>Iteration 3</strong><br>
x = 2401 × 2401 = 5764801<br>
n = 2 &gt;&gt;&gt; 1 = 1</p>
</li>
<li>
<p><strong>Iteration 4</strong><br>
pow = 343 × 5764801 = 1977326743<br>
x = 5764801 × 5764801 = 3.323293057 × 10¹³<br>
n = 1 &gt;&gt;&gt; 1 = 0</p>
</li>
</ul>
</li>
</ul>
<p>We exit the loop as the number has become 0 and we got pow as <strong>1977326743 which is the desired output</strong><br>
In this binary exponentiation approach, the loop iterated for only 4 times which is nothing but (O log<sub>2</sub>(N) + 1) ~ <strong>(O log<sub>2</sub>(N))</strong></p>
<p>And for <strong>2nd example of 1st Approach</strong> where<br>
<code>x = 1 and n = 2147483647</code><br>
This loop executed for only 31 times <strong>(O log<sub>2</sub>(N))</strong> which is far far less than 2147483647 times(in case of O(N) approach)<br></p>
<ul>
<li>
<p><strong>JAVA / C++ CODE</strong></p>
  <iframe src="https://leetcode.com/playground/hRAZkbLc/shared" width="100%" height="400" allowfullscreen="" translate="no"></iframe>
</li>
<li>
<p><strong>COMPLEXITY</strong></p>
<ul>
<li><strong>Time: O(log<sub>2</sub>(n))</strong>, where <code>n</code> is the given power</li>
<li><strong>Space: O(1),</strong> in-place</li>
</ul>
</li>
</ul>
<img src="https://assets.leetcode.com/users/images/6f980162-6f32-4bfc-88e2-212a3d2d83cd_1645193689.9401023.jpeg" alt="" width="100%">
<br><br><br>
<img src="https://assets.leetcode.com/users/images/5e27a0db-88da-4bfa-830b-a9e18b37cc30_1645193695.887591.jpeg" alt="" width="100%">
<br><br>
<p><strong>Refer to the following github repsitory for more leetcode solutions</strong><br>
<a href="https://github.com/Akshaya-Amar/LeetCodeSolutions" target="_blank">https://github.com/Akshaya-Amar/LeetCodeSolutions</a></p>
<h1 id="please-upvote-if-you-find-this-post-helpful-"><strong>Please UPVOTE if you find this post helpful :)</strong></h1></div>
 */
class Powxn_Solution {
    public double myPow(double x, int n) {
        
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        
        double pow = 1;
        
        while(n != 0){
            if((n & 1) != 0){
                pow *= x;
            } 
                
            x *= x;
            n >>>= 1;
            
        }
        
        return pow;
    }
}
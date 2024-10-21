package BetterCodeAnswer.Medium.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sum-of-square-numbers/">633. Sum of Square Numbers</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a non-negative integer <code>c</code>, decide whether there're two integers <code>a</code> and <code>b</code> such that <code>a<sup>2</sup> + b<sup>2</sup> = c</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> c = 5
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> 1 * 1 + 2 * 2 = 5
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> c = 3
 * <strong>Output:</strong> false
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= c &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * </div>
 */
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        int[] tests = {
            5,
            3,
            2147483647
        };

        for (int num : tests) {
            System.out.println(new SumOfSquareNumbers_Solution().judgeSquareSum(num));
        }
    }
}

// 103 ms 40 MB
class SumOfSquareNumbers_Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;
    }
    public boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }
}

// 0 ms 40.2 MB
/**
 * <h3 id="approach-5-fermat-theorem" level="3" class="group/heading relative"><a href="#approach-5-fermat-theorem" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach 5: Fermat Theorem</h3>
 * 
 * <p><strong>Algorithm</strong></p>
 * <p>This approach is based on the following statement, which is based on Fermat's Theorem:</p>
 * <blockquote>
 * <p>Any positive number <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span> is expressible as a sum of two squares if and only if the prime factorization of <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span>, every prime of the form <span class="math math-inline"><span class="katex"><span class="katex-mathml">(4k+3)(4k+3)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord">4</span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord">3</span><span class="mclose">)</span></span></span></span></span> occurs an even number of times.</p>
 * </blockquote>
 * <p>By making use of the above theorem, we can directly find out if the given number <span class="math math-inline"><span class="katex"><span class="katex-mathml">cc</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">c</span></span></span></span></span> can be expressed as a sum of two squares.</p>
 * <p>To do so we simply find all the prime factors of the given number <span class="math math-inline"><span class="katex"><span class="katex-mathml">cc</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">c</span></span></span></span></span>, which could range from <span class="math math-inline"><span class="katex"><span class="katex-mathml">[2,c][2,\sqrt{c}]</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.0503em; vertical-align: -0.25em;"></span><span class="mopen">[</span><span class="mord">2</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord sqrt"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.8003em;"><span class="svg-align" style="top: -3em;"><span class="pstrut" style="height: 3em;"></span><span class="mord" style="padding-left: 0.833em;"><span class="mord mathnormal">c</span></span></span><span style="top: -2.7603em;"><span class="pstrut" style="height: 3em;"></span><span class="hide-tail" style="min-width: 0.853em; height: 1.08em;"><svg width="400em" height="1.08em" viewBox="0 0 400000 1080" preserveAspectRatio="xMinYMin slice"><path d="M95,702
 * c-2.7,0,-7.17,-2.7,-13.5,-8c-5.8,-5.3,-9.5,-10,-9.5,-14
 * c0,-2,0.3,-3.3,1,-4c1.3,-2.7,23.83,-20.7,67.5,-54
 * c44.2,-33.3,65.8,-50.3,66.5,-51c1.3,-1.3,3,-2,5,-2c4.7,0,8.7,3.3,12,10
 * s173,378,173,378c0.7,0,35.3,-71,104,-213c68.7,-142,137.5,-285,206.5,-429
 * c69,-144,104.5,-217.7,106.5,-221
 * l0 -0
 * c5.3,-9.3,12,-14,20,-14
 * H400000v40H845.2724
 * s-225.272,467,-225.272,467s-235,486,-235,486c-2.7,4.7,-9,7,-19,7
 * c-6,0,-10,-1,-12,-3s-194,-422,-194,-422s-65,47,-65,47z
 * M834 80h400000v40h-400000z"></path></svg></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.2397em;"><span></span></span></span></span></span><span class="mclose">]</span></span></span></span></span> along with the count of those factors, by repeated division.<br>
 * If at any step, we find out that the number of occurrences of any prime factor of the form <span class="math math-inline"><span class="katex"><span class="katex-mathml">(4k+3)(4k+3)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord">4</span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord">3</span><span class="mclose">)</span></span></span></span></span> occurs an odd number of times, we can return a False value.</p>
 * <p>In case, <span class="math math-inline"><span class="katex"><span class="katex-mathml">cc</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">c</span></span></span></span></span> itself is a prime number, it won't be divisible by any of the primes in the <span class="math math-inline"><span class="katex"><span class="katex-mathml">[2,c][2,\sqrt{c}]</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.0503em; vertical-align: -0.25em;"></span><span class="mopen">[</span><span class="mord">2</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord sqrt"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.8003em;"><span class="svg-align" style="top: -3em;"><span class="pstrut" style="height: 3em;"></span><span class="mord" style="padding-left: 0.833em;"><span class="mord mathnormal">c</span></span></span><span style="top: -2.7603em;"><span class="pstrut" style="height: 3em;"></span><span class="hide-tail" style="min-width: 0.853em; height: 1.08em;"><svg width="400em" height="1.08em" viewBox="0 0 400000 1080" preserveAspectRatio="xMinYMin slice"><path d="M95,702
 * c-2.7,0,-7.17,-2.7,-13.5,-8c-5.8,-5.3,-9.5,-10,-9.5,-14
 * c0,-2,0.3,-3.3,1,-4c1.3,-2.7,23.83,-20.7,67.5,-54
 * c44.2,-33.3,65.8,-50.3,66.5,-51c1.3,-1.3,3,-2,5,-2c4.7,0,8.7,3.3,12,10
 * s173,378,173,378c0.7,0,35.3,-71,104,-213c68.7,-142,137.5,-285,206.5,-429
 * c69,-144,104.5,-217.7,106.5,-221
 * l0 -0
 * c5.3,-9.3,12,-14,20,-14
 * H400000v40H845.2724
 * s-225.272,467,-225.272,467s-235,486,-235,486c-2.7,4.7,-9,7,-19,7
 * c-6,0,-10,-1,-12,-3s-194,-422,-194,-422s-65,47,-65,47z
 * M834 80h400000v40h-400000z"></path></svg></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.2397em;"><span></span></span></span></span></span><span class="mclose">]</span></span></span></span></span>. Thus, we need to check if <span class="math math-inline"><span class="katex"><span class="katex-mathml">cc</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">c</span></span></span></span></span> can be expressed in the form of<br>
 * <span class="math math-inline"><span class="katex"><span class="katex-mathml">4k+34k+3</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.7778em; vertical-align: -0.0833em;"></span><span class="mord">4</span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">3</span></span></span></span></span>. If so, we need to return a False value, indicating that this prime occurs an odd number(1) of times.</p>
 * <p>Otherwise, we can return a True value.</p>
 * <p>The proof of this theorem includes the knowledge of advanced mathematics and is beyond the scope of this article. However, interested reader can refer to <a href="http://wstein.org/edu/124/lectures/lecture21/lecture21/node2.html" target="_blank">this</a> documentation.</p>
 */
class SumOfSquareNumbers_Solution2 {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}
package BetterCodeAnswer.Easy.List;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/destination-city/">1436.Destination City</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given the array <code>paths</code>, where <code>paths[i] = [cityA<sub>i</sub>, cityB<sub>i</sub>]</code> means there exists a direct path going from <code>cityA<sub>i</sub></code> to <code>cityB<sub>i</sub></code>. <em>Return the destination city, that is, the city without any path outgoing to another city.</em></p>

<p>It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
<strong>Output:</strong> "Sao Paulo" 
<strong>Explanation:</strong> Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -&gt; "New York" -&gt; "Lima" -&gt; "Sao Paulo".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> paths = [["B","C"],["D","B"],["C","A"]]
<strong>Output:</strong> "A"
<strong>Explanation:</strong> All possible trips are:&nbsp;
"D" -&gt; "B" -&gt; "C" -&gt; "A".&nbsp;
"B" -&gt; "C" -&gt; "A".&nbsp;
"C" -&gt; "A".&nbsp;
"A".&nbsp;
Clearly the destination city is "A".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> paths = [["A","Z"]]
<strong>Output:</strong> "Z"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= paths.length &lt;= 100</code></li>
	<li><code>paths[i].length == 2</code></li>
	<li><code>1 &lt;= cityA<sub>i</sub>.length, cityB<sub>i</sub>.length &lt;= 10</code></li>
	<li><code>cityA<sub>i</sub> != cityB<sub>i</sub></code></li>
	<li>All strings consist of lowercase and uppercase English letters and the space character.</li>
</ul>
</div></div>
 */
public class DestinationCity {
    public static void main(String[] args) {
        String[][][] tests = {
            {{"London","New York"},{"New York","Lima"},{"Lima","Sao Paulo"}},
            {{"B","C"},{"D","B"},{"C","A"}}
        };
        
        for (String[][] strings : tests) {
            List<List<String>> strListList = new ArrayList<>();
            
            for (String[] strings2 : strings) {
                List<String> strList = new ArrayList<>();

                for (String strings3 : strings2) {
                    strList.add(strings3);
                }

                strListList.add(strList);
            }

            System.out.println(new DestinationCity_Solution().destCity(strListList));
        }
    }
}

// 1 ms 43.4 MB
class DestinationCity_Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> startCities = new HashSet<>();

        // Store all starting cities in a set
        for (List<String> path : paths) {
            startCities.add(path.get(0));
        }

        // Find the destination city
        for (List<String> path : paths) {
            if (!startCities.contains(path.get(1))) {
                return path.get(1); // Return the destination city
            }
        }

        return ""; // If no destination city found (shouldn't reach here if every path is valid)
    }
}
package BetterCodeAnswer.Easy.Class;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/design-hashmap/">706.Design HashMap</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Design a HashMap without using any built-in hash table libraries.</p>

<p>Implement the <code>MyHashMap</code> class:</p>

<ul>
	<li><code>MyHashMap()</code> initializes the object with an empty map.</li>
	<li><code>void put(int key, int value)</code> inserts a <code>(key, value)</code> pair into the HashMap. If the <code>key</code> already exists in the map, update the corresponding <code>value</code>.</li>
	<li><code>int get(int key)</code> returns the <code>value</code> to which the specified <code>key</code> is mapped, or <code>-1</code> if this map contains no mapping for the <code>key</code>.</li>
	<li><code>void remove(key)</code> removes the <code>key</code> and its corresponding <code>value</code> if the map contains the mapping for the <code>key</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
<strong>Output</strong>
[null, null, null, 1, -1, null, 1, null, -1]

<strong>Explanation</strong>
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= key, value &lt;= 10<sup>6</sup></code></li>
	<li>At most <code>10<sup>4</sup></code> calls will be made to <code>put</code>, <code>get</code>, and <code>remove</code>.</li>
</ul>
</div></div>
 */
public class DesignHashMap {
    public static void main(String[] args) {
        String[]  action = {"get","put","put","put","put","put","put","get","remove","put","put","put","put","put","get","get","put","put","put","remove","put","put","put","get","put","remove","put","get","put","get","put","remove","put","put","put","remove","put","remove","put","put","put","put","put","put","put","put","put","put","put","remove","get","remove","put","remove","put","put","put","put","remove","put","put","remove","put","put","put","remove","put","put","put","put","get","put","put","put","put","get","put","put","put","put","put","put","get","put","put","put","get","put","remove","remove","remove","put","put","put","put","put","put","get","remove","put"};
        int[][] input = {{83},{87,12},{91,90},{12,1},{38,14},{60,53},{22,1},{38},{3},{21,67},{67,60},{64,31},{37,11},{8,30},{81},{87},{69,4},{18,82},{63,37},{97},{83,48},{54,1},{32,81},{18},{62,37},{21},{81,89},{8},{30,43},{69},{36,17},{75},{53,51},{61,97},{92,45},{39},{71,18},{57},{98,10},{56,32},{16,52},{7,35},{84,11},{12,41},{58,6},{62,41},{4,44},{91,3},{80,45},{36},{62},{3},{80,46},{18},{0,64},{44,29},{50,4},{42,7},{83},{27,16},{42,8},{72},{61,0},{90,85},{85,50},{88},{69,23},{67,92},{6,46},{37,38},{14},{95,6},{97,78},{77,39},{90,27},{4},{85,34},{58,70},{20,35},{10,5},{10,17},{56,59},{1},{21,7},{35,78},{28,53},{28},{56,93},{84},{44},{54},{1,61},{25,27},{56,76},{65,70},{14,80},{68,21},{46},{84},{9,38}};
        
        MyHashMap obj = new MyHashMap();
        
        for (int i = 0; i < action.length; i++) {
            switch (action[i]) {
                case "put":
                    obj.put(input[i][0], input[i][1]);
                    break;
                
                case "get":
                    obj.get(input[i][0]);
                    break;

                case "remove":
                    obj.remove(input[i][0]);
                    break;
            }
        }
    } 
}

class MyHashMap{
        // 13 ms
        // 46.7 MB
        final ListNode[] nodes = new ListNode[10_000];

        public void put(int key, int value){
            int i = idx(key);
            if(nodes[i] == null)
                nodes[i] = new ListNode(-1, -1);
            ListNode prev = find(nodes[i], key);
            if(prev.next == null)
                prev.next = new ListNode(key, value);
            else prev.next.val = value;
        }

        public int get(int key){
            int i = idx(key);
            if(nodes[i] == null)
                return -1;
            ListNode node = find(nodes[i], key);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int key){
            int i = idx(key);
            if(nodes[i] != null){
                ListNode prev = find(nodes[i], key);
                if(prev.next != null)
                    prev.next = prev.next.next;
            }
        }

        int idx(int key){return Integer.hashCode(key) % nodes.length;}

        ListNode find(ListNode bucket, int key){
            ListNode node = bucket, prev = null;
            for(; node != null && node.key != key; node = node.next)
                prev = node;
            return prev;
        }

        class ListNode{
            int key, val;
            ListNode next;

            ListNode(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
    }

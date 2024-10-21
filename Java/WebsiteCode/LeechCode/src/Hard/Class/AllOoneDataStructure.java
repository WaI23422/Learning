package Hard.Class;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/all-oone-data-structure/">432. All O`one Data Structure</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.</p>
 * 
 * <p>Implement the <code>AllOne</code> class:</p>
 * 
 * <ul>
 * 	<li><code>AllOne()</code> Initializes the object of the data structure.</li>
 * 	<li><code>inc(String key)</code> Increments the count of the string <code>key</code> by <code>1</code>. If <code>key</code> does not exist in the data structure, insert it with count <code>1</code>.</li>
 * 	<li><code>dec(String key)</code> Decrements the count of the string <code>key</code> by <code>1</code>. If the count of <code>key</code> is <code>0</code> after the decrement, remove it from the data structure. It is guaranteed that <code>key</code> exists in the data structure before the decrement.</li>
 * 	<li><code>getMaxKey()</code> Returns one of the keys with the maximal count. If no element exists, return an empty string <code>""</code>.</li>
 * 	<li><code>getMinKey()</code> Returns one of the keys with the minimum count. If no element exists, return an empty string <code>""</code>.</li>
 * </ul>
 * 
 * <p><strong>Note</strong> that each function must run in <code>O(1)</code> average time complexity.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input</strong>
 * ["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
 * [[], ["hello"], ["hello"], [], [], ["leet"], [], []]
 * <strong>Output</strong>
 * [null, null, null, "hello", "hello", null, "hello", "leet"]
 * 
 * <strong>Explanation</strong>
 * AllOne allOne = new AllOne();
 * allOne.inc("hello");
 * allOne.inc("hello");
 * allOne.getMaxKey(); // return "hello"
 * allOne.getMinKey(); // return "hello"
 * allOne.inc("leet");
 * allOne.getMaxKey(); // return "hello"
 * allOne.getMinKey(); // return "leet"
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= key.length &lt;= 10</code></li>
 * 	<li><code>key</code> consists of lowercase English letters.</li>
 * 	<li>It is guaranteed that for each call to <code>dec</code>, <code>key</code> is existing in the data structure.</li>
 * 	<li>At most <code>5 * 10<sup>4</sup></code>&nbsp;calls will be made to <code>inc</code>, <code>dec</code>, <code>getMaxKey</code>, and <code>getMinKey</code>.</li>
 * </ul>
 * </div>
 */
public class AllOoneDataStructure {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {"AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"},
                {}, {"hello"}, {"hello"}, {}, {}, {"leet"}, {}, {}
            },
        };

        for (Object[][] test : tests) {
            String[] actions = Arrays.copyOf(test[0], test[0].length, String[].class);
            AllOne store = new AllOne();
            Object[] res = new Object[test[0].length]; 

            for (int i = 0; i < test[0].length; i++) {
                switch (actions[i]) {
                    case "getMaxKey":
                        res[i] = store.getMaxKey();
                        break;
                    case "getMinKey":
                        res[i] = store.getMinKey();
                        break;
                    case "inc":
                        store.inc((String) test[i+1][0]);
                        res[i] = null;
                        break;
                    case "dec":
                        store.dec((String) test[i+1][0]);
                        res[i] = null;
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

class Node {

    int freq;
    Node prev;
    Node next;
    Set<String> keys = new HashSet<>();

    Node(int freq) {
        this.freq = freq;
    }
}

// 50ms 60.96MB
class AllOne {

    Node head;
    Node tail;
    Map<String, Node> map = new HashMap<>();

    AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int freq = node.freq;
            node.keys.remove(key);

            Node nextNode = node.next;
            if (nextNode == tail || nextNode.freq != freq + 1) {
                Node newNode = new Node(freq + 1);
                newNode.keys.add(key);
                newNode.prev = node;
                newNode.next = nextNode;
                node.next = newNode;
                nextNode.prev = newNode;
                map.put(key, newNode);
            } else {
                nextNode.keys.add(key);
                map.put(key, nextNode);
            }

            if (node.keys.isEmpty()) {
                removeNode(node);
            }
        } else {
            Node firstNode = head.next;
            if (firstNode == tail || firstNode.freq > 1) {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                newNode.prev = head;
                newNode.next = firstNode;
                head.next = newNode;
                firstNode.prev = newNode;
                map.put(key, newNode);
            } else {
                firstNode.keys.add(key);
                map.put(key, firstNode);
            }
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }

        Node node = map.get(key);
        node.keys.remove(key);
        int freq = node.freq;

        if (freq == 1) {
            map.remove(key);
        } else {
            Node prevNode = node.prev;
            if (prevNode == head || prevNode.freq != freq - 1) {
                Node newNode = new Node(freq - 1);
                newNode.keys.add(key);
                newNode.prev = prevNode;
                newNode.next = node;
                prevNode.next = newNode;
                node.prev = newNode;
                map.put(key, newNode);
            } else {
                prevNode.keys.add(key);
                map.put(key, prevNode);
            }
        }

        if (node.keys.isEmpty()) {
            removeNode(node);
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
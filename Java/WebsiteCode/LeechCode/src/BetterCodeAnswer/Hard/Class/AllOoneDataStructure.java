package BetterCodeAnswer.Hard.Class;

import java.util.Arrays;
import java.util.HashMap;

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
    public String val;
    public Node next;
    public Node prev;
    public int freq;

    public Node(String val) {
        this.val = val;
        this.next = null;
        this.prev = null;
        this.freq = 0;
    }
}

class DoublyLinkedList {
    public Node head;
    public Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void unlinkNode(Node current) {
        if (this.tail == current) {
            this.tail = current.prev;
        }
        if(this.head == current){
            this.head = current.next;
        }
        Node prev = current.prev;
        Node next = current.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        current.next = null;
        current.prev = null;
    }

    public void insertAtEnd(Node current) {
        this.tail.next = current;
        current.prev = this.tail;
        this.tail = current;
    }

    public void moveLeft(Node current) {
        Node prev = current.prev;
        if(prev == null || prev.freq>=current.freq)
            return;
        while (prev != null && prev.freq < current.freq) {
            prev = prev.prev;
        }
        this.unlinkNode(current);
        if (prev != null) {
            Node temp = prev.next;
            prev.next = current;
            current.prev = prev;
            current.next = temp;
            temp.prev = current;
        } else {
            current.next = this.head;
            this.head.prev = current;
            this.head = current;
        }
    }

    public void moveRight(Node current){
        Node next = current.next;
        if(next == null || next.freq<=current.freq){
            return;
        }
        while(next!= null && next.freq > current.freq){
            next = next.next;
        }
        this.unlinkNode(current);
        if(next != null){
            Node temp = next.prev;
            next.prev = current;
            current.next = next;
            current.prev = temp;
            temp.next = current;
        }else{
            current.prev = this.tail;
            this.tail.next = current;
            this.tail = current;
        }
    }

}

// 44ms 59.8MB
class AllOne {
    private DoublyLinkedList list;
    private HashMap<String, Node> map;

    public AllOne() {
        this.list = new DoublyLinkedList();
        this.map = new HashMap<>();
    }

    public void inc(String key) {
        if (!this.map.containsKey(key)) {
            Node current = new Node(key);
            current.freq++;
            this.map.put(key, current);
            if (this.map.size() == 1) {
                this.list.head = current;
                this.list.tail = current;
            }else{
                this.list.insertAtEnd(current);
            }
        } else {
            Node current = this.map.get(key);
            current.freq++;
            this.list.moveLeft(current);
        }
    }

    public void dec(String key) {
        Node current = this.map.get(key);
        current.freq--;
        if(current.freq == 0){
            this.map.remove(key);
            this.list.unlinkNode(current);
            return;
        }
        this.list.moveRight(current);
    }

    public String getMaxKey() {
        return this.list.head == null ? "": this.list.head.val;
    }

    public String getMinKey() {
        return this.list.tail == null ? "": this.list.tail.val;
    }
}
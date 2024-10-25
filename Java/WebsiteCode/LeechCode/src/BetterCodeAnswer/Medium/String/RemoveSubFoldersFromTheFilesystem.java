package BetterCodeAnswer.Medium.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/remove-sub-folders-from-the-filesystem/">1233. Remove Sub-Folders from the Filesystem</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given a list of folders <code>folder</code>, return <em>the folders after removing all <strong>sub-folders</strong> in those folders</em>. You may return the answer in <strong>any order</strong>.</p>
 * 
 * <p>If a <code>folder[i]</code> is located within another <code>folder[j]</code>, it is called a <strong>sub-folder</strong> of it. A sub-folder of <code>folder[j]</code> must start with <code>folder[j]</code>, followed by a <code>"/"</code>. For example, <code>"/a/b"</code> is a sub-folder of <code>"/a"</code>, but <code>"/b"</code> is not a sub-folder of <code>"/a/b/c"</code>.</p>
 * 
 * <p>The format of a path is one or more concatenated strings of the form: <code>'/'</code> followed by one or more lowercase English letters.</p>
 * 
 * <ul>
 * 	<li>For example, <code>"/leetcode"</code> and <code>"/leetcode/problems"</code> are valid paths while an empty string and <code>"/"</code> are not.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * <strong>Output:</strong> ["/a","/c/d","/c/f"]
 * <strong>Explanation:</strong> Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> folder = ["/a","/a/b/c","/a/b/d"]
 * <strong>Output:</strong> ["/a"]
 * <strong>Explanation:</strong> Folders "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * <strong>Output:</strong> ["/a/b/c","/a/b/ca","/a/b/d"]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= folder.length &lt;= 4 * 10<sup>4</sup></code></li>
 * 	<li><code>2 &lt;= folder[i].length &lt;= 100</code></li>
 * 	<li><code>folder[i]</code> contains only lowercase letters and <code>'/'</code>.</li>
 * 	<li><code>folder[i]</code> always starts with the character <code>'/'</code>.</li>
 * 	<li>Each folder name is <strong>unique</strong>.</li>
 * </ul>
 * </div></div>
 */
public class RemoveSubFoldersFromTheFilesystem {
    public static void main(String[] args) {
        String[][] tests = {
            {
                "/a","/a/b","/c/d","/c/d/e","/c/f"
            }
        };

        for (String[] folder : tests) {
            System.out.println(new RemoveSubFoldersFromTheFilesystem_Solution().removeSubfolders(folder));
        }
    }
}

class Trie{
    class Node{
        boolean eow;
        Node[]children;
        Node(){
            children=new Node[27];
        }
    }
    Node root;
    Trie(){
        root=new Node();
    }
    public void insert(String s){
        Node curr=root;
        for(char ch:s.toCharArray()){
            int idx=ch-'a';
            if(ch=='/')idx=26;
            if(curr.children[idx]==null)curr.children[idx]=new Node();
            curr=curr.children[idx];
        }
        curr=curr.children[26]=new Node();
        curr.eow=true;
    }
    public boolean search(String s){
        Node curr=root;
        for(char ch:s.toCharArray()){
            int idx=ch-'a';
            if(ch=='/')idx=26;
            if(curr.children[idx]==null)return false;
            curr=curr.children[idx];
            if(curr.eow==true)return true;
        }
        return false;
    }
}

// 27 ms 55.78 MB
class RemoveSubFoldersFromTheFilesystem_Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie trie=new Trie();
        Arrays.sort(folder,(a,b)->a.length()-b.length());
        List<String>ans=new ArrayList<>();
        for(String s:folder){
            if(!trie.search(s)){
                ans.add(s);
                trie.insert(s);
            }
        }
        return ans;
    }
}

// 28ms 53.69MB
class RemoveSubFoldersFromTheFilesystem_Solution2 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparing(s -> s.length()));
        Set<String> seen = new HashSet<>();
        outer:
        for (String f : folder) {
            for (int i = 2; i < f.length(); ++i)
                if (f.charAt(i) == '/' && seen.contains(f.substring(0, i))) 
                    continue outer;
            seen.add(f);
        }
        return new ArrayList<>(seen);
    }
}
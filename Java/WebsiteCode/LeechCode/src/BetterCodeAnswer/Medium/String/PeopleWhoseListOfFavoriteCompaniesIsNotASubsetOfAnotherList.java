package BetterCodeAnswer.Medium.String;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {
    public static void main(String[] args) {
        String[][][] tests = {
            {
                {"arrtztkotazhufrsfczr","knzgidixqgtnahamebxf","zibvccaoayyihidztflj"},
                {"cffiqfviuwjowkppdajm","owqvnrhuzwqohquamvsz"},
                {"knzgidixqgtnahamebxf","owqvnrhuzwqohquamvsz","qzeqyrgnbplsrgqnplnl"},
                {"arrtztkotazhufrsfczr","cffiqfviuwjowkppdajm"},
                {"arrtztkotazhufrsfczr","knzgidixqgtnahamebxf","owqvnrhuzwqohquamvsz","qzeqyrgnbplsrgqnplnl","zibvccaoayyihidztflj"}
            },
            {
                {"leetcode","google","facebook"},
                {"google","microsoft"},
                {"google","facebook"},
                {"google"},
                {"amazon"}
            }
        };

        for (String[][] test : tests) {
            List<List<String>> favoriteCompanies = new ArrayList<>();

            for (String[] companies_Array : test) {
                List<String> companies_List = new ArrayList<>(List.of(companies_Array));
                
                favoriteCompanies.add(companies_List);
            }

            System.out.println(new PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList_Solution().peopleIndexes(favoriteCompanies).toString());
        }
    }
}

// 37ms 56.93MB
class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList_Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int companyCount = 0;
        Map<String, Integer> companyMap = new HashMap<>();
        for (var list : favoriteCompanies) {
            for (String c : list) {
                if (!companyMap.containsKey(c)) {
                    companyMap.put(c, companyCount);
                    companyCount++;
                }
            }
        }
  
        List<BitSet> bitsets = new ArrayList<>();
        for (var list : favoriteCompanies) {
            BitSet b = new BitSet(companyCount);
            for (String c : list) {
                b.set(companyMap.get(c));
            }
            bitsets.add(b);
        }
  
        List<Integer> res = new ArrayList<>();
        outer: 
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            BitSet cur = bitsets.get(i);
            // check if cur is subset of any others
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i != j) {
                    BitSet other = bitsets.get(j);
                    BitSet tmp = new BitSet(companyCount);
                    tmp.or(cur);
                    tmp.andNot(other);
                    if (tmp.isEmpty()) {
                        continue outer;
                    }
                }
            }
            res.add(i);
        } 
  
        return res;
    }
}

// 111ms 58.07MB
/**
 * <h4 id="idea">idea</h4>
 * <p>Typical union-find<br>
 * For example:<br>
 * favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]</p>
 * <p>it is actually a graph:</p>
 * <div class="mb-6 rounded-lg px-3 py-2.5 font-menlo text-sm bg-fill-3 dark:bg-dark-fill-3"><div class="group relative" translate="no"><pre style="color: rgb(212, 212, 212); font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas; direction: ltr; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none; padding: 0px; margin: 0px; overflow: auto; background: transparent;"><code style="color: rgb(212, 212, 212); font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas, &quot;Andale Mono&quot;, &quot;Ubuntu Mono&quot;, &quot;Courier New&quot;, monospace; direction: ltr; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none;"><span><span>	{lgf}     {gm}    {a}
 * </span></span><span>      |  
 * </span><span>    {gf}
 * </span><span>	  |
 * </span><span>	 {g}</span></code></pre><div class="absolute -right-1.5 -top-0.5 flex gap-2"><div class="z-base-1 hidden rounded border group-hover:block border-border-quaternary dark:border-border-quaternary bg-layer-02 dark:bg-layer-02"><div class="relative cursor-pointer flex h-[22px] w-[22px] items-center justify-center bg-layer-02 dark:bg-layer-02 hover:bg-fill-tertiary dark:hover:bg-fill-tertiary rounded-[4px]" data-state="closed"><div><div data-state="closed"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3 h-3.5 w-3.5 text-text-primary dark:text-text-primary"><svg aria-hidden="true" focusable="false" data-prefix="far" data-icon="clone" class="svg-inline--fa fa-clone absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M64 464H288c8.8 0 16-7.2 16-16V384h48v64c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V224c0-35.3 28.7-64 64-64h64v48H64c-8.8 0-16 7.2-16 16V448c0 8.8 7.2 16 16 16zM224 304H448c8.8 0 16-7.2 16-16V64c0-8.8-7.2-16-16-16H224c-8.8 0-16 7.2-16 16V288c0 8.8 7.2 16 16 16zm-64-16V64c0-35.3 28.7-64 64-64H448c35.3 0 64 28.7 64 64V288c0 35.3-28.7 64-64 64H224c-35.3 0-64-28.7-64-64z"></path></svg></div></div></div></div></div></div></div></div>
 * <p>with path compression, the root of each node can be found faster:</p>
 * <div class="mb-6 rounded-lg px-3 py-2.5 font-menlo text-sm bg-fill-3 dark:bg-dark-fill-3"><div class="group relative" translate="no"><pre style="color: rgb(212, 212, 212); font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas; direction: ltr; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none; padding: 0px; margin: 0px; overflow: auto; background: transparent;"><code style="color: rgb(212, 212, 212); font-size: 13px; text-shadow: none; font-family: Menlo, Monaco, Consolas, &quot;Andale Mono&quot;, &quot;Ubuntu Mono&quot;, &quot;Courier New&quot;, monospace; direction: ltr; text-align: left; white-space: pre; word-spacing: normal; word-break: normal; line-height: 1.5; tab-size: 4; hyphens: none;"><span><span>	{lgf}     {gm}    {a}
 * </span></span><span>	/   \
 * </span><span> {gf}   {g}</span></code></pre><div class="absolute -right-1.5 -top-0.5 flex gap-2"><div class="z-base-1 hidden rounded border group-hover:block border-border-quaternary dark:border-border-quaternary bg-layer-02 dark:bg-layer-02"><div class="relative cursor-pointer flex h-[22px] w-[22px] items-center justify-center bg-layer-02 dark:bg-layer-02 hover:bg-fill-tertiary dark:hover:bg-fill-tertiary rounded-[4px]" data-state="closed"><div><div data-state="closed"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3 h-3.5 w-3.5 text-text-primary dark:text-text-primary"><svg aria-hidden="true" focusable="false" data-prefix="far" data-icon="clone" class="svg-inline--fa fa-clone absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M64 464H288c8.8 0 16-7.2 16-16V384h48v64c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V224c0-35.3 28.7-64 64-64h64v48H64c-8.8 0-16 7.2-16 16V448c0 8.8 7.2 16 16 16zM224 304H448c8.8 0 16-7.2 16-16V64c0-8.8-7.2-16-16-16H224c-8.8 0-16 7.2-16 16V288c0 8.8 7.2 16 16 16zm-64-16V64c0-35.3 28.7-64 64-64H448c35.3 0 64 28.7 64 64V288c0 35.3-28.7 64-64 64H224c-35.3 0-64-28.7-64-64z"></path></svg></div></div></div></div></div></div></div></div>
 * <p>In the end, we just need to return the index of the three roots of the graph.</p>
 * <h4 id="code">code</h4>
 * <ol>
 * <li>preprocess input, turn them into List&lt;Set&gt;, please refer to the update below</li>
 * <li>initialize father of each list as itself</li>
 * <li>for i from 0 to length
 * <ol>
 * <li>for j from i+1 to length
 * <ol>
 * <li>let a = root of list i, let b = root of list j</li>
 * <li>if a==b, it means list i and j have the same root, they are already in the same tree, do nothing</li>
 * <li>else if a contains b, let a becomes b's root</li>
 * <li>else if b contains a, let b becomes a's root</li>
 * </ol>
 * </li>
 * </ol>
 * </li>
 * <li>in the end, add all unique roots into a set, and return it in res</li>
 * </ol>
 */
class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList_Solution1 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res= new LinkedList<>();
        List<Set<String>> fcs = new LinkedList<>();
        for (List<String> fc: favoriteCompanies) fcs.add(new HashSet<>(fc));
        int l = fcs.size();
        int[] f = new int[l];
        for (int i=0; i<l; i++) f[i]=i;
        for (int i=0; i<l; i++)
            for (int j=i+1; j<l; j++){
                int a = find(f, i), b = find(f, j);
                if (a==b) continue;
                else if (contains(fcs.get(a), fcs.get(b))) f[b]=a;
                else if (contains(fcs.get(b), fcs.get(a))) f[a]=b;
            }
        Set<Integer> set= new HashSet<>();
        for (int i: f) set.add(find(f, i));
        res.addAll(set);
        Collections.sort(res);
        return res;
    }
    public boolean contains(Set<String> a, Set<String> b){
        if (a.size()<=b.size()) return false;
        return a.containsAll(b);
    }
    public int find(int[] f, int i){
        while (f[i]!=i){
            f[i]=f[f[i]];
            i=f[i];
        }
        return i;
    }
}
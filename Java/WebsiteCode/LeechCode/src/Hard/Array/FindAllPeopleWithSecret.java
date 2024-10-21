package Hard.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllPeopleWithSecret {
    public static void main(String[] args) {
        int[][][][] tests = {
            // {{{6,1}},{{2,3,8},{1,2,5},{1,5,10}}},
            {{{4,3}},{{3,1,3},{1,2,2},{0,3,3}}},
            // {{{5,1}},{{3,4,2},{1,2,1},{2,3,1},{1,3,1}}},
        };

        for (int[][][] test : tests) {
            int n = test[0][0][0], firstPerson = test[0][0][1];
            int[][] meetings = test[1];

            System.out.println(new FindAllPeopleWithSecret_Solution().findAllPeople(n, meetings, firstPerson));
        }
    }
}

// 41 ms 98.8 MB
class FindAllPeopleWithSecret_Solution2 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int[] groups = new int[100000];
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < n; ++i) groups[i] = i;
        groups[firstPerson] = 0;

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        int i = 0;
        while (i < meetings.length) {
            int currentTime = meetings[i][2];
            temp.clear();
            while (i < meetings.length && meetings[i][2] == currentTime) {
                int g1 = find(groups, meetings[i][0]);
                int g2 = find(groups, meetings[i][1]);
                groups[Math.max(g1, g2)] = Math.min(g1, g2);
                temp.add(meetings[i][0]);
                temp.add(meetings[i][1]);
                ++i;
            }
            for (int j = 0; j < temp.size(); ++j) {
                if (find(groups, temp.get(j)) != 0) {
                    groups[temp.get(j)] = temp.get(j);
                }
            }
        }

        for (int j = 0; j < n; ++j) {
            if (find(groups, j) == 0) result.add(j);
        }

        return result;
    }

    private int find(int[] groups, int index) {
        while (index != groups[index]) index = groups[index];
        return index;
    }
}

// Wrong: Because x_i -> y_i and reverse (This it just x_i -> y_i)
class FindAllPeopleWithSecret_Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        if (n == 2) {return Arrays.asList(new Integer[]{0,firstPerson});} // Special-case.

        Set<Integer> peopleWithSecret = new HashSet<>(List.of(new Integer[]{0,firstPerson}));
        HashMap<Integer,HashMap<Integer,List<Integer>>> container = new HashMap<>();  

        addElement(container, meetings);

        for (Integer key : container.keySet()) {
            Set<Integer> keySet = container.get(key).keySet();
            Integer keyInKeySet = keyContain(peopleWithSecret, keySet);
            while(keyInKeySet >= 0){
                peopleWithSecret.addAll(container.get(key).get(keyInKeySet));
                keySet.remove(keyInKeySet);
                keyInKeySet = keyContain(peopleWithSecret, keySet);
            }
        }

        return new ArrayList<>(peopleWithSecret);  
    }

    private static Integer keyContain(Set<Integer> set, Set<Integer> keySet) {
        for (Integer key : keySet) {
            if (set.contains(key)) {return key;}
        }

        return -1;
    }

    private static void addElement(HashMap<Integer,HashMap<Integer,List<Integer>>> hashMap, int[][] elements) {
        Arrays.sort(elements,(a,b) -> a[2] - b[2]);

        for (int[] element : elements) {
            Integer key1 = element[2], key2 = element[0];
            if (!hashMap.containsKey(key1)) {
                List<Integer> subList = new ArrayList<>(); 
                subList.add(element[1]);
                
                HashMap<Integer,List<Integer>> subHashMap = new HashMap<>(); 
                subHashMap.put(key2, subList);

                hashMap.put(key1, subHashMap);
            } else {
                if (!hashMap.get(key1).containsKey(key2)) {
                    List<Integer> subList = new ArrayList<>(); 
                    subList.add(element[1]);

                    hashMap.get(key1).put(key2, subList);
                } else {
                    hashMap.get(key1).get(key2).add(element[1]);
                }
            }
        }
    }
}
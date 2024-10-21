package Medium.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

// Brute-Froce: Time Limit Exceeded
class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList_Solution1 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int len = favoriteCompanies.size();
        HashMap<List<String>,Integer> favoriteCompaniesMap = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            favoriteCompaniesMap.put(favoriteCompanies.get(i), i);
        }
        
        List<Integer> people_idxs = new ArrayList<>(){{add(0);}};

        for (int i = 1; i < len; i++) {
            List<String> people_CompaniesList = favoriteCompanies.get(i);
            if (isNotSubset(people_idxs,favoriteCompanies,people_CompaniesList)) {
                people_idxs.add(i);
            };
        }

        return people_idxs;
    }

    private boolean isNotSubset(
            List<Integer> people_idxs, 
            List<List<String>> favoriteCompanies, 
            List<String> people_CompaniesList
        ){
        int len = people_idxs.size();
        boolean[] removed = new boolean[len];
        for (int i = 0; i < len; i++) {
            List<String> temp = favoriteCompanies.get(people_idxs.get(i));
            OUT:
            if (temp.size() > people_CompaniesList.size()) {
                for (String company : people_CompaniesList) {
                    if (!temp.contains(company)) {
                        break OUT;
                    }
                }
                return false;
            } else if (temp.size() < people_CompaniesList.size()) {
                for (String company : temp) {
                    if (!people_CompaniesList.contains(company)) {
                        break OUT;
                    }
                }
                removed[i] = true;
            }
        }
        
        int idx = 0;
        for (int i = 0; i < removed.length; i++) {
            if (removed[i]) {
                people_idxs.remove(i-idx++);
            }
        }
        
        return true;
    }
}

// 80ms 60.56MB
class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList_Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int count=0;
        HashMap<String,Integer> map=new HashMap<>();
        List<Set<Integer>> ppl=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        int n=favoriteCompanies.size();
        for(List<String> s:favoriteCompanies){
            HashSet<Integer> set=new HashSet<>();
            for(String str:s){
                if(!map.containsKey(str)) map.put(str,count++);
                set.add(map.get(str));
            }
            ppl.add(set);
        }
        for(int i=0;i<n;i++){
            boolean valid=true;
            for(int j=0;j<n && valid;j++){
                if(ppl.get(j).size()<=ppl.get(i).size()) continue;
                if(ppl.get(j).containsAll(ppl.get(i))) valid=false;
            }
            if(valid) res.add(i);
        }

        return res;
        
    }
}
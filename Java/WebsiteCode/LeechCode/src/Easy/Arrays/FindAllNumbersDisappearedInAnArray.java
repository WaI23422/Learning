package Easy.Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[][] tests = {
            {4,3,2,7,8,2,3,1},
            {1,1},
        };

        for (int[] nums : tests) {
            System.out.println(new FindAllNumbersDisappearedInAnArray_Solution().findDisappearedNumbers(nums));
        }
    }
}

// 3 ms 55.2 MB
class FindAllNumbersDisappearedInAnArray_Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> numberDis = new ArrayList<>();

        // 3 ms 55.2 MB
        int len = nums.length+1,
            numsNeed[] = new int[len];
        
        for (int num : nums) {
            numsNeed[num]++;
        }

        // for (int i = 1; i < len; i++) {
        //     if (numsNeed[i] == 0) {numberDis.add(i);}
        // }

        //// Time Limit Exceeded
        // List<Integer> numsList = Arrays.stream(nums)
        //                                .boxed()
        //                                .collect(Collectors.toList());
        
        // int len = nums.length+1;
        // for (int i = 1; i < len; i++) {
        //     if (!numsList.contains(i)) {
        //         numberDis.add(i);
        //     }
        // }

        return numberDis;
    }
}
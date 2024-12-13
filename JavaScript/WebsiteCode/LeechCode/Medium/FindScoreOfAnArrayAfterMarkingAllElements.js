// 10ms 60.32MB
/**
 * @param {number[]} nums
 * @return {number}
 */
var findScore = function (nums) {
    res = 0;
    for (let i = 0; i < nums.length; i += 2) {
        let start = i;
        while (i + 1 < nums.length && nums[i + 1] < nums[i]) {
            i++;
        }
        for (let j = i; j >= start; j -= 2) {
            res += nums[j];
        }
    }
    return res;
};
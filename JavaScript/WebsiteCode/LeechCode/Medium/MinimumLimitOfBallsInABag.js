// 27ms 60.51MB
/**
 * @param {number[]} nums
 * @param {number} maxOperations
 * @return {number}
 */
var minimumSize = function(nums, maxOperations) {
    let low = 1;
    let high = Math.max(...nums);
    while (low < high) {
        const mid = (low + high) >> 1;
        let cnt = 0;
        for (const x of nums) {
            cnt += ~~((x - 1) / mid);
        }
        if (cnt <= maxOperations) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }
    return low;
};
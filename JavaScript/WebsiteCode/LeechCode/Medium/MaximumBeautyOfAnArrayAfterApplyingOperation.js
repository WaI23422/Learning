//  16ms 63.39MB
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximumBeauty = function(nums, k) {
    const n = nums.length;
    let maxValue = 0;

    // Step 1: Find the maximum value in the array
    for (let i = 0; i < n; i++) {
        if (nums[i] > maxValue) {
            maxValue = nums[i];
        }
    }

    // Step 2: Create an array to track ranges
    const range = new Array(maxValue + 10).fill(0);

    // Step 3: Mark ranges for each number in the array
    for (let i = 0; i < n; i++) {
        const left = Math.max(0, nums[i] - k);
        const right = Math.min(maxValue, nums[i] + k) + 1;
        range[left]++;
        if (right < range.length) {
            range[right]--;
        }
    }

    // Step 4: Calculate prefix sums and find the maximum value
    let result = range[0];
    for (let i = 1; i < range.length; i++) {
        range[i] += range[i - 1];
        if (range[i] > result) {
            result = range[i];
        }
    }

    // Step 5: Return the result
    return result;
};
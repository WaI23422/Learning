
// 112ms 64.51MB
/**
 * @param {number[]} nums
 * @return {number}
 */
var continuousSubarrays = function(nums) {
    let n = nums.length;
    let totalCount = 0;
    
    // Two pointers to keep track of the current subarray
    let left = 0;
    let minDeque = []; // Monotonic deque for minimums
    let maxDeque = []; // Monotonic deque for maximums
    
    // Iterate over each right endpoint of the subarray
    for (let right = 0; right < n; right++) {
        // Maintain minDeque to store potential minimums for the current window
        while (minDeque.length && nums[minDeque[minDeque.length - 1]] >= nums[right]) {
            minDeque.pop();
        }
        minDeque.push(right);
        
        // Maintain maxDeque to store potential maximums for the current window
        while (maxDeque.length && nums[maxDeque[maxDeque.length - 1]] <= nums[right]) {
            maxDeque.pop();
        }
        maxDeque.push(right);
        
        // Shrink the window if the condition is violated
        while (nums[maxDeque[0]] - nums[minDeque[0]] > 2) {
            if (minDeque[0] === left) minDeque.shift();
            if (maxDeque[0] === left) maxDeque.shift();
            left++;
        }
        
        // Number of continuous subarrays ending at 'right'
        totalCount += right - left + 1;
    }
    
    return totalCount;
};
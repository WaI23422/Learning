// 35ms 69.69MB
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var shortestSubarray = function(nums, k) {
    let length = nums.length + 1;
    let deque = [];
    let frontIdx = 0;
    for(let i = 0; i < nums.length; i++) {
        if(i > 0) {
            nums[i] += nums[i-1];
        }
        if(nums[i] >= k) {
            length = Math.min(length, i + 1);
        }
        while(deque.length - frontIdx > 0 
        && nums[i] - nums[deque[frontIdx]] >= k) {
            length = Math.min(length, i - deque[frontIdx]);
            frontIdx++;
        }
        while(deque.length - frontIdx > 0 && nums[i] <= nums[deque.at(-1)]
        ) {
            deque.pop();
        }
        deque.push(i);
    }
    return length <= nums.length ? length : -1;
};


// 164ms 68.80MB
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var shortestSubarray = function(nums, k) {
    const n = nums.length;
    const prefix = new Array(n + 1).fill(0);

    // Step 1: Compute prefix sums
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }

    const deque = [];
    let minLength = Infinity;

    // Step 2: Process prefix sums
    for (let i = 0; i <= n; i++) {
        while (deque.length > 0 && prefix[i] - prefix[deque[0]] >= k) {
            minLength = Math.min(minLength, i - deque.shift());
        }

        while (deque.length > 0 && prefix[i] <= prefix[deque[deque.length - 1]]) {
            deque.pop();
        }

        deque.push(i);
    }

    return minLength === Infinity ? -1 : minLength;
};
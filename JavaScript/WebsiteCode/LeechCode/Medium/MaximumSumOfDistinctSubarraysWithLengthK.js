
// 51ms 63.29MB
var maximumSubarraySum = function(nums, k) {
    let distArr = Array(100001).fill(0)
    let i = 0
    let sum = 0
    let maxSum = 0
    let numNotDistinct = 0
    // check the first window
    for (i = 0; i < k; i++) {
        distArr[nums[i]]++
        if (distArr[nums[i]] > 1) {
            numNotDistinct++
        }
        sum += nums[i]
    }
    if (numNotDistinct == 0) {
        maxSum = sum
    }
    // now slide the window to the end of the array
    for (i = k; i < nums.length; i++) {
        // first check outgoing.
        if (distArr[nums[i-k]] > 1) {
            numNotDistinct--
        }
        distArr[nums[i-k]]--
        sum -= nums[i-k]

        //now check incoming
        distArr[nums[i]]++
        if (distArr[nums[i]] > 1) {
            numNotDistinct++
        }
        sum += nums[i]
        if (numNotDistinct == 0 && sum > maxSum) {
            maxSum = sum
        }
    }
    return maxSum
};

// 48ms 73.70MB
var maximumSubarraySum = function(nums, k) {
    const n = nums.length;
    const elements = new Set();
    let currentSum = 0;
    let maxSum = 0;
    let begin = 0;

    for (let end = 0; end < n; end++) {
        if (!elements.has(nums[end])) {
            currentSum += nums[end];
            elements.add(nums[end]);

            if (end - begin + 1 === k) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[begin];
                elements.delete(nums[begin]);
                begin++;
            }
        } else {
            while (nums[begin] !== nums[end]) {
                currentSum -= nums[begin];
                elements.delete(nums[begin]);
                begin++;
            }
            begin++;
        }
    }
    
    return maxSum;
};
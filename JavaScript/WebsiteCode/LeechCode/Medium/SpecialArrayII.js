// 11ms 85.06MB
/**
 * @param {number[]} nums
 * @param {number[][]} queries
 * @return {boolean[]}
 */
var isArraySpecial = function (nums, queries) {
    const lengthNums = nums.length;
    let rs = []; // arr to save result
    let arrCheck = []; // arr to save index of pair not ok
    let wrongId = -1;
    for (let i = 0; i < lengthNums - 1; i++) {
        if (nums[i] % 2 === nums[i + 1] % 2) {
            wrongId = i;
        }
        arrCheck[i] = wrongId;
    }
    arrCheck[lengthNums - 1] = arrCheck[lengthNums - 2]; // 2 item should be same value

    for (let i = 0; i < queries.length; i++) {
        if (
            queries[i][0] === queries[i][1] ||
            arrCheck[queries[i][0]] === arrCheck[queries[i][1]-1] &&
            arrCheck[queries[i][0]] !== queries[i][0]
        ) {
            rs.push(true);
        } else {
            rs.push(false);
        }
    }
    return rs;
};

// 24ms 85.89MB
/**
 * @param {number[]} nums
 * @param {number[][]} queries
 * @return {boolean[]}
 */
var isArraySpecial = function(nums, queries) {
    let n = nums.length;
        let pref = new Array(n).fill(1);
        for (let i = 1; i < n; i++) {
            if ((nums[i] & 1) !== (nums[i - 1] & 1)) {
                pref[i] = pref[i - 1] + 1;
            } else {
                pref[i] = 1;
            }
        }
        let ans = [];
        for (let [s, e] of queries) {
            let len = e - s + 1;
            if (pref[e] < len) {
                ans.push(false);
            } else {
                ans.push(true);
            }
        }
        return ans;
};
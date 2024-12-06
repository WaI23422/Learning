
// 26ms 62.36MB
/**
 * @param {number[]} banned
 * @param {number} n
 * @param {number} maxSum
 * @return {number}
 */
var maxCount = function (banned, n, maxSum) {
    const set = new Set()

    for (const item of banned) {
        if (item <= n) {
            set.add(item)
        }
    }
    let ret = 0;
    let sum = 0;

    for (let i = 1; i <= n; i++) {
        if (set.has(i) === false) {
            sum += i

            if (sum > maxSum)
                break;

            ret++

        }
    }

    return ret
};

// 44ms 65.04MB
/**
 * @param {number[]} banned
 * @param {number} n
 * @param {number} maxSum
 * @return {number}
 */
var maxCount = function(banned, n, maxSum) {
    const bannedSet = new Set(banned); // Use a set for faster lookups
        let sum = 0, count = 0;

        for (let i = 1; i <= n; i++) {
            if (!bannedSet.has(i) && sum + i <= maxSum) { // Skip banned numbers
                sum += i;
                count++;
            }
        }

        return count;
};
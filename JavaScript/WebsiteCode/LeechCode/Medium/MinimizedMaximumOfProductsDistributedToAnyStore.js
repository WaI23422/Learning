/**
 * @param {number} n
 * @param {number[]} quantities
 * @return {number}
 */
// 38ms 62.87MB
var minimizedMaximum = function(n, quantities) {
    let low = 1, high = Math.max(...quantities);
    let result = high;
    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        let total = 0;

        // Calculate the total hours it would take to eat at speed 'mid'
        for (let pile of quantities) {
            total += Math.ceil(pile / mid);
        }

        // If the total hours is less than or equal to H, we reduce the speed
        if (total <= n) {
            result = mid
            high = mid - 1;
        } else {
            low = mid + 1
        }
    }

    return result;
};
// 2ms 50.24MB
/**
 * @param {number[]} gifts
 * @param {number} k
 * @return {number}
 */
var pickGifts = function(gifts, k) {
    // use heap should be O(logn)
    const numbers = gifts;
    const sink = (i, n) => {
        while (i * 2 <= n) {
            let j = 2 * i;
            if (j < n && numbers[j - 1] < numbers[j]) {
                j++; // choose bigger child
            }
            if (numbers[i - 1] >= numbers[j- 1]) {
                break;
            }
            const temp = numbers[i - 1];
            numbers[i - 1] = numbers[j - 1];
            numbers[j - 1] = temp;
            i = j;
        }
    }
    const n = numbers.length;
    // build heap
    for (let i = Math.floor(n / 2); i >= 1; i--) {
        sink(i, n);
    }

    // use heap
    while (k--) {
        numbers[0] = Math.floor(Math.sqrt(numbers[0]));
        sink(1, n)
    }
    return numbers.reduce((sum, n) => sum + n, 0);;
};
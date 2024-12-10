
// 7ms 53.38MB
/**
 * @param {string} s
 * @return {number}
 */
var maximumLength = function(s) {
    let n = s.length;
    let l = 1, r = n;

    if (!helper(s, n, l)) return -1;

    while (l + 1 < r) {
        let mid = Math.floor((l + r) / 2);
        if (helper(s, n, mid)) l = mid;
        else r = mid;
    }

    return l;
};

/**
 * @param {string} s
 * @param {number} n
 * @param {number} x
 * @return {boolean}
 */
function helper(s, n, x) {
    let cnt = new Array(26).fill(0);
    let p = 0;

    for (let i = 0; i < n; i++) {
        while (s[p] !== s[i]) p++;
        if (i - p + 1 >= x) cnt[s[i].charCodeAt(0) - 'a'.charCodeAt(0)]++;
        if (cnt[s[i].charCodeAt(0) - 'a'.charCodeAt(0)] > 2) return true;
    }

    return false;
}
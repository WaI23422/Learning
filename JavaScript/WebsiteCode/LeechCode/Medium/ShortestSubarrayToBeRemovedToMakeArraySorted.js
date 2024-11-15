// 6ms
var findLengthOfShortestSubarray = function (arr) {
    let size = arr.length, r = size - 1;
    while (r > 0 && arr[r - 1] <= arr[r]) r -= 1;
    if (r === 0) return 0;
    let res = r;
    for (let i = 0; i < size; i++) {
        if (arr[i - 1] > arr[i]) break;
        while (arr[i] > arr[r]) r += 1;
        res = Math.min(res, r - i - 1);
    }
    return res;
};
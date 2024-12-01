// 0ms 49.27MB
/**
 * @param {number[]} arr
 * @return {boolean}
 */
var checkIfExist = function (arr) {
    for (let i = 0; i < arr.length - 1; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[i] == arr[j] * 2 || arr[j] == arr[i] * 2) {
                return true
            }
        }
    }
    return false
};

// 5ms 52.41MB
/**
 * @param {number[]} arr
 * @return {boolean}
 */
var checkIfExist = function(arr) {
    let exists_arr = [];
    
    for (let i = 0; i < arr.length; i++) {
        let num = arr[i];
        if (
            exists_arr[num*2] ||
            (num%2==0 && exists_arr[num/2])
        ) {return true;}
        exists_arr[num] = true;
    }

    return false;
};

// Test:
arr = [-2,0,10,-19,4,6,-8];
console.log(checkIfExist(arr));

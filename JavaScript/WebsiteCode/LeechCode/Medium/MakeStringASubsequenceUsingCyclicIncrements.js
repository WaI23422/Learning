// JavaScript

/**
 * @param {string} str1
 * @param {string} str2
 * @return {boolean}
 */
// 8ms 55.62MB
var canMakeSubsequence = function(str1, str2) {
    let p1 = 0;
    let p2 = 0;

    while (p1 !== str1.length && p2 !== str2.length) {
        if (str1[p1] === str2[p2] || str1[p1] === Rotate(str2[p2])) {
            p1++;
            p2++;
        } else {
            p1++;
        }
    }

    return p2 === str2.length;
};

var Rotate = function(c) {
    if (c === 'a') {
        return 'z';
    }

    return String.fromCharCode(c.charCodeAt(0) - 1);
}

// 17ms 56.11MB
var canMakeSubsequence = function(source, target) {
    let targetIdx = 0;
    const targetLen = target.length;
    
    for (let currChar of source) {
        if (targetIdx < targetLen && 
            ((target.charCodeAt(targetIdx) - currChar.charCodeAt(0) + 26) % 26 <= 1)) {
            targetIdx++;
        }
    }
    
    return targetIdx === targetLen;
};
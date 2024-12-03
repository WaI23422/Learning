
/**
 * @param {string} s
 * @param {number[]} spaces
 * @return {string}
 */
// 61ms 82.81MB
var addSpaces = function (s, spaces) {
    const result = []
    for (let i = 0; i < spaces.length; i++) {
        if (i === 0) {
            if (spaces === 0) {
                result.push("")
            }
            else {
                result.push(s.substring(0, spaces[i]))
            }
        }
        else {
            result.push(s.substring(spaces[i - 1], spaces[i]))
        }
    }
    result.push(s.substring(spaces.at(-1), s.length))
    return result.join(" ")
};

/**
 * @param {string} s
 * @param {number[]} spaces
 * @return {string}
 */
// JavaScript
// 73ms 89.54MB
var addSpaces = function(s, spaces) {
    const result = new Array(s.length + spaces.length);
    let writePos = 0;
    let readPos = 0;
    
    for (const spacePos of spaces) {
        while (readPos < spacePos) {
            result[writePos++] = s[readPos++];
        }
        result[writePos++] = ' ';
    }
    
    while (readPos < s.length) {
        result[writePos++] = s[readPos++];
    }
    
    return result.join('');
};
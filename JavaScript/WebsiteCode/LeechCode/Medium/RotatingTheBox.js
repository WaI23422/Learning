// JavaScript

// 265ms 78.27MB
function rotateTheBox(box) {
    const ROWS = box.length;
    const COLS = box[0].length;
    
    const res = Array(COLS).fill(0)
                           .map(() => Array(ROWS).fill('.'));
    
    for (let r = 0; r < ROWS; r++) {
        let i = COLS - 1;
        for (let c = COLS - 1; c >= 0; c--) {
            if (box[r][c] === '#') {
                res[i][ROWS - r - 1] = '#';
                i--;
            } else if (box[r][c] === '*') {
                res[c][ROWS - r - 1] = '*';
                i = c - 1;
            }
        }
    }
    return res;
}

// 238ms 78.08MB
var rotateTheBox = function (box) {
    let m = box.length
    let n = box[0].length
    let rotatedBox = Array.from( {length : n}, (()=>Array(m).fill('.')))

    for (let i = 0; i < m; i++){
        let currentIndex = n - 1;

        for (let j = n - 1; j >= 0; j--){
            let val = box[i][j]

            if (val === '.') continue;
            if (val === '*') currentIndex = j;

            rotatedBox[currentIndex][m-1-i] = val;
            currentIndex--;
        }
    }

    return rotatedBox;
};
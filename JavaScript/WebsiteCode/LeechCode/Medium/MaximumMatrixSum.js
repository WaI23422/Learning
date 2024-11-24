// 10ms 59.49MB
var maxMatrixSum = function (matrix) {
    let sum = 0;
    let negSign = 0;
    let minNegSign = Infinity;
    for (let row = 0; row < matrix.length; row++) {
        for (let column = 0; column < matrix[row].length; column++) {
            if (matrix[row][column] <= 0) {
                negSign++;
            }
            minNegSign = Math.min(minNegSign, Math.abs(matrix[row][column]));
            sum += Math.abs(matrix[row][column]);
        }
    }
    if (negSign % 2 !== 0) {
        return sum - minNegSign * 2;
    }
    return sum;
};
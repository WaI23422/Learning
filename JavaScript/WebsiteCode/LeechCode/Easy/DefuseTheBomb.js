
// 0ms 50.39MB
var decrypt = function(code, k) {
    const n = code.length;
   const result = new Array(n).fill(0);

   if (k === 0) return result;

   let start, end, sum = 0;

   // Define start and end based on k
   if (k > 0) {
       start = 1;
       end = k;
   } else {
       start = n + k;
       end = n - 1;
   }

   // Initialize the sum for the first element
   for (let i = start; i <= end; i++) {
       sum += code[i % n];
   }

   // Apply sliding window to compute the sum for each position
   for (let i = 0; i < n; i++) {
       result[i] = sum;
       // Slide the window
       sum -= code[start % n];
       start++;
       end++;
       sum += code[end % n];
   }

   return result;
};

// 3ms 50.12MB
var decrypt = function(code, k) {
    const n = code.length;
    if (k === 0) return Array(n).fill(0);

    let isReversed = false;

    if (k < 0) {
        code.reverse();
        k = -k;
        isReversed = true;
    }

    const pre = new Array(n).fill(0);
    pre[0] = code[0];
    for (let i = 1; i < n; i++) {
        pre[i] = pre[i - 1] + code[i];
    }

    const res = new Array(n).fill(0);
    for (let i = 0; i < n; i++) {
        if (i + k < n) {
            res[i] = pre[i + k] - pre[i];
        } else {
            res[i] = (pre[n - 1] - pre[i]) + pre[(i + k) % n];
        }
    }

    if (isReversed) {
        res.reverse();
    }

    return res;
};
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

/**
 * @param {number} n
 * @param {number[]} quantities
 * @return {number}
 */

var tryMaximum = function(max, n, quantities) {
    for (let i=0; i<quantities.length; i++) {
       n=n-Math.ceil(quantities[i]/max);
    }
    return n;
}

// 15ms 60.2MB
var minimizedMaximum2 = function(n, quantities) {
    var max = Math.max(...quantities);
    var min = 1;
    var sol = Math.ceil((max + min)/2);
    var foundSolution = tryMaximum(sol, n,quantities);
    while(min<max && foundSolution!==0) {   
        if(foundSolution<0) {
            min=sol+1;
        } else if(foundSolution>0)  {
           max=sol-1;
        }
        sol = Math.ceil((max + min) /2);  
        foundSolution = tryMaximum(sol, n,quantities);
    }
 
    while(foundSolution==0) {
        sol--;
        foundSolution = tryMaximum(sol, n,quantities);
    }
    if (foundSolution<0) sol++;
    return sol;
};

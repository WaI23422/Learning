
// 1ms 52.74MB
/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} multiplier
 * @return {number[]}
 */
var getFinalState = function(nums, k, multiplier) {
    for (let i=1; i<=k; i++){
        m = Math.min(...nums)
        index = nums.indexOf(m)
        nums[index] = m * multiplier
    }
    return nums
};

// 16ms 58.23MB
/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} multiplier
 * @return {number[]}
 */
var getFinalState = function(nums, k, multiplier) {
    // Priority queue implementation using a Min-Heap
    const heap = [];
    
    // Helper functions for the heap
    const heapPush = (val, idx) => {
        heap.push({ val, idx });
        let currentIndex = heap.length - 1;
        while (currentIndex > 0) {
            let parentIndex = Math.floor((currentIndex - 1) / 2);
            if (heap[parentIndex].val > heap[currentIndex].val ||
                (heap[parentIndex].val === heap[currentIndex].val && heap[parentIndex].idx > heap[currentIndex].idx)) {
                [heap[parentIndex], heap[currentIndex]] = [heap[currentIndex], heap[parentIndex]];
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    };

    const heapPop = () => {
        const top = heap[0];
        const end = heap.pop();
        if (heap.length > 0) {
            heap[0] = end;
            let index = 0;
            while (true) {
                let left = 2 * index + 1;
                let right = 2 * index + 2;
                let smallest = index;

                if (left < heap.length && (heap[left].val < heap[smallest].val ||
                    (heap[left].val === heap[smallest].val && heap[left].idx < heap[smallest].idx))) {
                    smallest = left;
                }
                if (right < heap.length && (heap[right].val < heap[smallest].val ||
                    (heap[right].val === heap[smallest].val && heap[right].idx < heap[smallest].idx))) {
                    smallest = right;
                }
                if (smallest === index) break;
                [heap[index], heap[smallest]] = [heap[smallest], heap[index]];
                index = smallest;
            }
        }
        return top;
    };

    // Initialize the heap with the array values and indices
    nums.forEach((num, idx) => heapPush(num, idx));

    // Perform k operations
    while (k-- > 0) {
        let smallest = heapPop();
        heapPush(smallest.val * multiplier, smallest.idx);
    }

    // Update the original array based on the heap state
    while (heap.length > 0) {
        let { val, idx } = heapPop();
        nums[idx] = val;
    }

    return nums;
};
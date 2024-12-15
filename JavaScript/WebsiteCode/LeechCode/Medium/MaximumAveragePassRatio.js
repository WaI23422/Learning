
// 1032ms 92.02MB
/**

 * @param {number[][]} classes

 * @param {number} extraStudents

 * @return {number}

 */

const maxAverageRatio = (classes, extraStudents) => {

    const pq = new MinPriorityQueue({priority: ([avg, pass, total]) => {
        const new_avg = (pass + 1) / (total + 1);
        return avg - new_avg;
    }});
    
    let total_avg = 0;
    for(const [pass, total] of classes) {
        
        const avg = pass / total;
        pq.enqueue([avg, pass, total]);
        total_avg += avg;
        
    }

    while(extraStudents--) {
        let [min_avg, min_pass, min_total] = pq.dequeue().element;

        total_avg -= min_avg;
        ++min_pass;
        ++min_total;

        const avg = min_pass / min_total;
        pq.enqueue([avg, min_pass, min_total]);
        
        total_avg += avg;
    }

    return total_avg / classes.length;

};
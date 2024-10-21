package BetterCodeAnswer.Hard.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {3,1,10,10,1},
                {4,8,2,2,7},
                {3}
            },
            {
                {10,20,5},
                {70,50,30},
                {2}
            }
        };

        for (int[][] test : tests) {
            int quality[] = test[0],
                wage[] = test[1],
                k = test[2][0];
            
            System.out.println(new MinimumCostToHireKWorkers_Solution().mincostToHireWorkers(quality, wage, k));
        }
    }
}

// 36 ms 46.3 MB
class MinimumCostToHireKWorkers_Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Map.Entry<Double, Integer>> arr = new ArrayList<>();
        int n = quality.length;
        for (int i = 0; i < n; i++) {
            arr.add(Map.entry(((double) 1.0*wage[i]/quality[i]), quality[i]));
        }
        arr.sort((a, b) -> Double.compare(a.getKey(), b.getKey()));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int sum = 0;
        double res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += arr.get(i).getValue();
            pq.offer(arr.get(i).getValue());
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            if (i - k + 1 >= 0) {
                res = Math.min(res, sum * 1.0 * arr.get(i).getKey());
            }
        }
        return res;
    }
}

// 24 ms 45.9 MB
class Worker implements Comparable<Worker> {
    final int q, w;
    public Worker(int q, int w) {
        this.q = q;
        this.w = w;
    }
    @Override
    public int compareTo(Worker other) {
        return Integer.compare(w * other.q, q * other.w);
    }
}

class MinimumCostToHireKWorkers_Solution2 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] a = new Worker[n];
        for (int i = 0; i < n; ++i) {
            a[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(a);
        int s = 0;
        double res = 1e15;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (Worker worker: a) {
            q.add(-worker.q);
            s += worker.q;
            if (q.size() > k) s += q.poll();
            if (q.size() == k) res = Math.min(res, (double) s * worker.w / worker.q);
        }
        return res;
    }
}

// 26 ms 45.8 MB
class MinimumCostToHireKWorkers_Solution3 {
    class Worker {
        int quality;
        int wage;
        double ratio;
        Worker(int quality, int wage){
            this.quality = quality;
            this.wage = wage;
            this.ratio = this.wage*1.0/this.quality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Worker> workers = new ArrayList<>();
        for(int i=0; i < quality.length; i++){
            workers.add(new Worker(quality[i], wage[i]));
        }

        Collections.sort(workers, (a,b)->Double.compare(a.ratio,b.ratio));
        PriorityQueue<Worker> pq = new PriorityQueue<>((a,b)-> b.quality-a.quality);
        double totalQuality = 0, minCost = Double.MAX_VALUE;
        for(Worker worker : workers){
            pq.add(worker);
            totalQuality += worker.quality;
            if(pq.size() == k){
                minCost = Math.min(minCost, totalQuality*worker.ratio);
                totalQuality -= pq.remove().quality;       // Remove the worker with the highest quality
            }
        }
        
        return minCost;
    }
}
package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int[][][][] tests = {
            {{{4},{0},{3},{1}},{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}},
            {{{3},{0},{2},{1}},{{0,1,100},{1,2,100},{0,2,500}}},
            {{{3},{0},{2},{0}},{{0,1,100},{1,2,100},{0,2,500}}},
        };        
    
        for (int[][][] test : tests) {
            int[][] flights = test[1];
            int n = test[0][0][0], src = test[0][0][1], dst =test[0][0][2], k =test[0][0][3];

            System.out.println(new CheapestFlightsWithinKStops_Solution().findCheapestPrice(n, flights, src, dst, k));
        }
    }
}

// 3 ms 44 MB
class CheapestFlightsWithinKStops_Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        for (int i = 0; i <= k; i++) {
            if (isRoutePossible(distance, flights)) {
                break;
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
    private boolean isRoutePossible(int[] dist, int[][] flights) {
        int[] copy = Arrays.copyOf(dist, dist.length);
        boolean result = true;

        for (int[] flight : flights) {
            int src = flight[0];
            int dst = flight[1];
            int  cost =flight[2];

            if (copy[src] < Integer.MAX_VALUE && dist[dst] > dist[src] + cost) {
                dist[dst] = cost + copy[src];
                result = false;
            }
        }
        return result;
    }
}

// 1 ms 44.7 MB
class CheapestFlightsWithinKStops_Solution2 {
    class Stop{
        int city;
        int dist;
        Stop(int city, int dist){
            this.city = city;
            this.dist = dist;
        }
    }
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        int cheapest = Integer.MAX_VALUE;
        Queue<Stop> queue = new LinkedList<>();
        queue.add(new Stop(src, 0));
        int distance[] = new int[n];
        for(int i=0;i<n;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        Map<Integer, List<Stop>> map = new HashMap<>();
        for(int i=0;i<flights.length;i++){
            if(map.get(flights[i][0]) != null){
                map.get(flights[i][0]).add(new Stop(flights[i][1], flights[i][2]));
            }
            else{
                List<Stop> list = new ArrayList<>();
                list.add(new Stop(flights[i][1], flights[i][2]));
                map.put(flights[i][0], list);    
            }
        }
        while(!queue.isEmpty() && k-->=0){
            int size = queue.size();
            int count = 0;
            while(count++<size){
                Stop curr = queue.poll();
                List<Stop> list = map.get(curr.city);
                if(list == null){
                    continue;
                }
                for(Stop stop : list){
                    if(stop.city == dst){
                        cheapest = Math.min(cheapest, stop.dist+curr.dist);
                    }
                    if(distance[stop.city]>stop.dist+curr.dist){
                        distance[stop.city] = stop.dist+curr.dist;
                        queue.add(new Stop(stop.city, stop.dist+curr.dist));
                    }
                }
            }
        }
        return cheapest == Integer.MAX_VALUE ? -1 : cheapest;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        for (int i = 0; i <= k; i++) {
            if (isRoutePossible(distance, flights)) {
                break;
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
    private boolean isRoutePossible(int[] dist, int[][] flights) {
        int[] copy = Arrays.copyOf(dist, dist.length);
        boolean result = true;

        for (int[] flight : flights) {
            int src = flight[0];
            int dst = flight[1];
            int  cost =flight[2];

            if (copy[src] < Integer.MAX_VALUE && dist[dst] > dist[src] + cost) {
                dist[dst] = cost + copy[src];
                result = false;
            }
        }
        return result;
    }
}
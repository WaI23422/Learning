package Hard.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,3},{4,0,5}} 
        };

        for (int[][] board : tests) {
            System.out.println(new SlidingPuzzle_Solution().slidingPuzzle(board));
        }
    }
}

// DFS: 111ms 45.2MB
class SlidingPuzzle_Solution1 {

    // Direction map for zero's possible moves in a flattened 1D array (2x3 board)
    private final int[][] directions = {
        { 1, 3 },
        { 0, 2, 4 },
        { 1, 5 },
        { 0, 4 },
        { 3, 5, 1 },
        { 4, 2 },
    };

    public int slidingPuzzle(int[][] board) {
        // Convert the 2D board into a string representation to use as state
        StringBuilder startState = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                startState.append(board[i][j]);
            }
        }

        // Map to store the minimum moves for each visited state
        Map<String, Integer> visited = new HashMap<>();

        // Start DFS traversal from initial board state
        dfs(startState.toString(), visited, startState.indexOf("0"), 0);

        // Return the minimum moves required to reach the target state, or -1 if unreachable
        return visited.getOrDefault("123450", -1);
    }

    private void dfs(
        String state,
        Map<String, Integer> visited,
        int zeroPos,
        int moves
    ) {
        // Skip if this state has been visited with fewer or equal moves
        if (visited.containsKey(state) && visited.get(state) <= moves) {
            return;
        }
        visited.put(state, moves);

        // Try moving zero to each possible adjacent position
        for (int nextPos : directions[zeroPos]) {
            String newState = swap(state, zeroPos, nextPos); // Swap to generate new state
            dfs(newState, visited, nextPos, moves + 1); // Recursive DFS with updated state and move count
        }
    }

    // Helper method to swap characters at indices i and j in the string
    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}

// BFS: 6ms 43.90MB
class SlidingPuzzle_Solution {

    public int slidingPuzzle(int[][] board) {
        // Direction map for zero's possible moves in a 1D representation of the 2x3 board
        int[][] directions = new int[][] {
            { 1, 3 },
            { 0, 2, 4 },
            { 1, 5 },
            { 0, 4 },
            { 1, 3, 5 },
            { 2, 4 },
        };

        String target = "123450";
        StringBuilder startState = new StringBuilder();

        // Convert the 2D board into a string representation
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                startState.append(board[i][j]);
            }
        }

        Set<String> visited = new HashSet<>(); // To store visited states
        Queue<String> queue = new LinkedList<>();
        queue.add(startState.toString());
        visited.add(startState.toString());

        int moves = 0;

        // BFS to find the minimum number of moves
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String currentState = queue.poll();

                // Check if we reached the target solved state
                if (currentState.equals(target)) {
                    return moves;
                }

                int zeroPos = currentState.indexOf('0');
                for (int newPos : directions[zeroPos]) {
                    String nextState = swap(currentState, zeroPos, newPos);

                    // Skip if this state has been visited
                    if (visited.contains(nextState)) continue;

                    // Mark the new state as visited and add it to the queue
                    visited.add(nextState);
                    queue.add(nextState);
                }
            }
            moves++;
        }
        return -1;
    }

    // Helper method to swap characters at indices i and j in the string
    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
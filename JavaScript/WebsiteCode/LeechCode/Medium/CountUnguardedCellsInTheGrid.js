// JavaScript

// 232ms 90.26MB
var countUnguarded = function(m, n, guards, walls) {
    // Initialize grid with zeros
    const g = Array(m).fill().map(() => Array(n).fill(0));
    
    // Mark guards and walls as 2
    for (const [x, y] of guards) {
        g[x][y] = 2;
    }
    for (const [x, y] of walls) {
        g[x][y] = 2;
    }
    
    // Directions: up, right, down, left
    const dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]];
    
    // Process each guard's line of sight
    for (const [gx, gy] of guards) {
        for (const [dx, dy] of dirs) {
            let x = gx;
            let y = gy;
            while (true) {
                x += dx;
                y += dy;
                // Check cells in current direction until hitting boundary or obstacle
                if (x < 0 || x >= m || y < 0 || y >= n || g[x][y] === 2) {
                    break;
                }
                g[x][y] = 1;
            }
        }
    }
    
    // Count unguarded cells (cells with value 0)
    return g.reduce((sum, row) => sum + row.filter(cell => cell === 0).length, 0);
};

// 136ms 86.28MB
/**
 * @param {number} m
 * @param {number} n
 * @param {number[][]} guards
 * @param {number[][]} walls
 * @return {number}
 */
var countUnguarded = function(m, n, guards, walls) {
    const grid = Array.from({ length: m }, () => Array(n).fill(0));
    let freeCells = m * n - walls.length - guards.length;

    for (let [i, j] of walls) grid[i][j] = 'W';
    for (let [i, j] of guards) grid[i][j] = 'G';

    for (let [row, col] of guards) {
        for (let i = col + 1; i < n; i++) {
            if (grid[row][i] === 'W' || grid[row][i] === 'G') break;
            if (grid[row][i] === 0) {
                freeCells--;
                grid[row][i] = 'S';
            }
        }

        for (let i = col - 1; i >= 0; i--) {
            if (grid[row][i] === 'W' || grid[row][i] === 'G') break;
            if (grid[row][i] === 0) {
                freeCells--;
                grid[row][i] = 'S';
            }
        }

        for (let i = row + 1; i < m; i++) {
            if (grid[i][col] === 'W' || grid[i][col] === 'G') break;
            if (grid[i][col] === 0) {
                freeCells--;
                grid[i][col] = 'S';
            }
        }

        for (let i = row - 1; i >= 0; i--) {
            if (grid[i][col] === 'W' || grid[i][col] === 'G') break;
            if (grid[i][col] === 0) {
                freeCells--;
                grid[i][col] = 'S';
            }
        }
    }

    return freeCells;
};
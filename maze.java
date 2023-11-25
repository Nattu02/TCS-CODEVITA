import java.util.*;

public class maze {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();
        int C = scanner.nextInt();

        int[][] maze = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }
        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();
        int targetRow = scanner.nextInt();
        int targetCol = scanner.nextInt();

        int result = shortestPath(maze, startRow, startCol, targetRow, targetCol);

        if (result == Integer.MAX_VALUE) {
            System.out.print("STUCK");
        } else {
            System.out.print(result);
        }
    }

    static int shortestPath(int[][] maze, int startRow, int startCol, int targetRow, int targetCol) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int distance = current[2];

            if (row == targetRow && col == targetCol) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];

                if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length &&
                        !visited[newRow][newCol] && maze[newRow][newCol] != 1) {
                    if (maze[newRow][newCol] != 3 || countDangerousBlocks(maze, visited, newRow, newCol, dx, dy) == 1) {
                        queue.offer(new int[]{newRow, newCol, distance + 1});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static int countDangerousBlocks(int[][] maze, boolean[][] visited, int row, int col, int[] dx, int[] dy) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length &&
                    maze[newRow][newCol] == 3 && !visited[newRow][newCol]) {
                count++;
            }
        }
        return count;
    }
}

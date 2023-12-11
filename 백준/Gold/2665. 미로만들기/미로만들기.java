import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static class Point {
        int r, c, black;
        Point(int r, int c, int black) {
            this.r = r;
            this.c = c;
            this.black = black;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int minCnt = bfs();

        bw.write(minCnt + "");
        bw.close();
    }

    private static int bfs() {
        Deque<Point> deque = new ArrayDeque<>();
        deque.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            Point p = deque.poll();
            if (p.r == N - 1 && p.c == N - 1) {
                return p.black;
            }

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    if (map[nr][nc] == 1) {
                        deque.offerFirst(new Point(nr, nc, p.black));
                    } else {
                        deque.offerLast(new Point(nr, nc, p.black + 1));
                    }
                    visited[nr][nc] = true;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}

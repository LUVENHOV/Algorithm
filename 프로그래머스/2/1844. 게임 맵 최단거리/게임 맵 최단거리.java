import java.util.ArrayDeque;

class Solution {

private static int[] rx = {1, -1, 0, 0};
private static int[] ry = {0, 0, 1, -1};

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        int[][] dist = new int[maps.length][maps[0].length];
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(0, 0));
        dist[0][0] = 1;
        dist[maps.length - 1][maps[0].length - 1] = -1;

        while (!que.isEmpty()) {
            Pair now = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + rx[i];
                int ny = now.y + ry[i];

                if (nx >= 0 && nx < maps[0].length && ny >= 0 && ny < maps.length && maps[ny][nx] != 0 && dist[ny][nx] <= 0){
                    dist[ny][nx] = dist[now.y][now.x] + 1;
                    que.add(new Pair(nx, ny));
                }
            }
        }

        return dist[maps.length - 1][maps[0].length - 1];
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] list;
    static int[] travel;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        travel = new int[M];
        list = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    list[i].add(j);
                }
                if (i == j) list[i].add(j);
            }
        }
        for (int i = 0; i < M; i++) {
            travel[i] = sc.nextInt();
        }
        for (int i = 0; i < M-1; i++) {
            bfs(travel[i], travel[i+1]);
        }
        System.out.println("YES");
    }
    static void bfs(int start, int dest) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        que.offer(start);
        visited[start] = true;
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);
                if (next == dest) return;
                if (!visited[next]) {
                    que.offer(next);
                    visited[next] = true;
                }
            }
        }
        System.out.println("NO");
        System.exit(0);
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] dist;
	static int[] rr = { 1, -1, 0, 0 };
	static int[] rc = { 0, 0, 1, -1 };

	private static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		} // 입력받기

		// 시작장소부터 거리재기
		dist[0][0] = 1;
		BFS();
		System.out.println(dist[N - 1][M - 1]);
	}

	static void BFS() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0));

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.r + rr[i];
				int nc = now.c + rc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 1 && dist[nr][nc] == 0) {
					dist[nr][nc] = dist[now.r][now.c] + 1;
					queue.add(new Node(nr, nc));

				}
			}

		}
	}

}

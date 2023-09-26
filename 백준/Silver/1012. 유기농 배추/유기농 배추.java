import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int T, N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] rr = { 0, 0, 1, -1 };
	static int[] rc = { 1, -1, 0, 0 };
	static int count;

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static void BFS() {
		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && visited[i][j] == false) {
					visited[i][j] = true;
					queue.add(new Node(i, j));

					while (!queue.isEmpty()) {
						Node now = queue.poll();
						for (int k = 0; k < 4; k++) {
							int nr = now.r + rr[k];
							int nc = now.c + rc[k];

							if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 1
									&& visited[nr][nc] == false) {
								visited[nr][nc] = true;
								queue.add(new Node(nr, nc));
							}

						}
					}
					count++;
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			count = 0;
			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = 1;
			}

			BFS();
			System.out.println(count);
		}

	}
}

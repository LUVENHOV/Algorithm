import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int l, r, c, cnt;

		public Node(int l, int r, int c, int cnt) {
			this.l = l;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int L, R, C;
	static char[][][] board;
	static StringBuilder sb = new StringBuilder();

	static int[] rl = { 0, 0, 0, 0, 1, -1 };
	static int[] rr = { -1, 1, 0, 0, 0, 0 };
	static int[] rc = { 0, 0, -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) {
				System.out.println(sb.toString());
				return;
			}

			int start_l = 0, start_r = 0, start_c = 0;
			board = new char[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();
					for (int k = 0; k < C; k++) {
						board[i][j][k] = str.charAt(k);
						if (board[i][j][k] == 'S') {
							start_l = i;
							start_r = j;
							start_c = k;
							board[i][j][k] = '.';
						}
					}
				}
				br.readLine();
			}
			bfs(start_l, start_r, start_c);
		}
	}

	static void bfs(int l, int r, int c) {
		Queue<Node> que = new LinkedList<>();
		boolean[][][] check = new boolean[L][R][C];
		que.add(new Node(l, r, c, 0));
		check[l][r][c] = true;

		while (!que.isEmpty()) {
			Node now = que.poll();

			if (board[now.l][now.r][now.c] == 'E') {
				sb.append("Escaped in " + now.cnt + " minute(s).\n");
				return;
			}

			for (int i = 0; i < 6; i++) {
				int nl = now.l + rl[i];
				int nr = now.r + rr[i];
				int nc = now.c + rc[i];
				if (nl < 0 || nr < 0 || nc < 0 || nl > L - 1 || nr > R - 1 || nc > C - 1)
					continue;
				if (check[nl][nr][nc])
					continue;
				if (board[nl][nr][nc] == '.' || board[nl][nr][nc] == 'E') {
					check[nl][nr][nc] = true;
					que.add(new Node(nl, nr, nc, now.cnt+1));
				}
			}
		}
		sb.append("Trapped!\n");
	}
}
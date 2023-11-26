import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static char[][] board;
	static boolean[][] visited;
	static int[] rr = { 0, 1, 0, -1 };
	static int[] rc = { 1, 0, -1, 0 };
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		for(int i = 0; i < 4; i++) {
			int nr = r + rr[i];
			int nc = c + rc[i];
			if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && board[r][c] == board[nr][nc]) {
				cnt++;
				dfs(nr, nc);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < N; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		visited = new boolean[M][N];
		int black = 0;
		int white = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					cnt = 1;
					dfs(i,j);
					
					if(board[i][j] == 'B') black += cnt*cnt;
					else white += cnt*cnt;
				}
			}
		}
		System.out.println(white + " " + black);
	}
}

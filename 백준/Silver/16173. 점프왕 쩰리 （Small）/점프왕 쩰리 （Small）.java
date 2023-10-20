import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int[] rr = { 1, 0 };
	static int[] rc = { 0, 1 };
	static boolean flag = false;

	static void dfs(int r, int c) {
		
		//board[N-1][N-1] 도달 시 flag true로 바꿔서 성공처리
		if (r == N-1 && c == N-1) {
			flag = true;
			return;
		}

		int value = board[r][c];

		for (int i = 0; i < 2; i++) {
			int nr = r + rr[i] * value;
			int nc = c + rc[i] * value;

			if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine() , " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 보드 입력받기
		
		dfs(0,0);
		
		if (flag) {
			System.out.println("HaruHaru");
		} else
			System.out.println("Hing");
	}
}

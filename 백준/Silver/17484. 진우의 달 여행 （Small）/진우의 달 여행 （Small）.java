import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,min_count;
	static int[][] board;
	static int[] rr = {1,1,1};
	static int[] rc = {-1,0,1};
	
	
	static void dfs(int r, int c, int dir, int cnt) {
		//마지막 row에 도달하면 cnt와 min_count를 비교해서 저장
		if(r == N-1) {
			min_count = Math.min(min_count, cnt);
		}
		
		for(int i =0; i< 3; i++) {
			int nr = r + rr[i];
			int nc = c + rc[i];
			//맵 안에서 이전과 방향이 다르면
			if(nr >= 0 && nc >=0 && nr < N && nc < M && dir != i) {
				dfs(nr,nc,i,cnt+board[nr][nc]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min_count = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < M; i++) {
			dfs(0,i,3,board[0][i]);
		}
		System.out.println(min_count);
	}//main
}

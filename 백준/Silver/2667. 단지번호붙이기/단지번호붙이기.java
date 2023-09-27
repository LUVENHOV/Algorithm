import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static int N, count;
	static int map[][];
	static int[] rr = {-1,1,0,0};
	static int[] rc = {0,0,1,-1};

	static void dfs(int r, int c) {
		map[r][c] = 0; //방문처리
		count++;//count 늘리기
		
		for(int i = 0; i < 4; i++) {
			int nr = r + rr[i];
			int nc = c + rc[i];
			
			if(nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == 1) {
				dfs(nr,nc);
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		} // 지도 입력받기

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count = 0;
				if (map[i][j] == 1) {
					dfs(i, j);
					list.add(count);
				}
			}
		}
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i = 0 ; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}

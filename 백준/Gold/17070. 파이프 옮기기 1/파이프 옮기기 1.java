import java.util.Scanner;

public class Main {
	static int N, cnt;
	static int[][] arr;
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	N = sc.nextInt();
	arr = new int[N+1][N+1];
	for(int i = 1;i<=N;i++) {
		for(int j = 1;j<=N;j++) {
			arr[i][j] = sc.nextInt();
		}
	}
	cnt = 0;
	DFS(1, 2, 0);
	System.out.println(cnt);
}

public static void DFS(int r, int c, int dir) {//0: 가로, 1: 세로, 2: 대각선
	if(r>N || c>N||arr[r][c] == 1) 
		return;
	
	if(dir == 2) {
		if(arr[r-1][c] == 1 || arr[r][c-1] == 1) 
			return;
	}
	if(r==N && c== N) {
		cnt++;
		return;
	}
	
	if(dir == 0) {
		DFS(r, c+1, 0);
		DFS(r+1, c+1, 2);
	}
	else if(dir == 1) {
		DFS(r+1, c, 1);
		DFS(r+1, c+1, 2);
	}
	else {
		DFS(r, c+1, 0);
		DFS(r+1, c, 1);
		DFS(r+1, c+1, 2);
	}
	
}
}

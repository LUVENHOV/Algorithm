import java.util.Scanner;

public class Solution {
	
	static int[] arr;
	
	static int find(int a) {
		if(arr[a] == a) return a;
		return find(arr[a]);
	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x > y) arr[x] = y;
		else arr[y] = x;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			arr = new int[n+1];
			
			for(int i = 1; i <= n; i++) {
				arr[i] = i;
			}
			
			String answer = "";
			
			for(int i = 0; i < m ; i++) {
				int s1 = sc.nextInt();
				int s2 = sc.nextInt();
				int s3 = sc.nextInt();
				
				if(s1 == 0) union(s2,s3);
				else {
					if(find(s2) == find(s3)) answer += 1;
					else answer += 0;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}

import java.util.HashSet;
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
		
		for(int tc = 1 ; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			arr = new int[N+1];
			
			for(int i = 1; i <= N; i++) {
				arr[i] = i;
			}
			
			HashSet<Integer> set = new HashSet<Integer>();
			
			for(int i = 0; i < M; i++) {
				int s1 = sc.nextInt();
				int s2 = sc.nextInt();
				union(s1, s2);
			}
			
			for(int i = 1; i <= N; i++) {
				set.add(find(i));
			}
			
			System.out.println("#" + tc + " " + set.size());
		}
	}
}

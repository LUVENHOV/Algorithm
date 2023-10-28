import java.util.Scanner;

public class Main {

	static int N;
	static int[] nums;
	static int[] ans;
	static StringBuilder sb;

	static void com(int idx, int start) {
		if (start == 6) {
			for(int i = 0; i< 6; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		if(idx == N) return;
		ans[start] = nums[idx];
		com(idx + 1, start+1);
		com(idx + 1, start);
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while (true) {
			sb = new StringBuilder();

			N = sc.nextInt();
			if (N == 0)
				break;

			nums = new int[N];
			ans = new int[6];

			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}

			com(0, 0);
			System.out.println(sb);
		}

	}

}

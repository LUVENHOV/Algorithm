import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int num, cnt;

	public Node(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

public class Main {

	static int N;
	static int[] ans;
	static ArrayList<Integer>[] arr;

	public static int bfs(int start, int counted) {
		boolean[] chk = new boolean[N + 1];
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(start, counted));
		chk[start] = true;
		int min = 0;

		while (!que.isEmpty()) {
			Node now = que.poll();

			for (int next : arr[now.num]) {
				if (chk[next])
					continue;
				chk[next] = true;
				que.add(new Node(next, now.cnt + 1));
			}
			min = now.cnt;
		}

		return min;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		ans = new int[N + 1];
		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == -1)
				break;

			arr[a].add(b);
			arr[b].add(a);
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			ans[i] = bfs(i, 0);
			min = Math.min(min, ans[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		int min_count = 0;
		for (int i = 1; i <= N; i++) {
			if (ans[i] == min) {
				sb.append(i + " ");
				min_count++;
			}
		}

		System.out.print(min + " " + min_count);
		System.out.println();
		System.out.println(sb);

	}
}

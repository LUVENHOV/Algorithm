import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, K;
	static int answer = 0;
	static int cnt = 0;
	static boolean[] checked;

	static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		L1: while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			for (int k = 0; k < size; k++) {
				int num = queue.poll();
				for (int i = 0; i < 3; i++) {
					int nextnum = 0;
					if (i == 0)
						nextnum = num + 1;
					else if (i == 1)
						nextnum = num - 1;
					else if (i == 2)
						nextnum = num * 2;

					if (nextnum >= 0 && nextnum < 200001 && !checked[nextnum]) {
						if (nextnum == K) {
							answer = cnt;
							break L1;
						}
						checked[nextnum] = true;
						queue.add(nextnum);

					}
				}

			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		checked = new boolean[200001];
		checked[N] = true;
		BFS();
		System.out.println(answer);

	}
}

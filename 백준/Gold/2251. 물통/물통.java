import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Water {
		int a, b, c;

		public Water(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

	}

	static int A, B, C;
	static ArrayList<Integer> answer;

	static void bfs() {
		Queue<Water> que = new LinkedList<>();
		boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];
		que.add(new Water(0, 0, C));

		while (!que.isEmpty()) {
			Water now = que.poll();
			// 방문한 적이 있으면 continue
			if (visited[now.a][now.b][now.c])
				continue;
			// a가 비어있으면 C의 값을 정답배열에 추가
			if (now.a == 0)
				answer.add(now.c);
			// 현재 상태 true 처리
			visited[now.a][now.b][now.c] = true;

			// 1. B -> A
			// B를 A에 다 부어도 A가 꽉 차지 않을 때
			if (now.a + now.b <= A) {
				que.add(new Water(now.a + now.b, 0, now.c));
			}
			// B를 A에 부으면 A가 꽉 찰 때
			else {
				que.add(new Water(A, now.b - (A - now.a), now.c));
			}
			// 2. C -> A
			// B를 A에 다 부어도 A가 꽉 차지 않을 때
			if (now.a + now.c <= A) {
				que.add(new Water(now.a + now.c, now.b, 0));
			}
			// B를 A에 부으면 A가 꽉 찰 때
			else {
				que.add(new Water(A, now.b, now.c - (A - now.a)));
			}
			// 3. A -> B
			// A를 B에 다 부어도 B가 꽉 차지 않을 때
			if (now.a + now.b <= B) {
				que.add(new Water(0, now.a + now.b, now.c));
			}
			// A를 B에 부으면 B가 꽉 찰 때
			else {
				que.add(new Water(now.a - (B - now.b), B, now.c));
			}
			// 4. C -> B
			// C를 B에 다 부어도 B가 꽉 차지 않을 때
			if (now.c + now.b <= B) {
				que.add(new Water(now.a, now.c + now.b, 0));
			}
			// C를 B에 부으면 B가 꽉 찰 때
			else {
				que.add(new Water(now.a, B, now.c - (B - now.b)));
			}
			// 5. A -> C
			// A를 C에 다 부어도 C가 꽉 차지 않을 때
			if (now.a + now.c <= C) {
				que.add(new Water(0, now.b, now.a + now.c));
			}
			// A를 B에 부으면 C가 꽉 찰 때
			else {
				que.add(new Water(now.a - (C - now.c), now.b, C));
			}
			// 6. B -> C
			// B를 C에 다 부어도 C가 꽉 차지 않을 때
			if (now.b + now.c <= C) {
				que.add(new Water(now.a, 0, now.c + now.b));
			}
			// B를 A에 부으면 A가 꽉 찰 때
			else {
				que.add(new Water(now.a, now.b - (C - now.c), C));
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		answer = new ArrayList<>();

		bfs();

		Collections.sort(answer);
		for (int ans : answer) {
			System.out.print(ans + " ");
		}

	}
}

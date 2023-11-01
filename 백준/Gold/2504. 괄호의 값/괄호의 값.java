import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		Stack<Character> stack = new Stack<>();
		// 초깃값 설정
		int answer = 0;
		int now = 1;
		
		for (int i = 0; i < N.length(); i++) {
			// 스택에 넣는 거는 '(' 와 '[' 뿐
			if (N.charAt(i) == '(') {
				stack.push(N.charAt(i));
				now *= 2;
			} else if (N.charAt(i) == '[') {
				stack.push(N.charAt(i));
				now *= 3;
			}
			// ')'의 경우
			else if (N.charAt(i) == ')') {
				// 스택이 비었을 경우 or 다음으로 쌓여있는 값(peek)이 '('이 아닌경우
				if (stack.isEmpty() || stack.peek() != '(') {
					// answer = 0 으로 초기화
					answer = 0;
					// '('가 아니라면 '['인 경우일 것이므로 break
					break;
					// 이전 char이 '('면 앞서 '('를 스택에 넣을 때 저장한
					// now 값을 result에 더해준다
				} else if (N.charAt(i - 1) == '(') {
					answer += now;
				}
				// 모든 케이스에 대해 처리했으니까 now 초기화
				now /= 2;
				// stack에서 하나 pop
				stack.pop();
			}
			// ']'의 경우
			else if (N.charAt(i) == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					// answer = 0 으로 초기화
					answer = 0;
					// '['가 아니라면 '('인 경우일 것이므로 break
					break;
					// 이전 char이 '['면 앞서 '['를 스택에 넣을 때 저장한
					// now 값을 result에 더해준다
				} else if (N.charAt(i - 1) == '[') {
					answer += now;
				}
				now /= 3;
				stack.pop();
			}
		}
		//만약 stack이 전부 처리 되지 않았다면 그건 올바른 괄호문이 아닌 것
		if(!stack.isEmpty()) System.out.println(0);
		else System.out.println(answer);
	}
}

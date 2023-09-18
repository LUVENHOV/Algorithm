import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 1;
		
		String str = sc.next();
		for(int i = 0; i < str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-i-1)) answer = 0;
		}
		
		System.out.println(answer);
	}

}

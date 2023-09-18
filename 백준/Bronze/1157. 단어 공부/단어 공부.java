import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = -1;
		char answer = '?';
		
		String str = sc.next().toUpperCase();
		
		int[] arr = new int[26];
		
		for(int i = 0; i < str.length(); i++) {
				arr[str.charAt(i)-'A']++;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				answer = (char) ('A' + i);
			}
			else if(arr[i] == max) answer = '?';
		} 

		System.out.println(answer);
	}
}

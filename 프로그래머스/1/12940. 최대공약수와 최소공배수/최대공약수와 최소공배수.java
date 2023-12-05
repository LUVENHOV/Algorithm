class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = 1; //최대공약수 초기화
        int min = m; //최소공배수 초기화
        
        for(int i = 1; i <= n; i++){
            if(n % i == 0 && m % i ==0 && i > max) max = i;
        }
        
        for(int i = m; i <= n*m; i++){
            if(i % n == 0 && i % m == 0) {
                min = i;
                break;
            }
        }
        
        answer[0] = max;
        answer[1] = min;
        
        return answer;
    }
}
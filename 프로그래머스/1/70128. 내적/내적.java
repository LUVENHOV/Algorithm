class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int cur = 0;
        
        for(int i = 0; i < a.length; i++){
            cur = a[i] * b[i];
            answer += cur;
        }
        
        
        return answer;
    }
}
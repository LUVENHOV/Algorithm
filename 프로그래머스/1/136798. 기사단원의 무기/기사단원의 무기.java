class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++){
            int count = 0;
            //제곱근까지만 탐색
            for(int j = 1; j*j <= i; j++){
                //제곱근인 경우 count +1
                if(j*j == i) count++;
                //아닌 경우 두 수의 쌍이므로 +2
                else if(i%j == 0) count += 2;
            }
            
            if(count > limit) count = power;
            
            answer += count;
        }
        
        return answer;
    }
}
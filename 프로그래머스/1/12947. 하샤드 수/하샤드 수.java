import java.io.IOException;
class Solution {
    public boolean solution(int x) throws IOException {
        boolean answer = true;
        
        int sum = 0;
        int num = x;
        
        while ( num >= 1){
            sum += num % 10;
            num /= 10;
        }
        
        if(x % sum != 0) answer = false;
        
        return answer;
        
    }
}
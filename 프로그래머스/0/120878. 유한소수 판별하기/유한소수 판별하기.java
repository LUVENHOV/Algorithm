import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int final_b = b / GCD(a, b);
        
        while( final_b != 1) {
            if(final_b % 2 == 0) {
                final_b /= 2;
            }else if (final_b % 5 == 0) {
                final_b /= 5;
            }else {
                return 2;
            }
        }
        
        return 1;
    }
    
    private int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}
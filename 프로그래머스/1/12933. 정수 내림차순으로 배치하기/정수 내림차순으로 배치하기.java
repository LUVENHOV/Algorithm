import java.util.*;

class Solution {
    public long solution(long n) {
        
        String[] str = Long.toString(n).split("");
        Arrays.sort(str);
        
        StringBuilder sb = new StringBuilder();
        for(String i : str) sb.append(i);
        
        return Long.parseLong(sb.reverse().toString());
    }
}
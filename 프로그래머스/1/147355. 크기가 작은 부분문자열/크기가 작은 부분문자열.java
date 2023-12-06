class Solution {
    public int solution(String t, String p) {
        int length = t.length() - p.length() + 1;
        int answer = 0;
        
        for (int i = 0; i < length; i++) {
            String tmp = t.substring(i, i + p.length());   
            
            if (Long.parseLong(tmp) <= Long.parseLong(p)) {
            	answer++;
            }
        }
        return answer;
    }
}
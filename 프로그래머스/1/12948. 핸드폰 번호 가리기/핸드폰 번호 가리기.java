class Solution {
    public String solution(String phone_number) {
        char[] num = phone_number.toCharArray();
        for(int i = 0; i < num.length - 4; i++){
            num[i] = '*';
        }
        
        return String.valueOf(num);
    }
}
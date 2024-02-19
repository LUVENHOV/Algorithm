class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int left = 10;
        int right = 12;
        
        for(int num : numbers){
            if(num == 1 || num == 4 || num == 7){
                left = num;
                sb.append("L");
            }
            else if(num == 3 || num == 6 || num == 9){
                right = num;
                sb.append("R");
            }
            else{
                if(num == 0) {
                    num = 11;
                }
                
                int leftDist = Math.abs(num - left)/3 + Math.abs(num - left)%3;
                int rightDist = Math.abs(num - right)/3 + Math.abs(num - right)%3;
                
                if(leftDist < rightDist){
                    sb.append("L");
                    left = num;
                } else if(leftDist > rightDist){
                    sb.append("R");
                    right = num;
                } else {
                    if(hand.equals("left")){
                        sb.append("L");
                        left = num;
                    } else {
                        sb.append("R");
                        right = num;
                    }
                }
            }
        }
        return sb.toString();
    }
}
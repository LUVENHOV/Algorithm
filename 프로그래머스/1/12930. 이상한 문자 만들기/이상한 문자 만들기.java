class Solution {
        public String solution(String s) {
            String answer = "";
            int count = 0;
            String[] arr = s.split("");

            for(String str : arr){
                count = str.contains(" ") ? 0 : count + 1;
                answer += count %2 == 0 ? str.toLowerCase() : str.toUpperCase();
            }

            return answer;
        }
}
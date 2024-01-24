class Solution {
    public String solution(String polynomial) {
        int x_count = 0;
        int num = 0;
        
        for(String s : polynomial.split(" ")){
            if(s.contains("x"))
                x_count += s.equals("x") ? 1 : Integer.parseInt(s.replaceAll("x", ""));
            else if(!s.equals("+"))
                num += Integer.parseInt(s);
        }
        
        return(x_count != 0 ? x_count > 1 ? x_count + "x" : "x" : "") +  (num != 0 ? (x_count != 0 ? " + " : "") 
                + num : x_count == 0 ? "0" : "");
        
    }
}
class Solution {
    public String solution(String s) {
        
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
        
		String arr[] = s.split(" ");

		for (int i = 0; i < arr.length; i++) {
			if (min > Integer.parseInt(arr[i])) {
				min = Integer.parseInt(arr[i]);
			}
			if (max < Integer.parseInt(arr[i])) {
				max = Integer.parseInt(arr[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(max);

		return sb.toString();
    }
}
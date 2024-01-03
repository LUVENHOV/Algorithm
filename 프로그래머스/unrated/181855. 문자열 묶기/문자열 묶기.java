import java.util.*;

class Solution {
	public int solution(String[] strArr) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (String str : strArr) {
			int length = str.length();
			map.put(length, map.getOrDefault(length, 0) + 1);
		}

		int maxCount = 0;
		for (int count : map.values()) {
			maxCount = Math.max(maxCount, count);
		}

		return maxCount;
	}
}
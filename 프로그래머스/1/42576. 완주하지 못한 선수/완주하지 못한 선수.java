import java.util.HashMap;

class Solution { 
	
	public String solution(String[] participant, String[] completion) { 
		
		String answer =""; 
		HashMap<String, Integer> hash = new HashMap<>(); 
        
		for(String player : participant) hash.put(player, hash.getOrDefault(player, 0) + 1); 
        
		for(String player : completion) hash.put(player, hash.get(player) -1); 
        
		for(String key : hash.keySet()) { 
			if(hash.get(key) != 0) { 
				answer = key; break;
			} 
		} 
		return answer; 
	} 
}
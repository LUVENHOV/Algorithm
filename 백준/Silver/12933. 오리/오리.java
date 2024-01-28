import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        if (str[0] != 'q' || str.length%5 != 0) {
            System.out.println(-1);
            return;
        }
        boolean[] visited = new boolean[str.length];
        char[] duck = {'q', 'u', 'a', 'c', 'k'};
        int count = 0;
        int index = 0;

        for(int i = 0; i < str.length; i++){
            ArrayList<Character> list = new ArrayList<>();
            for( int j = i; j < str.length; j++){
                if(!visited[j] && str[j] == duck[index]){
                    index++;
                    list.add(str[j]);
                    visited[j] = true;
                    if(index == 5) index = 0;
                }
            }

            if(list.size() != 0){
                if(list.get(list.size() -1) != 'k'){
                    System.out.println(-1);
                    return;
                }
                count ++;
            }
        }
        System.out.println(count);
    }
}

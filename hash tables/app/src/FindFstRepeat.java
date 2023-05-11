import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindFstRepeat {
    public char find(String str) {
        var string = str.replaceAll("\\s", "");
        Map<Character, Integer> map = new HashMap<>();
        var chars = string.toCharArray();
        for (char ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }
        for (char c : chars) {
            if(map.get(c) == 1){
                return c;
            }
        }
        return Character.MIN_VALUE;
    }

    public char repeat(String str) {
        var string = str.replaceAll("\\s", "");
        Set<Character> set = new HashSet<>();
        for (char ch : string.toCharArray()) {
            if(set.contains(ch)){
                return ch;
            }else{
                set.add(ch);
            }
        }
        System.out.println(set);
        return Character.MIN_VALUE;
    }
}

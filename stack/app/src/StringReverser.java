import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringReverser {

    private final List<Character> leftBrackets = Arrays.asList('(', '[', '{', '<');
    private final List<Character> rightBrackets = Arrays.asList(')', ']', '}', '>');

    public String reverse(String inpuString) {
        StringBuffer stringBuffer = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (Character character : inpuString.toCharArray()) {
            stack.push(character);  
        }
        while(!stack.isEmpty()){
            stringBuffer.append(stack.pop());
        }
        return stringBuffer.toString();
    }

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : input.toCharArray()) {
            if(isLeftBrackets(ch)){
                stack.push(ch);
            }
            if (stack.isEmpty()) {
                return false;
            }
            if(isRightBrackets(ch)){
                var top = stack.pop();
                if(!bracketsMatch(top, ch)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeftBrackets(char ch) {
        return leftBrackets.contains(ch);
    }
    private boolean isRightBrackets(char ch) {
        return rightBrackets.contains(ch);
    }
    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
    
}

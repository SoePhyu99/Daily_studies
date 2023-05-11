import java.util.Stack;

public class QueueWithStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public Integer enque(int item){
        stack1.add(item);
        System.out.println(stack1 + "this is stack 1");
        return 1;
    }
    public Integer deque(){
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        stack2.pop();
        System.out.println(stack2+ "this is stack 2");
        return stack2.pop();
    }
}

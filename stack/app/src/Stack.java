import java.util.Arrays;

public class Stack {
    int[] stack = new int[5];
    int count = 0;
    public void push(int item) {
        if(count == stack.length){
            System.out.println("Can't push");
        }else{
            stack[count++] = item;
        }
    }

    public int pop() {
        if(isEmpty()){
            return -1;
        }else{
            var pop = stack[count - 1];
            stack[count-1] = 0;
            count--;
            return pop;
        }
    }

    public int peek() {
        return count == 0 ? -1 : stack[count-1];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public String toString() {
        var newItem = new int[count];
        for (int i = 0; i < count; i++) {
            newItem[i] = stack[i];
        }
        return Arrays.toString(newItem);
    }
}

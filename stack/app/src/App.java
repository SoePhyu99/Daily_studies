public class App {
    public static void main(String[] args) throws Exception {
        StringReverser stringReverser = new StringReverser();
        System.out.println(stringReverser.reverse("abcd"));

        var string = "([2]+<1>)";
        var result = stringReverser.isBalanced(string);
        System.out.println(result);
        
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
    }
}

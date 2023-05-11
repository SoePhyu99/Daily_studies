public class App {
    public static void main(String[] args) throws Exception {
        Array numbers = new Array(3);
        int[] newNumbers = {1,3,5,7,9};
        numbers.insert(1);
        numbers.insert(2);
        numbers.insert(3);
        numbers.insert(4);
        numbers.insert(5);
        // numbers.insert(40);
        // numbers.removeAt(2);
        numbers.insertAt(6, 5);
        numbers.reverse();
        numbers.print();
        numbers.intersect(newNumbers);
        System.out.println(numbers.indexOf(1));
        System.out.println(numbers.min());
        System.out.println(numbers.max());
    }
}

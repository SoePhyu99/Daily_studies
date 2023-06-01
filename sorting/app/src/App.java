import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] array = {1,2,3,1,5,2,3,4,5,4};
        InsertionSort sort = new InsertionSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

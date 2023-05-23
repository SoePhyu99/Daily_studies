import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        // LinearSearch linearSearch = new LinearSearch();
        JumpSearch binarySearch = new JumpSearch();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        var result = binarySearch.search(1, arr);
        System.out.println(result);
    }
    
}

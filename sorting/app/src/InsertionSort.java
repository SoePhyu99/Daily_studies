import java.util.ArrayList;
import java.util.List;

/**
 * InsertionSort
 */
public class InsertionSort {

    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) { // while(head != null)
            var current = array[i];              // temp = head
            int j = i - 1;                       // previous = head.previous
            while (j >= 0 && current < array[j]) {// previous !=null && temp.val < previous.val
                array[j + 1] = array[j];    // previous.next = previous
                j--;//previous = previous.previous
            }
            array[j + 1] = current;//previous.next = temp
        }
    }
}
import java.util.Arrays;

public class CountSort {
    public void sort(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i]] = count[array[i]] + 1;
        }
        int y = 0;
        System.out.println(Arrays.toString(count));
        for (int i = 0; i < count.length; i++) {
            int r = count[i];
            if(r != 0){
                array[y] = i;
                y++;
            }
            while(r > 1){
                array[y] = i;
                y++;
                r--;
            }
            System.out.println(i);
        }
    }
}

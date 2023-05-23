public class LinearSearch {
    public int search(int item, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == item){
                return i;
            }
        }
        return -1;
    }
}

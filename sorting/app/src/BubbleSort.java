public class BubbleSort {
    public void sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if(array[i+1] < array[i]){
                    changeOrder(i+1, i, array);
                }
            }
        }
    }
    private void changeOrder(int first, int second, int[] array) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}

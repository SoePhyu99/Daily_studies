public class SelectSort {
    public void sort(int[] array) {
        int max = 0;
        int index = 0;
        int sortedIndex = array.length - 1;
        int count = array.length - 1;
        while(count >= 0){
            for (int i = count; i >= 0; i--) {
                if(array[i] > max){
                    max = array[i];
                    index = i;
                }
            }
            changeOrder(index, sortedIndex--, array);
            System.out.println(max + " * " + array[index]);
            count--;
            max = 0;
        }
    }
    private void changeOrder(int first, int second, int[] array) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}

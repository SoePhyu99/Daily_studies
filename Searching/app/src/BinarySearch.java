public class BinarySearch {
    public int search(int target, int[] array) {
        return search(target, array, 0, array.length - 1);
    }
    private int search(int target, int[] array, int left, int right) {
        int middle = (left + right) / 2;
        if(array[middle] == target){
            return middle;
        }
        if(array[middle] > target){
            right = middle;
        }else if(array[middle] < target){
            left = middle + 1;
        }
        
        if(right < left || right == 0){
            return -1;
        }
        return search(target, array, left, right);
    }
}

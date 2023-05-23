public class TernarySearch {
    public boolean search(int target, int[] array) {
        return search(target, array, 0, array.length - 1);
    }
    public boolean search(int target, int[] array, int left, int right) {
        if(target < array[left] || target > array[right]){
            return false;
        }
        int middle = (right - left) / 3;
        int mid1 = left + middle;
        int mid2 = right - middle;
        if(array[mid1] == target || array[mid2] == target || middle == 0 && array[mid1 + 1]== target){
            return true;
        }
        if(target < array[mid1]){
            right = mid1;
        }else if(target > array[mid2]){
            left = mid2;
        }else if(target > array[mid1] && target < array[mid2]){
            left = mid1;
            right = mid2;
        }
        return search(target, array, left, right);
    }
}

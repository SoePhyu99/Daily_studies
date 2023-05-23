public class JumpSearch {
    public int search(int target, int[] array) {
        if(target < array[0] || target > array[array.length - 1]){
            return -1;
        }
        int jump = (int) Math.sqrt(array.length);
        int start = 0;
        int next = start + jump;

        while(next <= array.length) {
            if(target <= array[next - 1]){
                for (int j = start; j < next; j++) {
                    if(target == array[j]){
                        return j;
                    }
                }
            }
            start = next;
            if(next + jump > array.length){
                next = array.length;
            }else{
                next = next + jump;
            }
        }
        return -1;
    }
}

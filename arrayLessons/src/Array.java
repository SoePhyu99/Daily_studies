public class Array {

    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int value) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = value;
    }

    // removeAt
    public void removeAt(int index) {
        if(index < 0 || index >= count){
            System.out.println("Out of Bound!");
        }else{
            for (int i = index; i < count; i++) {
                items[i] = items[i+1];
            }
            count--;
        }
    }
    // indexOf
    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if(items[i] == value){
                return 1;
            }
        }
        return -1;
    }

    // max
    public int max() {
        int max = items[0];
        for (int i = 1 ; i < items.length; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }

    // min
    public int min() {
        int min = items[0];
        for (int i = 0; i < count; i++) {
            if(items[i] < min){
                min = items[i];
            }
        }
        return min;
    }

    // reverse
    public void reverse() {
        int newIndex = 0;
        int[] newItems = new int[count];
        for (int i = count - 1; i > -1; i--) {
            newItems[newIndex++] = items[i];
        }
        items = newItems;
    }

    // insertAt
    public void insertAt(int item, int index){
        if (index == count) {
            insert(item);
        }
        if (index > count || index < 0) {
            System.out.println("Cannot insert!");
        }else
        {items[index] = item;}
    }

    // intersect
    public void intersect(int[] newItems) {
        int[] commonItems = new int[count * 2];
        int index = 0;
        for (int i = 0; i < count; i++) {
            for (int j : newItems) {
                if (j == items[i]) {
                    commonItems[index++] = items[i];
                }
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.println(commonItems[i]);
        }
    }
}

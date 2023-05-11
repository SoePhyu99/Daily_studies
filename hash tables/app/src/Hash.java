import java.util.Arrays;

public class Hash {
    public class Entry{
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return value;
        }
    }

    Entry[] entries = new Entry[5];
    int count = 0;
    public void put(int key, String value) {
        entries[count++] = new Entry(key, value);
        System.out.println(Arrays.toString(entries));
    }

    public Entry get(int key) {
        return entries[key];
    }

    public void remove(int key) {
        entries[key] = null;
    }
    
}

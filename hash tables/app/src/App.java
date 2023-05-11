
public class App {
    public static void main(String[] args) throws Exception {

        Hash hash = new Hash();
        hash.put(0, "30");
        hash.put(1, "40");
        hash.put(2, "50");
        hash.put(3, "60");
        hash.remove(2);
        hash.put(4, "70");
        var result = hash.get(4);

        // FindFstRepeat findFstRepeat = new FindFstRepeat();
        // var result = findFstRepeat.repeat("green apple");
        System.out.println(result);
    }
}

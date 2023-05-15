public class App {
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("care");
        trie.insert("careful");
        trie.autoComplete("car");
        System.out.println();
    }
}

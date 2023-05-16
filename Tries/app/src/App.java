public class App {
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("care");
        trie.insert("carte");
        trie.insert("careful");
        var result = trie.findWords("car");
        trie.countWords();
        System.out.println(result);
    }
}

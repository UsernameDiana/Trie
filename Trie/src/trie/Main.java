package trie;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] words = FileUtility.toStringArray("shak.txt", "[^A-Za-z]");

        SimpleTrie tries = new SimpleTrie();

        for (String word : words) {
            tries.put(word, word);
        }

        System.out.println("Find " + tries.get("OR"));
        tries.print(System.out);

    }
}

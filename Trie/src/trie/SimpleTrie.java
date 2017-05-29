package trie;

import java.io.PrintStream;

public class SimpleTrie {

    public static int SIZE = indexOf('Z') + 2;

    private WordCounter data = null;
    private SimpleTrie[] tries = null;

    public class WordCounter {

        String word;
        int count;

        WordCounter(String word) {
            this.word = word;
            this.count = 1;
        }
    }

    private static int indexOf(char letter) {
        if (letter == '\'') {
            return 26;
        }
        return (int) (letter - 'A');
    }

    public void put(String word, String data) {
        if (word.isEmpty()) {
            if (this.data == null) {
                this.data = new WordCounter(data);
            } else {
                this.data.count++;
            }
        } else {
            char letter = word.charAt(0);
            int index = indexOf(letter);
            if (tries == null) {
                tries = new SimpleTrie[SIZE];
            }
            if (tries[index] == null) {
                tries[index] = new SimpleTrie();
            }

            SimpleTrie trie = tries[index];
            trie.put(word.substring(1), data);
        }
    }

    public WordCounter get(String word) {
        if (word.isEmpty()) {
            return data;
        }
        if (tries == null) {
            return null;
        }
        char letter = word.charAt(0);
        int index = indexOf(letter);

        SimpleTrie trie = tries[index];
        if (trie == null) {
            return null;
        }
        return trie.get(word.substring(1));
    }

    public void print(PrintStream out) {
        if (data != null) {
            out.println(data.word + " Occures: " + data.count + " Times");
        }
        if (tries != null) {
            for (SimpleTrie trie : tries) {
                if (trie == null) {
                    continue;
                }
                trie.print(out);
            }
        }
    }
}

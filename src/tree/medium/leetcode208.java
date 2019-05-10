package tree.medium;

/**
 * Created by Hxg
 * Date: 2019/5/2
 * Time: 15:00
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode208 {
    class TrieNode {
        boolean isWord;
        private TrieNode[] child;

        TrieNode() {
            isWord = false;
            child = new TrieNode[26];
        }

        public TrieNode getChild(int i) {
            if (i >= 26 || i < 0)
                throw new IllegalArgumentException();
            return child[i];
        }

        public void setChild(int i, TrieNode node) {
            child[i] = node;
        }
    }

    public class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode r = root;
            if (r == null)
                return;
            for (int i = 0; i < word.length(); i++) {
                int id = word.charAt(i) - 'a';
                if (r.getChild(id) == null) {
                    r.setChild(id, new TrieNode());
                }
                r = r.getChild(id);

            }
            r.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode r = root;
            if (r == null)
                return false;
            for (int i = 0; i < word.length(); i++) {
                int id = word.charAt(i) - 'a';
                if (r.getChild(id) == null) {
                    return false;
                }
                r = r.getChild(id);
            }
            return r.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode r = root;
            if (r == null)
                return false;
            for (int i = 0; i < prefix.length(); i++) {
                int id = prefix.charAt(i) - 'a';
                if (r.getChild(id) == null) {
                    return false;
                }
                r = r.getChild(id);
            }
            return r != null;
        }
    }

}

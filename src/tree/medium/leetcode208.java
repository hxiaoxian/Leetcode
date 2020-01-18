package tree.medium;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 */
public class leetcode208 {
    class TrieNode {
        TrieNode[] child;
        boolean isword;

        public TrieNode() {
            child = new TrieNode[26];
            isword = false;
        }
    }

    class Trie {

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new TrieNode();
                }
                node = node.child[c - 'a'];
            }
            node.isword = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.child[c - 'a'] == null)
                    return false;
                node = node.child[c - 'a'];
            }
            return node.isword;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.child[c - 'a'] == null)
                    return false;
                node = node.child[c - 'a'];
            }
            return true;
        }
    }
}

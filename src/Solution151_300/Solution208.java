package Solution151_300;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution208 {

    public static void main(String[] args) {
        Trie test = new Trie();
//        test.insert("ab");
//        test.insert("abc");
//        System.out.println(test.search("abc"));
        System.out.println("add1");
        for (int i = 0; i < 26; i++) {
            test.insert("aa"+String.valueOf((char)( 'a'+i)));
        }
        System.out.println("add2");
        for (int i = 0; i < 26; i++) {
            test.insert("a"+String.valueOf((char)( 'a'+i)));
        }

//        test.insert("aaa");
//        test.insert("aa");
        System.out.println(test.search("aaa"));
    }
}

class Trie {
    private char[] head;
    private int headLen;
    private Map<Character, Trie> childs;
    private Trie father;

    /** Initialize your data structure here. */
    public Trie() {
        this.childs = new HashMap<>();
        this.father = null;
        this.headLen = 0;
    }

    public void insert(char[] word, int from, int to){
        to = Math.min(to, word.length);
        from = Math.max(from, 0);

        if (head == null) {
            head = Arrays.copyOfRange(word, from, to);
            headLen = to - from;
            return;
        }

        int sameLen = 0;
        int searchLen = Math.min(headLen, to - from);
        for (; sameLen < searchLen; sameLen++) {
            if (head[sameLen] != word[sameLen + from])
                break;
        }

        if (sameLen < headLen){
            //todo 这里有错误要修，如果有相同头部，那么应该是产生一个父节点而非插入到子节点
            Trie child1 = childs.getOrDefault(head[sameLen], new Trie());
            child1.insert(head, sameLen, headLen);
            childs.putIfAbsent(head[sameLen], child1);
            headLen = sameLen;
        }

        if (sameLen < (to - from)){
            Trie child2 = childs.getOrDefault(word[sameLen + from], new Trie());
            child2.insert(word, sameLen + from, to);
            childs.putIfAbsent(word[sameLen + from], child2);
        }
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word.toCharArray(), 0, word.length());
    }

    private boolean search(char[] word, int from){
        int searchLen = Math.min(headLen, word.length - from);
        if (searchLen < headLen)
            return false;

        for (int i = 0; i < searchLen; i++) {
            if (word[i + from] != head[i])
                return false;
        }

        if (searchLen == headLen && searchLen == (word.length - from))
            return true;

        return childs.containsKey(word[searchLen + from]) &&
                childs.get(word[searchLen + from]).search(word, searchLen + from);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word.toCharArray(), 0);
    }

    private boolean startWith(char[] prefix, int from){
        int searchLen = Math.min(headLen, prefix.length - from);

        for (int i = 0; i < searchLen; i++) {
            if (prefix[i + from] != head[i])
                return false;
        }

        if (searchLen <= headLen && searchLen == (prefix.length - from))
            return true;

        return childs.containsKey(prefix[searchLen + from]) &&
                childs.get(prefix[searchLen + from]).startWith(prefix, searchLen + from);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startWith(prefix.toCharArray(), 0);
    }
}
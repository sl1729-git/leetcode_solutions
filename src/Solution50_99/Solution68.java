package Solution50_99;

import java.util.ArrayList;
import java.util.List;

public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        int currentLineWordNum = 0;
        int maxSpaceNum = 0;
        int maxSpaceNumCount = 0;
        StringBuffer lineBuf = new StringBuffer();
        int currentLineLeftSpace = maxWidth;
        int lineStartWordIndex = 0;
        String[] spaces = new String[maxWidth];
        for (int i = 0; i < spaces.length; i++) {
            spaces[i] = lineBuf.toString();
            lineBuf.append(' ');
        }
        lineBuf.delete(0,lineBuf.length());
        for (int i = 0; i < words.length; i++) {
            if (currentLineLeftSpace < words[i].length()){
                if (currentLineWordNum == 1){
                    lineBuf.append(words[lineStartWordIndex]);
                    lineBuf.append(spaces[maxWidth-lineBuf.length()]);
                }else {
                    currentLineLeftSpace++;
                    maxSpaceNumCount = currentLineLeftSpace % (currentLineWordNum - 1) == 0 ? currentLineWordNum - 1 :
                            currentLineLeftSpace % (currentLineWordNum - 1);
                    maxSpaceNum = 1 + (currentLineLeftSpace / (currentLineWordNum - 1)) +
                            (maxSpaceNumCount == currentLineWordNum - 1 ? 0 : 1);
                    for (int j = lineStartWordIndex; j < i; j++) {
                        lineBuf.append(words[j]);
                        if (j - lineStartWordIndex < maxSpaceNumCount)
                            lineBuf.append(spaces[maxSpaceNum]);
                        else if (j != i - 1)
                            lineBuf.append(spaces[maxSpaceNum - 1]);
                    }
                }
                ret.add(lineBuf.toString());
                lineBuf.delete(0,lineBuf.length());
                currentLineLeftSpace = maxWidth;
                currentLineWordNum = 0;
                lineStartWordIndex = i;
                i--;
            }
            else {
                currentLineLeftSpace -= words[i].length() + 1;
                currentLineWordNum ++;
            }
        }
        lineBuf.delete(0,lineBuf.length());
        for (int i = lineStartWordIndex; i < words.length; i++) {
            lineBuf.append(words[i]);
            if (i != words.length - 1)
                lineBuf.append(' ');
        }
        lineBuf.append(spaces[maxWidth-lineBuf.length()]);
        ret.add(lineBuf.toString());
        return ret;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        Solution68 s = new Solution68();
        System.out.println(s.fullJustify(words,16));
    }
}

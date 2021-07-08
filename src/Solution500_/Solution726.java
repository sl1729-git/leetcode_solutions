package Solution500_;

import java.util.*;

public class Solution726 {

    private int getNum(char[] buf, int index){
        int right = index;
        while (right < buf.length && Character.isDigit(buf[right]))right++;
        return right == index ? 1 : Integer.valueOf(new String(buf, index, right - index));
    }

    private int getAtomNameRange(char[] buf, int index){
        int right = index;
        if (!Character.isUpperCase(buf[index++]))
            return index - 1;
        while (index < buf.length && Character.isLowerCase(buf[index]))index++;
        return index;
    }

    /**
     * 这个就是字符串的解析，没有多余的技巧性内容
     * @param formula 化学表达式，必须按照leetcode726题的要求输入
     * @return 按照原子表示的字典序输出原子数量
     */
    public String countOfAtoms(String formula) {
        if (formula == null)
            return "";

        char[] buf = formula.toCharArray();
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        Map<String, Integer> count = new HashMap<>();
        int[] quickJumpTable = new int[buf.length];
        while (index < buf.length){
            char currentChar = buf[index++];
            if (currentChar == '(')
                stack.push(index - 1);
            if (currentChar == ')'){
                int left = stack.pop();
                quickJumpTable[left] = index - 1;
                quickJumpTable[index - 1] = left;
            }
        }

        index = 0;
        stack.clear();
        while (index < buf.length){
            char currentChar = buf[index];
            if (currentChar == '('){
                index = quickJumpTable[index];
                stack.push(getNum(buf, index + 1));
                index = quickJumpTable[index];
                index ++;
                continue;
            }
            if (currentChar == ')'){
                stack.pop();
                index ++;
                continue;
            }
            if (Character.isDigit(currentChar)) {
                index ++;
                continue;
            }

            int right = getAtomNameRange(buf, index);
            String atom = new String(buf, index, right - index);
            index = right;
            int atomNum = getNum(buf, index);
            for (Integer mul:stack) {
                atomNum *= mul;
            }
            count.put(atom, count.getOrDefault(atom, 0) + atomNum);
        }

        List<String> atoms = new ArrayList<>(count.keySet());
        atoms.sort(String::compareTo);
        StringBuilder ret = new StringBuilder();
        for (String atom:atoms) {
            ret.append(atom);
            int atomNum = count.get(atom);
            if (atomNum > 1)
                ret.append(count.get(atom));
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        String formula = "K4(ON(SO3)2)2(ON)";
        Solution726 s = new Solution726();
        System.out.println(s.countOfAtoms(formula));
    }
}

package Solution500_;

public class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        boolean ret = true;
        int indexName = 0, indexTyped = 0;
        while (indexName < name.length() && indexTyped < typed.length()){
            if (name.charAt(indexName) == typed.charAt(indexTyped)){
                indexName ++;
                indexTyped ++;
            }else if (indexTyped > 0 && typed.charAt(indexTyped) == typed.charAt(indexTyped-1)){
                indexTyped ++;
            }else {
                return false;
            }
        }
        while (indexTyped > 0 && indexTyped < typed.length()){
            if (typed.charAt(indexTyped) == typed.charAt(indexTyped-1))
                indexTyped ++;
            else
                return false;
        }
        return indexName == name.length();
    }

    public static void main(String[] args) {
        String name = "";
        String typed = "a";
        Solution925 s = new Solution925();
        System.out.println(s.isLongPressedName(name, typed));
    }
}

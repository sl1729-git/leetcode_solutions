package Test;

import java.util.*;

public class Param {
    private static Set<String> supportOperator = new HashSet<>(Arrays.asList("==","!=","&=","$="));
    private static Set<String> supportLogicalConnect = new HashSet<>(Arrays.asList("and","or"));

    public static List<Condition[]> getParam(String param) throws Exception{
        param = param + " or";
        char[] paramChars = param.trim().toCharArray();
        int left = 0, right = left, end = paramChars.length;
        String[] condition = new String[3];
        List<Condition[]> ret = new ArrayList<>();
        List<Condition> andAllGroup = new ArrayList<>();
        while (right < end){
            right = getColumn(paramChars, right, condition, 0);
            right = getOperator(paramChars, right, condition, 1);
            right = getSearchText(paramChars, right, condition, 2);
            andAllGroup.add(new Condition(condition));
            right = isAnd(paramChars, right, condition, 0);
            if (condition[0].equals("or")){
                ret.add(andAllGroup.toArray(new Condition[0]));
                andAllGroup.clear();
            }
        }
        return ret;
    }

    private static int getColumn(char[] param, int offset, String[] ret, int dst) throws Exception{
        if (offset >= param.length)
            throw new Exception(String.format(
                    "It looks like you do not finish you expression in last Predicate"
            ));
        int right = offset;
        if (param[right] == '*'){
            ret[dst] = "*";
            right = offset + 1;
        }else {
            while (right < param.length && (Character.isLetterOrDigit(param[right]) || param[right] == '_')) right++;
            ret[dst] = String.valueOf(param, offset, right - offset);
        }
        while (right < param.length && Character.isSpaceChar(param[right]))right++;
        return right;
    }

    private static int getOperator(char[] param, int offset, String[] ret, int dst) throws Exception{
        if (offset + 2 >= param.length)
            throw new Exception(String.format(
                    "It looks like you do not finish you expression because you loss operator and search text"
            ));
        ret[dst] = String.valueOf(param, offset, 2);
        if (!supportOperator.contains(ret[dst]))
            throw new Exception(String.format(
                    "Do not support operator %s or you make mistake in expression and error index is %d",
                    ret[dst], offset));
        offset += 2;
        while (offset < param.length && Character.isSpaceChar(param[offset]))offset++;
        return offset;
    }

    private static int getSearchText(char[] param, int offset, String[] ret, int dst) throws Exception{
        if (param[offset] != '"')
            throw new Exception(String.format(
                    "It looks like you miss \" or you make mistake in expression and error index is %d",
                    offset
            ));
        int right = ++offset;
        while (right < param.length && (param[right] != '"' || param[right] == '"' && param[right - 1] == '\\'))
            right++;
        if (right == param.length)
            throw new Exception(String.format(
                    "It looks like you miss \" or you make mistake in expression and error index is %d",
                    right
            ));
        ret[dst] = String.valueOf(param, offset, right - offset);
        right ++;
        while (right < param.length && Character.isSpaceChar(param[right]))right++;
        return right;
    }

    private static int isAnd(char[] param, int offset, String[] ret, int dst) throws Exception{
        if (offset == param.length){
            ret[dst] = "";
            return param.length;
        }

        String connect = "";

        if ((param[offset] == 'o' || param[offset] == 'O') && offset + 1 < param.length){
            connect = String.valueOf(param, offset, 2).toLowerCase();
        }else if ((param[offset] == 'a' || param[offset] == 'A') && offset + 2 < param.length)
            connect = String.valueOf(param, offset, 3).toLowerCase();
        else
            throw new Exception(String.format(
                    "it looks like you did some error in logical connect word at %d",
                    offset
            ));
        if (!supportLogicalConnect.contains(connect))
            throw new Exception(String.format(
                    "do not support logical operator %s at index %d",
                    connect, offset
            ));

        offset += connect.equals("and") ? 3 : 2;
        ret[dst] = connect;
        while (offset < param.length && Character.isSpaceChar(param[offset]))offset++;
        return offset;
    }

    public static void main(String[] args) throws Exception{
        String testString = "C_1 == \"A\" or C2 &= \"B\"";
        Param param = new Param();
        List<Condition[]> tmp = param.getParam(testString);
        for (Condition[] conditions:tmp) {
            for (Condition condition:conditions) {
                System.out.print(condition);
            }
            System.out.print("\r\n");
        }
        List<Integer> test = new ArrayList<>(Arrays.asList(2,3,1));
        test.sort(Integer::compareTo);
        System.out.println(test);
    }

}

class Condition{
    String column;
    String operator;
    String searchText;

    public Condition(String[] condition){
        column = condition[0];
        operator = condition[1];
        searchText = condition[2];
    }

    public String toSQLString(){
        if (column.equals("*"))
            return "";
        String searchText = this.searchText.replace("\'","\'\'").replace("\"","\'\"");
        switch (operator){
            case "==":
                return String.format("BINARY %s = \'%s\'",column, searchText);
            case "!=":
                return String.format("BINARY %s <> \'%s\'",column, searchText);
            case "$=":
                return String.format("%s = \'%s\'",column, searchText);
            case "&=":
                return String.format("BINARY %s LIKE \'%%%s%%\'",column, searchText.replace("%","\'%"));
        }
        return "";
    }

    @Override
    public String toString() {
        return "Condition{" +
                "column='" + column + '\'' +
                ", operator='" + operator + '\'' +
                ", searchText='" + searchText + '\'' +
                '}';
    }
}
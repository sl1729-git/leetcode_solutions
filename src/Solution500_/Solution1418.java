package Solution500_;

import java.util.*;

public class Solution1418 {

    /**
     *
     * 这个正常按照要求写就好了，完全是看标准库的熟练度
     *
     * @param orders 点餐的订单表，非空，每一项非空，每一项的内容要求为
     *               第一位为顾客姓名，第二位为桌号，第三位为餐品名称
     * @return 第一行第一个为Table，表示桌号，后面的以字母序进行记录的餐品名称
     *         ，第二行后一行表示对应桌号，每一种餐品的点餐数量
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<String> colName = new ArrayList<>();
        Map<Integer, Map<String, Integer>> count = new HashMap<>();
        Set<String> foodNames = new HashSet<>();
        for (List<String> order:orders) {
            int table = Integer.valueOf(order.get(1));
            String food = order.get(2);
            if (!count.containsKey(table)){
                count.put(table, new HashMap<>());
            }
            Map<String, Integer> tmp = count.getOrDefault(table, new HashMap<>());
            tmp.put(food, tmp.getOrDefault(food, 0) + 1);
            foodNames.add(food);
        }

        List<List<String>> ret = new ArrayList<>();
        colName.addAll(foodNames);
        ret.add(colName);

        List<Integer> tables = new ArrayList<>(count.keySet());
        tables.sort(Integer::compareTo);
        colName.sort(String::compareTo);
        colName.add(0, "Table");

        for (Integer table:tables) {
            List<String> col = new ArrayList<>();
            col.add(String.valueOf(table));
            Map<String, Integer> currentTable = count.get(table);
            for (int i = 1; i < colName.size(); i++) {
                col.add(String.valueOf(currentTable.getOrDefault(colName.get(i), 0)));
            }
            ret.add(col);
        }

        return ret;
    }
}

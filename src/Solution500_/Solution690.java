package Solution500_;

import Utils.Employee;

import java.util.*;

public class Solution690 {
    /**
     * 没有进行错误输入检查，如果检查只需要将注释取消
     * @param employees 不为null，且不包含null，员工列表，每一个员工必须仅有一位上司
     * @param id 要计算对应员工的影响力的id号
     * @return 对应员工极其所有下属的影响力和
     */
    public int getImportance(List<Employee> employees, int id) {
        int ret = 0;
        if (employees == null)
            return ret;
//        Set<Integer> counted = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Employee> id2employee = new HashMap<>();
        for (Employee employee:employees) {
            id2employee.put(employee.id, employee);
        }
        queue.add(id);
        while (!queue.isEmpty()){
            Employee tmp = id2employee.get(queue.poll());
//            if (counted.contains(tmp.id))
//                throw new RuntimeException("出现环");
            ret += tmp.importance;
//            counted.add(tmp.id);
            queue.addAll(tmp.subordinates);
        }

        return ret;
    }
}

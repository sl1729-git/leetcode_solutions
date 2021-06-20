package Solution500_;

import java.util.*;

public class Solution1600 {

    public static void main(String[] args) {
        ThroneInheritance s = new ThroneInheritance("king");
        s.birth("king","clyde");
        s.death("king");
        s.birth("clyde","shannon");
        System.out.println(s.getInheritanceOrder());
        s.birth("shannon","scott");
        s.death("clyde");
        System.out.println(s.getInheritanceOrder());
    }
}

/**
 * 记录每一位皇室成员姓名，是否死亡和继承关系的类
 *
 * 提供的接口有创建成员，插入成员和列出以当前节点为第一继承人的继承顺序
 */
class InheritantNode {
    private String name;
    private boolean death = false;
    private Stack<InheritantNode> childs = new Stack<>();

    public InheritantNode(String name){
        this.name = name;
    }

    public void insert(InheritantNode child){
        childs.add(child);
    }

    public void markDeath(){
        death = true;
    }

    public List<String> getInheritanceOrder(){
        List<String> ret = new ArrayList<>();
        List<InheritantNode> nodes = new ArrayList<>();
        nodes.add(this);
        while (!nodes.isEmpty()){
            InheritantNode currentNode = nodes.remove(0);
            if (!currentNode.death)
                ret.add(currentNode.name);
            for (int i = 0; i < currentNode.childs.size(); i++) {
                nodes.add(i,currentNode.childs.get(i));
            }
        }

        return ret;
    }

}

/**
 * 继承人的实现类
 */
class ThroneInheritance {
    //继承人的根节点
    private InheritantNode root;
    //用于快速查找姓名对应的继承人类
    private Map<String, InheritantNode> quickFindTable = new HashMap<>();

    public ThroneInheritance(String kingName) {
        root = new InheritantNode(kingName);
        quickFindTable.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        InheritantNode node = quickFindTable.getOrDefault(parentName, null);
        if (node == null)
            return;
        InheritantNode child = new InheritantNode(childName);
        node.insert(child);
        quickFindTable.put(childName, child);
    }

    public void death(String name) {
        InheritantNode node = quickFindTable.getOrDefault(name, null);
        if (node == null)
            return;
        node.markDeath();
    }

    public List<String> getInheritanceOrder() {
        return root.getInheritanceOrder();
    }
}
import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1600 lang=java
 *
 * [1600] 皇位继承顺序
 */

// @lc code=start
class ThroneInheritance {

    private Node root;
    private Map<String, Node> nameMap;
    private Map<Node, List<Node>> childMap;

    public ThroneInheritance(String kingName) {
        root = new Node(kingName, null);
        nameMap = new HashMap<>();
        childMap = new HashMap<>();
        nameMap.put(kingName, root);
        childMap.put(root, null);
    }
    
    public void birth(String parentName, String childName) {
        Node node = nameMap.get(parentName);
        Node child = new Node(childName, null);
        nameMap.put(childName, child);
        if (childMap.get(node) == null) {
            childMap.put(node, new ArrayList<>());
        }
        childMap.get(node).add(child);
        node.childs = childMap.get(node);
    }
    
    public void death(String name) {
        Node node = nameMap.get(name);
        node.death = true;
    }
    
    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        getOrder(root, res);
        return res;
    }

    private void getOrder(Node root, List<String> orderList) {
        if (root == null) {
            return;
        }
        if (root.death == false) {
            orderList.add(root.name);
        }
        if (root.childs != null) {
            for(Node child : root.childs) {
                getOrder(child, orderList);
            }
        }
    }
}

class Node {
    public String name;
    public boolean death;
    public List<Node> childs;

    public Node(String name, List<Node> childs) {
        this.name = name;
        this.childs = childs;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
// @lc code=end


/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);
        Deque<Node> deque = new LinkedList<>();
        deque.offer(node);
        while(!deque.isEmpty()) {
            Node temp = deque.poll();
            for(Node n : temp.neighbors) {
                if(!visited.containsKey(n)) {
                    visited.put(n, new Node(n.val, new ArrayList<>()));
                    deque.offer(n);
                }
                visited.get(temp).neighbors.add(visited.get(n));
            }
        }
        return clone;
    }
}
// @lc code=end


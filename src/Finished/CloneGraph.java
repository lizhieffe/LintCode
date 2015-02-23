package Finished;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import Utils.UndirectedGraphNode;

public class CloneGraph {

	/**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        // write your code here
        Map<UndirectedGraphNode, UndirectedGraphNode> relation 
                = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
//        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        relation.put(node, cloneNode(node));
        while (queue.size() > 0) {
            UndirectedGraphNode last = queue.removeFirst();
//            visited.add(last);
            UndirectedGraphNode clone = relation.get(last);
            for (UndirectedGraphNode neighbor : last.neighbors) {
                UndirectedGraphNode neighborClone = null;
                if (!relation.containsKey(neighbor)) {
                    neighborClone = cloneNode(neighbor);
                    relation.put(neighbor, neighborClone);
                    queue.addLast(neighbor);
                }
                else
                    neighborClone = relation.get(neighbor);
                clone.neighbors.add(neighborClone);
                
                
            }
        }
        return relation.get(node);
    }
    
    UndirectedGraphNode cloneNode(UndirectedGraphNode node) {
        return new UndirectedGraphNode(node.label);
    }
    
    @Test
    public void tc01() {
    	UndirectedGraphNode n0 = new UndirectedGraphNode(0);
    	UndirectedGraphNode n1 = new UndirectedGraphNode(1);
    	UndirectedGraphNode n2 = new UndirectedGraphNode(2);
    	UndirectedGraphNode n3 = new UndirectedGraphNode(3);
    	UndirectedGraphNode n4 = new UndirectedGraphNode(4);
    	UndirectedGraphNode n5 = new UndirectedGraphNode(5);
    	n0.neighbors.add(n1);
    	n0.neighbors.add(n5);
    	n1.neighbors.add(n2);
    	n1.neighbors.add(n5);
    	n2.neighbors.add(n3);
    	n3.neighbors.add(n4);
    	n3.neighbors.add(n4);
    	n4.neighbors.add(n5);
    	n4.neighbors.add(n5);
    	UndirectedGraphNode result = new CloneGraph().cloneGraph(n0);
    	System.out.println();
    }
}

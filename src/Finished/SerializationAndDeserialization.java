package Finished;

import java.util.LinkedList;

import org.junit.Test;

import Utils.TreeNode;

public class SerializationAndDeserialization {
	/**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null)
            return "";
        StringBuilder builder = new StringBuilder();
        int remain = 1;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (remain > 0) {
            TreeNode node = queue.removeFirst();
            if (node instanceof TreeNodeNone)
                builder.append("#,");
            else {
                builder.append(node.val + ",");
                --remain;
            }
            if (node.left != null) {
                queue.addLast(node.left);
                ++remain;
            }
            else {
                queue.addLast(new TreeNodeNone(0));
            }
            if (node.right != null) {
                queue.addLast(node.right);
                ++remain;
            }
            else {
                queue.addLast(new TreeNodeNone(0));
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() == 0)
            return null;
        String[] s = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        for (int i = 1; i < s.length; ++i) {
            TreeNode node = queue.remove(0);
            if (isInt(s[i])) {
                node.left = new TreeNode(Integer.parseInt(s[i]));
                queue.addLast(node.left);
            }
            else {
                queue.addLast(new TreeNodeNone(0));
            }
            if (++i < s.length && isInt(s[i])) {
                node.right = new TreeNode(Integer.parseInt(s[i]));
                queue.addLast(node.right);
            }
            else {
                queue.addLast(new TreeNodeNone(0));
            }
        }
        return root;
    }
    
    private boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    @Test
    public void test01() {
    	String data = "1,2,#,3,#,4";
    	TreeNode root = new SerializationAndDeserialization().deserialize(data);
    	System.out.println();
    }
    
    @Test
    public void test02() {
    	TreeNode root = new TreeNode(1);
    	root.right = new TreeNode(2);
    	String result = new SerializationAndDeserialization().serialize(root);
    	System.out.println();
    }
}

class TreeNodeNone extends TreeNode {

	public TreeNodeNone(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}
    
}

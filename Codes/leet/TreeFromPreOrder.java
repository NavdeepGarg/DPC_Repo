package com.leet;


class TreeNode{
	
	public TreeNode(int value) {
		super();
		this.value = value;
	}
	public int value;
	public TreeNode left;
	public TreeNode right;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	
}

public class TreeFromPreOrder {
	
	public static Integer idxRef=new Integer(0);
	
	public static TreeNode buildtree(int[] preOrder, Integer idxRef, int rightNodeLimit ) {
		
		if(idxRef==preOrder.length || preOrder[idxRef] >rightNodeLimit) {
			return null;
		}
		
		TreeNode root = new TreeNode(preOrder[idxRef]);
		TreeFromPreOrder.idxRef++;
		root.left=buildtree(preOrder, TreeFromPreOrder.idxRef, root.value);
		root.right=buildtree(preOrder, TreeFromPreOrder.idxRef, rightNodeLimit);
		return root;
	}
	
	
	public static void preOrderTraversal(TreeNode root) {
		
		if(root==null)
			return;
		
		System.out.println(root.getValue());
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	public static void main(String[] args) {
		
		
		int[] preOrder= {8,5,1,7,10,12};
		
		TreeNode root = buildtree(preOrder,TreeFromPreOrder.idxRef,Integer.MAX_VALUE);
		
		preOrderTraversal(root);
	}

}

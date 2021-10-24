package com.datastructure.module;

public class CompanyTransaction {

   //Part 1
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	static Node prevNode = null;
	static Node headNode = null;

	private static void flattenBTToSkewed(Node root, int order) {

		if (root == null) {
			return;
		}
        // descending 
		if (order > 0) {
			flattenBTToSkewed(root.right, order);
		} 
		 // ascending 
		else 
		{
			flattenBTToSkewed(root.left, order);
		}
		
		Node rightNode = root.right;
		Node leftNode = root.left;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		// Similarly recurse for the left / right
		// subtree on the basis of the order required
		
		if (order > 0) {
			flattenBTToSkewed(leftNode, order);
		} else {
			flattenBTToSkewed(rightNode, order);
		}
	}

	// Function to traverse the right
	// skewed tree using recursion
	private static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Node root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(60);
		root.left.left = new Node(10);
		// root.right.left = new Node(40);
		root.left.right = new Node(40);

		// System.out.print("Longest Path element starting from root element: " + sb);

		// Order of the Skewed tree can
		// be defined as follows -
		// For Increasing order - 0
		// For Decreasing order - 1
		int order = 0;
		flattenBTToSkewed(root, order);
		traverseRightSkewed(headNode);
		//traverseRightSkewed(root);
	}

}

package com.datastructure.module;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;


public class TransactionUtil {

	// Represent a node of binary tree
	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			// Assign data to the new node, set left and right children to null
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	// Represent the root of binary tree
	public Node root;

	int[] treeArray;
	int index = 0;

	public TransactionUtil() {
		root = null;
	}
	//

	// Function to perform inorder traversal on the tree
	public static void inorder(Node root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	// Function to traverse the binary tree and store its keys in a set
	public static void extractKeys(Node root, Set<Integer> set) {
		// base case
		if (root == null) {
			return;
		}

		extractKeys(root.left, set);
		set.add(root.data);
		extractKeys(root.right, set);
	}

	// Function to put keys back into a set in their correct order in the BST
	// by doing inorder traversal
	public static void convertToBST(Node root, Iterator<Integer> it) {
		if (root == null) {
			return;
		}

		convertToBST(root.left, it);
		root.data = it.next();
		convertToBST(root.right, it);
	}

	// convertBTBST() will convert a binary tree to binary search tree
	public Node convertBTBST(Node node) {

		// Variable treeSize will hold size of tree
		int treeSize = calculateSize(node);
		treeArray = new int[treeSize];

		// Converts binary tree to array
		convertBTtoArray(node);

		// Sort treeArray
		Arrays.sort(treeArray);

		// Converts array to binary search tree
		Node d = createBST(0, treeArray.length - 1);
		return d;
	}

	// calculateSize() will calculate size of tree
	public int calculateSize(Node node) {
		int size = 0;
		if (node == null)
			return 0;
		else {
			size = calculateSize(node.left) + calculateSize(node.right) + 1;
			return size;
		}
	}

	// convertBTtoArray() will convert the given binary tree to its corresponding
	// array representation
	public void convertBTtoArray(Node node) {
		// Check whether tree is empty
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			if (node.left != null)
				convertBTtoArray(node.left);
			// Adds nodes of binary tree to treeArray
			treeArray[index] = node.data;
			index++;
			if (node.right != null)
				convertBTtoArray(node.right);
		}
	}

	// createBST() will convert array to binary search tree
	public Node createBST(int start, int end) {

		// It will avoid overflow
		if (start > end) {
			return null;
		}

		// Variable will store middle element of array and make it root of binary search
		// tree
		int mid = (start + end) / 2;
		Node node = new Node(treeArray[mid]);

		// Construct left subtree
		node.left = createBST(start, mid - 1);

		// Construct right subtree
		node.right = createBST(mid + 1, end);

		return node;
	}

	// inorder() will perform inorder traversal on binary search tree
	public void inorderTraversal(Node node) {

		// Check whether tree is empty
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		} else {

			if (node.left != null)
				inorderTraversal(node.left);
			System.out.print(node.data + " ");
			if (node.right != null)
				inorderTraversal(node.right);

		}
	}

	static Node prevNode = null;
	static Node headNode = null;

	public static void readyBTForSkewd(Node root, int order) {

		if (root == null) {
			return;
		}
		// descending
		if (order > 0) {
			readyBTForSkewd(root.right, order);
		}
		// ascending
		else {
			readyBTForSkewd(root.left, order);
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
			readyBTForSkewd(leftNode, order);
		} else {
			readyBTForSkewd(rightNode, order);
		}
	}

	// Function to traverse the right
	// skewed tree using recursion
	public static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		//System.out.print(root.data + " ");
		traverseRightSkewed(root.right);
	}

}
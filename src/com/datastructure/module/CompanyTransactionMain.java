package com.datastructure.module;

import com.datastructure.module.TransactionUtil;
import com.datastructure.module.TransactionUtil.Node;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Set;

public class CompanyTransactionMain {
	

	public static void main(String[] args) {
		TransactionUtil bt = new TransactionUtil();
		StringBuilder sb = new StringBuilder();
		
		//Add nodes to the binary tree
		bt.root = new Node(50); 
		bt.root.left = new Node(30); 
		bt.root.right = new Node(60); 
		bt.root.left.left = new Node(10); 
		bt.root.right.left = new Node(40);
		
		//root.left.right = new Node(40);
		
		// Order of the Skewed tree can be defined as follows -
		// For Increasing order - 0
		// For Decreasing order - 1
		int order = 0;
	
		
		 //Display given binary tree
		 System.out.println("Inorder representation of binary tree: ");
		 bt.inorderTraversal(bt.root);
		 
		 //Converts binary tree to corresponding binary search tree Node bst =
		 bt.convertBTBST(bt.root);
			
		//Display corresponding binary search tree 
		 System.out.println("\nInorder representation of resulting binary search tree: ");
			 
		 
		// traverse the binary tree and store its keys in a set
	        Set<Integer> set = new TreeSet<>();
	        bt.extractKeys(bt.root, set);
	 
	        // put back keys present in the set to their correct order in the BST
	        Iterator<Integer> it = set.iterator();
	        bt.convertToBST(bt.root, it);
	 
	        // print the BST
	        
	        bt.inorderTraversal(bt.root);
	   
	        bt.readyBTForSkewd(bt.root, order);
			 
			bt.traverseRightSkewed(bt.headNode);
			 
		 
		
	}

}

// root.right.left = new Node(40); // Commented current line assignment input since it was not Balance search tree. 
// for Given assignment input Need additional conversion to make balance search tree.
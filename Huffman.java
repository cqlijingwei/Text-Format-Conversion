/**
 * File: Huffman.java
 * Author: Li Jingwei
 * Date: November 23, 2015
 * Purpose: CSCI 1110, Assignment 9
 * 
 * Description: This program reads pieces of text and outputs for each piece of text a single 
 * integer, representing the number of bits needed to encode the text using the Huffman encoding 
 * algorithm.
 */
import java.util.Scanner;
import java.util.PriorityQueue;

/**
 * This is the Huffman class of the program containing all the program code.
 * It implements the Huffman algorithm.
 */
public class Huffman {

	/**
	 * This method is called when the program starts running.
	 * It reads in a number of lines from the console, instantiate the
	 * tree and output the bits calculated.
	 */
	public static void main(String[] args) 
	{
		// Instantiate new scanner to read from the console.
		Scanner keyboard = new Scanner(System.in);
		
		// Define the tree node.
		TreeNode node = null;
		TreeNode head = null;
		
		// Create the priority queue for storing and sorting the nodes.
		PriorityQueue<TreeNode> queue = new PriorityQueue<TreeNode>();
		
		// Get the number of lines of text to follow.
		int num = keyboard.nextInt();
		
		// Loop till number 0 appears.
		while ( num != 0 )
		{
			keyboard.nextLine();
			// Loop through the next numbers of lines.
			for (int i = 0; i < num; i++)
			{
				// Get the next line's byte codes.
				byte[] line = keyboard.nextLine().getBytes();
				
				// Loop through the byte code.
				for ( int m = 0; m < line.length; m++)
				{
					// Judge if the node is null.
					if ( node == null )
					{
						// Create the tree node.
						node = new TreeNode( line[m], null, null);
						
						// Define the node as head node.
						head = node;
					}
					else 
					{
						// Find the head node.
						node = head;
						
						// Loop through the nodes.
						while ( node != null )
						{
							// Check if the node is the same.
							if (node.nodeCheck(line[m]))
							{
								break;
							}
							// Check if the right node is null.
							else if ( node.right == null )
							{
								node.right = new TreeNode(line[m], null, null);
								break;
							}
							// Move to the right child.
							else 
							{
								node = node.right;
							}
						}
					}					
				}
			}
			
			// Add the nodes into the priority queue.
			while ( head != null )
			{
				// Add the node into the priority queue.
				queue.add(head);
				
				// Get the head node.
				node = head;
				
				// Define the right node as the new head.
				head = head.right;
				
				// The old head node's right node becomes null.
				node.right = null;
			}
			
			// Create the binary tree.
			while ( true )
			{
				// Get the first two nodes in the priority queue.
				head = queue.poll();
				
				// Judge if the priority queue is empty when one node is removed.
				if ( queue.isEmpty() )
				{
					break;
				}
				
				node = queue.poll();
				
				// Define the parent of the two nodes.
				node = new TreeNode(head.fre() + node.fre(), head, node);
				
				// Add the parent node into the priority queue.
				queue.add(node);
			}
			
			// Traverse the tree.
			System.out.println(head.traverse(0));
			
			// Initialize the variables.
			node = null;
			head = null;
			
			// Get the next input number.
			num = keyboard.nextInt();
		}
	}

}

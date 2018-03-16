/**
 * File: TreeNode.java
 * Author: Li Jingwei
 * Date: November 23, 2015
 * Purpose: CSCI 1110, Assignment 9
 * 
 * Description: This program sets up the tree by the TreeNode class. 
 */

/**
 * This is the TreeNode class of the program containing all the program code.
 * It implements the tree construction.
 */
public class TreeNode implements Comparable<TreeNode>
{
	// Create the variables.
	public TreeNode left;
	public TreeNode right;
	private int frequency = 1;
	private byte bytecode;
	
	// The constructor.
	TreeNode( byte bytecode, TreeNode left, TreeNode right )
	{
		this.bytecode = bytecode;
		this.left = left;
		this.right = right;
	}
	
	// The second constructor.
	TreeNode( int frequency, TreeNode left, TreeNode right )
	{
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}
	
	// Check whether the letter is the same or not. If so, add the frequency.
	public boolean nodeCheck( byte n )
	{
		// Judge if the byte code is the same.
		if ( this.bytecode == n )
		{
			// Increment the frequency number.
			this.frequency++;
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Return the frequency number.
	public int fre()
	{
		return frequency;
	}
	
	// Traverse the tree and get the bits number.
	public int traverse( int height )
	{
		// Judge if the node is the leaf.
		if ( this.left == null && this.right == null )
		{
			if ( height == 0 )
			{
				return this.frequency;
			}
			else 
			{
				return this.frequency * height;
			}
		}
		else if ( this.left == null )
		{
			return this.right.traverse(height + 1);
		}
		else if ( this.right == null )
		{
			return this.left.traverse(height + 1);
		}
		else 
		{
			return this.left.traverse(height + 1) + this.right.traverse(height + 1);
		}
	}
	
	// Method for comparing the specified tree nodes.
	public int compareTo( TreeNode com)
	{
		// Compare the frequency of two nodes.
		if ( this.frequency < com.frequency )
		{
			return -1;
		}
		else if ( this.frequency > com.frequency )
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
}

package algorithm.unit3;
import java.util.Iterator;

import javax.swing.RootPaneContainer;

import org.omg.CORBA.PRIVATE_MEMBER;

public class BinarySearchTree implements Iterable<String>{
	public Iterator<String> iterator()
	{
		BSTIterator a = new BSTIterator(Size());
		addNodes(a, root);
		return a;	
	}
	private Node root;
	private class Node{
		private String key;
		private int value;
		private Node left;
		private Node right;
		private int N;
		public String toString()
		{
			return key+ " : "+ value;
		}
		public Node(String key, int v)
		{
			this.key = key;
			this.value = v;
			this.left = null;
			this.right = null;
			this.N = 1;
		}
	}	
	private int size(Node n)
	{
		if (n == null) return 0;
		else return n.N;
	}
	private class BSTIterator implements Iterator<String>
	{
		private String[] nodes;
		private int N;
		private int index;
		public void add(String a)
		{
			nodes[N-index] = a;
			index --;
		}
		public BSTIterator(int N) 
		{
			nodes = new String[N];
			this.index = N;
			this.N = N;
		}	
		public String next()
		{
			String a = nodes[index++];
			return a;	
		}
		public boolean hasNext()
		{
			return index != N; 
		}
	}
	private Node find(Node root, String key)
	{
		if (root == null) return null;
		int comp = key.compareTo(root.key);
		if (comp>0)
			return root.right;
		else if(comp==0)
			return root;
		else
			return root.left;	
	}
	public Integer get(String key)
	{
		if (find(root, key)== null) return null;
		else 
		{
			return find(root, key).value;
		}
	}
	
	public void put(String key, int v)
	{
		if (this.root == null)
			root = new Node(key, v);
		else
			put(root, key, v);
	}
	private void put(Node root, String key, int v)
	{
		int cmp = key.compareTo(root.key);
		if (cmp > 0)
		{
			if (root.right == null){root.right = new Node(key, v);}
			else {put(root.right, key, v);}
		}
		else if (cmp < 0)
		{
			if (root.left == null){root.left = new Node(key, v);}
			else {put(root.left, key, v);}
		}
		else 
		{
			root.value = v;
		}
		root.N = size(root.left) + size(root.right) + 1;
	}
	
	public int Size()
	{
		return size(root);
	}
	
	public void traverse()
	{
		traverse(root);
	}
	private void traverse(Node root)
	{
		if (root != null)
		{
			System.out.println(root);
			traverse(root.left);
			traverse(root.right);
		}			
	}
	public void addNodes(BSTIterator a, Node root)
	{
		if (root != null)
		{
			a.add(root.key);
			addNodes(a, root.left);
			addNodes(a, root.right);
		}
		
	}
	public String maxKey(Node root)
	{
		if (root == null){return null;}
		else {
			if (root.right == null) {return root.key;}
			else return maxKey(root.right);
		}
	}
	public String minKey(Node root)
	{
		if (root == null){return null;}
		else 
		{
			if (root.left == null) {return root.key;}
			else return minKey(root.left);
		}
	}
	public static void main(String[] args)
	{
		BinarySearchTree BST = new BinarySearchTree();
		BST.put("A", 34);
		BST.put("B", 324);
		BST.put("P", 3422);
		System.out.println(BST.get("A"));
		BST.put("A", 3242);
		BST.put("O", 12);
		BST.put("U", 56);
		BST.put("C", 94153);
		System.out.println(BST.get("A"));
		System.out.println(BST.Size());
		System.out.println(BST.minKey(BST.root));
		System.out.println(BST.maxKey(BST.root));
		BST.traverse();
		for(String i:BST){
			System.out.println(i);
		}
	}
}

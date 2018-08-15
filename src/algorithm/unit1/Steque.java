package algorithm.unit1;

import java.util.Scanner;

public class Steque<Item> {
	private class Node{
		Item item;
		Node next;	
	}
	private Node first;
	private Node last;
	private int N = 0;
	public boolean isEmpty(){return N == 0;}
	public void push(Item item)
	{
		Node oldfirst = this.first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		this.N ++;
	}
	public void enqueue(Item item)
	{
		Node oldlast = this.last;
		last = new Node();
		last.item = item;
		if (oldlast == null){first = last;}
		else{oldlast.next = last;}
		this.N ++;
	}
	public Item pop()
	{
		if (this.isEmpty()){return null;}
		else
		{
			Node temp = first;
			first = first.next;
			this.N--;
			return temp.item;
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Steque<Integer> steque = new Steque<Integer>();
		while(in.hasNext())
		{
			int a = in.nextInt();
			if (a == 0){System.out.println(steque.pop());}
			else if (a < 5){steque.enqueue(a);}
			else{steque.push(a);}
		}
	}

}

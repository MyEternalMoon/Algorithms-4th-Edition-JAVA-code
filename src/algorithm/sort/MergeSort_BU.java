package algorithm.sort;

import org.omg.CORBA.IRObject;

public class MergeSort_BU {
	private int[] list;
	private int[] list_support;
	public MergeSort_BU(int[] a)
	{ 
		list = a;
		list_support = new int[a.length];
	}
	private void merge(int low, int mid, int high)
	{
		int i = low;
		int j = mid+1;
		for (int a = low; a<= high;a++)
			list_support[a] = list[a];
		for (int k = low; k <= high; k++)
		{
			if (i > mid) list[k] = list_support[j++];
			else if (j >= high + 1) list[k] = list_support[i++];
			else if (list_support[i] <= list_support[j]) list[k] = list_support[i++];
			else list[k] = list_support[j++];		
		}
	}
	public void sort()
	{//Core
		for (int size = 1;size < list.length;size*=2)
		{
			for (int low= 0;low < list.length-size ;low += size*2)
			{
				/* When integer low is smaller than n-size, we go on;
			 	if not, merge [low...low+size-1] and [low+size,list.length-1];*/
				merge(low, low+size-1, Math.min(low+size*2-1, list.length-1));
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {342,436,42357,423587,563,456,7,7,21};
		MergeSort_BU s = new MergeSort_BU(a);
		s.sort();
		for(int i: a) System.out.println(i);

	}

}

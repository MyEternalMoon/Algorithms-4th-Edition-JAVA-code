package algorithm.sort;

public class MergeSort_UB {
	private int[] list;
	private int[] list_support;
	public MergeSort_UB(int[] a)
	{ 
		list = a;
		list_support = new int[a.length];
	}
	private void merge(int low, int mid, int high)
	{ 
		//Merge [low...mid] and [mid+1...high] on condition that both arrays are sorted.
		int i = low;
		int j = mid+1;
		for (int a = low; a<= high;a++)
			// copy array to support array only when you are merging not initializing.
			list_support[a] = list[a];
		for (int k = low; k <= high; k++)
		{
			//Remember integer mid is the index of the last elements of the former array.
			if (i > mid) list[k] = list_support[j++];
			else if (j > high) list[k] = list_support[i++];
			else if (list_support[i] <= list_support[j]) list[k] = list_support[i++];
			else list[k] = list_support[j++];		
		}
	}
	public void sort()
	{
		int high = list.length-1;
		sort(0,high);
	}
	public void sort(int low, int high)
	{
		if (low >= high)
			return;
		else
		{
			//it needs some efforts here.
			int mid = low + (high-low)/2;
			sort(low, mid);
			sort(mid+1, high);
			merge(low, mid, high);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3214,435,567234,234,123,34,11,11,3};
		MergeSort_UB sort = new MergeSort_UB(a);
		sort.sort();
		for(int i: a){System.out.println(i);}
		
	}

}

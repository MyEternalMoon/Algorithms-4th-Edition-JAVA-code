package algorithm.sort;

public class MergeSortPlus {

	private int[] list;
	private int[] list_support;
	/*New feature here, when the size of sub-array 
	is smaller than a number, do selection sort instead;*/
	private void selection(int i, int j)
	{
		System.out.println("length<=4, using selection sort.");
		for (int a = i;a<j;a++)
		{
			for(int b = i+1; b>i&&list[b]<list[b-1]; b--)
			{
				int temp = list[b];
				list[b] = list[b-1];
				list[b-1] = temp;
			}
		}
	}
	public MergeSortPlus(int[] a)
	{ 
		list = a;
		list_support = new int[a.length];
	}
	private void merge(int low, int mid, int high)
	{ 
		//New feature added here, when already ordered, skip this merge;
		if (list[mid]<list[mid+1]) return; 	
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
			int mid = low + (high-low)/2;
			if (high - low < 3)
				selection(low,high);
			else
			{
				sort(low, mid);
				sort(mid+1, high);
				merge(low, mid, high);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3214,435,567234,234,123,34,11,11,3};
		MergeSortPlus sort = new MergeSortPlus(a);
		sort.sort();
		for(int i: a){System.out.println(i);}
		
	}

}

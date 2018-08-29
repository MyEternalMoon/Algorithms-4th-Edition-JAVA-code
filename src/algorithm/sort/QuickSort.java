package algorithm.sort;

public class QuickSort {
	private static void exchange(int[]a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	private static int partition(int[]a, int m, int n)
	{// This is a bit difficult.
		int val = a[m];
		int i = m;
		int j = n+1;
		while (true)
		{
			while(a[++i]<val){if(i>=n) break;};
			while(a[--j]>val);
			if (i>=j)
				break;
			exchange(a, i, j);
		}
		exchange(a, m, j);
		return j;
	}
	public static void sort(int[]a, int low, int high)
	{
		if (low >= high)
			return;
		int mid = partition(a, low, high);
		sort(a,low,mid);
		sort(a, mid+1, high);
	}
	public static void sort(int[]a)
	{ 
		sort(a, 0, a.length-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {32,465,657,234,78,268,2};
		QuickSort.sort(a);
		for(int i:a)System.out.println(i);
	}

}

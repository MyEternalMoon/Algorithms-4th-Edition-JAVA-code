package algorithm.sort;

public class InsertionSort {
	private static void back(int[] a, int j, int i)
	{
		if (j != i)
		{
			int temp = a[i];
			for(int p = i-1;p>j;p--)
			{
				a[p+1] = a[p];
			}
			a[j] = temp;
		}
	}
	public static void sort(int[] a)
	{
		int N = a.length;
		for (int i = 1; i<N;i++)
		{
			int j = i-1;
			for(;j >=0 && a[i]<=a[j]; j--){}
			back(a, j+1, i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {213,212,3452,213,345,1232,45,56};
		InsertionSort.sort(a);
		for(int i:a) System.out.println(i);
	}

}

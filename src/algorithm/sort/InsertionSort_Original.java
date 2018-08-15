package algorithm.sort;

public class InsertionSort_Original {
	private static void exchange(int[]a, int i,int j)
	{
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	public static void sort(int[]a)
	{
		int N = a.length;
		for(int i =1;i<N;i++)
		{
			for(int j = i-1;j>=0&&a[j]>a[j+1];j--) exchange(a, j+1, j);
		}
	}
	public static void main(String[] args)
	{
		int[] a = {12,34,56,56472,13435,432,67};
		sort(a);
		for(int i:a)System.out.println(i);
	}
}

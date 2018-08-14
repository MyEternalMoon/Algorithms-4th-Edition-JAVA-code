package algorithm.sort;

public class BubbleSort {
	private static void exchange(int[]a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void sort(int[] list)
	{
		int N = list.length;
		while(N > 1)
		{
			for (int i = 0; i< N-1;i++)
			{
				if (list[i] > list[i+1]){exchange(list, i, i+1);}
			}
			N --;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 234,435,657,1234,675,234,879};
		BubbleSort.sort(a);
		for (int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
	}	
}
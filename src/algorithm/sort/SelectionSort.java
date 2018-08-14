package algorithm.sort;

public class SelectionSort {

	public static void sort(int[] list)
	{
		int N = list.length;
		for (int i= 0; i< N-1; i++)
		{
			int min = list[i];
			int index = i;
			for (int j = i+1; j< N; j++)
			{
				if (list[j] < min)
				{
					min = list[j];
					index = j;
				}	
			}
			int temp = min;
			list[index] = list[i];
			list[i] = min;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 3 ,0 ,99, 23, 34, 234,234, 232,235 ,2354};
		SelectionSort.sort(a);
		for (int i=0; i<a.length;i++)
			System.out.println(a[i]);

	}

}

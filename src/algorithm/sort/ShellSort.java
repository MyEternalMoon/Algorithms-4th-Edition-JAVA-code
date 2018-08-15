package algorithm.sort;

public class ShellSort 
{
	private static void exchange(int[] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void sort(int[] a)
	{
		int N = a.length;
		int h = 1;
		while(3*h<N) h = h * 3;//To get suitable h, there are many ways.
		while(h >= 1)
		{
			for (int i = h;i<N;i++)
			{
				for(int j = i-h;j>=0&&a[j+h]<a[j];j-=h) exchange(a, j+h, j);
			}
			h = h/3;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {23,345,56,7658,234,465,23567,234,675,2345678,23,4657,23};
		ShellSort.sort(a);
		for(int i:a)System.out.println(i);
	}

}

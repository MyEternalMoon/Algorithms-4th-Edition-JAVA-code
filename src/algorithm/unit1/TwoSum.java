package algorithm.unit1;

import java.lang.reflect.Array;
import java.util.Scanner;

class BinarySearch
{
	public BinarySearch(){}
	public static int search(int[] a, int low, int high, int key)
	{
		int mid = (low+high)/2;
		while (low <= high)
		{
			if (a[mid] == key) return mid;
			else if (a[mid] < key) low = mid+1;
			else if (a[mid] > key) high = mid-1;
			mid = (low+high)/2;
			//System.out.printf("h:%d, m:%d, l:%d", high,mid,low);
		}
		return -1;
	}
}
public class TwoSum {
	public static int BinaryCount(int a[])
	{
		int n = 0;
		int length = Array.getLength(a)-1;
		for (int i =0;i<length;i++)
		{
			if (BinarySearch.search(a, i, length, -a[i])!= -1) n++;
		}
		return n;
	}
	
	public static int Count(int a[])
	{
		int n = 0;
		int length = Array.getLength(a)-1;
		for (int i=0;i<length;i++)
		{
			for (int j=i+1;j<length;j++)
			{
				if (a[i] + a[j] == 0) n++;
			}
		}
		return n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		int arr[] = new int[n];
		for (int i=0;i<n;i++) arr[i] = a.nextInt();
		System.out.println(TwoSum.BinaryCount(arr));
	}

}

package algorithm.unit1;

import java.util.Scanner;

public class UF_UU_p {
	
	private int N;
	private int a[];
	private int size[];
	
	public UF_UU_p(int n)
	{
		this.N = n;
		this.size = new int[n];
		this.a = new int[n];
		for(int i =0;i<n;i++)
		{
			size[i] = 1;
			a[i] = i;
		}
	}
	
	public boolean connected(int p, int q){return find(p) == find(q);}
	
	public int find(int p){
		while(a[p] != p){p = a[p];}
		return p;
	}
	
	public void Union(int p, int q)
	{
		int p_root = find(p);
		int q_root = find(q);
		if (q_root != p_root)
		{
			if (size[p_root] > size[q_root])
			{
				a[p_root] = q_root;
				size[q_root] += size[p_root];
			}
			else 
			{
				a[q_root] = p_root;
				size[p_root] += size[q_root];
			}
			N --;
		}
	}
	
	public int count(){return this.N;}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UF_UU_p UF = new UF_UU_p(10);
		Scanner u = new Scanner(System.in);
		for (int i=0;i<8;i++)
		{
			UF.Union(u.nextInt(), u.nextInt());
		}
		System.out.println(UF.count());
	}

}

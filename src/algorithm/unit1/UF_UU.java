package algorithm.unit1;

public class UF_UU {
	private int N;
	private int a[];
	
	public UF_UU(int n)
	{
		this.N = n;
		this.a = new int[N];	
		for (int i = 0; i< N; i++){a[i] = i;}
	}
	public boolean connected(int p, int q){return find(p) == find(q);}
	public int find(int p)
	{	
		//Go up to get root;
		while (a[p] != p) p = a[p];
		return p;
	}
	public void connect(int p, int q)
	{	// connect p's root to q's
		int p_root = find(p);
		int q_root = find(q);
		if (p_root != q_root)
		{
			//a[q_root] == q_root, so the right-value can be either;
			a[p_root] = q_root;
		}
		N--;
	}
	public int count() {return this.N;}
}

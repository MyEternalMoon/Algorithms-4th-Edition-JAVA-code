package algorithm.unit1;

public class UF_QF {
	private int N;
	private int[] a;
	
	public UF_QF(int n)
	{
		this.N = n;
		this.a = new int[N];
		for (int i = 0; i < N; i++) a[i] = i;
	}

	public int count(){return this.N;}
	public int find(int p){return a[p];}
	public void connect(int p, int q)
	{
		int temp = a[p];
		if (find(p)!=find(q))
		{	//connect p to q and the identifier is q;
			for (int i=0;i<N;i++)
			{
				if (a[i] == temp) a[i] = a[q];
			}
			N --;
		}
	}
	public boolean connected(int p, int q){ return find(p)==find(q); }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

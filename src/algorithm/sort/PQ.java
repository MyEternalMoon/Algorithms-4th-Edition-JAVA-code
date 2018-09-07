package algorithm.sort;

public class PQ {
	private int PQ[];
	private int N = 0;
	public boolean isEmpty(){
		return N==0;
	}
	public PQ(int size)
	{
		PQ = new int[size+1];
	}
	public void sink(int index)
	{
		if (index*2>N)
			return;
		else 
		{
			if (PQ[index] < PQ[index*2] | PQ[index] < PQ[index*2+1])
			{
				if (PQ[index*2]<PQ[index*2+1])
				{
					int tmp = PQ[index];
					PQ[index] = PQ[index*2+1];
					PQ[index*2+1] = tmp;
					sink(index*2+1);
				}
				else {
					int tmp = PQ[index];
					PQ[index] = PQ[index*2];
					PQ[index*2] = tmp;
					sink(index*2);
				}
				
			}
		}
	}
	public void swim(int index)
	{
		if (index <= 1)
			return;
		else {
			if (PQ[index]>PQ[index/2])
			{
				int tmp = PQ[index];
				PQ[index] = PQ[index/2];
				PQ[index/2] = tmp;
				swim(index/2);
			}
		}
	}
	public void insert(int k)
	{
		PQ[++N] = k;
		swim(N);	
	}
	public int delMAX()
	{
		if (isEmpty()) return -1;
		int ret = PQ[1];
		PQ[1] = PQ[N];
		N--;
		sink(1);
		return ret;		
	}
	
	public static void main(String[] args)
	{
		PQ a = new PQ(10);
		a.insert(46512);
		a.insert(9);
		a.insert(4);
		a.insert(10);
		a.insert(45);
//		a.insert(468541653);
//		a.insert(451);
//		a.insert(516);
		for(int i =0;i<9;i++)
		System.out.println(a.delMAX());
	}
}

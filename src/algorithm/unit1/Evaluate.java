package algorithm.unit1;

import java.util.*;

public class Evaluate {

	public Evaluate(){}
	public static double evaluate(Scanner in)
	{
		Stack<Double> value = new Stack<Double>();
		Stack<String> operation = new Stack<String>();
		while (in.hasNext())
		{
			String i = in.next();
			if (i.equals("+")||i.equals("-")||i.equals("/")||i.equals("*"))
				operation.push(i);
			else if (i.equals("("))
				continue;
			else if (i.equals("\n"))
				return value.pop();
			else if (i.equals(")"))
			{
				String pop = operation.pop();
				Double v = value.pop();
				switch (pop) {
				case "+":
				{
					v = v + value.pop();
					value.push(v);
					break;
				}
				
				case "-":
				{
					v = value.pop() - v;
					value.push(v);
					break;
				}
				case "*":
				{
					v = value.pop() * v;
					value.push(v);
					break;
				}
				case "/":
				{
					v = value.pop() / v;
					value.push(v);
				}
				default:
					value.push(Math.sqrt(v));
				}
			}
			else {
				value.push(Double.parseDouble(i));
			}
		}
		return value.pop();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println(Evaluate.evaluate(in));;
		
	}

}

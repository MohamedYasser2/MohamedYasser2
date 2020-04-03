package eg.edu.alexu.csd.datastructure.stack;

import java.util.EmptyStackException;
import java.util.Scanner;

public class Main {
	 static void menu()
	{
		System.out.println("1:Push");
		System.out.println("2:Pop");
		System.out.println("3:Peek");
		System.out.println("4:Get Size");
		System.out.println("5:Check if Empty");

	}
	
	public static void main(String[] args)
	{
		Stack tester = new Stack();
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			menu();
			int n = scan.nextInt();
			switch(n)
			{
			case 1 : 
				System.out.println("Enter a number to push:");
				int p = scan.nextInt();
				tester.push(p);
				break;
				
			case 2 : 
				try {
					tester.pop();
				} catch (EmptyStackException e) {
					System.out.println("Stack is Empty");
				}	
				break;
			case 3 : 
				try {
					System.out.println(tester.peek());
				}
				catch(EmptyStackException e)
				{
					System.out.println("Stack is Empty");
				}
				break;
			case 4 : 
				int a = tester.size();
				System.out.println(a);
				break;
				
			case 5 :
				if(tester.isEmpty()==true)
				{
					System.out.println("Stack is Empty");
				}
				else {
					System.out.println("Stack not Empty");
				}
				break;
				
			default :
				System.out.print("Wrong Input, Enter again");
				
			}
			System.out.print("\n");
		}
		

	}

}
/*ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = "";
		try {
			String e =test.space(expression);
			String ev = test.infixToPostfix(expression);
			System.out.println(e);
			System.out.println(ev);
			
			int res=test.evaluate(ev);
			 System.out.println(res);
		}
		catch (RuntimeException e)
		{
			System.out.println("Wrong Expression");
		}			Stack test = new Stack();
		*/
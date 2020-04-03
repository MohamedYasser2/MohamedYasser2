package eg.edu.alexu.csd.datastructure.stack;


public class ExpressionEvaluator implements IExpressionEvaluator{
	Stack stk =new Stack();
	/**
	 * check if a character is either + , - , * , / , ) , (
	 * @param op
	 * @return boolean
	 */
	boolean isOp(char op)
	{
		if((op=='+')||(op=='*')||(op=='/')||(op=='-')||(op==')')||(op=='('))
		{
			return true;
		}
		return false;
	}
	/**
	 * takes two float numbers and an operation and return the result
	 * @param t1
	 * @param t2
	 * @param op  return float result
	 */
	float result(float t1,float t2 ,char op)
	{
		float t=0;
		switch(op)
		{
		case '+':
			t=t1+t2;
			break;
		
		case '-':
			t=t2-t1;
			break;
			
		case'/':
			if(t1==0)
			{
				throw new RuntimeException("Wrong Expression");
			}
			t=t2/t1;
			break;
			
		case'*':
			t=t1*t2;
			break;
		}
		return t;
	}
	/**
	 * takes the initial expression and removes all spaces and check if there is dummy zero or errors 
	 * @param expression
	 * @return string 
	 */
	String space(String expression)
	{
		Stack s=new Stack();
		int i=0;
		
		for(i=0;i<expression.length();i++)
		{
			if(expression.charAt(i)!=' ')
			{
				s.push(expression.charAt(i));
			}
		}
		String t="";
		Stack a =new Stack();
		while(!s.isEmpty())
		{
				a.push(s.pop());
		}
		while(!a.isEmpty())
		{
			t+=a.pop();
		}
		for(i=0;i<t.length();i++)
		{
			if((!isOp(t.charAt(i))&&(!Character.isLetterOrDigit(t.charAt(i)))))
					{
				throw new RuntimeException("Wrong Expression");
					}
		}
		i=0;
		if((t.charAt(t.length()-1)=='-')&&(t.charAt(t.length()-1)=='/')&&(t.charAt(t.length()-1)=='+')&&(t.charAt(t.length()-1)=='*'))
		{
			throw new RuntimeException("Wrong Expression");
		}
		for(i=0;i<t.length();i++)
		{
			if((i+1<t.length())&&(Character.isLetter(t.charAt(i)))&&(Character.isLetter(t.charAt(i+1))))
				{
				throw new RuntimeException("Wrong Expression");
				}
		}
		i=0;
		String x="";
		if((t.charAt(0)=='-')&&(Character.isLetterOrDigit(t.charAt(1))))
		{
			String dum="";
			while((i+1<t.length())&&(Character.isLetterOrDigit(t.charAt(i+1))))
			{
				dum +=t.charAt(i+1);
				i++;
			}
			i++;
			x+="(0-";
			x+=dum;
			x+=")";
			dum="";
		}
		if((t.charAt(0)=='+'))
		{
			i+=1;
		}
		for(;i<t.length();i++)
		{
			if((i+1<t.length())&&(t.charAt(i)=='*')&&(t.charAt(i+1)=='*'))
			{
				throw new RuntimeException("Wrong Expression");
			}
			if((i+1<t.length())&&(t.charAt(i)=='/')&&(t.charAt(i+1)=='/'))
			{
				throw new RuntimeException("Wrong Expression");
			}
			if((i+1<t.length())&&(t.charAt(i)==')')&&(t.charAt(i+1)=='('))
			{
				throw new RuntimeException("Wrong Expression");
			}
			if((i+1<t.length())&&(t.charAt(i)=='(')&&(t.charAt(i+1)==')'))
			{
				throw new RuntimeException("Wrong Expression");
			}
			if((i+1<t.length())&&(t.charAt(i)==')')&&(Character.isLetterOrDigit(t.charAt(i+1))))
			{
				throw new RuntimeException("Wrong Expression");
			}
			if((i+1<t.length())&&(t.charAt(i)=='+')&&(t.charAt(i+1)=='+'))
					{
				x+=t.charAt(i);
					i+=1;
					}
			
		else if(((i+1<t.length())&&(isOp(t.charAt(i)))&&((t.charAt(i+1))=='-')))
			{
				String dum="";
				if(((i+2)<t.length())&&(Character.isLetterOrDigit(t.charAt(i+2))))
				{
					x+=t.charAt(i);
					while(((i+2)<t.length())&&(Character.isLetterOrDigit(t.charAt(i+2))))
						{
							dum +=t.charAt(i+2);
							i++;
						}
					i+=1;
					x+="(0-";
					x+=dum;
					x+=")";
					dum="";
				}
				else if((i+2<t.length())&&((t.charAt(i+2)=='(')))
				{
					x+=t.charAt(i);
					while((i+2<t.length())&&(t.charAt(i+2)!=')'))
					{
						dum +=t.charAt(i+2);
						i++;
					}
					i +=2;
					dum+=")";
					x+="(0-";
					x+=dum;
					x+=")";
					dum="";
				}
			}
			else {
				x+=t.charAt(i);
			}
		}
	
		
			Stack p =new Stack();
			for(i=0;i<x.length();i++)
			{
				if(x.charAt(i)!=' ')
				{
					p.push(x.charAt(i));
				}
			}
			String z="";
			Stack o =new Stack();
			while(!p.isEmpty())
			{
				if(((char)p.peek()=='+')||((char)p.peek()=='-')||((char)p.peek()=='/')||((char)p.peek()=='*'))
				{
					o.push(' ');
					o.push(p.pop());
					o.push(' ');
				}
				else
				{
					o.push(p.pop());
				}
			}
			while(!o.isEmpty())
			{
				z+=o.pop();
			}
		return z;
	}
			
	/**
	 * takes a string and index to check the more priority and less priority to convert to postfix	
	 * @param s
	 * @param i
	 * @return boolean
	 */
	boolean check(String s , int i)
	{
		if(stk.size()==0)
		{
			return false;
		}
		Object temp = stk.peek();
		if((char)temp==s.charAt(i))
		{
			return true;
		}
		else if (((char)temp=='/')&&((s.charAt(i)=='+')||(s.charAt(i) == '-') || (s.charAt(i)=='*')))
		{
			return true;
		}
		else if (((char)temp=='*')&&((s.charAt(i)=='+')||(s.charAt(i) == '-') || (s.charAt(i)=='/')))
		{
			return true;
		}
		else if (((char)temp=='+' && s.charAt(i) =='-') || ((char)temp=='-' && s.charAt(i)=='+'))
		{
			return true;
		}
		
		return false;
	}

	@Override
	public String infixToPostfix(String expression) {
		// TODO Auto-generated method stub
		int i =0;
		if((expression.charAt(0)=='*')||(expression.charAt(0)=='/'))
		{
			throw new RuntimeException("Wrong Expression");
		}
		if((expression.charAt(expression.length()-1)=='+')||(expression.charAt(expression.length()-1)=='/')||(expression.charAt(expression.length()-1)=='*')||(expression.charAt(expression.length()-1)=='-'))
		{
			throw new RuntimeException("Wrong Expression");
		}
		
		expression=space(expression);
		
		
		String pfix="" ; 
		for(i=0;i<expression.length();i++)
		{
			if((expression.charAt(i)=='+') ||(expression.charAt(i)=='-') ||(expression.charAt(i)=='/') ||(expression.charAt(i)=='*'))
			{
				if(check(expression,i))
				{	while(check(expression,i))
					{ 
					pfix +=stk.pop();
					pfix +=' ';
					}
					stk.push(expression.charAt(i));
				}
				else
				{
					stk.push(expression.charAt(i));
				}
			}
			else if ((expression.charAt(i)=='('))
			{
				stk.push(expression.charAt(i));
			}
			else if((expression.charAt(i)==')'))
			{
				if(stk.size()==0)
				{
					throw new RuntimeException("Wrong Expression");
				}
				while((char)stk.peek()!='(')
				{
					if(stk.size()==1)
					{
						throw new RuntimeException("Wrong Expression");
					}
					pfix+=stk.pop();
					pfix+=' ';
				}
				stk.pop();
			}
			else if((expression.charAt(i)==' '))
			{}
			else {
				for(i=i;i<expression.length();i++)
				{
					if((expression.charAt(i)!=' ')&&(expression.charAt(i)!=')')&&(expression.charAt(i)!='('))
					{
						pfix += expression.charAt(i);
					}
					else
					{
						i--;
						break;
					}
				}
				pfix+=' ';
				}
				
			}
		
		
		while(!stk.isEmpty())
		{
			pfix+=stk.pop();
			pfix+=' ';
		}
		i=0;
		for(i=0;i<pfix.length();i++)
		{
			if((pfix.charAt(i)=='(')||(pfix.charAt(i)==')'))
			{
				throw new RuntimeException("Wrong Expression");
			}
		}
		return pfix;
	}

	@Override
	public int evaluate(String expression) {
		// TODO Auto-generated method stub
			String word="";
			int i =0;
			float t1,t2,t=0;
			for(i=0;i<expression.length();i++)
			{
				if(Character.isDigit(expression.charAt(i)))
				{
					word += expression.charAt(i);
				}
				else
				{
					if(word!="")
						{stk.push(word);}
					word="";
					if((expression.charAt(i)=='+')||(expression.charAt(i)=='-')||(expression.charAt(i)=='/')||(expression.charAt(i)=='*'))
					{
						char op=expression.charAt(i);
						t1=Float.parseFloat(stk.pop().toString());
						t2=Float.parseFloat(stk.pop().toString());
						t=result(t1,t2,op);
						stk.push(t);
					}
				}
			}
			float ans = Float.parseFloat(stk.pop().toString());
			int res =(int)ans;
			return res;
		}
	}



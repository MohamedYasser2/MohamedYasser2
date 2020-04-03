package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpressionEvaluatorTest {

	@Test
	void test() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		
		String expression = "2 + 3 * 4 ";
		String answer ="2 3 4 * + ";
		int res=14;
		String ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		assertEquals(res,test.evaluate(ev));
		
		 expression = "(1 + 2) * 7";
		 answer ="1 2 + 7 * ";
		 res=21;
		 ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		assertEquals(res,test.evaluate(ev));
		
		 expression = "a * b + 5 ";
		 answer ="a b * 5 + ";
		 ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		
		expression = "a * b / c";
		 answer ="a b * c / ";
		 ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		
		expression = "(a / (b - c + d)) * (e - a) * c";
		 answer ="a b c - d + / e a - * c * ";
		 ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		 
		expression = "a / b - c + d * e - a * c";
		 answer ="a b / c - d e * + a c * - ";
		 ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		
		
		expression = "a * (b + c) * d";
		 answer ="a b c + * d * ";
		 ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		
		 expression = "-100++300 - -400*-(2*4)";
		 answer ="0 100 - 300 + 0 400 - 0 2 4 * - * - ";
		 res=-3000;
		 ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		assertEquals(res,test.evaluate(ev));
		
		 expression = "(4+8)*(6-5)/((3-2)*(2+2))";
		 answer ="4 8 + 6 5 - * 3 2 - 2 2 + * / ";
		 res=3;
		 ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		assertEquals(res,test.evaluate(ev));
		
		 expression = "-5* -(2+7)";
		 answer ="0 5 - 0 2 7 + - * ";
		 res=45;
		 ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		assertEquals(res,test.evaluate(ev));
		
		 expression = "43  5  / - 23 * - (2-3)";
		 answer ="435 0 23 - / 0 2 3 - - * ";
		 res=-18;
		 ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		assertEquals(res,test.evaluate(ev));
		
		expression = "9-(-3 + 8)";
		 answer ="9 0 3 - 8 + - ";
		 res=4;
		 ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		assertEquals(res,test.evaluate(ev));
		
		expression = "-a + -b / -(a+c)";
		 answer ="0 a - 0 b - 0 a c + - / + ";
		 ev=test.infixToPostfix(expression);
		assertEquals(answer,ev);
		
		String expression1="2 3 4 * +";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(expression1));
		
		
		String expression2="(2+3)+(3-4";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(expression2));
		
		String expression3="2 3 4()";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(expression3));
		
		String expression4="&*3-%+2$";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(expression4));
		
		String expression5="2/0";
		assertThrows(RuntimeException.class,() -> test.evaluate(expression5));
		
		String expression6="a   b + c";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(expression6));
		
		String expression7="2**4";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(expression7));
		
		String expression8="4+3//2";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(expression8));
		
		String expression9="(2+4)(5*2)";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(expression9));
		
		String e1="(4+3)2";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(e1));
		
		String e2="(a*c)b";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(e2));
		
		String e3="/5+3";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(e3));
		
		String e4="* 6+ 5";
		assertThrows(RuntimeException.class,() -> test.infixToPostfix(e4));
		
		
		
		
	}

}

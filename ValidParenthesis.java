import java.util.Stack;

/**
 * 
 */

/**
 * @author shivangisingh
 *Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParenthesis {

	/**
	 * @param args
	 */
	
	public static boolean checkValid(String s) {
//		Assuming that we only get [].{},() kinds of braces
		
		Stack<Character> leftStack = new Stack<Character>();
		System.out.println(s.length()+" Length");
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
//			Also assuming that we dont have invalid charcaters in there
			if(ch=='{'||ch=='['||ch=='(') {
				leftStack.push(ch);
				System.out.println(leftStack.peek()+ "ADDED");
				continue;
			}
			
				if(leftStack.isEmpty()){
					return false;
				}
				else if(ch==']' && leftStack.peek()!='[') {
					return false;
				}
				else if(ch=='}' && leftStack.peek()!='{') {
					return false;
				}
				else if(ch==')' && leftStack.peek()!='(') {
					return false;
				}

		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkValid("{}[]"));
		System.out.println(checkValid("{}[]{[[[]]]]}"));

	}

}

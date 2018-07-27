import java.util.Stack;

public class ValidParentheses {
  public Character inverse( Character c ) {
    Character result;
    switch ( c ) {
      case '}':
        result = '{';
        break;
      case ']':
        result = '[';
          break;
      case ')':
        result = '(';
        break;
      default:
        result = null;
        break;
    }
    return result;
  }
  public boolean isValid(String s) {
    Stack<Character> strStack = new Stack<>();
    for( int i = 0 ; i < s.length() ; i++ ) {
      Character c = s.charAt(i);
      if( strStack.isEmpty() ) {
        if( c == '}' || c == ']' || c == ')' ) {
          return false;
        }
        strStack.push(c);
      } else if( c == '{' || c == '[' || c == '(' ) {
        strStack.push(c);
      } else {
        Character strPeek = strStack.peek();
        if( strPeek == inverse(c) ) {
          strStack.pop();
        } else {
          return false;
        }
      }
    }

    return strStack.isEmpty();
  }

  public static void main(String[] args) {
    ValidParentheses validParentheses = new ValidParentheses();
    System.out.println(validParentheses.isValid("{[]}"));
    System.out.println(validParentheses.isValid("([)]"));
    System.out.println(validParentheses.isValid("()"));
  }
}

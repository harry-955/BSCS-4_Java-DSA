/* Method-2: First check if incoming symbol is any operand => directly add in postfix expression
* but if it is operator then perform stack operations accordingly
*/

package stack;

import java.util.Scanner;
import java.util.Stack;

public class Postfix_2 {

  static int prec(char c) {
    if (c == '^') {
      return 3;
    } else if (c == '*' || c == '/') {
      return 2;
    } else if (c == '+' || c == '-') {
      return 1;
    } else {
      return -1;
    }
  }

  static String infixToPostfix(String infix) {
    Stack<Character> stack = new Stack<>();
    String res = "";

    for (int i = 0; i < infix.length(); i++) {
      char ch = infix.charAt(i);
      if (
        (ch >= 'a' && ch <= 'z') ||
        (ch >= 'A' && ch <= 'Z') ||
        (ch >= '0' && ch <= '9')
      ) {
        res += ch;
      } else if (ch == '(') {
        stack.push(ch);
      } else if (ch == ')') {
        while (!stack.empty() && stack.peek() != '(') {
          res += stack.pop();
        }
        if (!stack.empty()) {
          stack.pop();
        }
      } else {
        while (!stack.empty() && prec(ch) <= prec(stack.peek())) {
          res += stack.pop();
        }
        stack.push(ch);
      }
    }
    while (!stack.empty()) {
      res += stack.pop();
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter infix expression: ");
    String s = sc.nextLine();
    System.out.println("Postfix expression: " + infixToPostfix(s));
    
    /* -----------For default Inputs---------- */
    // String str = "K+L-M*N+(O^P)*W/U/V*T+Q"; // ^J^A
    // System.out.println("Infix Expression: " + str);
    // System.out.println("Postfix expression: " + infixToPostfix(str));

    // String str2 = "2+4-5*6+(9^1)*4/5/7*8+3"; // ^J^A
    // System.out.println("\nInfix Expression: " + str2);
    // System.out.println("Postfix expression: " + infixToPostfix(str2));
    sc.close();
  }
}

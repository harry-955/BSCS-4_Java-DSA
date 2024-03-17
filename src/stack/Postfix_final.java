/* -----------Final and fully optimized Postfix Calculation using stack------------ */

package stack;

// import java.util.Scanner;
import java.util.Stack;

public class Postfix_final {

  public static int prec(char c) {
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

  public static String infixToPostfix(String infix) {
    Stack<Character> stack = new Stack<>(); // using built in stack, user defined can also be used
    String postfix = "";

    for (int i = 0; i < infix.length(); i++) {
      char ch = infix.charAt(i);
      if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
        if (ch == '^') { // ^ has highest precedence, directly push even if top = ^
          stack.push(ch);
        } else { // for other operators with Associativity L-to-R
          while (!stack.empty() &&
              stack.peek() != '(' &&
              prec(ch) <= prec(stack.peek())) {
            // if incoming op has less or equal precedence than op on top of stack
            postfix += stack.pop(); // pop and add into postfix untill incoming op precedence has become greater
          }
          stack.push(ch);
        }
      } else if (ch == '(') {
        stack.push(ch);
      } else if (ch == ')') {
        while (stack.peek() != '(') { // pop and add in postfix untill '(' is found
          postfix += stack.pop();
        }
        stack.pop(); // just remove the '(' from stack without adding in postfix
      } else { // for any operand (including digits and alphabets)
        postfix += ch;
      }
    } // end of for loop
    // pop and add all operators from stack to postfix exp untill stack has gone empty
    while (!stack.empty()) {
      postfix += stack.pop();
    }
    return postfix;
  }

  public static void main(String[] args) {
    /* -------------For user Input------------ */
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter infix expression:");
    // String s = sc.nextLine();
    String str = "K+L-M*N+(O^P)*W/U/V*T+Q^J^A";
    System.out.println("Infix Expression: " + str);
    System.out.println("Postfix expression: " + infixToPostfix(str));
    // sc.close();
  }
}

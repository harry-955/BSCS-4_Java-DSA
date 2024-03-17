
/* -----------Final and fully optimized Prefix Calculation using stack------------ */
package stack;

import java.util.Scanner;
import java.util.Stack;

public class Prefix_final {

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

  public static String infixToPrefix(String infix) {
    Stack<Character> stack = new Stack<>();
    String reverse, postfix, prefix;
    reverse = postfix = prefix = "";
    for (int i = infix.length() - 1; i >= 0; i--) {
      reverse += infix.charAt(i);
    }

    for (int i = 0; i < reverse.length(); i++) {
      char ch = reverse.charAt(i);
      if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
        if (ch == '^') { // for power, Associativity R-to-L
          while (!stack.empty() &&
              stack.peek() != '(' &&
              prec(ch) == prec(stack.peek())) {
            postfix += stack.pop(); // pop and add in postfix even if top = ^ (same precedence)
          }
          stack.push(ch); // if precedence is high, directly push
        } else { // for other operators, Associativity L-to-R
          while (!stack.empty() &&
              stack.peek() != '(' &&
              prec(ch) < prec(stack.peek())) {
            postfix += stack.pop(); // pop untill and op of same or grater precedence has occured
          }
          stack.push(ch); // if precedence is high or equal, directly push in stack
        }
      } else if (ch == ')') {
        stack.push(ch); // opposite rule as compared to postfix
      } else if (ch == '(') {
        while (stack.peek() != ')') { // pop and add in postfix untill ')' is found
          postfix += stack.pop();
        }
        stack.pop(); // just remove the ')' from stack without adding in postfix
      } else { // for any operand (including digits and alphabets)
        postfix += ch;
      }
    } // end of for loop
    // pop all operators from stack to postfix exp
    while (!stack.empty()) {
      postfix += stack.pop();
    }
    // Reverse the resultant postfix expression to get the prefix
    for (int i = postfix.length() - 1; i >= 0; i--) {
      prefix += postfix.charAt(i);
    }
    return prefix;
  }

  public static void main(String[] args) {
    /* -------------For user Input------------ */
    Scanner sc = new Scanner(System.in);
    // System.out.println("Enter infix expression:");
    // String str = sc.nextLine();
    
    String str = "K+L-M*N+(O^P)*W/U/V*T+Q"; // ^J^A
    System.out.println("Infix Expression: " + str);
    System.out.println("Prefix expression: " + infixToPrefix(str));
    sc.close();
  }
}
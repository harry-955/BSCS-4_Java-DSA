package stack;

import java.util.Scanner;
import java.util.Stack;

public class Prefix_2 {

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

  static String infixToPrefix(String infix) {
    Stack<Character> stack = new Stack<>();
    String res, reverse, prefix;
    res = reverse = prefix = "";
    for (int i = infix.length() - 1; i >= 0; i--) {
      reverse += infix.charAt(i);
    }

    for (int i = 0; i < reverse.length(); i++) {
      char ch = reverse.charAt(i);
      if ((ch >= 'a' && ch <= 'z') ||
          (ch >= 'A' && ch <= 'Z') ||
          (ch >= '0' &&
              ch <= '9')) {
        res += ch;
      } else if (ch == ')') {
        stack.push(ch);
      } else if (ch == '(') {
        while (!stack.empty() && stack.peek() != ')') {
          res += stack.pop();
        }
        if (!stack.empty()) {
          stack.pop();
        }
      } else { // for all operators
        // if operator is ^, Associativity R-to-L
        if (ch == '^') {
          while (!stack.empty() &&
              stack.peek() != ')' &&
              prec(ch) == prec(stack.peek())) {
            res += stack.pop();
          }
          stack.push(ch); // directly push if prec of ^ is higher than prec of stack.peek()
        } else { // for all other operators with Associativity L-to-R
          while (!stack.empty() &&
              stack.peek() != ')' &&
              prec(ch) < prec(stack.peek())) {
            res += stack.pop();
          }
          stack.push(ch); // directly push if prec of operator is higher than prec of stack.peek()
        }
      }
    }
    while (!stack.empty()) {
      res += stack.pop();
    }
    // Reverse the result postfix
    for (int i = res.length() - 1; i >= 0; i--) {
      prefix += res.charAt(i);
    }
    return prefix;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter infix expression: ");
    String str = sc.nextLine();
    System.out.println("Prefix expression: " + infixToPrefix(str));

    // String str = "K+L-M*N+(O^P)*W/U/V*T+Q"; // ^J^A
    // System.out.println("Infix Expression: " + str);
    // System.out.println("Prefix expression: " + infixToPrefix(str));

    // String str2 = "2+4-5*6+(9^1)*4/5/7*8+3"; // ^J^A
    // System.out.println("\nInfix Expression: " + str2);
    // System.out.println("Prefix expression: " + infixToPrefix(str2));
    sc.close();
  }
}

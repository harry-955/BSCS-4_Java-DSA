/*
 * Try-1: Using a separate class for Postfix expression which has 
 * Attributes - postfix expression 
 * Method - Operator's Precedence Checker
 * Also optimized it in Postfix_final and Postfix_2, can be check after this
 */

package stack;

// import java.util.Scanner;

class Postfix_Class {
  public String postfixExp;

  Postfix_Class() {
    postfixExp = "";
  }

  public String checkPrecedence(char expChar, char stackChar) {
    if ((expChar == '+' || expChar == '-') &&
        (stackChar == '+' || stackChar == '-')) {
      return "same";
    } else if ((expChar == '*' || expChar == '/') &&
        (stackChar == '*' || stackChar == '/')) {
      return "same";
    } else if (expChar == '^' && stackChar == '^') {
      return "same";
    } else if ((expChar == '+' || expChar == '-') &&
        (stackChar == '*' || stackChar == '/' || stackChar == '^')) {
      return "low";
    } else if ((expChar == '*' || expChar == '/' || stackChar == '^') &&
        (stackChar == '+' || stackChar == '-')) {
      return "high";
    } else if ((expChar == '/' || expChar == '*') && stackChar == '^') {
      return "low";
    } else if (expChar == '^' && (stackChar == '/' || stackChar == '*')) {
      return "high";
    } else {
      System.out.println("Precedence issue");
      return "";
    }
  }

  public static void main(String[] args) {
    // System.out.print("Enter Infix Expression: ");
    // Scanner input = new Scanner(System.in);
    // String exp = input.nextLine();
    String exp = "K+L-M*N+(O^P)*W/U/V*T+Q^J^A";

    Postfix_Class postfix = new Postfix_Class();
    HStack stack = new HStack(exp.length() / 2); // max operators in an expression can be half of length of exp

    System.out.println("\nIteration : Input : Postfix Expression\n");

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);
      if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        if (stack.isEmpty() || stack.peek().charAt(0) == '(') {
          stack.push(ch);
        } else {
          String precedence = postfix.checkPrecedence(ch, stack.peek().charAt(0));
          if (precedence.equals("same")) {
            char topChar = stack.peek().charAt(0);
            postfix.postfixExp += topChar;
            stack.pop();
            stack.push(ch);
          } else if (precedence.equals("high")) {
            stack.push(ch);
          } else if (precedence.equals("low")) {
            char topChar = stack.peek().charAt(0);
            // char topChar = peek();
            // boolean isLow = true;
            while (true) {
              postfix.postfixExp += topChar;
              stack.pop();
              if (!stack.isEmpty()) {
                topChar = stack.peek().charAt(0);
                if (postfix.checkPrecedence(ch, topChar).equals("high")) {
                  stack.push(ch);
                  break;
                } else if (postfix.checkPrecedence(ch, topChar).equals("same")) {
                  postfix.postfixExp += topChar;
                  stack.pop();
                  stack.push(ch);
                  break;
                }
              } else {
                stack.push(ch);
                break;
              }
            }
          }
        }
      } else if (ch == '^' || ch == '(') {
        if (stack.isFull()) {
          System.out.println("Stack overflow");
        } else {
          stack.push(ch);
        }
      } else if (ch == ')') {
        while (stack.peek().charAt(0) != '(') {
          postfix.postfixExp += stack.peek().charAt(0);
          stack.pop();
        }
        stack.pop();
      } else {
        postfix.postfixExp += ch;
      }
      System.out.print("Iteration " + (i + 1) + " : " + ch + " : ");
      // for(int j=0; j<=top ; j++){
      // System.out.print(stack[j] + " ");
      // }
      System.out.println(postfix.postfixExp);
    }
    while (!(stack.isEmpty())) {
      postfix.postfixExp += stack.peek().charAt(0);
      stack.pop();
    }
    System.out.println("\nPostfix Expression: " + postfix.postfixExp + "\n");
    // input.close();
  }
}
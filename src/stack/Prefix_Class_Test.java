// Tried to interchange '(' and ')' while reversing the string and then followed same rules of postfix

package stack;

// import java.util.Scanner;

class Prefix_Class_Test {

  public String givenExp;
  public String reverseExp;
  public String postfixExp;
  public String prefixExp;

  Prefix_Class_Test(String givenExp) {
    this.givenExp = givenExp;
    this.reverseExp = "";
    for (int i = this.givenExp.length() - 1; i >= 0; i--) {
      this.reverseExp += this.givenExp.charAt(i);
    }
    System.out.println("Reversed Expression: " + this.reverseExp + "\n");
    postfixExp = "";
    prefixExp = "";
  }

  public String checkPrecedence(char expChar, char stackChar) {
    if (
      (expChar == '+' || expChar == '-') &&
      (stackChar == '+' || stackChar == '-')
    ) {
      return "same";
    } else if (
      (expChar == '*' || expChar == '/') &&
      (stackChar == '*' || stackChar == '/')
    ) {
      return "same";
    } else if (expChar == '^' && stackChar == '^') {
      return "same";
    } else if (
      (expChar == '+' || expChar == '-') &&
      (stackChar == '*' || stackChar == '/' || stackChar == '^')
    ) {
      return "low";
    } else if (
      (expChar == '*' || expChar == '/' || stackChar == '^') &&
      (stackChar == '+' || stackChar == '-')
    ) {
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
    // String givenExp = input.nextLine();
    String givenExp = "K+L-M*N+(O^P)*W/U/V*T+Q";
    System.out.println("Given Expression " + givenExp);

    Prefix_Class_Test prefix = new Prefix_Class_Test(givenExp);
    Stack stack = new Stack(prefix.givenExp.length() / 2);

    System.out.println("\nIteration : Input : Postfix Expression\n");

    for (int i = 0; i < prefix.reverseExp.length(); i++) {
      char ch = prefix.reverseExp.charAt(i);
      // For operators with L to R Associativity and ')' paranthesis
      if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == ')') {
        if (stack.isEmpty() || ch == ')') {
          stack.push(ch);
        } else {
          String precedence = prefix.checkPrecedence(
            ch,
            stack.peek().charAt(0)
          );
          // if incoming op has high or same precedence
          if (precedence.equals("same") || precedence.equals("high")) {
            stack.push(ch);
          }
          // if incoming op has lower precendence pop all operators untill a same or low precendence is found
          else if (precedence.equals("low")) {
            char topChar = stack.peek().charAt(0); // get char at top
            while (true) {
              prefix.postfixExp += topChar; //
              stack.pop();
              // if stack is not empty after pop
              if (!stack.isEmpty()) {
                topChar = stack.peek().charAt(0); // get new char at top and check precendence again
                // if new precendence of our char is higher than top char then simply push our char
                if (
                  prefix.checkPrecedence(ch, topChar).equals("high") ||
                  prefix.checkPrecedence(ch, topChar).equals("same")
                ) {
                  stack.push(ch);
                  break; // exit from loop
                }
              } else { // if stack is empty now
                stack.push(ch);
                break;
              }
            }
          }
        }
      }
      // For character with R-to-L associativity
      else if (ch == '^') {
        if (stack.isEmpty()) {
          stack.push(ch);
        } else if (stack.peek().charAt(0) == ')') {
          stack.push(ch);
        } else {
          // if stack is not empty and top != ')' then check precedence with operator on top
          char topChar = stack.peek().charAt(0); // get char from top
          String precedence = prefix.checkPrecedence(ch, topChar); // get precedence of current op w.r.t. op on top
          // if precedence is high then simply push the current op on stack
          if (precedence.equals("high")) {
            stack.push(ch);
          }
          // if precendence is same than pop the op on top and then push current op on stack
          else if (precedence.equals("same")) {
            prefix.postfixExp += topChar; // add top op in postfix expression
            stack.pop();
            stack.push(ch);
          }
          // if precedence is low than remove op on top one-by-one untill an op of same or low precedence is found
          else if (precedence.equals("low")) {
            topChar = stack.peek().charAt(0);
            while (true) {
              prefix.postfixExp += topChar; // add char to postfix
              stack.pop(); // pop top char
              // if stack is not empty after pop
              if (!stack.isEmpty()) {
                topChar = stack.peek().charAt(0); // get new char at top and check precendence again
                // if new precendence of our char is higher than char then simply push our char
                if (prefix.checkPrecedence(ch, topChar).equals("high")) {
                  stack.push(ch); // simply add the current char '^' in postfix expression
                  break; // exit from loop
                }
                // if new precendence of our char is same as top than follow associativity
                else if (prefix.checkPrecedence(ch, topChar).equals("same")) {
                  prefix.postfixExp += topChar;
                  stack.pop();
                  stack.push(ch);
                }
              } else { // if stack is empty now
                stack.push(ch);
                break;
              }
            }
          }
        }
      } else if (ch == '(') {
        char topChar = stack.peek().charAt(0);
        while (true) {
          prefix.postfixExp += topChar;
          stack.pop();
          topChar = stack.peek().charAt(0);
          if (topChar == ')') {
            stack.pop();
            break;
          }
        }
      } else {
        prefix.postfixExp += ch;
      }
      //   } else if (ch == ')') {
      //     while (stack.peek().charAt(0) != '(') {
      //       prefix.postfixExp += stack.peek().charAt(0);
      //       stack.pop();
      //     }
      //     stack.pop();
      //   } else {
      //     prefix.postfixExp += ch;
      //   }
      System.out.print("Iteration " + (i + 1) + " : " + ch + " : ");
      if (stack.isEmpty()) {
        System.out.print(" ");
      } else {
        for (int j = 0; j <= stack.top; j++) {
          System.out.print(stack.stack[j] + " ");
        }
      }
      System.out.println(" : " + prefix.postfixExp);
    }
    while (!(stack.isEmpty())) {
      prefix.postfixExp += stack.peek().charAt(0);
      stack.pop();
    }
    System.out.println(
      "\nPostfix Expression after loop: " + prefix.postfixExp + "\n"
    );

    for (int j = prefix.postfixExp.length() - 1; j >= 0; j--) {
      prefix.prefixExp += prefix.postfixExp.charAt(j);
    }
    System.out.println("Final Prefix Expression: " + prefix.prefixExp);
    // input.close();
  }
}

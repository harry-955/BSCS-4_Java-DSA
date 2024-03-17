class Postfix {

  public static String exp = "K+L-M*N+(O^P)*W/U/V*T+Q^J^A";
  public static String postfixExp = "";
  public static int size = exp.length() / 2;
  public static char[] stack = new char[size];
  public static int top = -1;

  public static boolean isEmpty() {
    if (top == -1) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean isFull() {
    if (top + 1 == size) {
      return true;
    } else {
      return false;
    }
  }

  public static void push(char ch) {
    if (isFull()) {
      System.out.println("Stack Overflow");
    } else {
      top += 1;
      stack[top] = ch;
    }
  }

  public static void pop() {
    if (isEmpty()) {
      System.out.println("Stack Underflow !");
    } else {
      top -= 1;
    }
  }

  public static char peek() {
    if (isEmpty()) {
      System.out.println("stack empty");
      return ' ';
    }
    return stack[top];
  }

  public static String checkPrecedence(char expChar, char stackChar) {
    if ((expChar == '+' || expChar == '-') &&
        (stackChar == '+' || stackChar == '-')) {
      return "same";
    } else if ((expChar == '*' || expChar == '/') &&
        (stackChar == '*' || stackChar == '/')) {
      return "same";
    } else if ((expChar == '+' || expChar == '-') &&
        (stackChar == '*' || stackChar == '/' || stackChar == '^')) {
      return "low";
    } else if ((expChar == '*' || expChar == '/' || stackChar == '^') &&
        (stackChar == '+' || stackChar == '-')) {
      return "high";
    } else if ((expChar == '/' || expChar == '*') && stackChar == '^') {
      return "low";
    } else {
      System.out.println("Precedence issue");
      return "";
    }
  }

  public static void main(String[] args) {
    System.out.println("\nOrginal Expression: " + exp + "\n");
    System.out.println("\nIteration : Input : Postfix Expression\n");
    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);
      if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        if (isEmpty() || stack[top] == '(') {
          push(ch);
        } else {
          String precedence = checkPrecedence(ch, stack[top]);
          if (precedence.equals("same")) {
            char topChar = peek();
            postfixExp += topChar;
            pop();
            push(ch);
          } else if (precedence.equals("high")) {
            push(ch);
          } else if (precedence.equals("low")) {
            char topChar = peek();
            // char topChar = peek();
            // boolean isLow = true;
            while (true && !isEmpty()) {
              postfixExp += topChar;
              pop();
              if (!isEmpty()) {
                topChar = peek();
                if (checkPrecedence(ch, topChar).equals("high")) {
                  push(ch);
                  break;
                } else if (checkPrecedence(ch, topChar).equals("same")) {
                  postfixExp += topChar;
                  pop();
                  push(ch);
                  break;
                }
              } else {
                push(ch);
                break;
              }
            }
          }
        }
      } else if (ch == '^' || ch == '(') {
        if (isFull()) {
          System.out.println("Stack overflow");
        } else {
          push(ch);
        }
      } else if (ch == ')') {
        while (peek() != '(') {
          postfixExp += peek();
          pop();
        }
        pop();
      } else {
        postfixExp += ch;
      }
      System.out.print("Iteration " + (i + 1) + " : " + ch + " : ");
      // for(int j=0; j<=top ; j++){
      // System.out.print(stack[j] + " ");
      // }
      System.out.println(postfixExp);
    }
    while (!(isEmpty())) {
      postfixExp += stack[top];
      pop();
    }
    System.out.println("\nPostfix Expression: " + postfixExp + "\n");
  }
}

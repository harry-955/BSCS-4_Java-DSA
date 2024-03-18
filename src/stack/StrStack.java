package stack;

import java.util.Scanner;

class StrStack extends HStack {

  Scanner input = new Scanner(System.in);

  String[] stack;

  StrStack(int size) {
    super(size);
    stack = new String[size];
  }

  public void push() {
    if (top == this.stack.length - 1) {
      System.out.println("Stack Overflow !");
    } else {
      System.out.print("Enter Item to push: ");
      String item = input.nextLine();
      top++;
      this.stack[top] = item;
      // System.out.println("Push Successful");
    }
  }

  public String peek() {
    if (isEmpty()) {
      System.out.println("stack empty");
      return null;
    }
    return this.stack[top];
  }

  public void display() {
    if (top == -1) {
      System.out.println("No Elements in stack to display");
    } else {
      for (int i = top; i >= 0; i--) {
        if (i == top) {
          System.out.println("Index " + i + ": " + stack[i] + " (Top)");
        } else {
          System.out.println("Index " + i + ": " + stack[i]);
        }
      }
      // System.out.println("Display Successful");
    }
  }
}

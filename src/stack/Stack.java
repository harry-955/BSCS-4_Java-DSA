package stack;

import java.util.Scanner;

public class Stack {

  Scanner input = new Scanner(System.in);
  String[] stack;

  public int size;
  public int top;

  Stack(int size) {
    this.size = size;
    stack = new String[size];
    top = -1;
    System.out.println("Stack of Size " + this.size + " initiated...\n");
  }

  public void pop() {
    if (top == -1) {
      System.out.println("Stack underflow !");
    } else {
      // System.out.println("Element: " + stack[top] + " Top: " + top);
      top--;
      // System.out.println("Pop Successfull");
    }
  }

  // Push with no parameter asks for input --> Type String

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

  //   Push with one parameter --> for char type

  public void push(char item) {
    if (top == this.stack.length - 1) {
      System.out.println("Stack Overflow !");
    } else {
      top++;
      this.stack[top] = String.valueOf(item);
      // System.out.println("Push Successful");
    }
  }

  public void push(String item) {
    if (top == this.stack.length - 1) {
      System.out.println("Stack Overflow !");
    } else {
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

  /* -------To Display the current elements in stack--------- */
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

  public boolean isEmpty() {
    if (top == -1) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isFull() {
    if (top + 1 == size) {
      return true;
    } else {
      return false;
    }
  }

  public int count() {
    if (isEmpty()) {
      return -1;
    } else {
      return top + 1;
    }
  }
}

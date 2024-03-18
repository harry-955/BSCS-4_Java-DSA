package stack;
import java.util.Scanner;
/*
 * Menu Based Program to check the working of various methods of HStack class
 */
public class StackMenu {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // int size = 10; // if you want default size of stack
    System.out.print("Enter Size of Stack: ");
    int size = scanner.nextInt();

    HStack stack = new HStack(size);
    int ch = 0;
    while (ch != 8) {
      System.out.println("\n1: Push");
      System.out.println("2: Pop");
      System.out.println("3: Peek");
      System.out.println("4: Display Stack");
      System.out.println("5: Check if stack is full");
      System.out.println("6: Check if stack is empty");
      System.out.println("7: Count Elements in stack");
      System.out.println("8: Exit");
      System.out.print("\nInput Choice: ");

      ch = scanner.nextInt();
      switch (ch) {
        case 1: // push
          stack.push();
          break;
        case 2: // pop
          stack.pop();
          break;
        case 3: // peek
          String peekElement = stack.peek();
          if (peekElement != null) {
            System.out.println("Character " + peekElement);
          }
          break;
        case 4:
          stack.display(); // display
          break;
        case 5: // isFull
          if (stack.isFull()) {
            System.out.println("Yes, Stack is Full");
          } else {
            System.out.println("No, Stack is Not Full");
          }
          break;
        case 6: // isEmpty
          if (stack.isEmpty()) {
            System.out.println("Yes, Stack is Empty");
          } else {
            System.out.println("No, Stack is Not Empty");
          }
          break;
        case 7: // counter
          int count = stack.count();
          if (count == -1) {
            System.out.println("No Element in Stack");
          } else {
            System.out.println("Element(s) in Stack: " + count);
          }
          break;
        case 8: // exit
          System.out.println("Happy Coding, .....Good Bye Harry...");
          break; // exit from switch
        default:
          System.out.println("Invalid Input !");
          continue;
      }
    }
    scanner.close();
  }
}

package stack;
import java.util.Scanner;
/*
 * To check the working of various stack methods.
 */
public class StackTest {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int size = 10;
    System.out.print("Enter Size of Stack: ");
    size = scanner.nextInt();

    // while (true) {
    //   try {
    //     System.out.print("Enter Size of Stack: ");
    //     size = scanner.nextInt();
    //     break;
    //   } catch (Exception ex) {
    //     System.out.println("Invalid Input");
    //     continue;
    //     // ex.printStackTrace();
    //   }
    // }
    Stack stack = new Stack(size);
    int ch;
    while (true) {
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
        case 1:
          stack.push();
          break;
        case 2:
          stack.pop();
          break;
        case 3:
          String peekElement = stack.peek();
          if (peekElement != null) {
            System.out.println("Character " + peekElement);
          }
          break;
        case 4:
          stack.display();
          break;
        case 5:
          if (stack.isFull()) {
            System.out.println("Yes, Stack is Full");
          } else {
            System.out.println("No, Stack is Not Full");
          }
          break;
        case 6:
          if (stack.isEmpty()) {
            System.out.println("Yes, Stack is Empty");
          } else {
            System.out.println("No, Stack is Not Empty");
          }
          break;
        case 7:
          int count = stack.count();
          if (count == -1) {
            System.out.println("No Element in Stack");
          } else {
            System.out.println("Element(s) in Stack: " + count);
          }
          break;
        case 8:
          System.out.println("Good Bye Harry...");
          break; // exit from switch
        default:
          System.out.println("Invalid Input !");
          continue;
      }
      if (ch == 8) {
        break; // exit from loop
      }
    }
    scanner.close();
  }
}

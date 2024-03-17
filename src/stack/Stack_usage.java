package stack;
import java.util.Scanner;

public class Stack_usage {
    static int top = -1;
    static int[] stk = new int[3];

    public static void push(int item) {
        System.out.println("Top: " + top + " length: " + stk.length);
        if (top == stk.length - 1) {
            System.out.println("Stack Overflow !");
        } else {
            top++;
            stk[top] = item;
            System.out.println("Push Successful");
        }
    }

    public static void pop() {
        if (top == -1) {
            System.out.println("Stack underflow !");
        } else {
            System.out.println("Element: " + stk[top] + " Top: " + top);
            top--;
            System.out.println("Pop Successful");
        }
    }

    public static void display() {
        if (top == -1) {
            System.out.println("Stack underflow !");
        } else {
            for (int i = top; i >= 0; i--) {
                if (i == top) {
                    System.out.println("Index " + i + ": " + stk[i] + " (Top)");
                } else {
                    System.out.println("Index " + i + ": " + stk[i]);
                }
            }
            System.out.println("Display Successful");
        }

    }

    public static void main(String[] args) {
        // int stk[] = new int[6];
        Scanner scanner = new Scanner(System.in);
        int ch = 0;
        int item;
        do {
            System.out.println("\n1: Push");
            System.out.println("2: Pop");
            System.out.println("3: Display Stack");
            System.out.println("4: Exit");
            System.out.print("\nInput Choice: ");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Item: ");
                    item = scanner.nextInt();
                    push(item);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                System.out.println("--------Happy Coding :) -------");
                    break;
                default:
                    System.out.println("Invalid Input !");
                    break;
            }
        } while (ch != 4);
        scanner.close();
    }

}

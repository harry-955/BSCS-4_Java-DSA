// package stack;

// import java.util.Scanner;

// class CharStack extends Stack {
//   Scanner input = new Scanner(System.in);
//   char[] stack;

//   CharStack(int size) {
//     super(size);
//     stack = new char[size];
//   }

//   public void push() {
//     if (top == this.stack.length - 1) {
//       System.out.println("Stack Overflow !");
//     } else {
//       System.out.print("Enter Item to push: ");
//       char item = input.next().charAt(0);
//       top++;
//       this.stack[top] = item;
//       // System.out.println("Push Successful");
//     }
//   }

//   public char peek() {
//     if (isEmpty()) {
//       System.out.println("stack empty");
//       return ' ';
//     }
//     return this.stack[top];
//   }

//   public void display() {
//     if (top == -1) {
//       System.out.println("No Elements in stack to display");
//     } else {
//       for (int i = top; i >= 0; i--) {
//         if (i == top) {
//           System.out.println("Index " + i + ": " + stack[i] + " (Top)");
//         } else {
//           System.out.println("Index " + i + ": " + stack[i]);
//         }
//       }
//       // System.out.println("Display Successful");
//     }
//   }
// }

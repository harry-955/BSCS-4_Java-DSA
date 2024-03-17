import java.util.Scanner;

class stack { // start of stack class

	static int stk[] = new int[20]; // declaration of global variables
	static int max = 5;
	static int top = -1, item;

	public static void main(String arg[]) { // start of main()
		char choice = ' ';
		Scanner input = new Scanner(System.in);

		while (choice != '4') { // start of while

			System.out.println("\n1 : Push");
			System.out.println("2 : Pop");
			System.out.println("3 : Display");
			System.out.println("4 : Exit\n");
			System.out.print("Enter Choice...");

			choice = input.next().charAt(0);

			switch (choice) { // start of switch statement

				case '1':
					System.out.print("\nEnter value to PUSH = ");
					item = input.nextInt();
					push(item);
					break;

				case '2':
					pop();
					break;

				case '3':
					display();
					break;

			} // end switch statement
		} // end while
		input.close();
	}// end main

	public static void push(int n) { // start of push()

		if (top == max - 1) {
			System.out.println("\nStack is Overflow\n");
		} else {
			top++;
			stk[top] = n;
		}

	}// end push

	public static void display() { // start of display()

		if (top != -1) {
			for (int i = top; i >= 0; i--)
				if (top == i)
					System.out.println("\n" + stk[i] + "      Top=" + top);
				else
					System.out.println(stk[i]);

		} else
			System.out.println("\nNO Value in Stack\n");

	}// end display

	public static void pop() { // start of pop()
		if (top == -1) {
			System.out.println("\nStack is UnderFlow\n");
		} else {
			System.out.println(stk[top]);
			top--;
		}

	} // end pop
} // end class stack

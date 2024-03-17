
/* ----------Find greatest of four numbers using nested-if----------- */
import java.util.Scanner;

class GreatestOfFour {

    public static void main(String[] args) {
        int a, b, c, d;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 1st Number: ");
        a = scanner.nextInt();
        System.out.print("Enter 2nd Number: ");
        b = scanner.nextInt();
        System.out.print("Enter 3rd Number: ");
        c = scanner.nextInt();
        System.out.print("Enter 4th Number: ");
        d = scanner.nextInt();
        /*
         * Basic trick => compare 2 numbers and if any is smaller, don't consider it in
         * inner condtions------
         */

        if (a > b) { // if true 'b' is removed from consideration
            if (a > c) { // if true 'c' is removed from consideration
                if (a > d) { // if control is here 'b' and 'c' are removed already, now compare 'a' and 'd'
                    System.out.println(a + " is greatest !");
                } else {
                    System.out.println(d + " is greatest !");
                }
            } else if (c > d) { // if control is here 'b' and 'a' are removed already, now compare 'c' and 'd'
                System.out.println(c + " is greatest !");
            } else {
                System.out.println(d + " is greatest !");
            }
        } // if 1st condition is false, a is removed from consideration
        else if (b > c) { // if true 'c' is removed
            if (b > d) { // 'a' and 'c' are removed, now compare 'b' and 'd'
                System.out.println(b + " is greatest !");
            } else {
                System.out.println(d + " is greatest !");
            }
        } // if 2nd condition is also false => 'a' and 'b' both are smaller
        else if (c > d) { // compare 'c' and 'd'
            System.out.println(c + " is greatest !");
        } else {
            System.out.println(d + " is greatest !");
        }
        scanner.close();
    }
}

// import java.util.Scanner;

class LinearSearch {
    public static void main(String[] args) {
        // Linear Search

        // Scanner sc = new Scanner(System.in);

        // System.out.println("Enter 5 values to initalize the array: ");
        // int[] array = new int[5];
        // System.out.println(array.length);
        // for (int i = 0; i < array.length; i++) {
        // array[i] = sc.nextInt();
        // }
        // System.out.print("Enter number to find in array: ");
        // int num = sc.nextInt();
        int[] array = { 2, 4, 432, 3, 2, 3 };
        int num = 432;
        boolean isFound = false;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                isFound = true;
                break;
            }
        }
        if (isFound) {
            System.out.println("Number Found");
        } else {
            System.out.println("Number not found");
        }

        // Binaary Search
        // First we have to sort the array (lets use Insertion sort)
        // for (int i = 1; i < array.length-1; i++) {
        // int element = array[i];
        // int j = i - 1;
        // while (j >= 0 && element < array[j]) {
        // array[j+1] = array[j];
        // j--;
        // }
        // array[j+1] = element;
        // }
        
        // Suppose we want to find 234 and its index as well
        int numToFind = 234;
        int midIndex, leftIndex, rightIndex;
        leftIndex = 0;
        rightIndex = array.length - 1;
        midIndex = (leftIndex + rightIndex) / 2;
        while (array[midIndex] != numToFind && leftIndex < rightIndex) {
            if (numToFind < array[midIndex]) {
                rightIndex = midIndex + 1;
            } else {
                leftIndex = midIndex - 1;
            }
            midIndex = (leftIndex + rightIndex) / 2;
        }
        
        if (numToFind == array[midIndex]) {
            System.out.println("Number Found at index: "+ midIndex);
        } else {
            System.out.println("Number not found!");
        }

        // sc.close(); //
    }
}
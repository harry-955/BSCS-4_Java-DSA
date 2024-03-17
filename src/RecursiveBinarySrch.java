// Here I have used concept of recursion instead of looping to find the number using binary search...
public class RecursiveBinarySrch {
    public static void main(String[] args) {
        int[] array = { 32, 324, 32, 764, 234, 432, 347, 758, 443 };
        // First Sorting this array by selection sort, you can prefer already sorted array if you hadn't learned sorting yet
        int smallest, temp;
        for (int i = 0; i < array.length - 1; i++) {
            smallest = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < smallest) {
                    temp = array[j];
                    array[j] = smallest;
                    smallest = temp;
                }
                array[i] = smallest;
            }
        }
        System.out.print("Sorted Array: ");
        for (int elememnt : array) {
            System.out.print(elememnt + " ");
        }
        System.out.println(); // new line

        // Now finding number by Binary Search based on a recursive function
        int numToFind = 758; // to be searched
        int leftIndex = 0;
        int rightIndex = array.length - 1; // Can be changed if only to be searched in specific part of array
        int location = binarySearch(array, leftIndex, rightIndex, numToFind); // function call
        if (location != -1) {
            // if item found, its index will be acoording to sorted array
            System.out.println("Number " + numToFind + " Found at index: " + location + " :) ");
        } else {
            System.out.println("Number " + numToFind + " not found :( ");
        }
    } // end of main function

    // searching function
    public static int binarySearch(int[] array, int stIdx, int endIdx, int item) {
        if (stIdx < endIdx) { // Base Case => First check if range is valid
            int midIndex = (stIdx + endIdx) / 2; // calculate the middle index
            if (item != array[midIndex]) { // if item is not at mid then change the range(start and end index)
                if (item < array[midIndex]) {
                    endIdx = midIndex - 1; // remove the right side of array after mid
                } else {
                    stIdx = midIndex + 1; // remove the left side of array before mid
                }
                midIndex = (stIdx + endIdx) / 2; // updated mid
            }
            if (item == array[midIndex]) {
                return midIndex; // return location at which the item/number is found
            } else {
                // Recursive Call, updated strat and end index will be sent as arguments
                return binarySearch(array, stIdx, endIdx, item);
            }
        }
        return -1; // start index > end index --> means number not found in the valid array range
    } // end of binary search function
} // end of class

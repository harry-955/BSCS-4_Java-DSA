package sorting;

/* -------------Menu Based program that provides facility to create / update array
 * then apply sorting algorithm of user's choice ------------------
 */
import java.util.Scanner;

public class SortingMenu {
    static Scanner scanner;
    // for colors, can be replaced with "" if not working in your system
    static final String RESET = "\u001B[0m";
    static final String BLUE = "\u001B[36m";
    static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.print(BLUE + " \nEnter Size of Array (cannot be changed): " + RESET);
        int[] array = new int[scanner.nextInt()];
        fillArray(array);
        int choice = 0;
        while (choice != 6) {
            System.out.println("\n1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Shell Sort");
            // System.out.println("5. Merge Sort");
            // System.out.println("6. Quick Sort");
            System.out.println("7. Display Array");
            System.out.println("8. Update Values in Array");
            System.out.println("9. Exit");
            System.out.print(YELLOW + "\nFeel Free to choose: " + RESET);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    /* ------Bubble Sort----- */
                    bubbleSort(array);
                    System.out.println("Array Sorted By Bubble sort :) ");
                    break;
                case 2:
                    /* ------Selection Sort----- */
                    selectionSort(array);
                    System.out.println("Array Sorted By Selection sort :) ");
                    break;
                case 3:
                    /* ------Insertion Sort----- */
                    insertionSort(array);
                    System.out.println("Array Sorted By Insertion sort :) ");
                    break;
                case 4:
                    /* ------Shell Sort----- */
                    shellSort(array);
                    System.out.println("Array Sorted By Shell sort :) ");
                    break;
                case 5:
                    /*
                     * ------Merge Sort-----
                     * Under Construction
                     */
                    break;
                case 6:
                    /*
                     * ------Quick Sort-----
                     * Under Construction
                     */
                    break;
                case 7: // display
                    newDisplay(array);
                    // displayArray(array);
                    break;
                case 8: // input array
                    fillArray(array);
                    break;
                case 9: // exit
                    System.out.println("--------------Happy Coding, GoodBye Yousuf :) ------------");
                    break;
                default:
                    System.out.println("Invalid Input Bruh <:( ");
                    break;
            }
        }
        scanner.close();
    }

    /*
     * --------To Fill values in an array, can be an existing one so it will be
     * updated--------
     */
    public static void fillArray(int[] array) {
        System.out.println("Fill " + array.length + " Elements in array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Array Filled :) ");
    }

    /* ------------To diplay current values in an array------------ */
    public static void displayArray(int[] array) {
        for (int val : array) {
            System.out.print(val + " ");
        }
    }

    /* ------------To sort array in ascending order by bubble sort------------ */
    public static void bubbleSort(int[] array) {
        if (array.length == 1) {
            return;
        } else {
            int temp;
            int innerCount, outerCount = 1, totalItr = 0;
            for (int i = 0; i < array.length - 1; i++) {
                /*
                 * compare prev element with next, there is no next of last element
                 * so I have used array.length-1 instead of whole array i.e., array.length
                 * and i is elements counter not index
                 */
                innerCount = 1;
                for (int j = 0; j < (array.length - 1) - i; j++) {
                    System.out.println("\nArray After Inner Iteration " + (innerCount++));
                    // for each iteration if previous element is greater than next, swap them
                    if (array[j] > array[j + 1]) {
                        // swap
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                    newDisplay(array);
                    totalItr++; // total iterations counter
                }
                System.out.println(YELLOW + "\nArray After Outer Iteration " + RESET + (outerCount++));
                newDisplay(array);
                totalItr++; // total iterations counter
            }
            System.out.println("\nTotal Iterations: " + totalItr);
        }
    }

    /* ------------To sort array in ascending order by selection sort------------ */
    public static void selectionSort(int[] array) {
        if (array.length == 1) {
            return;
        } else {
            int smallIdx, swap, innerCount, outerCount = 1, totalItr = 0;
            for (int i = 0; i < array.length - 1; i++) {
                smallIdx = i; // index of smallest valu, will be updated if any other element is smaller
                innerCount = 1; // inner loop counter
                for (int j = i + 1; j < array.length; j++) {
                    System.out.println("\nAfter Inner Iteration " + (innerCount++));
                    if (array[j] < array[smallIdx]) {
                        // update smallest value index
                        smallIdx = j;
                    }
                    System.out.println("Smallest: " + array[smallIdx]);
                    totalItr++; // total iterations counter
                }
                // swap current Index (i) val with smallest Index (j) val
                swap = array[i];
                array[i] = array[smallIdx];
                array[smallIdx] = swap;
                System.out.println(YELLOW + "\nArray After Outer Iteration " + RESET + (outerCount++));
                newDisplay(array);
                totalItr++; // total iterations counter
            }
            System.out.println("\nTotal Iterations: " + totalItr);
        }
    }

    /* ------------To sort array in ascending order by insertion sort------------ */
    public static void insertionSort(int[] array) {
        if (array.length == 1) {
            System.out.println("Array is Already Sorted !");
        } else {
            int innerCount, outerCount = 1, totalItr = 0;
            int element, sortedIdx;
            for (int i = 1; i < array.length; i++) {
                element = array[i]; // retrieve the current item
                sortedIdx = i - 1; // sorted portion starts from just behind current i
                innerCount = 1; // inner loop counter
                while (sortedIdx >= 0 && element < array[sortedIdx]) {
                    array[sortedIdx + 1] = array[sortedIdx];
                    sortedIdx--;
                } // end of while
                System.out.println("\nArray After Inner Iteration " + (innerCount++));
                newDisplay(array);
                totalItr++; // total iterations counter
                array[sortedIdx + 1] = element;
                System.out.println(YELLOW + "\nArray After Outer Iteration " + RESET + (outerCount++));
                newDisplay(array);
                // displayArray(array);
                totalItr++; // total iterations counter
            } // end of for
            System.out.println(YELLOW + "\nTotal Iterations: " + totalItr + RESET);
        }
    }

    /* ----------Sort Array in Ascending Order by Shell Sort--------- */
    public static void shellSort(int[] array) {
        /**
         * If length of array is even => gap = gap / 2
         * If length of array is odd => use ceil of result after gap / 2
         * i.e., if length = 7, gap = floor (3.5) => gap = 3
         */
        if (array.length <= 1) {
            System.out.println("Array is already Sorted :) ");
            return;
        } else {
            int gap, swap, innerCount = 0, outerCount = 0, totalCount = 0, swapCount = 0;
            gap = array.length / 2;
            // Iterate and swap untill gap has reduced to 0
            while (gap != 0) {
                for (int i = gap; i < array.length; i++) {
                    for (int j = i - gap; j >= 0; j -= gap) {
                        // compare each element at index j with element after gap, and swap accordingly
                        if (array[j] > array[j + gap]) {
                            // swap
                            swap = array[j];
                            array[j] = array[j + gap];
                            array[j + gap] = swap;
                            swapCount++;
                        } else {
                            break;
                        }
                        System.out.println("\nArray After Inner Iteration " + (++innerCount));
                        newDisplay(array);
                    }
                    System.out.println(YELLOW + "\nArray After Outer Iteration " + RESET + (++outerCount));
                    newDisplay(array);
                }
                totalCount++;
                gap /= 2;
            }
            System.out.println("Total Outer Iterations: " + outerCount);
            System.out.println("Total Inner Iterations: " + innerCount);
            System.out.println("Total Iterations: " + (innerCount + outerCount + totalCount));
            System.out.println("Total Swaps: " + swapCount);
        }
    }

    /* ------------To Visually diplay current values in an array------------ */
    public static void newDisplay(int[] array) {
        System.out.println(YELLOW);
        try {
            System.out.print("_"); // use _ if this is not working
            for (int val : array) {
                for (int i = 0; i < 3 + String.valueOf(val).length(); i++) {
                    Thread.sleep(100);
                    System.out.print("_");
                }
            }
            System.out.print("\n│"); // use | if this is not working
            for (int val : array) {
                Thread.sleep(100);
                System.out.print(" ");
                Thread.sleep(200);
                System.out.print(RESET + val);
                Thread.sleep(100);
                System.out.print(YELLOW + " │");
            }
            System.out.print("\n¯"); // use '-' if this is not working
            for (int val : array) {
                for (int i = 0; i < 3 + String.valueOf(val).length(); i++) {
                    Thread.sleep(100);
                    System.out.print("¯");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(RESET);
    }
}

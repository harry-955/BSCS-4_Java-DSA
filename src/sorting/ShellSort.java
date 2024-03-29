package sorting;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = { 23, 29, 15, 19, 31, 7, 9, 5, 2 };
        System.out.print("Original Array: ");
        for (int element : nums) {
            System.out.print(element + " ");
        }
        System.out.println();
        shellSort(nums);
        System.out.print("Sorted Array: ");
        for (int element : nums) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /* ----------Sort Array in Ascending Order by Shell Sort--------- */
    // -------------------not working-------------------
    // public static void shellSort(int[] nums) {
    // int gap, swap;
    // /**
    // * If length of array is even => gap = gap / 2
    // * If length of array is odd => use ceil of result after gap / 2
    // * i.e., if length = 7, gap = ceil (3.5) => gap = 4
    // */
    // if (nums.length % 2 == 0) {
    // gap = nums.length / 2;
    // } else {
    // gap = nums.length / 2 + 1;
    // }
    // // Iterate and swap untill gap has reduced to 0
    // while (gap != 0) {
    // for (int i = 0; i <= (nums.length - 1) - gap; i++) {
    // // compare each element at index i with element after gap, and swap
    // accordingly
    // if (nums[i] > nums[i + gap]) {
    // // swap
    // swap = nums[i];
    // nums[i] = nums[i + gap];
    // nums[i + gap] = swap;
    // }
    // }
    // if (nums.length % 2 == 0) {
    // gap = gap / 2;
    // } else {
    // gap = (gap / 2) + 1;
    // }
    // }
    // }
    public static void shellSort(int[] array) {
        if (array.length <= 1) {
            return;
        } else {
            int gap, swap, innerCount = 0, outerCount = 0, totalCount = 0, swapCount = 0;
            gap = array.length / 2;
            while (gap != 0) {
                for (int i = gap; i < array.length; i++) {
                    for (int j = i - gap; j >= 0; j -= gap) {
                        innerCount++;
                        if (array[j] > array[j + gap]) {
                            // swap
                            swap = array[j];
                            array[j] = array[j + gap];
                            array[j + gap] = swap;
                            swapCount++;
                        } else {
                            break;
                        }
                    }
                    outerCount++;
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
}

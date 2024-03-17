public class BinarySearch {
    public static void main(String[] args) {
        int[] array = { 32, 324, 32, 764, 234, 432, 347, 758, 443 };
        // First Sorting this array by selection sort
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
        System.out.println();

        // Now finding number by Binary Search
        int numToFind = 443;
        int midIndex, leftIndex, rightIndex;
        leftIndex = 0;
        rightIndex = array.length - 1;
        midIndex = (leftIndex + rightIndex) / 2; // initial mid index of array
        while (array[midIndex] != numToFind && leftIndex < rightIndex) {
            if (numToFind < array[midIndex]) {
                rightIndex = midIndex - 1;
            } else {
                leftIndex = midIndex + 1;
            }
            midIndex = (leftIndex + rightIndex) / 2; // mid index of new range
        }

        if (numToFind == array[midIndex]) {
            // index will be acoording to sorted array
            System.out.println("Number " + numToFind + " Found at index: " + midIndex); 
        } else {
            System.out.println("Number " + numToFind + "  not found in array!");
        }
    }
}

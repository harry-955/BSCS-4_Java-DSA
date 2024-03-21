public class SelectionSort {

    public static void main(String[] args) {
        int[] array = { 2, 1, 3, 6, 4, 7, 0, -2, -3, 1 };
        int minIdx;
        for (int i = 0; i < array.length - 1; i++) { // from initial to 2nd last element
            minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                // compare each time current element with its next and update minimum index
                // based on comparison
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            } // inner ended - now swap current element at index i with smallest one
            // Swap without 3rd variable (not working)
            // System.out.println();
            // System.out.println("Element at MinIndex " + minIdx + ": " + array[minIdx]);
            // System.out.println("Element at Iteration Index " + i + ": " + array[i]);
            // array[i] = array[i] + array[minIdx];
            // System.out.println("Sum: " + array[i] + " ");
            // array[minIdx] = array[i] - array[minIdx];
            // System.out.println("Value at Min Index: " + array[minIdx] + " ");
            // array[i] = array[i] - array[minIdx];
            // System.out.println("Value at iteration Index: " + array[i] + " ");
            // int sum = array[i] + array[minIdx];
            // array[i] = sum - array[i];
            // array[minIdx] = sum - array[i];

            // Swap with 3rd variable (working well)
            int temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
            // System.out.println("Element at index " + i + ": " + array[i]);
        }
        System.out.print("Sorted Array by Insertion Sort: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

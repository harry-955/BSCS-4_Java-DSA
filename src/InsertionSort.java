public class InsertionSort {

    public static void main(String[] args) {
        int[] array = { 21, 3, 22, 1, 0, 9, 5 };
        int j, item;
        for (int i = 1; i < array.length; i++) {
            item = array[i]; // retrieve the current item
            j = i - 1; // sorted portion starts from just behind current i
            /**
             * untill sorted portion has ended or item is now greater than value at current
             * index j of sorted portion
             */
            while (j >= 0 && item < array[j]) {
                array[j + 1] = array[j]; // shift current element of sorted portion to one step forward
                j--;
            }
            array[j + 1] = item; // store the retrieved item one index up where loop terminated in sorted portion
        }
        System.out.print("Sorted Array by Insertion Sort: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();

        /* ----------Tried another method - not working-------------- */
        // int temp, loc;
        // for (int ptr = 1; ptr < array.length; ptr++) {
        // temp = array[ptr];
        // loc = ptr - 1;
        // while (temp < array[loc]) {
        // array[ptr + 1] = array[ptr];
        // ptr++;
        // }
        // array[ptr + 1] = temp;
        // }
        // System.out.print("Sorted Array by Insertion Sort: ");
        // for (int element : array) {
        // System.out.print(element + " ");
        // }
        // System.out.println();
    }
}
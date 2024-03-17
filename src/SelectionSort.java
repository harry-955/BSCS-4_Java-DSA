public class SelectionSort {

  public static void main(String[] args) {
    int[] array = { 2, 1, 3, 6, 4, 7, 0 };
    int minIdx;
    for (int i = 0; i < array.length - 1; i++) {
      minIdx = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIdx]) {
          minIdx = j;
        }
      }
      // Swap without 3rd variable (giving error)
      //   System.out.println();
      //   System.out.println("Element at MinIndex " + minIdx + ": " + array[minIdx]);
      //   System.out.println("Element at Iteration Index " + i + ": " + array[i]);
      //   array[i] = array[i] + array[minIdx];
      //   System.out.println("Sum: " + array[i] + " ");
      //   array[minIdx] = array[i] - array[minIdx];
      //   System.out.println("Value at Min Index: " + array[minIdx] + " ");
      //   array[i] = array[i] - array[minIdx];
      //   System.out.println("Value at iteration Index: " + array[i] + " ");

      // int sum = array[i] + array[minIdx];
      // array[i] = sum - array[i];
      // array[minIdx] = sum - array[i];

      // Swap with 3rd variable (working well)

      int temp = array[i];
      array[i] = array[minIdx];
      array[minIdx] = temp;
      System.out.println("Element at index " + i + ": " + array[i]);
    }
    System.out.print("Sorted Array by Selection Sort: ");
    for (int element : array) {
      System.out.print(element + " ");
    }
    System.out.println();
  }
}

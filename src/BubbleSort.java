class BubbleSort {

  public static void main(String[] args) {
    int[] arr = { 2, 4, 0, 4, 5, 3 };
    for (int i = 0; i < arr.length - 1; i++) { // initial element
      for (int j = i + 1; j < arr.length; j++) {
        // Each time if previous element is smaller than next one, they will be swapped 
        if (arr[i] > arr[j]) {
          // swap
          arr[i] = arr[i] + arr[j];
          arr[j] = arr[i] - arr[j];
          arr[i] = arr[i] - arr[j];
        }
      }
      // In each iteration smallest element will be shifted to start of array
      System.out.println("Element at index " + i +": "+ arr[i]); 
    }
    System.out.print("Sorted Array by Bubble Sort: ");
    for (int element : arr) {
      System.out.print(element + " ");
    }
    System.out.println();
  }
}

public class InsertionSort {

  public static void main(String[] args) {
    int[] array = { 21, 3, 22, 1, 0, 9, 5 };
    int j, item;
    for (int i = 1; i < array.length; i++) {
      item = array[i];      
      j = i - 1;
      while (j >= 0 && item < array[j]) {        
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = item;
    }
    System.out.print("Sorted Array by Insertion Sort: ");
    for (int element : array) {
      System.out.print(element + " ");
    }
    System.out.println();
  }
}

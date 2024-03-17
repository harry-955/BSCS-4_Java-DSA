package queue;

public class CQueue {

  private int size;
  private String[] elements;
  private int f;
  private int r;

  /* ---------------Constructor----------------- */
  CQueue(int size) {
    f = r = -1;
    this.size = size;
    elements = new String[this.size];
    // Fill the queue with empty spaces, remove this if using simple display
    for (int i = 0; i < elements.length; i++) {
      elements[i] = " ";
    }
    System.out.println("Queue of Size " + this.size + " initiated.\n");
  }

  /* --------------Display current values of front and rear--------------- */
  public void printFR() {
    System.out.println("Front : " + f);
    System.out.println("Rear : " + r);
  }

  /* --------------Insert Element from Rear--------------- */
  public void insert(String item) {
    if ((f == 0 && r == size - 1) || r + 1 == f) {
      System.out.println("Cannot Insert, Queue is Full :( ");
    } else {
      if (f == -1) {
        f = 0;
      }
      if (r == size - 1) {
        r = -1;
      }
      r += 1;
      elements[r] = item;

      System.out.println("Insert Successful :) \n");
    }
  }

  /* --------------Delete Element from front--------------- */
  public String del() {
    if (f == -1) {
      // System.out.println(" Cannot Delete, Queue is Empty :( ");
      return null; // returns null if queue is empty
    } else {
      String item = elements[f];
      elements[f] = " "; // to show that element has been removed
      if (f == r) {
        f = r = -1; // query: if 1 insert 1 del; but if we don't do this, queue empty condition is not valid
      } else {
        if (f == size - 1) f = -1;
        f += 1; // normal situation, always implemented on delete
      }
      return item;
    }
  }

  /* ---------------Simple Version of display----------- */
  public void display() {
    if (f == -1) {
      System.out.println("Queue Empty, Nothing to display :( ");
    } else {
      System.out.println("Front : " + f + "\tRear : " + r);
      System.out.println("Index   : Item");
      //   if (f <= r) {
      //       // for (int i = f; i <= r; i++) {
      //       if (f == r) {
      //         System.out.println(
      //           i + "\t: " + elements[i] + "\t(Front) , " + "(Rear)"
      //         );
      //       } else if (i == f) {
      //         System.out.println(i + "\t: " + elements[i] + "\t(Front)");
      //       } else if (i == r) {
      //         System.out.println(i + "\t: " + elements[i] + "\t(Rear)");
      //       } else {
      //         System.out.println(i + "\t: " + elements[i]);
      //       }
      //     }
      //   } else {
      //     for (int i = f; i <= size - 1; i++) {
      //       if (f == r) {
      //         System.out.println(
      //           i + "\t: " + elements[i] + "\t(Front) , " + "(Rear)"
      //         );
      //       } else if (i == f) {
      //         System.out.println(i + "\t: " + elements[i] + "\t(Front)");
      //       } else if (i == r) {
      //         System.out.println(i + "\t: " + elements[i] + "\t(Rear)");
      //       } else {
      //         System.out.println(i + "\t: " + elements[i]);
      //       }
      //       if (i == size - 1) {
      //         i = -1;
      //       }
      //       if (i == r) {
      //         // System.out.println(i + "\t: " + elements[i]);
      //         break;
      //       }
      //     }
      //   }
      /* -----------------Upper 2 loops are combined below ------------- */
      for (int i = f; (f <= r) ? (i <= r) : (i <= size - 1); i++) {
        if (f == r) {
          System.out.println(
            i + "\t: " + elements[i] + "\t(Front) , " + "(Rear)"
          );
        } else if (i == f) {
          System.out.println(i + "\t: " + elements[i] + "\t(Front)");
        } else if (i == r) {
          System.out.println(i + "\t: " + elements[i] + "\t(Rear)");
        } else {
          System.out.println(i + "\t: " + elements[i]);
        }
        if (f > r) { // rear is behind the front (circular behavior)
          if (i == size - 1) { // at the end of queue but there rear is not there, so go back
            i = -1;
          }
          if (i == r) { // iterator has reached rear
            break; // exit from loop and eventually from display()
          }
        }
        // }
      }
    }
  }

  /*------------- Some private functions that will be called by newDisplay() method --------*/
  private void displayFront() {
    System.out.print("  "); // 2 spaces in each case
    for (int i = 0; i <= f; i++) {
      if (i != f) {
        for (int j = 0; j < 3 + elements[i].length(); j++) {
          System.out.print(" "); // spaces based on length of current element
        }
      } else { // if i == f then there will be less spaces and then F will be displayed
        for (int j = 0; j <= elements[i].length(); j++) {
          System.out.print(" ");
        }
      }
    }
    System.out.print("F\n");
  }

  private void upperBound() {
    System.out.print("--");
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < 3 + elements[i].length(); j++) {
        System.out.print("-");
      }
    }
    System.out.print("---\n  |");
  }

  private void elements() {
    for (int i = 0; i < size; i++) {
      System.out.print(" " + elements[i] + " |");
    }
  }

  private void lowerBound() {
    System.out.print("\n--");
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < 3 + elements[i].length(); j++) {
        System.out.print("-");
      }
    }
    System.out.print("---");
    System.out.println();
  }

  private void displayRear() {
    System.out.print("  ");
    for (int i = 0; i <= r; i++) {
      if (i != r) {
        for (int j = 0; j < 3 + elements[i].length(); j++) {
          System.out.print(" ");
        }
      } else {
        for (int j = 0; j <= elements[i].length(); j++) {
          System.out.print(" ");
        }
      }
    }
    System.out.print("R\n");
  }

  /* -----------New Display Method for Circular Queue----------- */
  public void newDisplay() {
    if (f == -1) {
      System.out.println("F");
      upperBound();
      elements();
      lowerBound();
      System.out.println("R");
    } else {
      displayFront();
      upperBound();
      elements();
      lowerBound();
      displayRear();
    }
  }
}
  
/* ----------------New Display Method suitable for character type queue------------- */
// public void newDisplay() {
//   System.out.println("\n");
//   for (int i = 0; i <= f; i++) {
//     System.out.print("    ");
//   }
//   System.out.println("F");
//   for (int i = 0; i <= (size * 4) + 4; i++) {
//     System.out.print("-");
//   }
//   System.out.println();
//   System.out.print("  |");
//   for (int i = 0; i <= size - 1; i++) {
//     if (f == -1) {
//       break;
//     } else {
//       if (elements[i] == null) {
//         System.out.print(" " + " " + " |");
//       } else {
//         System.out.print(" " + elements[i] + " |");
//       }
//     }
//   }
//   System.out.println();
//   for (int i = 0; i <= (size * 4) + 4; i++) {
//     System.out.print("-");
//   }
//   System.out.println();
//   for (int i = 0; i <= r; i++) {
//     System.out.print("    ");
//   }
//   System.out.println("R\n");
// }

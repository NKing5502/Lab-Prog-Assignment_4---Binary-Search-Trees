// Nick King
// Week_5  - Assignment_1  - Binary Search Trees
// Feburary 11, 2025

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest {
   // performs a recursive binary search on the data
   public static int recursiveBinarySearch(int[] data, int key, int low, int high) {
      if (low > high) {
         return -1; // key was not found
      }

      int middle = (low + high) / 2;

      if (key == data[middle]) {
         return middle; // key was found
      } else if (key < data[middle]) {
         return recursiveBinarySearch(data, key, low, middle - 1); // search's lower half
      } else {
         return recursiveBinarySearch(data, key, middle + 1, high); // search's upper half
      }
   }

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      SecureRandom generator = new SecureRandom();

      // creates an array of 15 random integers in sorted order
      int[] data = generator.ints(15, 10, 91).sorted().toArray();
      System.out.printf("%s%n%n", Arrays.toString(data)); // display array

      // get's input from user
      System.out.print("Enter an integer value (-1 to quit): ");
      int searchInt = input.nextInt(); // read an int from user

      // repeatedly input an integer; -1 terminates the program
      while (searchInt != -1) {
         // perform search
         int location = recursiveBinarySearch(data, searchInt, 0, data.length - 1);

         if (location == -1) { // not found
            System.out.printf("%d was not found%n%n", searchInt);
         } else { // found
            System.out.printf("%d was found in position %d%n%n", searchInt, location);
         }

         // get input from user
         System.out.print("Enter an integer value (-1 to quit): ");
         searchInt = input.nextInt(); // read's an int from user
      }

      input.close(); // close's the Scanner to prevent resource leak
   }
}
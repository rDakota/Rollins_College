/**
 * Example ArrayList implementation using C structs
 * Rowan Richter
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define INITIAL_CAPACITY 5


// Declare ArrayList struct
//
// It has three fields
//   int* array: a pointer to an array allocated by malloc
//   int size: the number of elements inserted into the list
//   int capacity: the length of the current array
typedef struct {
  int* array;
  int size;  // Number of inserted elements
  int capacity;  // Size of allocated array
} ArrayList;


/**
 * Construct a new ArrayList and return
 * a pointer to it
 */
ArrayList* arrayListInit() {
  
  // Allocate a struct for the new list
  ArrayList* newList = malloc(sizeof(ArrayList));

  // Check the return from malloc
  if (newList == 0) {
    perror("arrayListInit");
  }

  // Initialize the struct's fields
  newList->array = malloc(INITIAL_CAPACITY * sizeof(int));
  newList->size = 0;
  newList->capacity = INITIAL_CAPACITY;

  // Return the pointer to the new list
  return newList;
}


/**
 * Return the size of an ArrayList
 */
int arrayListSize(ArrayList* a) {
  // returns the size of the arrayList
  // not the capacity
  return a->size;
}


/**
 * Print the contents of an ArrayList
 */
void arrayListPrint(ArrayList *a) {
  printf("[");
  for (int i = 0; i < a->size; i++) {
    printf("%d", a->array[i]);
    if (i < a->size - 1) {
      printf(", ");
    }
  }
  printf("]\n");
}


/**
 * Append a value to the end of the array list
 */
void arrayListAppend(ArrayList *a, int value) {
  // If the array is full, allocate a new array and
  // copy the elements over to it
  if (a->size == a->capacity) {
    
    // Allocate a new array that holds
    // 2 * a->capacity * sizeof(int) bytes
    int *newArray = malloc(2 * (a->capacity) * sizeof(int));
    
    // Copy the values from the old array to the new array
    for (int i = 0; i < a->size; i++) {     
      newArray[i] = a->array[i];    
    }      
    // Free the old array
    free(a->array);
    // Set a->array to point to the new array
    a->array = newArray;
  }
  // Put the new value in the next position in a->array
  // Tip: if you're keeping track correctly, the next
  // free position is always a->array[a->size]
  a->array[a->size] = value;
  // Increment a->size
  a->size++;

}


/**
 * Return the value at the given index position in list a
 */
int arrayListGet(ArrayList *a, int index) {
  return a->array[index];
}


/**
 * Insert an element at a given position
 */
void arrayListInsert(ArrayList *a, int value, int index) {

  // cannot insert outside of size of arrayList
  if (index < 0 || index > a->size) {
    perror("arrayListInsert invalid index");
  } 
  
  // If the array is full, allocate a new array and
  // copy the elements over to it
  if (a->size == a->capacity) {
    // Allocate a new array that holds
    // 2 * a->capacity * sizeof(int) bytes
    int *newArray = malloc(2 * (a->capacity) * sizeof(int));
    
    // Copy the values from the old array to the new array
    for (int i = 0; i < a->size; i++) {     
      newArray[i] = a->array[i];    
    }      
    // Free the old array
    free(a->array);
    // Set a->array to point to the new array
    a->array = newArray;
  }

  // Put the new value in the correct position in a->array
  // move up all the elements by 1
  // place the correct element at the spot index
  // 50 is size 49 is index

  // if index is last element then
  // follow same procedure as append
  if (index == (a->size - 1)) { 
    a->array[a->size] = value;
  } else {
  // otherwise go from the back of the list and move up one
  // until the index position is reached
  // place the value at the index position 
  // and increment the size
    for (int i = a->size; i > index; i--) {
      a->array[i] = a->array[i - 1];
    }
    a->array[index] = value;
  }
    a->size++;
}
  
/**
 * Remove and return the element at the given position
 */
int arrayListRemove(ArrayList *a, int index) {

    // save the element ot be removed
    int removedItem = a->array[index];
    // reduce the size first
    a->size--;
    // cannot remove from outside of size of arrayList
    if (index < 0 || index > a->size) {
      perror("arrayListRemove invalid index");
    } 
    // size has already been reduced so loop works correctly
    for (int i = index; i < a->size; i++) {
      a->array[i] = a->array[i + 1];
    }
    return removedItem; // return value
}


int main(void) {
  
  ArrayList* a = arrayListInit();
  printf("Test 1:\n");
  // Test 1: print the size of a list
  // Prints 0
  printf("%d\n", arrayListSize(a));
  // PASSED


  printf("\nTest 2:\n");
  // Test 2: append a few values and print
  // Prints [1, 2, 3]
  arrayListAppend(a, 1);
  arrayListAppend(a, 2);
  arrayListAppend(a, 3);
  arrayListPrint(a);
  // PASSED

  printf("\nTest 3:\n");
  // Test 3: append more values
  // Requires reallocating and copying the backing array
  // Prints [1, 2, 3, ..., 48, 49, 50]
  for (int i = 4; i <= 50; i++) {
    arrayListAppend(a, i);
  }
  arrayListPrint(a);
  // PASSED

  printf("\nTest 4:\n");
  // Test 4: verify that size has increased
  // prints 50
  printf("The size is: %d\n", arrayListSize(a));
  // PASSED

  printf("\nTest 5:\n");
  // Test 5: get values
  // Prints 1, 50, and 26
  printf("%d\n", arrayListGet(a, 0)); 
  printf("%d\n", arrayListGet(a, arrayListSize(a) - 1));
  printf("%d\n", arrayListGet(a, arrayListSize(a) / 2));
  // PASSED

  printf("\nTest 6:\n");
  // Test 6: write your own test for arrayListInsert
  arrayListInsert(a, 111, 3); // [1, 2, 3, 111, 4,...]
  arrayListInsert(a, 222, 6); // [4, 5, 222, 6, ...]
  // placed at 25 index
  // [23, 24, 333, 25, ...]
  arrayListInsert(a, 333, arrayListSize(a) / 2); 
  arrayListInsert(a, 444, 40);  // [36, 37, 444, 38, 39 ...]
  // placed at last index
  // [49, 50, 555]
  arrayListInsert(a, 555, arrayListSize(a) - 1);
  // print the correct list and check for correct size of 55
  arrayListPrint(a);
  printf("The size is: %d\n", arrayListSize(a));
  // PASSED

  printf("\nTest 7:\n");
  // Test 7: write your own test for arrayListRemove
  // removes last index and returns 555
  printf("%d\n", arrayListRemove(a, arrayListSize(a) - 1));
  printf("%d\n", arrayListRemove(a, 40)); //returns 444
  printf("%d\n", arrayListRemove(a, arrayListSize(a) / 2)); // returns 333
  printf("%d\n", arrayListRemove(a, 6)); // returns 222
  printf("%d\n", arrayListRemove(a, 3)); // returns 111
  
  // print the correct list and chek for correct size of 50
  // the array should be back to how it was before test 6
  arrayListPrint(a);
  printf("The size is: %d\n", arrayListSize(a));
  // PASSED
  
  return 0;
}
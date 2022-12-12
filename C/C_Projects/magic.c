/**
 * Magic squares program
 * Rowan Richter
 */

#include <stdio.h>

int main(int argc, char *argv[]) {
  int n;
  printf("Enter an odd int value: ");
  // assigning a variable to scanf means
  // assigning something to total of properly inputted elements
  int input = scanf("%d", &n);
  // if there is not only 1 inputted element
  // or
  // if n is even or less than 1 then exit program
  if ( input != 1 || n < 1 ||  n % 2 == 0 ) {
    perror("Something went wrong: ");
    // exits program
    return(-1);
  }

  // initialize n by n array
  int square[n][n];

  // iterate through 2d array using pointer and assign all values to default values of zero
  //
  // Makes inputting the magic square more seamless
  for (int i = 0; i < n * n; i++) {
    *((int*)square + i ) = 0;
  }
  

  // Start in the top row, center column
  int row = 0;
  int col = n / 2;  // Integer division yields the correct column
        
        
  // Place the values from 1 to n ^ 2
  for (int i = 1; i <= n * n; i++) {
        	        
    // Place value i at square[row][col]
    // done using pointer method
    *(square[row] + col) = i;

    //printf("%d: Placed -> [%d][%d] %d\n", i, row, col, square[row][col]);
           
    // Save the initial row and col before the shift for later use 
    int oldRow = row; 
    int oldCol = col; 
    //printf("%d: Old -> [%d][%d]\n", i, oldRow, oldCol);
            
    // Move up and to the right in the matrix
    // Try to move up and right, wrapping around if you need to
    row -= 1;
    if (row < 0) {
      row = n - 1;
    }
            
    col += 1;
    if (col > n - 1) {
      col = 0;
    }

    // If that position is occupied, go back to the old location and move down instead
    if (square[row][col] != 0) { 
            
      // Reset to the old original values of row and col
      row = oldRow;
      col = oldCol;
        		
      // Move down one square, wrapping around the bottom if I need to
      row = row + 1;
      if (row > n - 1) {
        row = 0;
      }
      //printf("%d: Alternate Next -> [%d][%d]\n\n", i, row, col);
    }
     //else {
      //printf("%d: Next -> [%d][%d]\n\n", i, row, col);
    //}
     
  }
  
  for (int r = 0; r < n; r++) {
    for (int c = 0; c < n; c++) {
      printf("%d", square[r][c]);
      printf("\t");
    }
    printf("\n");
  }
}

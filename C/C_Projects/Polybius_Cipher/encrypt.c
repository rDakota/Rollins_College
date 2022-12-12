/**
 * Implement Polybius square encryption
 * Rowan Richter
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// the key is a 5 x 5 matrix
// this constant will be in
// the program as length of the matrix
#define KEY_WIDTH 5

char* encrypt(char matrix[KEY_WIDTH][KEY_WIDTH], char plain[]) {

  // dynamically allocate twice size of plaintext for cipher bc two numbers are equivalent to one character
  
  // allows to allocate memory (dynamically) of a requested
  //size from the heap and returns a pointer to the
  // beginning of the allocated block
  char *cipher = malloc((strlen(plain) * 2) * sizeof(char));
  
  int i = 0;
  // iterate over the plaintext
  while (i < strlen(plain)) {
    int row = 0;
    // iterate through rows
    while (row < KEY_WIDTH) {
      int col = 0;
      // iterate through cols
      while (col < KEY_WIDTH) {
        if (plain[i] == matrix[row][col]) {
          // allocate String for row and col of size 2
          // to account for 1 character and 1 null terminated byte
          char strRow[2] = "";
          char strCol[2] = "";
          // convert to strings
          // take int row and col and convert
          // to string representations
          sprintf(strRow, "%d", row);
          sprintf(strCol, "%d", col);
          // concatenate the numbers on
          strcat(cipher, strRow);
          strcat(cipher, strCol);
        }
        col++;
      }
      row++;
    }
    // since 'q' does not exist must add 'i' instead
    if (plain[i] == 'q') {
      // strcat concatenates Strings
      strcat(cipher, "21"); // spot for i
    }
    i++;
  }
  //printf("%ld\n", strlen(cipher));
  return cipher;
}

int main(int argc, char *argv[]) {

  // the polybus cipher key we are using
  char key[KEY_WIDTH][KEY_WIDTH] = {
  {'l', 'a', 'b', 'o', 'r'},
  {'c', 'd', 'e', 'f', 'g'},
  {'h', 'i', 'j', 'k', 'm'},
  {'n', 'p', 's', 't', 'u'},
  {'v', 'w', 'x', 'y', 'z'}
    
  };

  //"attackatdawn"

  // initialize string buffer
  // arbitrarily sized 
  char buf[1024];
  printf("Print your message: ");
  // get String input for message to be encrypted
  if (fgets(buf, sizeof(buf), stdin) != NULL) {
    printf("Original plaintext: %s", buf);
  }
  
  char* enc = encrypt(key, buf);
    // call encrypt and display encrypted message
  printf("Encrypted text: %s\n", enc);
}

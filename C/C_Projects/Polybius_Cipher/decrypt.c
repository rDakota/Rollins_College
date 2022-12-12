/**
 * Implement Polybius square decryption
 * Rowan Richter
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// the key is a 5 x 5 matrix
// this constant will be used throughout 
// the program as length of the matrix
#define KEY_WIDTH 5

char* decrypt(char matrix[KEY_WIDTH][KEY_WIDTH], char cipher[]) {
  
// dynamically allocate half the size of the cipher for the plaintext bc two numbers are equivalent to one character

  // allows to allocate memory (dynamically) of a requested
  //size from the heap and returns a pointer to the
  // beginning of the allocated block
  //
  // this serves as my plainText decrypted plaintext
  // that I will concat the message to
  char *plain = malloc((strlen(cipher) / 2) * sizeof(char));
  
  // indexing numbers for the pairs
  int index = 0;
  int stop = 2;
  
  // iterate through cipherText
  while (index < strlen(cipher)) {

    // convert row and colto ints
    int row = cipher[index] - '0';
    int col = cipher[stop - 1] - '0';

    // concatenate 1 character over
    // strncat concatenates chars to a String of specified amount
    strncat(plain, &matrix[row][col], 1);
    
    // increment by 2 bc incementing by pairs
    index += 2;
    stop += 2;
    
  }
  // return the message
  return plain;
}

int main(int argc, char *argv[]) {

  // the polybus cipher key we use
  char key[KEY_WIDTH][KEY_WIDTH] = {
  {'l', 'a', 'b', 'o', 'r'},
  {'c', 'd', 'e', 'f', 'g'},
  {'h', 'i', 'j', 'k', 'm'},
  {'n', 'p', 's', 't', 'u'},
  {'v', 'w', 'x', 'y', 'z'}
    
  };

  //"013333011023013311014130"
  //"2134011023"

  // arbitrarily sized buffer String
  char buf[1024];
  printf("Print your cipher: ");
  // get String input for cipher message to be decrypted
  if (fgets(buf, sizeof(buf), stdin) != NULL) {
    printf("Original ciphertext: %s", buf);
  }
  char* dec = decrypt(key, buf);
  // call decrypt and display decrypted message
  printf("Decrypted text: %s\n", dec);
  
}
/**
 * Treblecross
 * Rowan Richter
 */

#include <stdio.h>

void displayBoard(char b[], int size) {
  
  // display treblecross board
  for(int i = 0; i < size ; i++) {
    // decimal is converted to characters
    if (i == 0) {
      printf("[");
    }
    
    printf("%c", b[i]);
    
    if (i < size - 1) {
      printf(",");
    }
    else {
      printf("]\n");
    }
  } 
}

void defaultBoard(char b[], int size) {
  int i = 0;
  while (i < size) {
    b[i] = ' ';
    i++;
  }
}

int main(int argc, char *argv[]) {
  int n;
  printf("Enter the size: ");
  // assigning a variable to scanf means
  // assigning something to total of properly inputted elements
  int input = scanf("%d", &n);
  // the board cannot be less than 4 spaces or the game is pointless
  if (input != 1 || n < 4) {
    //printf("Invalid input: Must be greater than zero");
    perror("Something went wrong: ");
    return(-1);
  }

  // Create a 1-D array of n char
  char board[n];
  // default the board to ' 's
  defaultBoard(board, n);

  // Use a variable to keep track of the current player
  int player = 1;

  int playing = 1;
  while (playing == 1) {

    // display array
    displayBoard(board, n);

    int move;
    printf("Player %d: Chose an open position less than %d as an index of the board:\n", player, n);
    // assigning a variable to scanf means
    // assigning something to total of properly inputted elements
    int input = scanf("%d", &move);
    if (input != 1 ) {
      printf("Invalid input: Exactly one value must be inputted");
    } else if (move < 0) {
      printf("Invalid input: Must be greater than 0\n");
      continue;
    } else if (move > n - 1 ) {
      printf("Invalid input: Must be less than %d.\n", n);
      continue;
    } else if (board[move] == 'X') {
      printf("Invalid input: Must not be already occupied.\n");
      continue;
    }
    else {
      board[move] = 'X';
    }

    for (int i = 0; i < (n - 2); i++) { 
      // If a group of three exists, declare the current player the winner and set playing = false
      if ( (board[i] == 'X') && (board[i + 1] == 'X') && (board[i + 2] == 'X')) {
        // display array
        displayBoard(board, n);
    	  printf("Player %d is the winner!!\n", player);
    	  playing = 0;
    	}
    }
    
    player = (player % 2) + 1;   
  }
}

                                      
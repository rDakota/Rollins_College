/**
 * Validating Benford's Law
 * @RowanRichter
 */

// Use this file to implement the program that reads
// Census data and compares the distribution of population
// digits to Benford's Law

#include <stdio.h>
#include <stdlib.h>

// explicit declaration of strtok
char *strtok(char str[], const char *delim);

int main(int argc, char *argv[]) {

  // Open the file
  FILE *f = fopen("co-est2021-alldata.csv", "r");

  // Check the return code
  if (f == NULL) {
    perror("fopen");
    exit(1);
  }

  // Declare character buffer
  char buf[1024];

  int firstLine = 1;

  // total number of lines processed
  // must be a double for future fractional use
  double processedLines = 0;

  // occurrences of each leading digit
  int counts[10];
  // default to all zeros
  int arrayLength = sizeof(counts) / sizeof(int);
  for (int i = 0; i < arrayLength; i++) {
    *(counts + i) = 0;
  }
  
  // Loop over the remaining lines that have data
  // runs until every line has been read
  while (fgets(buf, sizeof(buf), f) != NULL) {

    // Skip the first line that contains the field names
    if (firstLine) {
      firstLine = 0;
      continue;
    }

    // Print the whole line
    //printf("%s", buf);

    // Use strtok to get the first value
    char *token;
    // separate a string into individual
    // tokens based on user set delimeter
    token = strtok(buf, ",");
    // takes the string buffer and the delimiter pattern
    // as inputs and returns a pointer of type char * 
    // that represents the first token in the line
    //printf("%s\n", token);

    // loop that extracts and prints the tenth value 
    for (int i = 1; i < 10; i++) {
      token = strtok(NULL, ",");
      
      if (i == 9) {
        //total++;
        // Get the first digit
        char firstDigit = *token;
        // difference between their underlying numeric codes
        // will take a digit character and turn it into its numeric counter part
        int digit = firstDigit - '0';
        // increment how many times each digit appears in the int array
        *(counts + digit) += 1;
        //printf("%c, Line: %d, %d\n", firstDigit, processedLines, digit);
      }
    }
    // increment to next line
    processedLines++;
    
    
  }
  // iterate less than size of counts array
  for (int i = 0; i < 10; i++) {
    // dividing number of occurences of first digit i 
    // by the number of total processedLines
    double occurFraction = *(counts + i) / processedLines;
    printf("Fraction of leading %d's = %.4f\n", i, occurFraction);
  }
  
}
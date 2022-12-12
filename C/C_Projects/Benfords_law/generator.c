/**
 * Generating random data
 * @RowanRichter
 */

// Use this file to implement the program that generates
// random data with first digits obeying Benford's Law
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

// explicit declaration
int atoi(const char *str);

int benfordDigit(){
  double r = ((double) rand()) / RAND_MAX;

  if (r < .3010) {  // A little bit more than 30.1% of values are 1's
    return 1;
  } else if (r < .4770) { // An additional 17.6% are 2's
    return 2;
  } else if (r < .6020) { // 12.5%
    return 3;
  } else if (r < 0.6990) { // 9.7%
    return 4;
  } else if (r < 0.7780) { // 7.9%
    return 5;
  } else if (r < 0.8450) { // 6.7%
    return 6;
  } else if (r < 0.9030) { // 5.8%
    return 7;
  } else if (r < 0.9540) { // 5.1%
    return 8;
  } else { // 4.6 %
    return 9;
  }
}

int uniformDigit() {
  // random double value between 0 and 1
  double r = ((double) rand()) / RAND_MAX;
  return r * 10;
}

int main(int argc, char *argv[]) {

  // Process arguments with getopt

  int numValues = 0;
  int numDigits = 10;

  // Process arguments with getopt
  int c;
  while ((c = getopt(argc, argv, "n:d:")) != -1) {
    switch (c) {
      case 'n':
        numValues = atoi(optarg);
        //printf("%d\n", numValues);
        break;
      case 'd':
        numDigits = atoi(optarg);
        //printf("%d\n", numDigits);
        break;

    } 
  }

  for (int n = 0; n < numValues; n++) {
    int result = benfordDigit();
  
    for (int d = 0; d < numDigits - 1; d++) {
      result = result * 10 + uniformDigit();
    }
  
    printf("%s\n", buf);

  }
}